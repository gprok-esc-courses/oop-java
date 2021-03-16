package p04_files.olympics;

public class Country {
    private String code;
    private String name;
    private int gold;
    private int silver;
    private int bronze;

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public void addMedal(String medal) {
        if(medal.equals("Gold")) {
            gold++;
        }
        else if(medal.equals("Silver")) {
            silver++;
        }
        else if(medal.equals("Bronze")) {
            bronze++;
        }
     }

     public String toString() {
        return code + " G:" + gold + ", S:" + silver + ", B:" + bronze;
     }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getGold() {
        return gold;
    }

    public int getSilver() {
        return silver;
    }

    public int getBronze() {
        return bronze;
    }
}
