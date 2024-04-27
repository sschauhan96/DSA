package gfg.medium;

import org.w3c.dom.Node;

public class CreateTreeUsingPreOrderAndInOrder {

    public static Node buildTree(int inorder[], int preorder[], int n) {
        return createTree(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    private static Node createTree(int[] preOrder, int pS, int pE, int[] inOrder, int iS, int iE) {
        if (pS > pE) {
            return null;
        }

        Node currNode = new Node(preOrder[pS]);
        int size = 0;
        int foundIdx = iS;

        for (int i = iS; i <= iE; i++) {
            if (inOrder[i] == currNode.data) {
                foundIdx = i;
                break;
            }
            size++;
        }

        currNode.left = createTree(preOrder, pS + 1, pS + size, inOrder, iS, foundIdx - 1);
        currNode.right = createTree(preOrder, pS + size + 1, pE, inOrder, foundIdx + 1, iE);
        return currNode;
    }

    static class Node {

        int data;
        Node left, right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }
}
