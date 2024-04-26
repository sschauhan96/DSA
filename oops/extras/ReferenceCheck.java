package day3.extras;

public class ReferenceCheck {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Sandeep";
        s1.age = 27;
        System.out.println(s1);
        Student s2 = new Student();
        s2.name = "Mohan";
        s2.age = 30;
        System.out.println(s2);
        updateStudentsData(s1, s2);
        System.out.println("===============After============");
        System.out.println(s1);
        System.out.println(s2);
    }

    private static void updateStudentsData(Student s1, Student s2) {
        s2 = new Student();
        System.out.println("--->" + s2);
        s2.name = "Dekho s2 update method m change hua h..main method m nhi";
        s2.age = 1000;
        System.out.println("--->" + s2);
        s1.name = "magar s1 change ho jaega";
        s1.age = 5000;
    }
}

class Student {
    String name;
    int age;

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
}