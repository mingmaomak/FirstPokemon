public class Pokemon{
    public byte species = 0;
    public int ramUsage = 0;
    public byte cpuUsage = 0;
    private String name = "";
    public int feedCount = 0;
    private int wins = 0;
    private int losts = 0;
    private int draws = 0;
    public Pokemon(byte byt, int ramU, byte cpuU, String n){
        species = byt;
        ramUsage = ramU;
        cpuUsage = cpuU;
        name = n;
    }
    public void feed(int feedingValue){
        ramUsage += feedingValue;
        feedCount++;
    }
    public int battle (String nameEnemy,int ramUsageEnemy){
        //System.out.println("For debugging purposes:\nnameEnemy:"+nameEnemy+"\nramUsageEnemy:"+ramUsageEnemy);
        System.out.println("The battle has begun!");
        int yourCP = (ramUsage/2), enemyCP = ((ramUsageEnemy/100)*cpuUsage);
        System.out.println(name + " has " + yourCP + " combat power!");
        System.out.println(nameEnemy + " has " + enemyCP + " combat power!");
        if(yourCP < enemyCP){
            System.out.println(name +" crashed from having less CP! "+ nameEnemy +" is the Winner!");
            //System.out.println("YOU LOSE!");
            System.out.println("You get 2 coins from losing.");
            losts++;
            return 2;
        }
        else if(yourCP > enemyCP){
            System.out.println(nameEnemy +" has stopped working from having less CP! "+ name +" is the Winner!");
            //System.out.println("YOU WIN!");
            System.out.println("You get 10 coins from winning.");
            wins++;
            return 10;
        }
        else if(yourCP == enemyCP){
            System.out.println("Both Pokemon have the same amount of CP!");
            //System.out.println("IT'S A DRAW!");
            System.out.println("You get 5 coins from this draw.");
            draws++;
            return 5;
        }
        return 3;
    }
    public String describe(){
        return ("Pokemon name: "+name+"\nSpecies: "+browser(species)+"\nIt use "+ramUsage+" bytes of RAM and use "+cpuUsage+"% of CPU usage.\nYou have fed this Pokemon "+feedCount+" times.\n"+percentage());
    }
    public String browser(byte a){
        String[] b = {"Chrome", "Safari", "Firefox", "Samsung_Internet", "UC_Browser", "Opera", "MS_Edge", "IE"};
        return b[a];
    }
    public String percentage(){
        double eee = (losts+wins+draws);
        if(eee!=0){
            double aaa = (wins/eee*100), bbb = (losts/eee*100), ccc = (draws/eee*100);
            return ("wins: "+wins+"\nlosts: "+losts+"\ndraws: "+draws+"\nWin "+aaa+"% Loss "+bbb+"% Draws "+ccc+"%");
        }
        else return("no battle record for this Pokemon");
    }
    public String rename(String toRename){
        name = toRename;
        return "toRename";
    }
}
