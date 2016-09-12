import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.*;
/**
 * Created by eric on 7/18/16.
 */
public class Main {

    public static int distanceSq(Point A, Point B) {
        int distanceSq;
        //distance formula without square root
        int x1 = (int)A.getX(), y1 = (int)A.getY(), x2 = (int)B.getX(), y2 = (int)B.getY();
        distanceSq = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);

        return distanceSq;
    }

    public static boolean isSquare(Point[] points) { //points aren't in order

        Point A = points[0], B = points[1], C = points[2], D = points[3];

        //calculate distance of every point from A
        double AB = distanceSq(A, B);
        double AC = distanceSq(A, C);
        double AD = distanceSq(A, D);

        if(AB == AC && AC == AD)
            return false;
        // If lengths of AB and AC, then
        // following conditions must met to form a square.
        // 1) Square of length of AD is same as twice
        //    the square of AB
        // 2) BD and CD are equal

        if(AB == AC && AB*2 == AD) {
            int BD = distanceSq(B, D);
            return (distanceSq(C, D) == BD && BD == AB && AD == distanceSq(B, C));
        }

        //similar cases
        if (AB == AD && AD*2 == AC) {
            int CD = distanceSq(C, D);
            return ((CD == distanceSq(B, C) && CD == AB) && AC == distanceSq(B, D));
        }
        if(AC == AD && AC*2 == AB) {
            int BC = distanceSq(B, C);
            return (distanceSq(B, D) == BC && BC == AC && AB == distanceSq(C, D));
        }

        return false;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //retrieve the coordinate points from input
                line = line.replace("(", "");
                line = line.replace(")", "");
                line = line.replace(" ", "");
                String[] commaSeparated = line.split(",");

                Point[] points = new Point[commaSeparated.length/2];
                int pointPos = 0;

                //store points
                for(int i = 0; i < commaSeparated.length; i+=2) {
                    int x = Integer.parseInt(commaSeparated[i]);
                    int y = Integer.parseInt(commaSeparated[i + 1]);
                    Point point = new Point(x, y);
                    points[pointPos] = point;
                    pointPos++;
                }

                System.out.println(isSquare(points));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
