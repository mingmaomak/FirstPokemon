//import org.graalvm.compiler.hotspot.nodes.AllocaNode;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random; 
import java.time.LocalTime;
import java.time.LocalDate;
public class PokemonGame{
    private static long coins = 0;
    private static byte hunger = 0;
    private static byte thirst = 0;
    private static int namingCount = 0;
    private static int progression = 0;
    public static Scanner sc = new Scanner(System.in);   
    public static Random r = new Random(); //Create a scanner and a random object 
    public static ArrayList<Pokemon> allPokemon = new ArrayList<Pokemon>();
    private static int boringVar = 0;
    public static int[] enemyRamUsage = {1,
          99999999,
         200000000,
         311111111,
         444444444,
         600000000,
         777777777,
        1000000000,
        1250000000,
        1510000000,
        1800000000,
        2100000000};
    public static void main(String[] args){
        LocalDate myDate = LocalDate.now(); // Create a date object
        System.out.println("yyyy mm dd of today is "+myDate); // Display the current date
        LocalTime myTime = LocalTime.now();
        System.out.println("The current time is "+myTime);
        boolean boo = true;
        while(boo){
            char command = map();
            switch(command){ 
                case '1':
                    if (hunger < 100 && thirst < 100) gym();
                    else System.out.println("Please go back to the home first.");
                break;
                case '2':
                    System.out.println("You get back to your home and have some food and drink. Your hunger and thirst has been reduced by 10");
                    hunger -= 10;
                    thirst -= 10;
                    if(hunger<0) hunger = 0;
                    if(thirst<0) hunger = 0;
                    System.out.println("Also, here's info of every Pokemon you own.");
                    for(Pokemon i : allPokemon){
                        boringVar++;
                        System.out.println("Pokemon number "+boringVar);
                        System.out.println(i.describe()+"\n");
                    }
                    boringVar = 0;
                break;
                case '3':
                    if (hunger < 100 && thirst < 100) store();
                    else System.out.println("Please go back to the home first.");
                break;
                case '4':
                    if (hunger < 100 && thirst < 100) garden();
                    else System.out.println("Please go back to the home first.");
                break;
                case '0': 
                    System.out.println("Goodbye");
                    boo = false;
                break;
                default:
                    System.out.println("invalid input entered");
                
            }
        }
    }
    public static String garden(){
        byte byt = (byte) r.nextInt(8);
        int ramUsage = 100000000 + r.nextInt(20000000);
        byte cpuUsage = (byte) (100-r.nextInt(10));
        System.out.println("You entered the garden and found a "+browser(byt)+". Yay!");
        System.out.println("It use "+ramUsage+" bytes of RAM and use "+cpuUsage+"% of CPU usage.");
        System.out.println("Please name your Pokemon. Choose a name longer than 2 characters.");
        String name = "";
        while(name.length()<3){
            name = sc.nextLine();
            namingCount++;
        }
        thirst += 5;
        if(thirst>100) thirst=100;
        Pokemon currentPokemon = new Pokemon(byt, ramUsage, cpuUsage, name);
        allPokemon.add(currentPokemon);
        System.out.println("You gain 5 thirst from sweating.");
        return "garden";
    }
    public static String browser(byte a){
        String[] b = {"Chrome", "Safari", "Firefox", "Samsung_Internet", "UC_Browser", "Opera", "MS_Edge", "IE"};
        return b[a];
    }
    public static char map(){
        System.out.println("");
        System.out.println("Enter 1 to go to the gym");
        System.out.println("Enter 2 to go to the home");
        System.out.println("Enter 3 to go to the store");
        System.out.println("Enter 4 to go to the garden");
        System.out.println("Enter 0 to quit the game");
        String commandString = "";
        while(commandString.isEmpty()){
            commandString = sc.nextLine();
        }
        char charEntered = commandString.charAt(0);
        return charEntered;
        //catch(Exception e){}
        //return 'a';
    }
    public static void gym(){
        char enemyNam = (char) ('A'+  r.nextInt(26));
        String enemyName = ""+enemyNam;
        //0if(progression<gymPokemon.lengt)
        System.out.println("Welcome to the gym.");
        System.out.println("Your enemy for today is "+enemyName+". It use "+ enemyRamUsage[progression]+" bytes of RAM and use 50% of CPU usage.");
        System.out.println("Choose your Pokemon for the battle, enter 0 or a number higher than your amount of Pokemon to cancel the battle");
        String commandStringg = sc.nextLine();
        int choosePokemon=-2100000000;
        while(choosePokemon == -2100000000){
            try {
                choosePokemon = Integer.parseInt(commandStringg);
            }
            catch (NumberFormatException e){
                choosePokemon = - -2100000000;
            } 
        }
        /* int foo;
try {
   foo = Integer.parseInt(myString);
}
catch (NumberFormatException e)
{
   foo = 0;
}*/
        if(choosePokemon == 0 || choosePokemon > allPokemon.size()){
            System.out.println ("Battle canceled. You gain 2 hunger.");
            hunger+=2;
            if(hunger>100) hunger = 100;
        }
        else{
            Pokemon yourChosenPokemon = allPokemon.get((choosePokemon-1));
            int gained = yourChosenPokemon.battle(enemyName, enemyRamUsage[progression]);
            coins += gained;
            if(gained==10 && progression<(enemyRamUsage.length-1)){
                progression++;
            }
            System.out.println ("You now have "+coins+" coins in total.");
            System.out.println ("You gain 3 hunger.");
            hunger+=3;
            if(hunger>100) hunger = 100;            
        }

        //System.out.println("Soon");
    }
    public static void store(){
        System.out.println("You entered the store with "+coins+" coins.\nEnter 1 for a Pokemon renaming license (free)\nEnter 2 for a 256MBram food (8 coins)\nEnter 3 for an intel food (lower amount of CPU usage by 10%) (16 coins)\nEnter 4 for an RTX food (lower amount of CPU usage by 30%) (32 coins)\nEnter anything else to return to the map.");
        String commandString = "";
        String commandStringg = "";
        int choosePokemon=-2100000000;
        while(commandString.isEmpty()){
            commandString = sc.nextLine();
            //char charEntered = commandString.charAt(0);
        }
        char charEntered = commandString.charAt(0);
        int  pay = 0;
        switch(charEntered){
            case '1':
                System.out.println("Choose your Pokemon to rename, enter 0 or a number higher than your amount of Pokemon to cancel");
                commandStringg = sc.nextLine();
                while(choosePokemon == -2100000000){
                    try {
                        choosePokemon = Integer.parseInt(commandStringg);
                    }
                    catch (NumberFormatException e){
                        choosePokemon = - -2100000000;
                    } 
                }
                if(choosePokemon == 0 || choosePokemon > allPokemon.size()){
                    System.out.println ("Renaming canceled.");
                }
                else{
                    Pokemon yourChosenPokemon = allPokemon.get((choosePokemon-1));
                    System.out.println("Please rename your Pokemon. Choose a name longer than 2 characters.");
                    String name = "";
                    while(name.length()<3){
                        name = sc.nextLine();
                    }
                    yourChosenPokemon.rename(name);
                    namingCount++;
                }
                break;
            case '2':
                pay = 8;
                if(coins>=pay){
                    System.out.println("Choose your Pokemon to feed 256MB ram food, enter 0 or a number higher than your amount of Pokemon to cancel");
                    commandStringg = sc.nextLine();
                    while(choosePokemon == -2100000000){
                        try {
                            choosePokemon = Integer.parseInt(commandStringg);
                        }
                        catch (NumberFormatException e){
                            choosePokemon = - -2100000000;
                        } 
                    }
                    if(choosePokemon == 0 || choosePokemon > allPokemon.size()){
                        System.out.println ("feeding canceled.");
                    }
                    else{
                        Pokemon yourChosenPokemon = allPokemon.get((choosePokemon-1));
                        coins -= pay;
                        yourChosenPokemon.ramUsage +=  256000000;
                        if(yourChosenPokemon.ramUsage>2000000000) yourChosenPokemon.ramUsage = 2000000000;
                        System.out.println("The Pokemon now use "+yourChosenPokemon.ramUsage+" bytes of RAM.\nYou now have "+coins+" coins.");
                    }                 
                }
                else{
                    System.out.println("You don't have enough coins.");
                }    
                break;          
            case '3':
                pay = 16;
                if(coins>=pay){
                    System.out.println("Choose your Pokemon to feed intel food, enter 0 or a number higher than your amount of Pokemon to cancel");
                    commandStringg = sc.nextLine();
                    while(choosePokemon == -2100000000){
                        try {
                            choosePokemon = Integer.parseInt(commandStringg);
                        }
                        catch (NumberFormatException e){
                            choosePokemon = - -2100000000;
                        } 
                    }
                    if(choosePokemon == 0 || choosePokemon > allPokemon.size()){
                        System.out.println ("feeding canceled.");
                    }
                    else{
                        Pokemon yourChosenPokemon = allPokemon.get((choosePokemon-1));
                        coins -= pay;
                        yourChosenPokemon.cpuUsage -= 10;
                        if(yourChosenPokemon.cpuUsage<((8-yourChosenPokemon.species)*2)) yourChosenPokemon.ramUsage = ((8-yourChosenPokemon.species)*2);
                        System.out.println("The Pokemon now use "+yourChosenPokemon.cpuUsage+"% of CPU usage.\nYou now have "+coins+" coins.");
                    }                 
                }
                else{
                    System.out.println("You don't have enough coins.");
                }   
                break;
            case '4':
                pay = 32;
                if(coins>=pay){
                    System.out.println("Choose your Pokemon to feed RTX food, enter 0 or a number higher than your amount of Pokemon to cancel");
                    commandStringg = sc.nextLine();
                    while(choosePokemon == -2100000000){
                        try {
                            choosePokemon = Integer.parseInt(commandStringg);
                        }
                        catch (NumberFormatException e){
                            choosePokemon = - -2100000000;
                        } 
                    }
                    if(choosePokemon == 0 || choosePokemon > allPokemon.size()){
                        System.out.println ("feeding canceled.");
                    }
                    else{
                        Pokemon yourChosenPokemon = allPokemon.get((choosePokemon-1));
                        coins -= pay;
                        yourChosenPokemon.cpuUsage -= 30;
                        if(yourChosenPokemon.cpuUsage<((8-yourChosenPokemon.species)*2)) yourChosenPokemon.ramUsage = ((8-yourChosenPokemon.species)*2);
                        System.out.println("The Pokemon now use "+yourChosenPokemon.cpuUsage+"% of CPU usage.\nYou now have "+coins+" coins.");
                    }                 
                }
                else{
                    System.out.println("You don't have enough coins.");
                }   
                break;
            default:
                
        }
    }

}
