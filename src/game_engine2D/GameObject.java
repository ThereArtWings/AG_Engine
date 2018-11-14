package game_engine2D;

import processing.core.PApplet;
import java.util.ArrayList;
import components2D.GameComponent;

public abstract class GameObject extends ProcessingEntity
	{
	
//	public ArrayList<GameComponent> components = new ArrayList<GameComponent>();
	public GameObject(PApplet p) {
		super(p);
		this.components = new ArrayList<GameComponent>();
	}

	public String name;
	public String tag;
	
	public ArrayList<GameComponent> components;
	public Transform transform = new Transform();
	public abstract void start();
	public abstract void update();
	public abstract void render();
	public void keyPressed(char key, int keyCode) {}
	public void keyReleased(char key, int keyCode) {}
	
	public String ToString() {
		return this.name;
	}
}
