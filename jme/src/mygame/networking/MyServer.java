/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.networking;

import com.jme3.network.Network;
import com.jme3.network.Server;
import java.io.IOException;

/**
 *
 * @author tao
 */
public class MyServer{
    Server server;
    MyServer(){}
    void start() throws IOException{
        server = Network.createServer(NetworkingConstants.GAME_NAME, NetworkingConstants.VERSION, NetworkingConstants.PORT_NUM, NetworkingConstants.PORT_NUM);
    }
}
