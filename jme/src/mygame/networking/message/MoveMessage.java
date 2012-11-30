/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.networking.message;

import com.jme3.network.AbstractMessage;

/**
 *
 * @author tao
 */
public class MoveMessage extends AbstractMessage{
    private int movex, movey;
    public MoveMessage(){}
    public MoveMessage(int movex,int movey){
        this.movex=movex;
        this.movey=movey;
    }
}
