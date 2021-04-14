import java.util.ArrayList;

public class BinaryTree {
    BinaryTreeNode root;

    public BinaryTree(int root) {
        this.root = new BinaryTreeNode(root);
    }

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return calculateSize(root);
    }

    private int calculateSize(BinaryTreeNode node) {
        if (node == null)
            return 0;
        else
            return (calculateSize(node.getLeftChild()) + 1 + calculateSize(node.getRightChild()));
    }

    public boolean contains(int element) {
        return containsNodeRecursive(root, element);
    }

    private boolean containsNodeRecursive(BinaryTreeNode current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.getElement()) {
            return true;
        }
        return value < current.getElement()
                ? containsNodeRecursive(current.getLeftChild(), value)
                : containsNodeRecursive(current.getRightChild(), value);
    }

    //----------In Order---------------------------
    public ArrayList<Integer> inOrder() {
        ArrayList<Integer> result = new ArrayList();
        orderInorder(root, result);
        return result;
    }

    void orderInorder(BinaryTreeNode node, ArrayList<Integer> result) {
        if (node == null)
            return;
        orderInorder(node.getLeftChild(), result);
        result.add(node.getElement());
        orderInorder(node.getRightChild(), result);
    }

    //----------Pre Order---------------------------
    public ArrayList<Integer> preorder() {
        ArrayList<Integer> result = new ArrayList();
        orderPreorder(root, result);
        return result;
    }

    void orderPreorder(BinaryTreeNode node, ArrayList<Integer> result) {
        if (node == null)
            return;
        result.add(node.getElement());
        orderPreorder(node.getLeftChild(), result);
        orderPreorder(node.getRightChild(), result);
    }

    //----------Post Order--------------------------
    public ArrayList<Integer> postorder() {
        ArrayList<Integer> result = new ArrayList();
        orderPostorder(root, result);
        return result;
    }

    void orderPostorder(BinaryTreeNode node, ArrayList<Integer> result) {
        if (node == null)
            return;

        orderPostorder(node.getLeftChild(), result);
        orderPostorder(node.getRightChild(), result);
        result.add(node.getElement());
    }

    //----------Level Order-------------------------

    public ArrayList<Integer> levelOrder() {
        ArrayList<Integer> result = new ArrayList();
        orderLevelorder(result);
        return result;
    }

    private void orderLevelorder(ArrayList<Integer> result) {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            printGivenLevel(root, i, result);
    }

    private void printGivenLevel(BinaryTreeNode root, int level, ArrayList<Integer> result) {
        if (root == null)
            return;
        if (level == 1)
            result.add(root.getElement());
        else if (level > 1) {
            printGivenLevel(root.getLeftChild(), level - 1, result);
            printGivenLevel(root.getRightChild(), level - 1, result);
        }
    }

    //---------- Height ------------------------------

    public int height() {
        return height(root);
    }

    private int height(BinaryTreeNode root) {
        if (root == null)
            return 0;
        else {
            int lheight = height(root.getLeftChild());
            int rheight = height(root.getRightChild());

            if (lheight > rheight)
                return (lheight + 1);
            else return (rheight + 1);
        }
    }
}
