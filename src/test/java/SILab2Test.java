import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

   SILab2 siLab2 = new SILab2();

   private List<String> createList(String... elems){
       return new ArrayList<>(Arrays.asList(elems));
   }

   //EveryBranch
    @Test
    void everyBranch() {
        /*
        First assert = assertNull
        Second assert = assertWithoutUsername
        Third assert = assertWithoutEmail
        Fourth asset = assertDifferentUsers
        Fifth asset = assertAllTrue
         */

        assertAll(() -> assertEquals(siLab2.function(null, Collections.singletonList(createList("drilons6").toString())), false),
                () -> assertEquals(siLab2.function(new User(null, "123456!", "drilon-saiti@hotmail.com"), Collections.singletonList(createList("drilons6").toString())), false),
                () -> assertEquals(siLab2.function(new User("drilons6", "123456!", null), Collections.singletonList(createList("drilons6").toString())), false),
                () -> assertEquals(siLab2.function(new User("drilons6", "123456!", "drilon-saitihotmail.com"), Collections.singletonList(createList("anything").toString())), false),
                () -> assertEquals(siLab2.function(new User("drilons6", "123456!", "drilon-saiti@hotmail.com"), Collections.singletonList(createList("drilons6").toString())), true)

        );
    }

    //Multiple condtition

    @Test
    void multipleCondition(){

        //user.getUsername()!=null && user.getEmail()!=null && !allUsers.contains(user.getUsername())

        // First assert = T && T && T //username=drilons6 email=drilon-saiti@hotmail.com allUsers=drilons6
        // Second = T && T && F //username=drilons6 email=drilon-saiti@hotmail.com allUsers=drilon
        // Third = T && F && F //username=drilons6 email=null allUsers=drilon
        // Foruth = F && X && X //username=null

       assertAll(
               () -> assertEquals(siLab2.function(new User("drilons6","123456!","drilon-saiti@hotmail.com"), Collections.singletonList(createList("drilons6").toString())),true),
               () -> assertEquals(siLab2.function(new User("drilons6","123456!","drilon-saitihotmail.com"), Collections.singletonList(createList("anything").toString())),false),
               () -> assertEquals(siLab2.function(new User("drilons6","123456!",null), Collections.singletonList(createList("anything").toString())),false),
               () -> assertEquals(siLab2.function(new User(null,"123456!","drilon-saiti@hotmail.com"), Collections.singletonList(createList("drilons6").toString())),false)

       );

        //atChar && user.getEmail().charAt(i)=='.'
        // First = T && T // atChar=true && user.getEmail().charAt(i)=='.' = email=drilon-saiti@hotmail.com
        // Second = T && F atChar=true && user.getEmail().charAt(i)=='.' = email=drilon-saiti@hotmailcom
        // Third = F && X atChar=false = email = drilon-saitihotmail.com

       assertAll(
               () -> assertEquals(siLab2.function(new User("drilons6","123456!","drilon-saiti@hotmail.com"), Collections.singletonList(createList("drilons6").toString())),true),
               () -> assertEquals(siLab2.function(new User("drilons6","123456!","drilon-saiti@hotmailcom"), Collections.singletonList(createList("drilons6").toString())),false),
               () -> assertEquals(siLab2.function(new User("drilons6","123456!","drilon-saitihotmail.com"), Collections.singletonList(createList("drilons6").toString())),false)
       );
    }




}
