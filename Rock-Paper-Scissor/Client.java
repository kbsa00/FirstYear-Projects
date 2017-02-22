import java.util.Scanner;
/**
 * Write a description of class Client here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Client
{
   public void mainMethod()
   {
    SteinSaksPapir t1 = new SteinSaksPapir();  
    Scanner scr = new Scanner(System.in);
    System.out.println("Skriv først inn antall runder du vil spille mot maskinen? ");
    int antall = scr.nextInt();
    
    for(int i = 0; i < antall; i++)
    {
    System.out.println("Skriv inn Stein, Saks eller Papir"); 
    
    
    t1.DinTur();
    t1.MaskinsTur(); 
    
    }
    
   
    System.out.println("Du har vunner antall runder " + t1.getSpillerscore());
    System.out.println("Maskinen har vunnet antall runder " + t1.getDataScore()); 
   }
}
