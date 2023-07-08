package zmisc;

public class TestDog {


    public static void main(String[] args) {

        Dog dog = new Dog("dcbsh", 34);
        System.out.println(dog.getAge());
        dog.setAge(23);
        System.out.println(dog);

    }
}
