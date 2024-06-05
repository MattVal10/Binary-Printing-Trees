// Matthew Valencia

// Tuesday June 4th

// Binary Printing Trees Lab 7

// Youtube, W3 Schools, ChatGPT

// Extra credit for doing it iteratively instead of recursively.

// NodeClass represents a single node in the binary search tree
class NodeClass {
    int value; // The value stored in the node
    NodeClass left; // Reference to the left child
    NodeClass right; // Reference to the right child

    // Constructor to initialize a node with a value
    public NodeClass(int value) {
        this.value = value;
        left = null; // Initialize left child as null
        right = null; // Initialize right child as null
    }
}
