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
                String[] sep = line.split(" ");
                for(int i = 0; i < sep.length; i++) {
                    String swappedWord = "";
                    swappedWord += sep[i].charAt(sep[i].length() -1) + sep[i].substring(1, sep[i].length() - 1) + sep[i].charAt(0);
                    System.out.print(swappedWord + " ");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
