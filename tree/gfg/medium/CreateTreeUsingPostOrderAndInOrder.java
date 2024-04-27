package gfg.medium;

public class CreateTreeUsingPostOrderAndInOrder {

    Node buildTree(int in[], int post[], int n) {
        return createTree(post, 0, n - 1, in, 0, n - 1);
    }

    private Node createTree(int[] postOrder, int pS, int pE, int[] inOrder, int iS, int iE) {
        if (pS > pE || iS > iE) {
            return null;
        }

        Node currNode = new Node(postOrder[pE]);
        int size = 0;
        int foundIdx = iS;

        for (int i = iS; i <= iE; i++) {
            if (currNode.data == inOrder[i]) {
                foundIdx = i;
                break;
            }
            size++;
        }

        currNode.left = createTree(postOrder, pS, pS + size - 1, inOrder, iS, foundIdx - 1);
        currNode.right = createTree(postOrder, pS + size, pE - 1, inOrder, foundIdx + 1, iE);
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
