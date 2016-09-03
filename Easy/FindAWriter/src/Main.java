import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 9/3/16.
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.equals("")) {
                    continue;
                }
                String[] sep = line.split("\\| ");

                String name = sep[0];
                String[] nums = sep[1].split(" ");

                for(int i = 0; i < nums.length; i++) {
                    int letterPos = Integer.parseInt(nums[i]);

                    System.out.print(name.charAt(letterPos - 1));
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
