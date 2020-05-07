package codegym.passwordManager;

import java.io.Console;
import java.io.Reader;
import java.util.Objects;
import java.util.Scanner;

public class PassWordField {
    public String getPASSWORD() {
        return PASSWORD;
    }

    private final String PASSWORD = "123456";
    private PassWordField() {
    }
    private static PassWordField instance;
    public synchronized static PassWordField getInstance(){
        if(instance == null){
            instance = new PassWordField();
        }
        return instance;
    }
    public void enterPassword(){
//        Scanner scn = new Scanner(System.in);
//        System.out.println("Enter password: ");
//        String pass = scn.nextLine();
//        System.out.println("Password is: " + pass);
        Console console = System.console();
        char[] passwordArray = console.readPassword("Enter password: ");
        String password = new String(passwordArray);
        System.out.println(password);
    }

}
