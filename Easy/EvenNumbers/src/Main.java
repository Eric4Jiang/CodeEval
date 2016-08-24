import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 8/23/16.
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int num = Integer.parseInt(line);

                if(num % 2 == 0)
                    System.out.println(1);
                else
                    System.out.println(0);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
