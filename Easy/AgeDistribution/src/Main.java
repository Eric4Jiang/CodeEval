import java.util.Scanner;
        import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                int age = Integer.parseInt(scanner.nextLine());

                if(age < 0 || age > 100)
                    System.out.println("This program is for humans");
                else if(0 <= age && age <= 2)
                    System.out.println("Still in Mama's arms");
                else if(age <= 4)
                    System.out.println("Preschool Maniac");
                else if(age <= 11)
                    System.out.println("Elementary school");
                else if(age <= 14)
                    System.out.println("Middle school");
                else if(age <= 18)
                    System.out.println("High school");
                else if(age <= 22)
                    System.out.println("College");
                else if(age <= 65)
                    System.out.println("Working for the man");
                else if(age <= 100)
                    System.out.println("The Golden Years");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
