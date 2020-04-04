import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Load extends Thread {

    protected static List<Planets> parsePlanetsXML() throws ParserConfigurationException, SAXException, IOException
    {
        List<Planets> Planets = new ArrayList<Planets>();
        Planets planets = null;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("D:\\CoreBuild Java program hero vs villan\\src\\planets.xml"));
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("planet");

        for (int i = 0; i < nList.getLength(); i++)
        {
            Node node = nList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                planets = new Planets();
                planets.setDescription(eElement.getElementsByTagName("description").item(0).getTextContent());
                planets.setId(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()));
                planets.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                planets.setHeroAttackModifier(Float.parseFloat(eElement.getElementsByTagName("heroAttackModifier").item(0).getTextContent()));
                planets.setHeroHealthModifier(Float.parseFloat(eElement.getElementsByTagName("heroHealthModifier").item(0).getTextContent()));
                planets.setVillainAttackModifier(Float.parseFloat(eElement.getElementsByTagName("villainAttackModifier").item(0).getTextContent()));
                planets.setVillainHealthModifier(Float.parseFloat(eElement.getElementsByTagName("villainHealthModifier").item(0).getTextContent()));

//                NodeList mdfiList=document.getElementsByTagName("modifiers");
//                System.out.println(mdfiList.getLength());

//                for(int j=0;j<mdfiList.getLength()-1;j++)
//                {
//                    System.out.println(j);
//                    Node nodemdfi=mdfiList.item(j);
//                    if(nodemdfi.getNodeType()==Node.ELEMENT_NODE)
//                    {
//                        Element mdfiElement=(Element)nodemdfi;
//                        planets.setHeroAttackModifier(mdfiElement.getElementsByTagName("heroAttackModifier").item(0).getTextContent());
//                        planets.setHeroHealthModifier(mdfiElement.getElementsByTagName("heroHealthModifier").item(0).getTextContent());
//                        planets.setVillainAttackModifier(mdfiElement.getElementsByTagName("villainAttackModifier").item(0).getTextContent());
//                        planets.setVillainHealthModifier(mdfiElement.getElementsByTagName("villainHealthModifier").item(0).getTextContent());
//
//                    }
//                }
                Planets.add(planets);
            }
        }
        return Planets;
    }
    protected static List<Characters> parseCharactersXML() throws ParserConfigurationException, SAXException, IOException
    {
        List<Characters> Ch = new ArrayList<Characters>();
        Characters character = null;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("D:\\CoreBuild Java program hero vs villan\\src\\Characters.xml"));
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("character");

        for (int i = 0; i < nList.getLength(); i++)
        {
            Node node = nList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                character = new Characters();
                character.setDescription(eElement.getElementsByTagName("description").item(0).getTextContent());
                character.setId(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()));
                character.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                character.setAttack(Float.parseFloat(eElement.getElementsByTagName("attack").item(0).getTextContent()));
                character.setHealth(Float.parseFloat(eElement.getElementsByTagName("health").item(0).getTextContent()));
                character.setVillain(Boolean.parseBoolean(eElement.getElementsByTagName("isVillain").item(0).getTextContent()));
                Ch.add(character);
            }
        }
        return Ch;
    }



    }


