import java.util.Random;
import java.util.Scanner;
/**
 * Write a description of class SteinSaksPapir here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SteinSaksPapir
{
  private int spiller; 
  private int data;
  private int dataScore;
  private int spillerscore; 
  public SteinSaksPapir()
  {
    
    
  }
  
  public int DinTur()
  {
    Scanner scr = new Scanner(System.in); 
    String Spiller = " ";  
    Spiller = scr.nextLine();
    if (Spiller.equals ("Stein") || Spiller.equals ("stein")) 
    {
      spiller = 0; 
    }
    
    else if (Spiller.equals("Saks") || Spiller.equals ("saks"))
    {
      spiller = 1; 
    }
    
    else if (Spiller.equals("Papir") || Spiller.equals ("papir"))
    {
      spiller = 2; 
    }
    
    return spiller; 
  }
  
  public int MaskinsTur()
  {
    
    Random rnd = new Random(); 
    data = rnd.nextInt(3); 
     if(spiller <= 3){ 
          if (spiller == data){
      System.out.println("Begge valgte samme!");
      System.out.println("Uavgjort");
        

   }
     else if (data == 0 && spiller == 1){
      System.out.println("Spillervalg: Saks");
      System.out.println("Datavalg: Stein");
      System.out.println("Data vant!");
      dataScore++; 
         
    }
     else if(data == 0 && spiller == 2){
      System.out.println("Spillervalg: Papir");
      System.out.println("Datavalg: Stein");
      System.out.println("Du vant!");
      spillerscore++; 
           
    }
      else if(data == 1 && spiller == 0){
       System.out.println("Spillervalg: Stein");
       System.out.println("Datavalg: Saks");
       System.out.println("Du vant!");                 
       spillerscore++;   
   }
     else if(data == 1 && spiller == 2){
      System.out.println("Spillervalg: Papir");
      System.out.println("Datavalg: Saks");
      System.out.println("Data vant!");
      dataScore++;
    }
     else if(data == 2 && spiller == 0){
      System.out.println("Spillervalg: Stein");
      System.out.println("Datavalg: Papir");
      System.out.println("Data vant!");
      dataScore++;   
     }
     else if(data == 2 && spiller == 1){
      System.out.println("Spillervalg: Saks");
      System.out.println("Datavalg: Papir");
      System.out.println("Du vant!");
      spillerscore++;   
     }
   }
   return data;
  }
  
  public int getSpillerscore()
  {
    return spillerscore;   
  }
  
  public int getDataScore()
  {
    return dataScore;   
    
  }
}
