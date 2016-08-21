import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

interface Stack {

    boolean isEmpty();
    void push(int num);
    int pop();

}

class StackArray implements Stack {

    ArrayList<Integer> stack;

    public StackArray() {
        stack = new ArrayList<Integer>();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void push(int num) {
        stack.add(num);
    }
    public int pop() {
        int element = stack.get(stack.size()-1);
        stack.remove(stack.size() - 1);
        return element;
    }

}

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                StackArray stack = new StackArray();

                String line = scanner.nextLine();
                String[] numbers = line.split(" ");
                for(int i = 0; i < numbers.length; i++)
                    stack.push(Integer.parseInt(numbers[i]));

                boolean alternative = true;
                while(!stack.isEmpty()) {
                    int lastElement = stack.pop();
                    if(alternative)
                        System.out.print(lastElement + " ");
                    alternative = !alternative;
                }
                System.out.print("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
