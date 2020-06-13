# Втора лабораториска вежба по Софтверско инженерство 

##  Drilon Saiti,186117

### Група на код:

 Ја добив групата на код 1

### Control Flow Graph:

![CFG](https://i.ibb.co/92FjrC8/a.jpg "ControlFlowGraph")



### Цикломатска комплексност:

 Цикломатската комплексност на овој код е 8, истата ја добив преку формулата E-N+2, каде што E е бројот на ребра и N е бројот на јазли. E=22,N=16. => 22-16+2=8

### Тест случаи според критериумот Multiple condtition

 //Multiple condtition

```java
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
   ```

###  Тест случаи според критериумот Еvery Branch 

 //EveryBranch

```java
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
```
###  Објаснување на напишаните unit tests

 **Multiple condtition** значи сите if-statment коит имат логични операции и & или.Се тестират условите на if-statment.
 Multiple condtition	
 
 > atChar && user.getEmail().charAt(i)=='.'
 
|Combination|Possible Test|Case	Branch|
|:----------|:------------|:----------|
|TT|drilon-saiti@hotmail.com|8-9|
|TF|drilon-saiti@hotmailcom|8-10|
|FX|drilon-saitihotmail.com|8-10|

>  //user.getUsername()!=null && user.getEmail()!=null && !allUsers.contains(user.getUsername())

|Combination|Possible Test|Case	Branch|
|:----------|:------------|:----------|
|TTT|drilons6,drilon-saiti@hotmail.com,drilons6|3-4
|TTF|drilons6,drilon-saiti@hotmail.com,drilon|3-13
|TFF|drilons6,null,drilons6|3-13|
|FXX|null|3-13|


**Every Branch** значи во сите јазлите од графот.Се тестират сите јазлите на пример од 1-2 2-3 итн.

|Every branch|user=null allUsers=anything|user=withOutusername allUsers=anything|user=withOut email  allUsers=anything|user=drilons6,123456!,drilon-saiti@hotmail.com allUsers=drilon|user=drilons6,123456!,drilon-saiti@hotmail.com allUsers=drilons6|
|:-----------|:--------------------------|:-------------------------------------|:------------------------------------|:-------------------------------|:-------------------------------|
|1-13|		|  |  |  |  |  |			
|1-2| *		| * | * | * | * |  |
|2-13|	*		|  |  |  |  |  |	
|2-3| 		| * | * | * | * |  |		
|3-13| 		| * | * | * |  |  |			
|3-4| 		|  |  |  | * |  |
|4-5.1| 		|  |  |  | * |  |					
|5.1-5.2| 		|  |  |  | * |  |					
|5.2-11| 		|  |  |  | * |  |					
|5.2-6| 		|  |  |  | * |  |				
|6-7| 		|  |  |  | * |  |					
|7-8| 		|  |  |  | * |  |					
|6-8| 		|  |  |  |  |  |					
|8-9|			|  |  |  | * |  |				
|9-10|			|  |  |  |*  |  |				
|8-10|			|  |  |  |  |  |			
|10-5.3|			|  |  |  | * |  |				
|5.3-5.2|			|  |  |  | * |  |				
|11-12| 		|  |  |  |  | * |					
|11-13|			|  |  |  |  |  |				
|12-14|			|  |  |  |*  |  |				
|13-14| 	*	| * | * |*  |  |  |

