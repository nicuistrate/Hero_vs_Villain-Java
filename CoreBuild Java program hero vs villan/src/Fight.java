import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Fight extends Thread {
    protected void figth() throws IOException, SAXException, ParserConfigurationException {

        int heroid = 0, villainid = 0, planetid = 0;
        boolean run, correct_hero = true, correct_villian = true, correct_planet = true,battel_time=true;

        List<Planets> planets = Load.parsePlanetsXML();
        System.out.println(planets);
        List<Characters> characters = Load.parseCharactersXML();
        System.out.println(characters);

        Scanner scanner = new Scanner(System.in);
        Random random=new Random();

        System.out.println("You want to start a fight? (true/false)");

        run = scanner.nextBoolean();
        while (run) {
            while (correct_hero) {
                System.out.println("Choose a hero by his id :");
                heroid = scanner.nextInt();
                heroid = heroid - 1;
                if (0 <= heroid && heroid <= characters.size()) {
                    if (characters.get(heroid).getVillain() == false) {
                        System.out.println("Your choice is  " + characters.get(heroid).getName());
                        correct_hero = false;
                    } else {
                        System.out.println("Your choice is a villian \nChoose another \n");
                    }
                } else {
                    System.out.println("You introduce the wrong id !\n Again :\n");
                }
            }
            while (correct_villian) {
                System.out.println("Choose a Villian by his id :");
                villainid = scanner.nextInt();
                villainid = villainid - 1;
                if (0 <= villainid && villainid <= characters.size()) {
                    if (characters.get(villainid).getVillain() == true) {
                        System.out.println("Your choice is  " + characters.get(villainid).getName());

                        correct_villian = false;
                    } else {
                        System.out.println("Your choice is a hero \n Choose another");
                    }
                } else {
                    System.out.println("You introduce the wrong id !\n Again :\n");
                }
            }
            while (correct_planet) {
                System.out.println("Choose a Planet by her id :");
                planetid = scanner.nextInt();
                planetid = planetid - 1;
                if (0 <= planetid && planetid <= planets.size()) {
                    System.out.println("You choosed planet: " + planets.get(planetid).getName());
                    correct_planet = false;

                } else {
                    System.out.println("You introduce the wrong id !\nAgain");
                }
            }


            characters.get(heroid).setHealth(characters.get(heroid).getHealth()+planets.get(planetid).getHeroHealthModifier());
            characters.get(heroid).setAttack(characters.get(heroid).getAttack()+planets.get(planetid).getHeroAttackModifier());
            characters.get(villainid).setHealth(characters.get(villainid).getHealth()+planets.get(planetid).getVillainHealthModifier());
            characters.get(villainid).setAttack(characters.get(villainid).getAttack()+planets.get(planetid).getVillainAttackModifier());

            while(true)
            {

                int damage_hero=random.nextInt(100-60)+60;
                int damage_villian=random.nextInt(100-60)+60;

                characters.get(heroid).setHealth(characters.get(heroid).getHealth()-(characters.get(villainid).getAttack()*damage_villian/100));
                characters.get(villainid).setHealth(characters.get(villainid).getHealth()-(characters.get(heroid).getAttack()*damage_hero/100));

                float aux1=characters.get(heroid).getHealth();
                float aux2=characters.get(villainid).getHealth();
                System.out.println("Viata Hero "+aux1);
                System.out.println("Viata Villian "+aux2);

                if(characters.get(villainid).getHealth()<0)
                {
                    System.out.println(characters.get(heroid).getName()+" WON !");
                    break;
                }else if(characters.get(heroid).getHealth()<0) {
                    System.out.println(characters.get(villainid).getName()+" WON !");
                    break;

                }

            }


            System.out.println("You want another fight (true/false)");
            run=scanner.nextBoolean();
            if(run==true)
            {
                correct_hero=true;
                correct_villian=true;
                correct_planet=true;
                planets = Load.parsePlanetsXML();
                characters = Load.parseCharactersXML();

            }
        }


    }
    protected void Avangers() throws IOException, SAXException, ParserConfigurationException {

        int heroid = 0, villainid = 0, planetid = 0,avg=1,aux_hero=0,nr_hero=0,damage_hero,damage_villian;
        boolean run, correct_hero = true, correct_villian = true, correct_planet = true,battel_time=true;
        String finish_hero;

        List<Planets> planets = Load.parsePlanetsXML();
        System.out.println(planets);
        List<Characters> characters = Load.parseCharactersXML();
        System.out.println(characters);

        Scanner scanner = new Scanner(System.in);
        Random random=new Random();

        System.out.println("You want to start a fight? (true/false)");

        run = scanner.nextBoolean();
        while (run) {
            while (correct_hero) {
                System.out.println("Choose a hero by his id :");
                heroid = scanner.nextInt();

                heroid = heroid - 1;
                avg=avg*10+heroid;
                System.out.println("Avg este "+avg);
                if (0 <= heroid && heroid <= characters.size()) {
                    if (characters.get(heroid).getVillain() == false) {
                        System.out.println("Your choice is  " + characters.get(heroid).getName());

                        nr_hero++;
                        System.out.println("numarul eroilor este "+nr_hero+" Hero id este "+heroid);


                    } else {
                        System.out.println("Your choice is a villian \nChoose another \n");
                    }
                } else {
                    System.out.println("You introduce the wrong id !\n Again :\n");
                }

                System.out.println("Finish with heroes? (yes/no)");
                finish_hero=scanner.nextLine();
                finish_hero=scanner.nextLine();
                if(finish_hero.equals("yes"))
                {
                    correct_hero = false;
                }
            }
            while (correct_villian) {
                System.out.println("Choose a Villian by his id :");
                villainid = scanner.nextInt();
                villainid = villainid - 1;
                if (0 <= villainid && villainid <= characters.size()) {
                    if (characters.get(villainid).getVillain() == true) {
                        System.out.println("Your choice is  " + characters.get(villainid).getName());

                        correct_villian = false;
                    } else {
                        System.out.println("Your choice is a hero \n Choose another");
                    }
                } else {
                    System.out.println("You introduce the wrong id !\n Again :\n");
                }
            }
            while (correct_planet) {
                System.out.println("Choose a Planet by her id :");
                planetid = scanner.nextInt();
                planetid = planetid - 1;
                if (0 <= planetid && planetid <= planets.size()) {
                    System.out.println("You choosed planet: " + planets.get(planetid).getName());
                    correct_planet = false;

                } else {
                    System.out.println("You introduce the wrong id !\nAgain");
                }
            }
            int avg1;
            avg1=avg;
            for(int k=0;k<nr_hero;k++)
            {
                characters.get(avg1%10).setHealth(characters.get(avg1%10).getHealth()+planets.get(planetid).getHeroHealthModifier());
                characters.get(avg1%10).setAttack(characters.get(avg1%10).getAttack()+planets.get(planetid).getHeroAttackModifier());
                avg1=avg1/10;
            }

            characters.get(villainid).setHealth(characters.get(villainid).getHealth()+planets.get(planetid).getVillainHealthModifier());
            characters.get(villainid).setAttack(characters.get(villainid).getAttack()+planets.get(planetid).getVillainAttackModifier());

            avg1=avg;
            int death_hero=0;
            while(battel_time)
            {

                for(int k=0;k<nr_hero;k++)
                {
                    int avg2=avg;
                    for(int o=0;o<nr_hero;o++) {
                        if (characters.get(avg2 % 10).getHealth() < 0) {
                            characters.get(avg2 % 10).setAttack(0);
                            characters.get(avg2 % 10).setAttack(0);
                            death_hero++;
                            System.out.println("Numarul eroilor morti este " + death_hero + " numarul eroilor este " + nr_hero);
                            if (death_hero == nr_hero) {
                                battel_time = false;
                                o=99;
                            }
                            avg2 = avg2 / 10;

                        }
                    }
                    damage_hero=random.nextInt(100-60)+60;
                    damage_villian=random.nextInt(100-60)+60;
                    float aux1=characters.get(villainid).getAttack()*damage_villian/100;
                    float aux2=characters.get(avg1%10).getAttack()*damage_hero/100;
                    characters.get(avg1%10).setHealth(characters.get(avg1%10).getHealth()-aux1);
                    characters.get(villainid).setHealth(characters.get(villainid).getHealth()-aux2);
                    System.out.println(characters.get(avg1 % 10).getName() + " a dat damage " + aux2 + " numarul random este " + damage_hero + " si mai are viata " + characters.get(avg1 % 10).getHealth());
                    System.out.println(characters.get(villainid).getName() + " a dat damage " + aux1 + " numarul random este " + damage_villian + " si mai are viata " + characters.get(villainid).getHealth());
                    avg1=avg1/10;
                      if(characters.get(villainid).getHealth()<0)
                     {
                         System.out.println("Avangers WON !");
                         battel_time=false;
                         break;
                     }else if(nr_hero==death_hero)
                      {
                          break;
                      }


                }


                avg1=avg;
            }
                if (nr_hero==death_hero) {
                System.out.println(characters.get(villainid).getName() + " WON !");
                battel_time=false;
                break;
            }



            }

            System.out.println("You want another fight (true/false)");
            run=scanner.nextBoolean();
            if(run==true)
            {
                correct_hero=true;
                correct_villian=true;
                correct_planet=true;
                battel_time=true;
                planets = Load.parsePlanetsXML();
                characters = Load.parseCharactersXML();

            }
        }


    }


