package day2.extras;

public class SelectNBoxesOutOfAnArray {
    public static void main(String[] args) {
        selectBoxes(new int[4], 3, "", new boolean[4]);
    }

    private static void selectBoxes(int[] arr, int nBoxes, String path, boolean[] visited) {
        if (nBoxes == 0) {
            System.out.println(path);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selectBoxes(arr, nBoxes - 1, path + "~b" + i, visited);
                visited[i] = false;
            }
        }
    }
}
