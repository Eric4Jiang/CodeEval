import java.io.File;

/**
 * Created by eric on 8/30/16.
 */
public class Main {
    public static void main(String[] args) {
        File file = new File(args[0]);

        System.out.println(file.length());

    }
}
