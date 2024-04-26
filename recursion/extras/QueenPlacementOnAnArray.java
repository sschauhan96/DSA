package day2.extras;

public class QueenPlacementOnAnArray {
    public static void main(String[] args) {
        placeQueensPermutaton(new int[4], new boolean[4], 2);
        System.out.println("==========================");
        placeQueensCombination(new int[4], new boolean[4], 2, 0);
    }

    private static void placeQueensPermutaton(int[] arr, boolean[] visited, int queens) {
        if (queens == 0) {
            printPlacements(visited);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                placeQueensPermutaton(arr, visited, queens - 1);
                visited[i] = false;
            }
        }
    }

    private static void placeQueensCombination(int[] arr, boolean[] visited, int queens, int currIdx) {
        if (queens == 0) {
            printPlacements(visited);
            return;
        }

        for (int i = currIdx; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                placeQueensCombination(arr, visited, queens - 1, i);
                visited[i] = false;
            }
        }
    }

    private static void printPlacements(boolean[] visited) {
        System.out.print("[");
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                System.out.print("~Q" + i + "~");
            } else {
                System.out.print("~X~");
            }
        }
        System.out.println("]");
    }
}
