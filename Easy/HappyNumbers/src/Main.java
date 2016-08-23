import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by eric on 8/22/16.
 */
public class Main {

    public static int isHappy(int num){
        Set<Integer> visited = new HashSet<>();

        while(!visited.contains(num)){
            visited.add(num);
            num = sumOfDigitsSquared(num);

            if(num == 1)
                return 1;
        }

        return 0;
    }

    public static int sumOfDigitsSquared(int n) {
        int sum = 0;

        //goes through each digit
        while(n > 0){
            int digit = n % 10;
            sum += Math.pow(digit,2);
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int num = Integer.parseInt(line);
                System.out.println(isHappy(num));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
