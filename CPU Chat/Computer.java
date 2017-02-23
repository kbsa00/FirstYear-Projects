import java.util.Scanner; 
/**
 * Write a description of class Computer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Computer
{
   public void Chat() 
   {
     Scanner scr = new Scanner(System.in);
     Scanner sc = new Scanner(System.in); 
     System.out.println("Hello, Computer here, Whats your name?");
     String navn = scr.nextLine(); 
     
     System.out.println("Hello " + navn);
     System.out.print("How old are you buddy? ");
     int age = scr.nextInt(); 
     if(age >=100)
     {
         System.out.println("That's impossible, You know i'm a smart computer, Please write your right age ;)");
         age = scr.nextInt(); 
     }
     else if (age <= -1)
     {
         System.out.println("That's just impossible Human!!");
         age = scr.nextInt(); 
      
     }
    
     System.out.println("Wow you're almost old as me, "  + age + " years old? You are still very young :D ");
     System.out.println(""); 
     
     System.out.println("What do you study or do for a living " + navn + " ?");
     
     String work = sc.nextLine(); 
     System.out.println("Oh cool, Really " + work + "? " + " That sounds so freaking interesting! " );
     System.out.print("");
     
     
     System.out.println("Please write exit in the chat to close end the chat");
     
     String bye = sc.nextLine(); 
     if (bye.equals("exit") || bye.equals ("Exit"))
     {
        System.out.println("*** CHAT IS NOW CLOSED  ***"); 
        scr.close(); 
     }
     
    
     
   }
}
