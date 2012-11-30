/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.networking;

import com.jme3.network.Client;
import com.jme3.network.Network;
import com.jme3.network.serializing.Serializer;
import java.io.IOException;
import mygame.networking.message.MoveMessage;

/**
 *
 * @author tao
 */
public class MyClient {
    Client client;
    public MyClient(){
        Serializer.registerClass(MoveMessage.class);
    }
    public void start() throws IOException{
        client = Network.connectToServer("localhost", NetworkingConstants.PORT_NUM);
    }
}
