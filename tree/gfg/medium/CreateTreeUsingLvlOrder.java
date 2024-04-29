package gfg.medium;

import java.util.LinkedList;
import java.util.Queue;

public class CreateTreeUsingLvlOrder {

    public static void main(String[] args) {
        int[] lvl = {10, 20, 30, 40, -1, 70, 80, 50, -1, -1, -1, 90, -1, -1, 60, 100, -1, -1, -1, -1, -1};
        Tree tree = new Tree(lvl);
        tree.printlvlOrder();
    }

    static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    static class Tree {

        Node root;

        public Tree(int[] lvlOrder) {
            this.root = createTreeUsingLvlOrder(lvlOrder);
        }

        public void printlvlOrder() {
            Queue<Node> queue = new LinkedList<>();
            queue.add(this.root);

            while (!queue.isEmpty()) {
                Node curr = queue.poll();
                if (curr.data != -1) {
                    System.out.println(curr.data);

                    if (curr.left != null) {
                        queue.add(curr.left);
                    } else {
                        queue.add(new Node(-1));
                    }

                    if (curr.right != null) {
                        queue.add(curr.right);
                    } else {
                        queue.add(new Node(-1));
                    }
                }
            }

        }

        private Node createTreeUsingLvlOrder(int[] lvlOrder) {
            if (lvlOrder == null || lvlOrder.length == 0) {
                return null;
            }
            Node node = new Node(lvlOrder[0]);
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            int idx = 1;
            while (idx < lvlOrder.length && !queue.isEmpty()) {
                Node curr = queue.poll();
                if (curr.data == -1) {
                    break;
                }
                if (lvlOrder[idx] != -1) {
                    curr.left = new Node(lvlOrder[idx]);
                    queue.add(curr.left);
                }

                idx++;
                if (idx == lvlOrder.length) {
                    continue;
                }

                if (lvlOrder[idx] != -1) {
                    curr.right = new Node(lvlOrder[idx]);
                    queue.add(curr.right);
                }
                idx++;
            }

            return node;
        }
    }
}
