import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 8/6/16.
 */
public class Main {

    //make sure they're smae length and if s2 is a substring of s1 + s1
    static boolean isRotation(String s1,String s2) {
        return (s1.length() == s2.length()) && ((s1+s1).contains(s2));
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(",");

                String original = words[0];
                String rotated = words[1];

                if(isRotation(original, rotated)) {
                    System.out.println("True");
                }
                else
                    System.out.println("False");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
