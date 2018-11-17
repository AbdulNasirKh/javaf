/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.Random;

/**
 *
 * @author ayed
 */
public class CpuPlayer extends player{

    
    
    
    public CpuPlayer()
    {
        Score = new score();
    }
    
     Random r = new Random();
     
    public boolean play(Patch b , score Score) {
                int x;
        int y;
        int z;

        boolean bol = true;

        z = r.nextInt(4);
        if (z % 4 == 0) {
            do{
                x = r.nextInt(b.getBoardSize());
                y = r.nextInt(b.getBoardSize());

            }while(b.grid[x][y].getPrint()!='o');
            if( b.grid[x][y].containAMine)
                    this.Score.putSignOnMine();
            else
                    this.Score.putSignOnEmpty();
              bol = false;
              b.grid[x][y].setPrint('P');
              System.out.println("[" + x + "," + y + "]");
              
            

        } else {

            do {
                x = r.nextInt(b.getBoardSize());
                y = r.nextInt(b.getBoardSize());

                if (b.grid[x][y].print == 'o') {
                    System.out.println("[" + x + "," + y + "]");
                    if (b.grid[x][y].containAMine) {
                        
                        
                        if(this.Score.getTotalScore()>=250)
                        this.Score.Continue();
                    else{
                          b.grid[x][y].print = 'B';
                          System.out.println(b);
                          return false;
                    }
                        b.grid[x][y].print = 'B';
                        return false;
                    }
                    int num = b.numberOfMinesArroundTheCell(x, y);
                    if (num != 0) {
                        this.Score.addTheMineNumber(num);
                        b.grid[x][y].print = (char) ('0' + num);
                    } else {

                        this.Score.clickOnEmptyCell();
                        int floodScore = b.FloodFillCelles(x,y);
                        this.Score.flood(floodScore);
                    }
                    bol = false;

                    
                } else if (b.grid[x][y].print == 'P') {
                    System.out.println("[" + x + "," + y + "]");
                    if(b.grid[x][y].containAMine){
                      //this.score -= 5;
                    
                    }else{
                        //this.score += 5;
                        
                    }
                    b.grid[x][y].print = 'o';
                    bol = false;
                }

            } while (bol);
        }
        return true;
    }
}
    

    
 