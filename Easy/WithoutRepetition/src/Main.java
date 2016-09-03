import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 8/30/16.
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                System.out.print(line.charAt(0));
                for(int i = 1; i < line.length(); i++) {
                    if(line.charAt(i) != line.charAt(i - 1))
                        System.out.print(line.charAt(i));
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
