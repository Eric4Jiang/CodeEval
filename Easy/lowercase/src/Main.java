import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 8/14/16.
 */
public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                System.out.println(line.toLowerCase());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
