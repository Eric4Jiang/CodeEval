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
                String[] split = line.split(" \\| ");

                String developer = split[0];
                String design = split[1];
                int bugs = 0;

                for(int i = 0; i < developer.length(); i++) {
                    if(developer.charAt(i) != design.charAt(i))
                        bugs++;
                }

                if(bugs == 0)
                    System.out.println("Done");
                else if(bugs <= 2)
                    System.out.println("Low");
                else if(bugs <= 4)
                    System.out.println("Medium");
                else if(bugs <= 6)
                    System.out.println("High");
                else if(bugs > 6)
                    System.out.println("Critical");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
