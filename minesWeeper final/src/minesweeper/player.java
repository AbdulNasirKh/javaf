/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author ayed
 */
abstract  class player {
    abstract public boolean play(Patch b , score Score);
    public score Score;
}
