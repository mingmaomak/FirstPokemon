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
    public static int choosePokemon=-2100000000;
    private static int boringVar = 0;
    public static int[] enemyRamUsage = {1,
        100000000,
        210000000,
        330000000,
        460000000,
        600000000,
        750000000,
        910000000,
       1080000000,
       1260000000,
       1450000000,
       1650000000,
       1860000000,
       2080000000};
    public static void main(String[] args){
        String commandStringg = "";
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
                    else System.out.println("Please go back to the house first.");
                break;
                case '2':
                    if (hunger < 100 && thirst < 100) shop();
                    else System.out.println("Please go back to the house first.");
                break;
                case '3':
                    System.out.println("You get back to your house and have some food and drink. Your hunger and thirst has been reduced by 10");
                    hunger -= 10;
                    thirst -= 10;
                    if(hunger<0) hunger = 0;
                    if(thirst<0) hunger = 0;
                    if(allPokemon.size()>0){
                        System.out.println("Also, here's info of every Pokemon you own.");
                        for(Pokemon i : allPokemon){
                            boringVar++;
                            System.out.println("Pokemon number "+boringVar);
                            System.out.println(i.describe()+"\n");
                        }
                    
                        boringVar = 0; 
                        System.out.println("If you want to, you can choose your Pokemon to be removed, enter 0 or a number higher than your amount of Pokemon to cancel");
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
                            System.out.println ("Removal canceled.");
                        }
                        else{
                            Pokemon yourChosenPokemon = allPokemon.get((choosePokemon-1));
                            System.out.println("Are you really sure to remove this Pokemon? (Enter 1 to confirm removal)\n"+yourChosenPokemon.describe());
                            choosePokemon = - -2100000000;
                            commandStringg = sc.nextLine();
                            while(choosePokemon == -2100000000 || choosePokemon == 2100000000){
                                try {
                                    choosePokemon = Integer.parseInt(commandStringg);
                                }
                                catch (NumberFormatException e){
                                    choosePokemon = - -2100000000;
                                } 
                            }    
                            if(choosePokemon == 1){
                                allPokemon.remove((choosePokemon-1));
                                System.out.println("Pokemon removed successfully.");
                            }                    
                            else System.out.println("Removal is cancelled.");// because you entered "+choosePokemon);
                        }
                    } 
                break;
                case '4':
                    if (hunger < 100 && thirst < 100) garden();
                    else System.out.println("Please go back to the house first.");
                break;
                case '5':
                    myDate = LocalDate.now(); // Create a date object
                    System.out.println("yyyy mm dd of today is "+myDate); // Display the current date
                    myTime = LocalTime.now();
                    System.out.println("The current time is "+myTime);
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
        System.out.println("Enter 2 to go to the shop");
        System.out.println("Enter 3 to go to the house");
        System.out.println("Enter 4 to go to the garden");
        System.out.println("Enter 5 to view current date & time.");
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
        //int choosePokemon=-2100000000;
        while(choosePokemon == -2100000000){
            try {
                choosePokemon = Integer.parseInt(commandStringg);
            }
            catch (NumberFormatException e){
                choosePokemon = - -2100000000;
            } 
        }
        if(choosePokemon == 0 || choosePokemon > allPokemon.size()){
            System.out.println ("Battle canceled.\nYou gain 2 hunger.");
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
            System.out.println ("You now have "+coins+" coins in total.\nYou gain 3 hunger.");
            hunger+=3;
            if(hunger>100) hunger = 100;            
        }
    }
    public static void shop(){
        System.out.println("You entered the shop with "+coins+" coins.\nEnter 1 for a Pokemon renaming license (free)\nEnter 2 for a 256MBram food (8 coins)\nEnter 3 for an intel food (lower amount of CPU usage by 10%) (16 coins)\nEnter 4 for an RTX food (lower amount of CPU usage by 30%) (32 coins)\nEnter anything else to return to the map.");
        String commandString = "";
        String commandStringg = "";
        while(commandString.isEmpty()){
            commandString = sc.nextLine();
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
                        yourChosenPokemon.feed((byte)2);
                        System.out.println("The Pokemon now use "+yourChosenPokemon.ramUsage+" bytes of RAM.\nYou now have "+coins+" coins.\nHere is the Pokemon's updated description."+yourChosenPokemon.describe());
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
                        yourChosenPokemon.feed((byte)3);
                        System.out.println("The Pokemon now use "+yourChosenPokemon.cpuUsage+"% of CPU usage.\nYou now have "+coins+" coins.\nHere is the Pokemon's updated description."+yourChosenPokemon.describe());
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
                        yourChosenPokemon.feed((byte) 4);
                        System.out.println("The Pokemon now use "+yourChosenPokemon.cpuUsage+"% of CPU usage.\nYou now have "+coins+" coins.\nHere is the Pokemon's updated description.\n"+yourChosenPokemon.describe());
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
//"If you want to, you can choose your Pokemon to be removed, enter 0 or a number higher than your amount of Pokemon to cancel"