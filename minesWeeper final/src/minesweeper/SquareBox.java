 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;


public class SquareBox {
    public char print;
    public boolean containAMine;
    public boolean containAShield;
    

    public SquareBox() {
        this.print = 'o';
        this.containAMine = false;
        this.containAShield = false;
    }

    public void setIsMine(boolean isMine) {
        this.containAMine = isMine;
    }
    
    public void setIsAShield(boolean isAShield) {
        this.containAShield = isAShield;
    }
    
    public boolean getIsShield() {
        return this.containAShield;
    }
    

    public void setPrint(char print) {
        this.print = print;
    }
    public boolean getIsMIne() {
        return containAMine;
    }
        
   
        
    public char getPrint() {
        return print;
    }
    

    
   
    
    
}
