// Matthew Valencia

// Tuesday June 4th

// Binary Printing Trees Lab 7

// Youtube, W3 Schools, ChatGPT

// Extra credit for doing it iteratively instead of recursively.

// TestClass to test the functionality of the binary search tree
public class TestClass {
    public static void main(String[] args) {
        ManagerClass bst = new ManagerClass(); // Create a new binary search tree
        int[] values = {50, 23, 75, 73, 2, 68, 10, 1, 43, 29}; // Values to be inserted

        // Print the values being inserted
        System.out.println("Inserting the Following values:");
        for (int value : values) {
            System.out.print(value + " ");
            bst.add(value); // Insert each value into the tree
        }
        System.out.println();
        System.out.println();

        // Print pre-order traversal
        System.out.println("Pre-Order Traversal:");
        for (int value : bst.preOrderTraversal()) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println();

        // Print in-order traversal
        System.out.println("In-Order Traversal:");
        for (int value : bst.inOrderTraversal()) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println();

        // Print post-order traversal
        System.out.println("Post-Order Traversal:");
        for (int value : bst.postOrderTraversal()) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println();
    }
}

