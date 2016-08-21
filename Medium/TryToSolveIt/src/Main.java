import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 8/14/16.
 */
public class Main {

    public static String decipher(String sentence) {
        //uses a hashtable to map original alhpabets to encoded ones
        char[] encoded = {'u', 'v', 'w', 'x', 'y', 'z', //maps a - g to these alphabets respectively
                          'n', 'o', 'p', 'q', 'r', 's', 't', // maps h - m
                          'g', 'h', 'i', 'j', 'k', 'l', 'm', // maps n - t
                          'a', 'b', 'c', 'd', 'e', 'f', 'g'}; // maps u - z

        String deciphered = "";

        for(int i = 0; i < sentence.length(); i++)
            deciphered += encoded[sentence.charAt(i) - 'a'];

        return deciphered;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line.trim();
                System.out.println(decipher(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
