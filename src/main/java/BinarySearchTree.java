public class BinarySearchTree extends BinaryTree {
    public void insert(int element) {
        insertRec(root, element);
    }

    BinaryTreeNode insertRec(BinaryTreeNode node, int element) {
        if (root == null) {
            root = new BinaryTreeNode(element);
            return root;
        }

        if (element < root.element)
            root.addLeftChild(insertRec(root.getLeftChild(), element));
        else if (element > root.element)
            root.addRightChild(insertRec(root.getRightChild(), element));

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

        /* loop down to find the leftmost leaf */
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
        rebalance(root);
    }

    private BinaryTreeNode rotateRight(BinaryTreeNode y) {
        BinaryTreeNode x = y.getLeftChild();
        BinaryTreeNode z = x.getRightChild();
        x.addRightChild(y);
        y.addLeftChild(z);
        return x;
    }

    private BinaryTreeNode rotateLeft(BinaryTreeNode y) {
        BinaryTreeNode x = y.getRightChild();
        BinaryTreeNode z = x.getLeftChild();
        x.addLeftChild(y);
        y.addRightChild(z);
        return x;
    }

    private BinaryTreeNode rebalance(BinaryTreeNode z) {
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.getRightChild().getRightChild()) > height(z.getRightChild().getLeftChild())) {
                z = rotateLeft(z);
            } else {
                z.addRightChild(rotateRight(z.getRightChild()));
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.getLeftChild().getLeftChild()) > height(z.getLeftChild().getRightChild()))
                z = rotateRight(z);
            else {
                z.addLeftChild(rotateLeft(z.getLeftChild()));
                z = rotateRight(z);
            }
        }
        return z;
    }

    private int getBalance(BinaryTreeNode n) {
        return (n == null) ? 0 : height(n.getRightChild()) - height(n.getLeftChild());
    }

    private int height(BinaryTreeNode n) {
        return 1 + Math.max(height(n.getLeftChild()), height(n.getRightChild()));
    }
}
