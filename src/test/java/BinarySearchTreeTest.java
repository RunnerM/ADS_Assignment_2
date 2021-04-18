import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTreeTest {

    BinarySearchTree binarySearchTree;
    BinaryTreePrint binaryTreePrint;

    @BeforeEach
    void setUp() {
        binarySearchTree = new BinarySearchTree(20);
        binaryTreePrint = new BinaryTreePrint();

        binarySearchTree.root.leftChild= new BinaryTreeNode(8);
        binarySearchTree.root.rightChild = new BinaryTreeNode(22);
        binarySearchTree.root.leftChild.leftChild = new BinaryTreeNode(4);
        binarySearchTree.root.leftChild.rightChild = new BinaryTreeNode(12);
        binarySearchTree.root.leftChild.rightChild.leftChild = new BinaryTreeNode(10);
        binarySearchTree.root.leftChild.rightChild.rightChild = new BinaryTreeNode(14);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void insert() {
        binaryTreePrint.printTree(binarySearchTree.root);
        binarySearchTree.insert(2);
        ArrayList<Integer> tree =binarySearchTree.inOrder();
        assertEquals(true,tree.contains(2));
        binaryTreePrint.printTree(binarySearchTree.root);

    }

    @Test
    void removeElement() {
        binarySearchTree.removeElement(4);
        assertEquals(false, binarySearchTree.contains(4));
    }

    @Test
    void findMin() {
        ArrayList<Integer> nodes= binarySearchTree.inOrder();
        System.out.println(Collections.min(nodes));
        System.out.println(binarySearchTree.findMin());

        assertEquals(true,Collections.min(nodes) ==binarySearchTree.findMin() );
    }

    @Test
    void findMax() {
        ArrayList<Integer> nodes= binarySearchTree.inOrder();
        assertEquals(true, Collections.max(nodes)== binarySearchTree.findMax());
    }

    @Test
    void rebalance() {
        binaryTreePrint.printTree(binarySearchTree.root);
        binarySearchTree.rebalance();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        binaryTreePrint.printTree(binarySearchTree.root);
        ArrayList<Integer> actual = binarySearchTree.inOrder();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(4);
        expected.add(8);
        expected.add(10);
        expected.add(12);
        expected.add(14);
        expected.add(20);
        expected.add(22);
        assertEquals(expected,actual);
    }
}