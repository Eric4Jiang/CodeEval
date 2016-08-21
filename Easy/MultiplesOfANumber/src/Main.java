import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 8/12/16.
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] num = line.split(",");

                int threshold = Integer.parseInt(num[0]);
                int power2n = Integer.parseInt(num[1]);
                int newPower2n = power2n;

                while(newPower2n < threshold)
                    newPower2n += power2n;

                System.out.println(newPower2n);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
