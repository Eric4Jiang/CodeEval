import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 7/23/16.
 */
public class Main {

    public static char findNonRepeatChar(String sentence) {
        int[] hashTable = new int[126];
        //store instances of each char in array
        for(int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            hashTable[c]++;
        }

        for(int j = 0; j < sentence.length(); j++) {
            if(hashTable[sentence.charAt(j)] == 1)
                return sentence.charAt(j);
        }
        return '\0';
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                char firstNonRepeatedChar = findNonRepeatChar(line);
                System.out.println(firstNonRepeatedChar);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
