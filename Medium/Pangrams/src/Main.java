import java.io.CharArrayReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 8/12/16.
 */
public class Main {

    public static String pangram(String sentence) {

        String missingLetters = "";
        int[] hashTable = new int[26];

        //document every letter used
        for(int i = 0; i < sentence.length(); i++) {
            char letter = sentence.charAt(i);
            if(Character.isLetter(letter)) {
                //upper case letter
                if (Character.isUpperCase(letter))
                    hashTable[letter - 'A']++;
                    //lower case
                else
                    hashTable[letter - 'a']++;
            }
        }

        boolean isPangram = true;

        //find missing letters
        for(int i = 0; i < hashTable.length; i++) {
            if(hashTable[i] == 0) {
                char letter = (char)(i + 97);
                missingLetters += letter;
                isPangram = false;
            }
        }

        return (isPangram) ? "NULL" : missingLetters;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String missingLetters = pangram(line);

                System.out.println(missingLetters);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
