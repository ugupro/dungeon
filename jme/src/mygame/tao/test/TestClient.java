/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.tao.test;

import com.jme3.app.SimpleApplication;
import com.jme3.system.JmeContext;
import java.io.IOException;
import mygame.networking.MyClient;

/**
 *
 * @author tao
 */
public class TestClient extends SimpleApplication{
    @Override
    public void simpleInitApp() {
        MyClient myclient=new MyClient();
        try{
            myclient.start();
        }catch(IOException e){
            System.err.println(e);
            System.exit(0);
        }
    }
    public static void main(String[] args){
        TestClient app = new TestClient();
        app.start(JmeContext.Type.Display);
    }
}
