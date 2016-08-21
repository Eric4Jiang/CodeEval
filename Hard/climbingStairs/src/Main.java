import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by eric on 8/2/16.
 */
public class Main {

    static BigInteger[] count = new BigInteger[1001];

    public static void initArray() {
        for(int i = 0; i < 1001; i++) {
            count[i] = BigInteger.valueOf(0);
        }
    }

    public static BigInteger findNumOfSteps(int steps) {
        //base cases
        if(steps <= 2)
            return new BigInteger(Integer.toString(steps));

      //if not already calculated
        if(count[steps].equals(BigInteger.valueOf(0)))
            count[steps] = findNumOfSteps(steps - 1).add(findNumOfSteps(steps - 2));

        return count[steps];
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line.trim();

                int steps = Integer.parseInt(line);
                initArray();

                BigInteger distinctWays = findNumOfSteps(steps);
                System.out.println(distinctWays);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
