/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.saya;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import java.util.ArrayList;
import mygame.DungeonGenerator;
import mygame.Main;

/**
 *
 * @author SAYA
 */
public class MainDungeonGeneratorTest extends Main {

    public static void main(String[] args) {
        Main app = new MainDungeonGeneratorTest();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        super.simpleInitApp();

        DungeonGenerator.StageComponentContainer _container = new DungeonGenerator.StageComponentContainer(new ArrayList<Integer>(), new ArrayList<Integer>(), new DungeonGenerator.StageGridManager(10, 10, 10, 10));

        Material mat = new Material(assetManager, "Common/MatDefs/Terrain/Terrain.j3md");
//        mat.setColor("Color", ColorRGBA.Red);
        _container.terrain.setMaterial(mat);
        _container.terrain.setLocalScale(2f,1f,2f);
        
        this.rootNode.attachChild(_container.terrain);
        
        Geometry boxGeo = new Geometry("test", new Box(1f, 1f, 1f));
        Material boxMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        boxMat.setColor("Color", ColorRGBA.Red);
        boxGeo.setMaterial(boxMat);
        boxGeo.setLocalTranslation(1f, 2f, 3f);

        this.rootNode.attachChild(boxGeo);
    }

}
