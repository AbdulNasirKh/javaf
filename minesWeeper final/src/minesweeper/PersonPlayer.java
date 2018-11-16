/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;
import java.util.Scanner;

/**
 *
 * @author ayed
 */
public class PersonPlayer extends player{
    
   
    public PersonPlayer() {
        //this.score = 0;
        Score = new score();
    }
    
    Scanner s = new Scanner(System.in);
    @Override
    public boolean play(Patch b  ,score Score) {
       
        this.Score = Score;
              
        int x;
        int y;
        System.out.println("Set a sign .. press 1 ");
        System.out.println("Open a squere .. press 2 ");
        System.out.println("Delet a sign .. pres 3 ");
            int t = s.nextInt();

            if (t == 2) {
                do {
                    do
                    {
                    System.out.println("x :");
                    x = s.nextInt();
                    System.out.println("y :");
                    y = s.nextInt();
                    if(!b.checkCelles(x, y))
                    {
                        System.out.println("x and y must be grater or equal to zero and less than " + b.getBoardSize() +"\n");
                    }
                    }while(!b.checkCelles(x, y));
                    System.out.println(b.grid[x][y].getPrint());

                     if (b.grid[x][y].getPrint() == 'p') {
                        System.out.println("pleas try again ");
                    }else
                    if (b.grid[x][y].containAMine) {
                        b.grid[x][y].print = 'B';
                        System.out.println(b);
                        if(this.Score.getNumberOfShields() >0)
                        {
                            this.Score.subOneFromShield();
                        } else
                            if(this.Score.getTotalScore()>=250)
                            {
                               this.Score.Continue();
                            }
                            else 
                        return  false;
                        
                    } else if (!b.grid[x][y].containAMine && b.grid[x][y].getPrint() != 'p' && b.grid[x][y].getPrint()=='o') {
                        if(b.grid[x][y].containAShield)
                        {
                            this.Score.addOneToShield();
                        }
                        
                        int num = b.numberOfMinesArroundTheCell(x, y);
                        if(num != 0)
                        {
                            b.grid[x][y].print = (char)('0' + num) ;
                           
                            this.Score.addTheMineNumber(num);
                        }
                        else{
                             this.Score.clickOnEmptyCell();
                             int floodScore = b.FloodFillCelles(x,y);
                             this.Score.flood(floodScore);
                        }                      
                    }

                } while (b.grid[x][y].getPrint() == 'p');

            } else if (t == 1) {

                do {
                    do
                    {
                    System.out.println("x :");
                    x = s.nextInt();
                    System.out.println("y :");
                    y = s.nextInt();
                    if(!b.checkCelles(x, y))
                    {
                        System.out.println("x and y must be grater or equal to zero and less than " + b.getBoardSize() +"\n");
                    }
                    }while(!b.checkCelles(x, y));
                    if (b.grid[x][y].getPrint() != 'o') {
                        System.out.println("you cant put here!!");
                    } 
                    
                    

                } while (b.grid[x][y].getPrint() != 'o');
                
                if(b.grid[x][y].containAMine)
                {
                    this.Score.putSignOnMine();

                } else {
                    this.Score.putSignOnEmpty();
                }
                b.grid[x][y].setPrint('p');
                return true;

            } else if (t == 3) {
                do {

                    do
                    {
                    System.out.println("x :");
                    x = s.nextInt();
                    System.out.println("y :");
                    y = s.nextInt();
                    if(!b.checkCelles(x, y))
                    {
                        System.out.println("x and y must be grater or equal to zero and less than " + b.getBoardSize() +"\n");
                    }
                    }while(!b.checkCelles(x, y));
                    if (b.grid[x][y].getPrint() != 'p') {
                        System.out.println("There is no sign here ");
                    }

                } while (b.grid[x][y].getPrint() != 'p');

                b.grid[x][y].setPrint('o');

        }
            return true;
    }
    
}
