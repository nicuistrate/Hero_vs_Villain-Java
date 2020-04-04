import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        Scanner scanner=new Scanner(System.in);
        boolean choose=true,choice=true;
        String foA;
        Fight fight=new Fight();
        while(choose)
        {
            System.out.println("Do you want to have a fight or to create an Avangers team? (fight/Avangers)");
            foA=scanner.nextLine();
            if(foA.equals("fight"))
            {

                fight.figth();
                System.out.println("Do you want to have another try?(true/false)");
                choice=scanner.nextBoolean();
            }else if(foA.equals("Avangers"))
            {
                fight.Avangers();
                System.out.println("Do you want to have another try?(true/false)");
                choice=scanner.nextBoolean();

            }

            if(choice)
            {
                choose=true;
            }
            else
            {
                choose=false;
            }


        }

    }
}

