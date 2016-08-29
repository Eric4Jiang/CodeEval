import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 8/29/16.
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                char c = line.charAt(0);
                int subStringSize = line.length();

                for(int i = 1; i < line.length(); i++) {
                    if (line.charAt(i) == c) {
                        subStringSize = i;
                        break;
                    }
                }

                System.out.println(subStringSize);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
