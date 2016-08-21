import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static int[] fib = new int[32];

    public static int Fib(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        if(fib[n - 1] == 0) {
            fib[n - 1] = Fib(n - 1);
        }
        if(fib[n - 2] == 0) {
            fib[n - 2] = Fib(n - 2);
        }

        fib[n] = fib[n - 1] + fib[n -2];
        return fib[n];
    }


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {

            //for every case
            while(scanner.hasNextInt()) {
                int num = scanner.nextInt();
                System.out.println(Fib(num));
            }
        } catch (FileNotFoundException e) {
             e.printStackTrace();
        }

        System.out.println(Fib(7));
    }
}
