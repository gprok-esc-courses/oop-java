package p04_files.olympics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Medals {
    public static void main(String[] args) {
        HashMap<String, Country> countries = new HashMap<>();

        try {
            FileReader file = new FileReader("so_medals.csv");
            BufferedReader reader = new BufferedReader(file);
            String line;
            while((line = reader.readLine()) != null) {
                String [] tokens = line.split(";");
                if(tokens[0].equals("City")) {
                    continue;
                }
                String code = tokens[7];
                String name = tokens[8];
                String medal = tokens[10];

                if(countries.containsKey(code)) {
                    Country country = countries.get(code);
                    country.addMedal(medal);
                }
                else {
                    Country country = new Country(code, name);
                    country.addMedal(medal);
                    countries.put(code, country);
                }
            }

            Collection<Country> countryList = countries.values();
            for (Country c : countryList) {
                System.out.println(c);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
