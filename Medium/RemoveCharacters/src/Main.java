import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 7/22/16.
 */
public class Main {

    public static String removeChars(String source, String scrubbedChars) {
        String scrubbedSource = source;

        //remove every char in scrubbedSchars from source
        for(int i = 0; i < scrubbedChars.length(); i++) {
            String letter =  Character.toString(scrubbedChars.charAt(i));
            scrubbedSource = scrubbedSource.replace(letter, "");
        }
        return scrubbedSource;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] commaSeparated = line.split(", ");
                String source = commaSeparated[0];
                String scrubbedChars = commaSeparated[1];

                String scrubbedSource = removeChars(source, scrubbedChars);
                System.out.println(scrubbedSource);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
