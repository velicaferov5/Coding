package exercises;

public class Node {
    private Node leftChild, rightChild;

    public Node(Node leftChild, Node rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public static void main(String[] args) {
        Node leaf1 = new Node(null, null);
        Node leaf2 = new Node(null, null);
        Node node = new Node(leaf1, null);
        Node root = new Node(node, leaf2);

        System.out.println(root.height());
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    /**
     * Recursively calculates height of tree
     *
     * @return height
     */
    public int height() {
        if (this.leftChild == null && this.rightChild == null)
            return 0;

        else {
            // calculate the depth of each subtree
            int leftHeight = 0;
            int rightHeight = 0;

            if (this.leftChild != null)
                leftHeight = this.leftChild.height();

            if (this.rightChild != null)
                rightHeight = this.rightChild.height();

            // return larger one
            if (leftHeight > rightHeight)
                return (leftHeight + 1);
            else
                return (rightHeight + 1);
        }
    }
}