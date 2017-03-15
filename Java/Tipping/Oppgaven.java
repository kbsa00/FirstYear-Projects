
/**
 * We created this class so that we can print out the weekresult also so that
 * you will be able to place your bet.  
 * 
 * @author Khalid B. Said
 * @version Innlevering 2
 */
public class Oppgaven
{
    /**
     * We are printing out our own bet and the weekresult and checking for simalarity
     * 
     */
     public void mainMethod() 
    { 
     
      System.out.println("Klassen Tipping instansieres...");
      Tipping tipping1 = new Tipping(); 
      System.out.println();
      
      System.out.println("Ukens rekke genereres...");
      tipping1.Weekresult();
      System.out.println();
      
      System.out.println("Brukers rekke registreres...");
      char[] DinKupong = tipping1.Register(); 
      System.out.println();
      
      System.out.println("Ukens Rekke hentes...");
      char[] UkensRekke = tipping1.getWeekresult();
      System.out.println();
      
      System.out.println("Ukens Rekke:");
      tipping1.print(UkensRekke);
      System.out.println();
      
      System.out.println("Brukers rekke:");
      tipping1.print(DinKupong);
      System.out.println();
      
      System.out.println("Bruker hadde " + tipping1.Check(UkensRekke, DinKupong) + " riktige tippetegn");
   
  }
}
