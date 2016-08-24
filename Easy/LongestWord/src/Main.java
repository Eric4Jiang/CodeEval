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
                String[] words = line.split(" ");

                int maxLength = 0;
                int pos = 0;

                for(int i = 0; i < words.length; i++) {
                    if(words[i].length() > maxLength) {
                        maxLength = words[i].length();
                        pos = i;
                    }
                }

                System.out.println(words[pos]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
