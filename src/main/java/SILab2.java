import org.graalvm.compiler.lir.LIRInstruction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'';
    }
}

public class SILab2 {

    public boolean function (User user, List<String> allUsers) { //1
        if (user!=null) { //2
            if (user.getUsername()!=null && user.getEmail()!=null && !allUsers.contains(user.getUsername())) { //3
                boolean atChar = false, dotChar = false; //4
                for (int i=0;i<user.getEmail().length();i++) { //5
                    if (user.getEmail().charAt(i)=='@') //6
                        atChar = true; //7
                    if (atChar && user.getEmail().charAt(i)=='.') { //8
                        dotChar = true; //9
                    }
                } //10
                if (atChar && dotChar) { //11
                    return true; //12
                }
            }
        }
        return false; //13
    } //14

    public boolean funk(User user, String user2){
        if(user != null) {
            System.out.println(user);
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
       
    }
   
}
