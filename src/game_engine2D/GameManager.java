package game_engine2D;
import processing.core.*;
import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;
import components2D.BoundingBox;

public class GameManager {
    public PApplet parent;
    public int background = 0;
    public static PVector offset = new PVector(0, 0);
    public static PVector screenOffset = new PVector(0, 0);
    public GameManager(PApplet p){
        parent = p;
        gameObjects = new ArrayList<GameObject>();
    }

    private ArrayList<GameObject> gameObjects;


    public void addObject(GameObject g){
        gameObjects.add(g);
    }
    public void removeObject(GameObject g){
        gameObjects.remove(gameObjects.lastIndexOf(g));
    }
    public void StartAll() {
    	
        for(int i = 0; i < gameObjects.size(); i++){
            GameObject g = gameObjects.get(i);
            g.start();
        }
    }
    public void UpdateAll() {
    	parent.pushMatrix();
    	parent.translate(offset.x, offset.y);
    	parent.background(background);
        for(int i = 0; i < gameObjects.size(); i++){
        	
            GameObject g = gameObjects.get(i);
            g.update();
            g.render();
        }
    }

}
