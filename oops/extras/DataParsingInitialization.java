package day3.extras;

public class DataParsingInitialization {
    public static void main(String[] args) {
        // Student1 s = new Student1();
        // System.out.println(s);

        System.out.println(Test.age);
    }

    static class Test {
        static int age = 10;
    }

}

class Student1 {
    String name = "Sandeep";

    public Student1() {
        this.name = "Narayan";
    }

    @Override
    public String toString() {
        return "Student [name=" + name + "]";
    }
}
