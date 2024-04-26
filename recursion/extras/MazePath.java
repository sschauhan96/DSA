package day2.extras;

public class MazePath {
    public static void main(String[] args) {
        int[][] maze = { { 0, 1, 0, 0 },
                { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };

        mazePath(maze, 0, 0, new boolean[maze.length][maze[0].length]);
    }

    private static void mazePath(int[][] maze, int i, int j, boolean[][] visited) {
        if (i == maze.length || j == maze[0].length || i < 0 || j < 0 || maze[i][j] == 1 || visited[i][j]) {
            return;
        }

        if (i == maze.length - 1 && j == maze[0].length - 1) {
            visited[i][j] = true;
            printPath(visited);
            visited[i][j] = false;
            System.out.println("=================================");
            return;
        }

        if (!visited[i][j]) {
            visited[i][j] = true;
            mazePath(maze, i + 1, j, visited);
            mazePath(maze, i, j + 1, visited);
            mazePath(maze, i - 1, j, visited);
            mazePath(maze, i, j - 1, visited);
            visited[i][j] = false;
        }

    }

    private static void printPath(boolean[][] visited) {
        for (boolean[] row : visited) {
            for (boolean col : row) {
                if (col) {
                    System.out.print("0\t");
                } else {
                    System.out.print("~\t");
                }
            }
            System.out.println();
        }
    }
}
