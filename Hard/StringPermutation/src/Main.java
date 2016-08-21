import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static String line;

    //sort the string in order of ascii values
    public static String sort(String line) {

        char[] c_array = new char[line.length()];
        String alphabetized = "";

        for(int i = 0; i < line.length(); i++)
            c_array[i] = line.charAt(i);

        Arrays.sort(c_array);

        //rebuild String
        for(int i = 0; i < c_array.length; i++)
            alphabetized += c_array[i];

        return alphabetized;
    }

    public static ArrayList<String> findPermutation(String prefix, String lettersLeft) {

        ArrayList<String> permutations = new ArrayList<>();

        //base case - found new permutation
        if(prefix.length() == line.length())  {
            permutations.add(prefix);
        }
        else {
            for (int i = 0; i < lettersLeft.length(); i++) {
                String letter_at_i = Character.toString(lettersLeft.charAt(i));

                String newPrefix = prefix + letter_at_i;

                //remove ith letter from lettersleft
                String newLettersLeft = lettersLeft.replace(letter_at_i, "");

                ArrayList<String> temp = findPermutation(newPrefix, newLettersLeft);
                //copy over strings
                for(String x: temp)
                    permutations.add(x);
            }
        }

        return permutations;
    }

    public static ArrayList<String> getPermutation() {

        //sort word into alphabetical order
        line = sort(line);

        ArrayList<String> permutation = new ArrayList<>();

        ArrayList<String> temp = findPermutation("", line);

        for(String x : temp)
            permutation.add(x);

        return permutation;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                line = scanner.nextLine();
                line.trim();

                ArrayList<String> permutation = getPermutation();

                //print power sets
                int i = 0;
                for (String p : permutation) {
                    if(i == permutation.size() - 1)
                        System.out.print(p);
                    else
                        System.out.print(p + ",");
                    i++;
                }
                System.out.print("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

