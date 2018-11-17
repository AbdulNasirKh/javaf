 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author adnan_kanakri
 */
public class SquareBox {
    public char print;
    public boolean containAMine;
    

    public SquareBox() {
        this.print = 'o';
        this.containAMine = false;
    }

    public void setIsMine(boolean isMine) {
        this.containAMine = isMine;
    }

    public void setPrint(char print) {
        this.print = print;

    }

    public char getPrint() {
        return print;
    }
    
    public boolean getIsMIne() {
        return containAMine;
    }
    
   
    
    
}
