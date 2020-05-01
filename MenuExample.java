import javax.swing.*; // import jdk.internal.platform.Container;
import java.awt.event.*;   
import java.util.*;  
import java.time.*;
public class MenuExample implements ActionListener{    
    //Non-Swing variables
    private static long coins = 0;
    private static byte hunger = 0;
    private static byte thirst = 0;
    private static int namingCount = 0;
    private static int progression = 0;
    private static Scanner sc = new Scanner(System.in);   
    private static Random r = new Random(); //Create a scanner and a random object 
    private static ArrayList<Pokemon> allPokemon = new ArrayList<Pokemon>();
    private static int choosePokemon=-2100000000;
    private static int boringVar = 0;
    private static int[] enemyRamUsage = {1,
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
    private static LocalDate myDate;
    private static LocalTime myTime;
    private static String coinText = "You have 0 coins.";
    //Swing Variables
    private static JFrame f;    
    private static JMenuBar mb;    
    private static JMenu datetimenu,edit;    
    private static JMenuItem cut,copy,paste,selectAll,datetime,timedate;    
    private static JButton gym = new JButton("gym"),house = new JButton("house"),garden = new JButton("garden"),item1 = new JButton("rename a Pokemon"),item2 = new JButton("buy a 256MB ram food (8 coins)"),item3 = new JButton("buy an intel food (16 coins)"),item4 = new JButton("buy an RTX food (32 coins)"); 
    private static JTextArea ta;  
    private static JScrollPane scroll;  
    private static JTextField coinTextField = new JTextField(coinText);
    MenuExample(){    
        f=new JFrame("PokemonGame");
        datetime = new JMenuItem("datetime");  
        timedate = new JMenuItem("timedate");
        cut=new JMenuItem("cut");    
        copy=new JMenuItem("copy");    
        paste=new JMenuItem("paste");    
        selectAll=new JMenuItem("selectAll"); 
        cut.addActionListener(this);    
        copy.addActionListener(this);    
        paste.addActionListener(this);    
        selectAll.addActionListener(this);   
        timedate.addActionListener(this);  
        datetime.addActionListener(this);   
        gym.addActionListener(this); 
        house.addActionListener(this); 
        garden.addActionListener(this);  
        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item4.addActionListener(this);
        mb=new JMenuBar();    //locations=new JMenu("Locations");    
        datetimenu=new JMenu("Datetime"); 
        edit=new JMenu("Edit");    
        datetimenu.add(datetime);datetimenu.add(timedate);
        edit.add(cut);edit.add(copy);edit.add(paste);edit.add(selectAll);
        mb.add(edit);mb.add(datetimenu);mb.add(gym);mb.add(house);mb.add(garden);mb.add(item1);mb.add(item2);mb.add(item3);mb.add(item4);mb.add(coinTextField);
        ta=new JTextArea();    
        scroll = new JScrollPane(ta);
        ta.setBounds(5,5,760,720);    
        f.add(mb);
        f.add(scroll);    
        f.setJMenuBar(mb);  
        myDate = LocalDate.now();
        myTime = LocalTime.now();
        disp(("yyyy mm dd of today is "+myDate+"\nThe current time is "+myTime));
        //f.setLayout(null);    
        f.setSize(1400,800);    
        f.setVisible(true);    
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }     
    public void actionPerformed(ActionEvent e) { 
        if(e.getSource()==cut)    
            ta.cut();    
        if(e.getSource()==paste)    
            ta.paste();    
        if(e.getSource()==copy)    
            ta.copy();    
        if(e.getSource()==selectAll)    
            ta.selectAll(); 
        if(e.getSource()==datetime){
            myDate = LocalDate.now();
            myTime = LocalTime.now();
            disp(("yyyy mm dd of today is "+myDate+"\nThe current time is "+myTime)); 
        }
        if(e.getSource()==timedate){
            myDate = LocalDate.now();
            myTime = LocalTime.now();
            disp(("The current time is "+myTime+"\nyyyy mm dd of today is "+myDate)); 
        }
        if(e.getSource()==gym){
            if (hunger < 100 && thirst < 100) gym();
            else JOptionPane.showMessageDialog(f,"Please go back to the house first.");}
        if(e.getSource()==house)
            house();
        if(e.getSource()==garden){
            if (hunger < 100 && thirst < 100) garden();
            else JOptionPane.showMessageDialog(f,"Please go back to the house first.");}
        if(e.getSource()==item1){
            if (hunger < 100 && thirst < 100) item1();
            else JOptionPane.showMessageDialog(f,"Please go back to the house first.");}
        if(e.getSource()==item2){
            if (hunger < 100 && thirst < 100)item2();
            else JOptionPane.showMessageDialog(f,"Please go back to the house first.");}
        if(e.getSource()==item3){
            if (hunger < 100 && thirst < 100)item3();
            else JOptionPane.showMessageDialog(f,"Please go back to the house first.");}
        if(e.getSource()==item4){
            if (hunger < 100 && thirst < 100)item4();
            else JOptionPane.showMessageDialog(f,"Please go back to the house first.");}
    }     
    public static void main(String[] args) {    
        new MenuExample();    
    }    
    public static void gym(){
        String gymString = "";
        char enemyNam = (char) ('A'+  r.nextInt(26));
        String enemyName = ""+enemyNam;
        gymString = gymString + ("Welcome to the gym.");
        gymString = gymString + ("\nYour enemy for today is "+enemyName+". It use "+ enemyRamUsage[progression]+" bytes of RAM and use 50% of CPU usage.");
        gymString = gymString + ("\nChoose your Pokemon for the battle\nEnter 0 or a number higher than your amount of Pokemon to cancel the battle");
        String str1 = "";
        while (choosePokemon == -2100000000){
            str1 = JOptionPane.showInputDialog(gymString);
            choosePokemon = Integer.parseInt(str1);
        } 
        if(choosePokemon == 0 || choosePokemon > allPokemon.size()){
            disp("Battle canceled.\nYou gain 2 hunger.");
            hunger+=2;
            if(hunger>100) hunger = 100;
        }
        else{
            Pokemon yourChosenPokemon = allPokemon.get((choosePokemon-1));
            int gained = 0;//yourChosenPokemon.battle(enemyName, enemyRamUsage[progression]);
            gymString = gymString + ("\nThe battle has begun!");
            int yourCP = (yourChosenPokemon.ramUsage/2), enemyCP = ((enemyRamUsage[progression]/100)*yourChosenPokemon.cpuUsage);
            gymString = gymString + ("\n"+yourChosenPokemon.name + " has " + yourCP + " combat power!");
            gymString = gymString + ("\n"+enemyName + " has " + enemyCP + " combat power!");
            if(yourCP < enemyCP){
                gymString = gymString + ("\n"+yourChosenPokemon.name +" crashed from having less CP! "+ enemyName +" is the Winner!");
                //System.out.println("YOU LOSE!");
                gymString = gymString + ("\nYou get 2 coins from losing.");
                yourChosenPokemon.losts++;
                coins += 2;
            }
            else if(yourCP > enemyCP){
                gymString = gymString + ("\n"+enemyName +" has stopped working from having less CP! "+ yourChosenPokemon.name +" is the Winner!");
                //System.out.println("YOU WIN!");
                gymString = gymString + ("\nYou get 10 coins from winning.");
                yourChosenPokemon.wins++;
                coins += 10;
                if(progression<(enemyRamUsage.length-1)){
                    progression++;
                }
            }
            else {
                gymString = gymString + ("\nBoth Pokemon have the same amount of CP!");
                //System.out.println("IT'S A DRAW!");
                gymString = gymString + ("\nYou get 5 coins from this draw.");
                yourChosenPokemon.draws++;
                coins += 5;     
            }    
            gymString = gymString + ("\nYou now have "+coins+" coins in total.\nYou gain 3 hunger.");
            hunger+=3;
            if(hunger>100) hunger = 100; 
            disp(gymString);           
        }
        updateCoin();
    }
    public static void house(){
        String str1 = "",hString = "You get back to your house and have some food and drink. Your hunger and thirst has been reduced by 10";
        hunger -= 10;
        thirst -= 10;
        if(hunger<0) hunger = 0;
        if(thirst<0) hunger = 0;
        if(allPokemon.size()>0){
            hString = hString + ("\nAlso, here's info of every Pokemon you own.");
            for(Pokemon i : allPokemon){
                boringVar++;
                hString = hString + "\nPokemon number "+boringVar+"\n";
                hString = hString + i.describe()+"\n";
            }
            boringVar = 0;
            while (choosePokemon == -2100000000){
                str1 = JOptionPane.showInputDialog("If you want to, you can choose your Pokemon to be removed.\nEnter 0 or a number higher than your amount of Pokemon to cancel");    
                choosePokemon = Integer.parseInt(str1);
            } 
            if(choosePokemon == 0 || choosePokemon > allPokemon.size()){
                hString = hString + ("Removal canceled.");
            }
            else{
                Pokemon yourChosenPokemon = allPokemon.get((choosePokemon-1)); 
                choosePokemon = - -2100000000;
                while(choosePokemon == -2100000000 || choosePokemon == 2100000000){
                    str1 = JOptionPane.showInputDialog("Are you really sure to remove this Pokemon? (Enter 1 to confirm removal)\n"+yourChosenPokemon.describe());
                }    
                if(choosePokemon == 1){
                    allPokemon.remove((choosePokemon-1));
                    hString = hString + ("Pokemon removed successfully.");
                }                    
                else hString = hString + ("removal is cancelled.");// because you entered "+choosePokemon);     
            }
        }
        disp(hString);
        updateCoin();
    }
    public static void garden(){
        String gardenString = "";
        byte byt = (byte) r.nextInt(8);
        int ramUsage = 100000000 + r.nextInt(20000000);
        byte cpuUsage = (byte) (100-r.nextInt(10));
        gardenString = gardenString + "You entered the garden and found a "+browser(byt)+". Yay!";
        gardenString = gardenString + "\nIt use "+ramUsage+" bytes of RAM and use "+cpuUsage+"% of CPU usage.";
        gardenString = gardenString + "\nPlease name your Pokemon. Choose a name longer than 2 characters.\n";
        String str1 = "";
        while (str1.length()<3){
            str1 = JOptionPane.showInputDialog(gardenString);
        }
        thirst += 5;
        if(thirst>100) thirst=100;
        Pokemon currentPokemon = new Pokemon(byt, ramUsage, cpuUsage, str1);
        allPokemon.add(currentPokemon);
        gardenString = gardenString + str1 + "\nYou gain 5 thirst from sweating.";
        ta.setText(gardenString);
        updateCoin();
    }
    public static String browser(byte a){
        String[] b = {"Chrome", "Safari", "Firefox", "Samsung_Internet", "UC_Browser", "Opera", "MS_Edge", "IE"};
        return b[a];
    }
    public static void item1(){
        String str1 = "",itemString = "Choose your Pokemon to rename\nEnter 0 or a number higher than your amount of Pokemon to cancel";
        while (choosePokemon == -2100000000){
            str1 = JOptionPane.showInputDialog(itemString);
            choosePokemon = Integer.parseInt(str1);
        } 
        if(choosePokemon == 0 || choosePokemon > allPokemon.size()){
            itemString = ("Renaming canceled.");
        }
        else{
            Pokemon yourChosenPokemon = allPokemon.get((choosePokemon-1));
            String name = "";
            while(name.length()<3){
                name = JOptionPane.showInputDialog("Please rename this Pokemon. Choose a name longer than 2 characters.");
            }
            yourChosenPokemon.rename(name);
            namingCount++;
            itemString = "Here is the Pokemon's updated description.\n"+yourChosenPokemon.describe();
        }
        disp(itemString);
        updateCoin();
    }
    public static void item2(){
        int pay = 8;
        String str1 = "",itemString = "Choose your Pokemon to feed a 32GB ram food\nEnter 0 or a number higher than your amount of Pokemon to cancel";
        if(coins>=pay){
            while (choosePokemon == -2100000000){
                str1 = JOptionPane.showInputDialog(itemString);
                choosePokemon = Integer.parseInt(str1);
            } 
            if(choosePokemon == 0 || choosePokemon > allPokemon.size()){
                itemString = itemString + ("\nFeeding canceled.");
            }
            else{
                Pokemon yourChosenPokemon = allPokemon.get((choosePokemon-1));
                coins -= pay;
                yourChosenPokemon.feed((byte)2);
                itemString = itemString + ("\nThe Pokemon now use "+yourChosenPokemon.ramUsage+" bytes of RAM.\nYou now have "+coins+" coins.\nHere is the Pokemon's updated description.\n"+yourChosenPokemon.describe());
            }
        }
        else{
            String notEnoughCoins = "You don't have enough coins.";
            JOptionPane.showMessageDialog(f,notEnoughCoins);
            itemString = notEnoughCoins;
        }
        disp(itemString);
        updateCoin();
    }
    public static void item3(){
        int pay = 16;
        String str1 = "",itemString = "Choose your Pokemon to an intel food\nThis will lower its CPU usage by 10% (cost 16 coins)\nEnter 0 or a number higher than your amount of Pokemon to cancel";
        if(coins>=pay){
            while (choosePokemon == -2100000000){
                str1 = JOptionPane.showInputDialog(itemString);
                choosePokemon = Integer.parseInt(str1);
            } 
            if(choosePokemon == 0 || choosePokemon > allPokemon.size()){
                itemString = itemString + ("\nFeeding canceled.");
            }
            else{
                Pokemon yourChosenPokemon = allPokemon.get((choosePokemon-1));
                coins -= pay;
                yourChosenPokemon.feed((byte)3);
                itemString = itemString + ("\nThe Pokemon now use "+yourChosenPokemon.cpuUsage+"% of CPU usage.\nYou now have "+coins+" coins.\nHere is the Pokemon's updated description.\n"+yourChosenPokemon.describe());
            }
        }
        else{
            String notEnoughCoins = "You don't have enough coins.";
            JOptionPane.showMessageDialog(f,notEnoughCoins);
            itemString = notEnoughCoins;
        }
        disp(itemString);
        updateCoin();
    }
    public static void item4(){
        int pay = 32;
        String str1 = "",itemString = "Choose your Pokemon to feed an RTX food\nThis will lower its CPU usage by 30% (cost 32 coins)\nEnter 0 or a number higher than your amount of Pokemon to cancel";
        if(coins>=pay){
            while (choosePokemon == -2100000000){
                str1 = JOptionPane.showInputDialog(itemString);
                choosePokemon = Integer.parseInt(str1);
            } 
            if(choosePokemon == 0 || choosePokemon > allPokemon.size()){
                itemString = itemString + ("\nFeeding canceled.");
            }
            else{
                Pokemon yourChosenPokemon = allPokemon.get((choosePokemon-1));
                coins -= pay;
                yourChosenPokemon.feed((byte)4);
                itemString = itemString + ("\nThe Pokemon now use "+yourChosenPokemon.cpuUsage+"% of CPU usage.\nYou now have "+coins+" coins.\nHere is the Pokemon's updated description.\n"+yourChosenPokemon.describe());
            }
        }
        else{
            String notEnoughCoins = "You don't have enough coins.";
            JOptionPane.showMessageDialog(f,notEnoughCoins);
            itemString = notEnoughCoins;
        }
        disp(itemString);
        updateCoin();
    }
    public static void disp(String display){
        ta.setText(display);
    }
    public static void updateCoin(){
        choosePokemon = -2100000000;
        coinText = "You have " + coins + " coins.";
        coinTextField.setText(coinText);
    }
}    