package game_engine2D;

import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;
import components2D.BoundingBox;
import components2D.BasicSpatialGrid;
import java.awt.event.MouseAdapter;
import javax.swing.event.MouseInputAdapter;

public class GameManager {
    public PApplet parent;
    public int background = 0;
    private ArrayList <GameObject> gameObjects;
    private ArrayList <GameObject> playerGameObjects;
    public static int frameCount = 0;
    public static ArrayList <BoundingBox> gameBoundingBoxes;
    public static PVector offset = new PVector(0, 0);
    public static PVector screenOffset = new PVector(0, 0);
    public static BasicSpatialGrid basicSpatialGrid;
    
    public GameManager(PApplet p){
        parent = p;

        screenOffset.x = parent.width / 2;
        screenOffset.y = parent.height / 2;
        this.Init();
    }
    
    public void Init()
    {
    	gameObjects = new ArrayList<GameObject>();
    	playerGameObjects = new ArrayList<GameObject>();
    	gameBoundingBoxes = new ArrayList<BoundingBox>();
    }
    
    public void addGameBoundingBoxes(GameObject b)
    {
    	b.ID = gameBoundingBoxes.size();
    	gameBoundingBoxes.add(b.transform.NewWorldBoundingBox());
    }
    
    public void addPlayerGameObject(GameObject b)
    {
    	playerGameObjects.add(b);
    }

    public void addObject(GameObject g)
    {
        gameObjects.add(g);
    }
    
    public void removeObject(GameObject g)
    {
        gameObjects.remove(gameObjects.lastIndexOf(g));
    }
    
	public void replaceObjects(ArrayList<GameObject> _gameObjects)
	{
		gameObjects = _gameObjects;
	}

	public void replacePlayerObjects(ArrayList<GameObject> _gameObjects)
	{
		playerGameObjects = _gameObjects;
	}
	
	public void replaceBoundingBoxes(ArrayList<BoundingBox> _boundingBoxes)
	{
		gameBoundingBoxes = _boundingBoxes;
	}
    
    public void StartAll() {
    	
        for(int i = 0; i < gameObjects.size(); i++){
            GameObject g = gameObjects.get(i);
            g.start();
        }
       basicSpatialGrid = new BasicSpatialGrid(parent.height,2);
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
        frameCount ++;
        parent.popMatrix();
    }
    
    public void keyPressed(char key, int keyCode)
    {
    	for (int i = 0; i < playerGameObjects.size(); i++)
    	{
    	GameObject g = playerGameObjects.get(i);
    	g.keyPressed(key,  keyCode);
    	}
    }
    
    public void keyReleased(char key, int keyCode)
    {
    	for (int i = 0; i < playerGameObjects.size(); i++)
    			{
    		GameObject g = playerGameObjects.get(i);
    		g.keyReleased(key, keyCode);    			}
    }
	public void mousePressed() {
		for (int i = 0; i < playerGameObjects.size(); i++) {
			// send key press to player
			GameObject g = playerGameObjects.get(i);
			g.mousePressed();
		}
	}

	public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		for (int i = 0; i < playerGameObjects.size(); i++) {
			// send key press to player
			GameObject g = playerGameObjects.get(i);
			g.mouseClicked(mouseX, mouseY, mouseButton);
		}
	}

}
