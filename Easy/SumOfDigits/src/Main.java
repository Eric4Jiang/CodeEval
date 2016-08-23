import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 8/22/16.
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int sum = 0;
                for(int i = 0; i < line.length(); i++){
                    sum += line.charAt(i) - '0';
                }
                System.out.println(sum);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
