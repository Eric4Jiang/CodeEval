import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 8/21/16.
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] nums = line.split(" ");
                int x = Integer.parseInt(nums[0]); // Fizz if divisible by x
                int y = Integer.parseInt(nums[1]); // BUZZ is divisible by y
                int N = Integer.parseInt(nums[2]); // number to count up to

                for(int i = 1; i <= N; i++) {
                    if(i % x  == 0 && i % y == 0)
                        System.out.print("FB ");
                    else if(i % x == 0)
                        System.out.print("F ");
                    else if(i % y == 0)
                        System.out.print("B ");
                    else
                        System.out.print(Integer.toString(i) + " ");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
