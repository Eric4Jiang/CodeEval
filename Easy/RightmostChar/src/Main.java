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
                String[] commaSep = line.split(",");

                String sentence = commaSep[0];
                char c = commaSep[1].charAt(0);

                int posOfRightmostC = -1;
                for(int i = 0; i < sentence.length(); i++) {
                    if(sentence.charAt(i) == c)
                        posOfRightmostC = i;
                }

                System.out.println(posOfRightmostC);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
