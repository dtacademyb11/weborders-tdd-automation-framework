package zmisc;

public class Cat {

    //Demonstartion of a Singleton design pattern in the example of a Cat class
    private static Cat cat;   //private static Variables

    private  Cat (){} // private constructor


    public static Cat getInstance(){  // getter method that initializes and returns the object of the class via null check
       if(cat == null){
           cat = new Cat();
       }


        return cat;
    }


    public static void main(String[] args) {

       // User story branch changes


        System.out.println("Hello World");

        



        // User story 2


        System.out.println("Hello World 2");


        // MY branch


    }
}
