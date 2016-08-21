import java.io.*;
import java.util.*;
import java.lang.String;

import static java.lang.Integer.parseInt;

public class main {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new File(args[0]))) {

            //for every case
            while(scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String temp = "";

                //split the line by commas
                String[] noCommas = line.split(",");

                //stores all unique numbers
                ArrayList<String> unique = new ArrayList<>();

                //if the number changed store it
                for(int i = 0, j = 0; i < noCommas.length; i++) {
                    if(!temp.equals(noCommas[i])) {
                        unique.add(j, noCommas[i]);
                        j++;
                    }
                    temp = noCommas[i];
                }
                //print unique elements with commas
                for(int k = 0; k < unique.size(); k++) {
                    if(unique.get(k) != null) {
                        if (k != unique.size() - 1) {
                            System.out.print(unique.get(k) + ",");
                        } else System.out.print(unique.get(k));
                    }
                }

                System.out.println("\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
