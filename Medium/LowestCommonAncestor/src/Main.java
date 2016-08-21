import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by eric on 7/23/16.
 */

class node {

    public int value;
    public node left, right, parent;

    public node(int value) {
        this.value = value;
    }

    public boolean add(int value) {
        if (value == this.value)
            return false;
        else if (value < this.value) {
            if (left == null) {
                left = new node(value);
                return true;
            } else
                return left.add(value);
        } else if (value > this.value) {
            if (right == null) {
                right = new node(value);
                return true;
            } else
                return right.add(value);
        }
        return false;
    }

    public void displayLeft() {
        System.out.println(left.value);
        if(left.left != null)
            left.displayLeft();
        if(left.right != null)
            left.displayRight();
    }
    public void displayRight() {
        System.out.println(right.value);
        if(right.left != null)
            right.displayLeft();
        if(right.right != null)
            right.displayRight();
    }

}

class BinaryTree {

    public node root;

    BinaryTree() {

    }

    public boolean isEmpty() {
        return (root == null);
    }

    public boolean add(int value) {
        if (root == null) {
            root = new node(value);
            return true;
        } else
            return root.add(value);
    }

    public void display() {
        System.out.println(root.value);
        root.displayLeft();
        root.displayRight();
    }

    public int findAncestor(int num1, int num2) {
        node currentNode = root;
        while(currentNode != null) {
            int value = currentNode.value;
            if(value == num1 || value == num2)
                return value;
            //if node are on opposite sides of current node
            if((value > num1 && value < num2) || (value < num1 && value > num2))
                return value;
            else if(value > num1 && value > num2)
                currentNode = currentNode.left;
            else
                currentNode = currentNode.right;
        }
        return -1;
    }

}

public class Main {

    public static void main(String[] args) {
        //make the tree
        BinaryTree tree = new BinaryTree();
        tree.add(30);
        tree.add(8);
        tree.add(52);
        tree.add(3);
        tree.add(20);
        tree.add(10);
        tree.add(29);

        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] num = line.split(" ");
                int ancestor = tree.findAncestor(Integer.parseInt(num[0]), Integer.parseInt(num[1]));
                System.out.println(ancestor);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
