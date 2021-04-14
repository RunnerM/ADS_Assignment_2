public class BinaryTreeNode {
    int element;
    BinaryTreeNode leftChild;
    BinaryTreeNode rightChild;

    public BinaryTreeNode(int element) {
        this.element = element;
        this.rightChild = null;
        this.leftChild = null;
    }

    void setElement(int element) {
        this.element = element;
    }

    public int getElement() {
        return element;
    }

    public void addLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public void addRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }
}
