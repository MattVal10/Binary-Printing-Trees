// Matthew Valencia

// Tuesday June 4th

// Binary Printing Trees Lab 7

// Youtube, W3 Schools, ChatGPT

// Extra credit for doing it iteratively instead of recursively. 
// Check at line 14 (add method), line 43 (search method), line 52 (remove method), 
// line 83 (pre-order traversal), line 107 (in-order traversal), and line 129 (post-order traversal).

// Import necessary libraries
import java.util.*;

// ManagerClass handles the operations on the binary search tree
class ManagerClass {
    private NodeClass root; // Root node of the tree

    // Constructor to initialize the tree with no nodes
    public ManagerClass() {
        root = null;
    }

    // Iterative add method to insert a new value into the tree
    public void add(int value) {
        NodeClass newNode = new NodeClass(value); // Create a new node with the given value
        if (root == null) { // If the tree is empty
            root = newNode; // Set the new node as the root
            return;
        }
        NodeClass current = root; // Start from the root
        NodeClass parent = null; // Parent node of the current node
        while (true) {
            parent = current;
            if (value < current.value) { // If the value is less than the current node's value
                current = current.left; // Move to the left child
                if (current == null) { // If the left child is null
                    parent.left = newNode; // Insert the new node as the left child
                    return;
                }
            } else { // If the value is greater than or equal to the current node's value
                current = current.right; // Move to the right child
                if (current == null) { // If the right child is null
                    parent.right = newNode; // Insert the new node as the right child
                    return;
                }
            }
        }
    }

    // Iterative search method to find a value in the tree
    public boolean search(int value) {
        NodeClass current = root; // Start from the root
        while (current != null) { // Traverse the tree until the value is found or the end is reached
            if (current.value == value) { // If the value is found
                return true; // Return true
            } else if (value < current.value) { // If the value is less than the current node's value
                current = current.left; // Move to the left child
            } else { // If the value is greater than the current node's value
                current = current.right; // Move to the right child
            }
        }
        return false; // Return false if the value is not found
    }

    // Iterative remove method to delete a value from the tree
    public void remove(int value) {
        root = removeNode(root, value); // Start the removal process from the root
    }

    // Helper method to remove a node with the given value
    private NodeClass removeNode(NodeClass root, int value) {
        if (root == null) { // If the tree is empty
            return root; // Return null
        }
        NodeClass parent = null;
        NodeClass current = root;
        while (current != null && current.value != value) { // Traverse the tree to find the node to be removed
            parent = current;
            if (value < current.value) { // Move to the left child if the value is less
                current = current.left;
            } else { // Move to the right child if the value is greater
                current = current.right;
            }
        }
        if (current == null) { // If the node is not found
            return root; // Return the original tree
        }
        if (current.left == null || current.right == null) { // If the node has at most one child
            NodeClass newCurr;
            if (current.left == null) { // If the left child is null
                newCurr = current.right;
            } else { // If the right child is null
                newCurr = current.left;
            }
            if (parent == null) { // If the node to be removed is the root
                return newCurr; // Replace the root with the new current node
            }
            if (current == parent.left) { // If the node to be removed is a left child
                parent.left = newCurr;
            } else { // If the node to be removed is a right child
                parent.right = newCurr;
            }
        } else { // If the node has two children
            NodeClass p = null;
            NodeClass temp;
            temp = current.right;
            while (temp.left != null) { // Find the minimum node in the right subtree
                p = temp;
                temp = temp.left;
            }
            if (p != null) {
                p.left = temp.right; // Remove the minimum node from its original position
            } else {
                current.right = temp.right; // If the minimum node is the right child
            }
            current.value = temp.value; // Replace the value of the node to be removed with the minimum node's value
        }
        return root; // Return the updated tree
    }

    // Pre-order traversal (iterative)
    public List<Integer> preOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        if (root == null) { // If the tree is empty
            return result; // Return an empty list
        }
        Stack<NodeClass> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            NodeClass node = stack.pop(); // Process the current node
            result.add(node.value); // Add the current node's value to the result list
            if (node.right != null) { // Push the right child onto the stack
                stack.push(node.right);
            }
            if (node.left != null) { // Push the left child onto the stack
                stack.push(node.left);
            }
        }
        return result; // Return the result list
    }

    // In-order traversal (iterative)
    public List<Integer> inOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        if (root == null) { // If the tree is empty
            return result; // Return an empty list
        }
        Stack<NodeClass> stack = new Stack<>();
        NodeClass current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) { // Traverse to the leftmost node
                stack.push(current);
                current = current.left;
            }
            current = stack.pop(); // Process the current node
            result.add(current.value); // Add the current node's value to the result list
            current = current.right; // Move to the right child
        }
        return result; // Return the result list
    }

    // Post-order traversal (iterative)
    public List<Integer> postOrderTraversal() {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) { // If the tree is empty
            return result; // Return an empty list
        }
        Stack<NodeClass> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            NodeClass node = stack.pop(); // Process the current node
            result.addFirst(node.value); // Add the current node's value to the front of the result list
            if (node.left != null) { // Push the left child onto the stack
                stack.push(node.left);
            }
            if (node.right != null) { // Push the right child onto the stack
                stack.push(node.right);
            }
        }
        return result; // Return the result list
    }
}
