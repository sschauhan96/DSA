package day2.extras;

public class ClimbStairsUnique {
    public static void main(String[] args) {
        climbStairs(5, 0, "");
    }

    private static void climbStairs(int n, int lastJump, String path) {
        if (n == 0) {
            System.out.println(path);
            return;
        }

        if (n < 0) {
            return;
        }

        if (lastJump <= 1) {
            climbStairs(n - 1, 1, path + "~1~");
        }
        if (lastJump <= 2) {
            climbStairs(n - 2, 2, path + "~2~");
        }
        if (lastJump <= 3) {
            climbStairs(n - 3, 3, path + "~3~");
        }
    }
}
