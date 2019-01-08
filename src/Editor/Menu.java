package Editor;

import java.util.ArrayList;

import components2D.BoundingBox;
import game_engine2D.GameManager;
import game_engine2D.GameObject;
import game_engine2D.ProcessingEntity;
import processing.core.PApplet;

public abstract class Menu extends ProcessingEntity 
{
	protected int exitScreen = -1;
	protected ArrayList<GameObject> gameObjects;
	protected ArrayList<GameObject> playerGameObjects;
	protected ArrayList<Menu> exitScreens;
	public Menu swap_screen = null;
	protected ArrayList<BoundingBox> gameBoundingBoxes;
	protected GameManager gameManager;
	protected boolean ready = false;
	public boolean activated = false;
	
	public Menu(PApplet p) 
	{
		super(p);
		this.name = "Game Screen";
		
	}
	public Menu(PApplet p, GameManager _gameManager)
	{
		super(p);
		this.name = "Game Screen";
		this.gameManager = _gameManager;
		this.exitScreens = new ArrayList<Menu>();
		this.playerGameObjects = new ArrayList<GameObject>();
		this.gameObjects = new ArrayList<GameObject>();
		this.gameBoundingBoxes = new ArrayList<BoundingBox>();
	}
	public void start()
{
		if(this.ready)
		{
			this.activate();
			return;
		}		
	}
	public abstract void keyPressed(char key, int keyCode);
	public abstract void keyReleased(char key, int keyCode);
	public abstract void mousePressed();
	public abstract void mouseClicked();

	public void exitScreensAdd(Menu _screen)
	{
		this.exitScreens.add(_screen);
	}
	public void swapTo(int i) 
	{
		if(this.exitScreen != i && this.exitScreen < this.exitScreens.size()) {
			this.exitScreen = i;
			this.swap_screen = this.exitScreens.get(this.exitScreen);
			parent.println("swapTo " + i + " => " + this.name);
			
		}
		
		
	}
	public void activate() 
	{	
	}
}
