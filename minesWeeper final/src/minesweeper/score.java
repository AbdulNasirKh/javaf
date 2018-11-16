/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;
import java.util.Scanner;
/**
 *
 * @author Abdulfattah khudari
 */
import java.util.Scanner;
public class score {
    
    private int totalScore;
    private int clickOnEmptyCell;
    private int flood;
    private int putSignOnMine;
    private int putSignOnEmpty;
    private int pressOnMine;
    private int containNumber;
    private int endGame;
    private int Continue;
    private int NumberOfshields;
    private Scanner read;
    public score()
    {
        
        this.totalScore = 0 ;
        this.NumberOfshields = 0;
        this.containNumber = 0;
        this.clickOnEmptyCell = 10;
        this.flood = 1;
        this.putSignOnMine = 5;
        this.putSignOnEmpty = -1;
        this.pressOnMine = -250;
        this.endGame = 100;
        this.Continue = 250;
        this.read = new Scanner(System.in);
        
    }
    
   public void edit()
   {    

       System.out.println("choose the one that you would like to change");
       System.out.println("1: Click on empty cell");
       System.out.println("2: Flood");
       System.out.println("3: Put a sign on mine");
       System.out.println("4: Put a sign on empty cell");
       System.out.println("5: Press on mine");
       System.out.println("6: press on a cell that contains number");
       System.out.println("7: Ending the game");
       System.out.println("8: number of shields");
       int choose =  read.nextInt();
       
       switch(choose)
       {
           case 1:
           {
               System.out.println("Enter the value that you want");
               int N = read.nextInt();
               this.clickOnEmptyCell = N;
               break;
           }
           case 2:
           {
               System.out.println("Enter the value the you want");
               int N = read.nextInt();
               this.flood = N;
               break;
           }
            case 3:
           {               
               System.out.println("Enter the value the you want");
               int N = read.nextInt();
               this.putSignOnMine = N;
               break;
           }
            case 4:
           {    
               System.out.println("Enter the value the you want");
               int N = read.nextInt();
               this.putSignOnEmpty = N;
               break;
           }
            case 5:
           {
               System.out.println("Enter the value the you want");
               int N = read.nextInt();
               this.pressOnMine = N;
               break;
           }
            case 6:
           {
                System.out.println("Enter the value the you want");
               int N = read.nextInt();
               this.containNumber = N;
               break;
           }
            case 7:
           {
                System.out.println("Enter the value the you want");
               int N = read.nextInt();
               this.endGame = N;
               break;
           }
            case 8:
            {
                System.out.println("Enter the value the you want");
               int N = read.nextInt();
               this.NumberOfshields = N;
               break;
            }
       }
   }
    public int getTotalScore()
    {
        return  this.totalScore;
    }
    
    
    //sign//
    public void putSignOnEmpty()
    {
        this.totalScore-=this.putSignOnEmpty;
    }
    
    public void putSignOnMine()
    {
        this.totalScore+=this.putSignOnMine;
    }
    
    //end sign
    
    public void addTheMineNumber(int mine)
    {
        this.containNumber = mine;
        this.totalScore+=this.containNumber;
    }
    
    
    public void clickOnEmptyCell()
    {
        this.totalScore+=this.clickOnEmptyCell;
    }
    
    public void flood(int numberOfCells)
    {
        this.totalScore+=this.flood*numberOfCells;
    }
 
    
    
    public void endGame()
    {
        this.totalScore+=this.NumberOfshields*50;
        this.totalScore+=this.endGame;
    }
    
    public void Continue()
    {
        this.totalScore-=this.Continue;
    }
    
    
    public void setNumberOfShields(int value)
    {
        this.NumberOfshields = value;
    }
    
    public void addOneToShield()
    {
        this.NumberOfshields++;
    }
    
    public void subOneFromShield()
    {
        this.NumberOfshields--;
    }
    
    public int getNumberOfShields()
    {
        return this.NumberOfshields;
    }
    
    
  public String toString() {
     
      
       String s = new String();
       
       s+="SCORE BORD ..\n\n";
       s+="1: Click on empty cell: " + this.clickOnEmptyCell +"\n";
       s+="2: Flood: " + this.flood +"\n";
       s+="3: Put a sign on mine: " + this.putSignOnMine +"\n";
       s+="4: Put a sign on empty cell: " + this.putSignOnEmpty +"\n";
       s+="5: Press on mine:  " + this.pressOnMine +"\n";
       s+="6: press on a cell that contains number:  " + this.containNumber +"\n";
       s+="7: Ending the game: " + this.endGame +"\n";
       s+="8: number of shields" + this.NumberOfshields;
       
       return s;
  }  
}
