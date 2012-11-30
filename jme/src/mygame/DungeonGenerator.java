/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.network.AbstractMessage;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.terrain.geomipmap.TerrainGrid;
import com.jme3.terrain.geomipmap.TerrainQuad;
import com.jme3.terrain.heightmap.AbstractHeightMap;
import com.jme3.texture.Texture;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SAYA
 */
public class DungeonGenerator {
    
    /**
     * stage creator interface
     */
    public static interface IStageGenerator {
        
        Stage create();
    }
    
    public static class StageGenerator implements IStageGenerator {
        
        /**
         * stage grid width and height (max indices)
         */
        private int width, height;
        
        /**
         * list of wall cells
         */
        private List<Integer> wallCellIndexList;
        
        /**
         * number of enemy popping points
         */
        private int enemyPopPoints;
        
        /**
         * list of enemy pop point cells
         */
        private List<Integer> enemyPopPointCellIndexList;
        
        /**
         * StageGenerator constructor
         * 
         * @param width
         * @param height
         * @param enemyPopPoints 
         */
        public StageGenerator(int width, int height, int enemyPopPoints) {
            this.width = width;
            this.height = height;
            this.enemyPopPoints = enemyPopPoints;
        }
        
        /**
         * create stage
         * @return stage instance
         */
        public Stage create() {
            return new Stage(this.width, this.height, this.wallCellIndexList, this.enemyPopPointCellIndexList);
        }

    }
    
    public static class StageComponentContainer {

        /**
         * ground
         */
        public TerrainQuad terrain;

        /**
         * list of walls
         */
        private List<Geometry> wallList;
        
        /**
         * list of enemy popping points
         */
        private List<Geometry> enemyPopPointList;
        
        public StageComponentContainer(List<Integer> wallCellIndexList, List<Integer> enemyPopPointCellIndexList, StageGridManager gridManager) {
            this.terrain = new TerrainQuad("Terrain", 3, 3, new float[]{0,0,0,0});
            this.wallList = new ArrayList<Geometry>();
            this.enemyPopPointList = new ArrayList<Geometry>();
            
            this.initTerrain();
            this.initWalls(wallCellIndexList, gridManager);
            this.initEnemyPopPoints(enemyPopPointCellIndexList, gridManager);
        }

        private void initTerrain() {
//            throw new UnsupportedOperationException("Not yet implemented");
        }

        private void initWalls(List<Integer> wallCellIndexList, StageGridManager gridManager) {
            for (Integer _index : wallCellIndexList) {
                // create location
                final Vector3f _boxLocation = gridManager.getGridCenterCoord(_index, new Vector3f());
                // create geometry
                final Geometry _boxGeometry = new Geometry("Wall", new Box(1, 1, 1));
                _boxGeometry.setLocalTranslation(_boxLocation); // set location on the terrain
                // attach to trrain
                this.terrain.attachChild(_boxGeometry);
            }
        }

        private void initEnemyPopPoints(List<Integer> enemyPopPointCellIndexList, StageGridManager gridManager) {
            for (Integer _index : enemyPopPointCellIndexList) {
                // create location
                final Vector3f _popLocation = gridManager.getGridCenterCoord(_index, new Vector3f());
                // create geometry
                final Geometry _popGeometry = new Geometry("EnemyPopPoint", new Sphere(8, 16, 1));
                _popGeometry.setLocalTranslation(_popLocation); // set location on the terrain
                // attach to trrain
                this.terrain.attachChild(_popGeometry);
            }
        }

    }
    
    public static class StageGridManager {
        
        /**
         * size of a stage
         */
        private float width, height;
        /**
         * size of grid
         */
        private int gridRows, gridColumns;
        
        public StageGridManager(float width, float height, int gridRows, int gridColumns) {
            this.width = width;
            this.height = height;
            this.gridRows = gridRows;
            this.gridColumns = gridColumns;
            
        }

        public Vector3f getGridCenterCoord(int index, Vector3f dest) {
            // TODO
            
            return dest;
        }
        
    }
    
    public static class Stage extends AbstractMessage {

        private StageGridManager gridManager;
        
        private StageComponentContainer componentContainer;

        private Stage(int width, int height, List<Integer> wallCellIndexList, List<Integer> enemyPopPointCellIndexList) {
            // TODO
        }
      
    }
    
}
