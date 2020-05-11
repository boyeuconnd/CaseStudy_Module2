package codegym.passwordManager;

import java.io.Console;

public class PasswordField {
    public String getPASSWORD() {
        return PASSWORD;
    }

    private final String PASSWORD = "123456";
    private PasswordField() {
    }
    private static PasswordField instance;
    public synchronized static PasswordField getInstance(){
        if(instance == null){
            instance = new PasswordField();
        }
        return instance;
    }
    public String enterPassword(){
        Console console = System.console();
        char[] passwordArray = console.readPassword("Enter password: ");
        String password = new String(passwordArray);
        return password;


    }

}
