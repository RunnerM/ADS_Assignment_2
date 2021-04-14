import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    BinaryTree binaryTree;
    BinaryTreePrint binaryTreePrint;

    @BeforeEach
    void setUp() {

         binaryTree = new BinaryTree();
         binaryTreePrint = new BinaryTreePrint();

        binaryTree.root = new BinaryTreeNode(1);
        binaryTree.root.leftChild = new BinaryTreeNode(2);
        binaryTree.root.rightChild = new BinaryTreeNode(3);
        binaryTree.root.leftChild.leftChild = new BinaryTreeNode(4);
        binaryTree.root.leftChild.rightChild = new BinaryTreeNode(5);
        binaryTree.root.rightChild.leftChild = new BinaryTreeNode(6);
        binaryTree.root.rightChild.rightChild = new BinaryTreeNode(7);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isEmpty() {

        assertFalse(binaryTree.isEmpty());

    }

    @Test
    void size() {
        assertEquals( 7,binaryTree.size());
    }

    @Test
    void contains() {

        binaryTree.setRoot(new BinaryTreeNode(2));
        assertTrue(binaryTree.contains(2));

    }

    @Test
    void inOrder() {

        binaryTreePrint.printTree(binaryTree.root);

        ArrayList<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(4);
        expectedResult.add(2);
        expectedResult.add(5);
        expectedResult.add(1);
        expectedResult.add(6);
        expectedResult.add(3);
        expectedResult.add(7);

        assertEquals(expectedResult,binaryTree.inOrder());

    }

    @Test
    void preorder() {
        binaryTreePrint.printTree(binaryTree.root);

        ArrayList<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(1);
        expectedResult.add(2);
        expectedResult.add(4);
        expectedResult.add(5);
        expectedResult.add(3);
        expectedResult.add(6);
        expectedResult.add(7);


        assertEquals(expectedResult,binaryTree.preorder());

    }

    @Test
    void postorder() {
        binaryTreePrint.printTree(binaryTree.root);

        ArrayList<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(4);
        expectedResult.add(5);
        expectedResult.add(2);
        expectedResult.add(6);
        expectedResult.add(7);
        expectedResult.add(3);
        expectedResult.add(1);


        assertEquals(expectedResult,binaryTree.postorder());
    }

    @Test
    void levelOrder() {

        binaryTreePrint.printTree(binaryTree.root);
        ArrayList<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(1);
        expectedResult.add(2);
        expectedResult.add(3);
        expectedResult.add(4);
        expectedResult.add(5);
        expectedResult.add(6);
        expectedResult.add(7);


        assertEquals(expectedResult,binaryTree.levelOrder());

    }

    @Test
    void height() {

        binaryTreePrint.printTree(binaryTree.root);

        assertEquals(2,binaryTree.height());

    }
}