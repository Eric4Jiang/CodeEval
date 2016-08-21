import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 8/7/16.
 */
public class Main {

    public static int findDuplicate(int[] nums) {
        int[] hash = new int[nums.length];
        int duplicate = 0;

        for(int i = 0; i < nums.length; i++) {
            hash[nums[i]]++;
            if(hash[nums[i]] > 1) {
                duplicate = nums[i];
                break;
            }
        }
        return duplicate;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] SemiColon = line.split(";");

                int size = Integer.parseInt(SemiColon[0]);
                String[] nums = SemiColon[1].split(",");
                int[] numbers = new int[nums.length];

                //make array
                for(int i = 0; i < nums.length; i++)
                    numbers[i] = Integer.parseInt(nums[i]);

                int duplicate = findDuplicate(numbers);
                System.out.println(duplicate);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
