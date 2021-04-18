import java.util.ArrayList;

public class BinarySearchTree extends BinaryTree {
    public BinarySearchTree(int root) {
        super(root);
    }

    public BinarySearchTree() {
        super();
    }

    public void insert(int element) {
        insertRec(root, element);
    }

    private BinaryTreeNode insertRec(BinaryTreeNode root, int element) {
        if (root == null) {
            root = new BinaryTreeNode(element);
            return root;
        }

        if (element < root.element) {
            root.addLeftChild(insertRec(root.getLeftChild(), element));

        } else if (element > root.element) {
            root.addRightChild(insertRec(root.getRightChild(), element));

        }

        return root;
    }

    public void removeElement(int key) {
        root = deleteRec(root, key);
    }

    private BinaryTreeNode deleteRec(BinaryTreeNode root, int key) {
        if (root == null)
            return root;

        if (key < root.getElement())
            root.addLeftChild(deleteRec(root.getLeftChild(), key));
        else if (key > root.getElement())
            root.addRightChild(deleteRec(root.getRightChild(), key));

        else {
            if (root.getLeftChild() == null)
                return root.getRightChild();
            else if (root.getRightChild() == null)
                return root.getLeftChild();

            root.setElement(minValue(root.getRightChild()));

            root.addRightChild(deleteRec(root.getRightChild(), root.getElement()));
        }

        return root;
    }

    private int minValue(BinaryTreeNode root) {
        int minv = root.getElement();
        while (root.getLeftChild() != null) {
            minv = root.getLeftChild().getElement();
            root = root.getLeftChild();
        }
        return minv;
    }
    //------------------------------------------------

    public int findMin() {
        BinaryTreeNode current = root;


        while (current.getLeftChild() != null) {
            current = current.getLeftChild();
        }
        return (current.getElement());
    }

    public int findMax() {
        return findMax(root);
    }

    private int findMax(BinaryTreeNode node) {
        if (node == null)
            return Integer.MIN_VALUE;

        int res = node.getElement();
        int lres = findMax(node.getLeftChild());
        int rres = findMax(node.getRightChild());

        if (lres > res)
            res = lres;
        if (rres > res)
            res = rres;
        return res;

    }
//-------------------balance----------

    public void rebalance() {
        root=rebalance_2();
    }

    public BinaryTreeNode rebalance_2() {

        ArrayList<BinaryTreeNode> nodes = new ArrayList<BinaryTreeNode>();
        nodes = this.inOrderNode();


        int n = nodes.size();
        return buildTreeUtil(nodes, 0, n - 1);


    }

    BinaryTreeNode buildTreeUtil(ArrayList<BinaryTreeNode> nodes, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        BinaryTreeNode node = nodes.get(mid);

        node.addLeftChild(buildTreeUtil(nodes, start, mid - 1));
        node.addRightChild(buildTreeUtil(nodes, mid + 1, end));

        return node;
    }

}
