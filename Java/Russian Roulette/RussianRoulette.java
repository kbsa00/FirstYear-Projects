import java.util.Scanner;
/**
 * Write a description of class Age here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RussianRoulette
{
    public String RussianRoulette()
    {
    int chamber = 0;
    Scanner input = new Scanner(System.in);
    System.out.println("Skriv et tall fra 1-7");
      String gjett = " ";
       switch (chamber) 
       {
         case 1: gjett = "UHUU You Live :)";
         break; 
         case 2: gjett = "Uhuu You Got Very Lucky ";
         break; 
         case 3: gjett = "Daamn Nigga you dead :( ";
         break;
         case 4: gjett =  "Damn You got lucky "; 
         break;  
         case 5: gjett = "Wohoo isn't this exciting. That was close one";
         break; 
         case 6: gjett ="Lucky son of a bitch ";
         break;
         default: gjett = "Fuck I missed the shot ";
            
        
       }
       return gjett;
    }
    
   }
