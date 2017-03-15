import java.util.Scanner; 
import java.util.Random; 
/**
 * We created a betting class where you could bet on 12 games and also check out the result of the week.
 * You will also be able to compare the weekresult and the bet you placed.
 * 
 * @author Khalid B Said
 * @version Innlevering 2 
 */
public class Tipping
{
    // This is the fields of the class Tipping.
    private char[] UkensRekke;
     
    /**
     * This will be the constructer of the class. 
     */
     public Tipping ()
    {
        UkensRekke = new char [12];
    }
    
    /**
     * Weekresult will make the result of the week and will put it out randomly. 
     */
     public void Weekresult()
    {
       Random rnd = new Random(); 
       
       for (int i = 0; i < UkensRekke.length; i++)
       {
        int Resultat = rnd.nextInt(3);
        
        if (Resultat == 0)
        {
          UkensRekke[i] = 'H';
        }
        else if(Resultat == 1)
        {
         UkensRekke[i] = 'B';
        }
        else if(Resultat == 2) 
        {
         UkensRekke[i] = 'U';
        }
        }         
    }
    
    /**
     * This code will return the Array that we earlier made. 
     */
     public char[] getWeekresult()
    {
     return UkensRekke;
    }
    
    /**
     * This code will print out the Array we created also known as the all the result of the week. 
     */
     public void print(char [] UkensRekke)
    {
        for(int i = 0; i < UkensRekke.length; i++)
        {
            System.out.print(UkensRekke[i] + "  ");
        }
    } 
    
    /**
     * In this code we created register which allows the user to input their bet on the weekresult. 
     */
     public char[] Register()
    {
    char[] DinKupong = new char[12];
    Scanner register = new Scanner(System.in);
     
     
     for (int i = 0; i < UkensRekke.length; i++) 
     
    {
     System.out.print("Skriv inn tippetegn " + (i+1) +  ":");
     DinKupong[i] = Character.toUpperCase(register.nextLine().toCharArray()[0]);
    }
    return DinKupong;
    }
    
    /**
     *  This code will allow us to check our bet and the weekresult for similarity
     */
     public int Check(char[] UkensRekke, char[] DinKupong) 
    {
     int antall = 0; 
        for (int i = 0; i < 12; i++)
      {
        if (UkensRekke[i] == DinKupong[i])
        {
            antall = antall + 1; 
        } 
    }
    return antall;
    }
} 

