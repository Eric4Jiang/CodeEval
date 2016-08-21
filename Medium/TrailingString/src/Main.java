import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 7/24/16.
 */
public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {

                String line = scanner.nextLine();
                line = line.trim();

                if(line.length() == 0)
                    continue;
                String[] commaSeparated = line.split(",");

                String A = commaSeparated[0];
                A.trim();
                String B = commaSeparated[1];
                B.trim();

                int startIndex = A.length() - B.length();

                if(A.endsWith(B))
                    System.out.println(1);
                else
                    System.out.println(0);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
