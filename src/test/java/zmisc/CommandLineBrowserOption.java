package zmisc;

public class CommandLineBrowserOption {


    public static void main(String[] args) {

        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("os.name"));

//        System.setProperty("browser", "panda");

        // mvn test -D browser=panda

        System.out.println(System.getProperty("browser"));



    }
}
