import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 8/22/16.
 */
public class Main {

    public static String switchCase(String sentence) {
        String switched = "";
        for(int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);

            if(Character.isLetter(c)) {
                if(Character.isUpperCase(c))
                    switched += Character.toLowerCase(c);
                else
                    switched += Character.toUpperCase(c);
            } else {
                switched += c;
            }
        }

        return switched;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(switchCase(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
