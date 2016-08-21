import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 6/24/16.
 */
public class main {

    public static boolean isPrime(int num) {
        for(int j = 2; j < num; j++) {
            if((num % j) == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int primes = 0, j = 2, sum = 0;
        while(primes < 1000) {
            if(isPrime(j)) {
                sum += j;
                primes++;
            }
            j++;
        }
        System.out.println(sum);
    }
}
