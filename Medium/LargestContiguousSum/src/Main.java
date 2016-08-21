import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 8/4/16.
 */
public class Main {

    public static int max_subarray(int low, int high, ) {
        //base case
        if()
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] numbers = line.split(",");
                int[] num = new int[numbers.length];

                for(int i = 0; i < numbers.length; i++)
                    num[i] = Integer.parseInt(numbers[i]);

                System.out.println(max_subarray(num));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
