import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static int[] coins = {1,3,5};

    public static int minimumCoins(int total) {
        int count = 0;

        for(int i = 2; i >= 0; i--) {
            count += total / coins[i];
            total = total % coins[i];
        }

        return count;
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int num = Integer.parseInt(line);

                System.out.println(minimumCoins(num));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}




