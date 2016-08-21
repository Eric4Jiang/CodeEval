import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 8/11/16.
 */
public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(" ");
                for(int i = words.length - 1; i >= 0; i--)
                    System.out.print(words[i] + " ");
                System.out.print("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
