import java.io.File;
import java.io.FileNotFoundException;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by yao on 8/24/2016.
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String output = "";

                for(int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);

                    if(Character.isLetter(c)) {
                        output += Character.toLowerCase(c);
                        //add space in bettwen words
                        if(i != line.length() - 1) {
                            char nextC = line.charAt(i + 1);
                            if (!Character.isLetter(nextC))
                                output += " ";
                        }
                    }
                }

                System.out.println(output);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
