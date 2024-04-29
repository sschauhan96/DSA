package leetcode.easy;

public class DiameterOfBT {

    public int diameterOfBinaryTree(TreeNode root) {
        return calculate(root).dia;
    }

    private HeightAndDia calculate(TreeNode root) {
        if (root == null) {
            return new HeightAndDia();
        }
        HeightAndDia sp1 = calculate(root.left);
        HeightAndDia sp2 = calculate(root.right);
        int selfDia = sp1.height + sp2.height + 2;

        int currHeight = Math.max(sp1.height, sp2.height) + 1;
        int currDia = Math.max(Math.max(sp1.dia, sp2.dia), selfDia);
        return new HeightAndDia(currHeight, currDia);
    }

    class HeightAndDia {

        int height = -1;
        int dia = 0;

        public HeightAndDia() {

        }

        public HeightAndDia(int height, int dia) {
            this.height = height;
            this.dia = dia;
        }
    }

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
    }
}
