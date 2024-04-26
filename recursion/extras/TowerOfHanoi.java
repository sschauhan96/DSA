package day2.extras;

public class TowerOfHanoi {
    public static void main(String[] args) {
        towerOfHanoi(3, 'A', 'C', 'B');
    }

    private static void towerOfHanoi(int plates, char source, char destination, char helper) {
        if (plates == 0) {
            return;
        }
        towerOfHanoi(plates - 1, source, helper, destination);
        System.out.println("moving plate from " + source + " to destination " + destination);
        towerOfHanoi(plates - 1, helper, destination, source);
    }
}
