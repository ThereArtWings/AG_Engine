package game_engine2D;
import processing.core.PApplet;
import java.util.ArrayList;

import components2D.GameComponent;
public abstract class GameObject extends ProcessingEntity {
	public ArrayList<GameComponent> components = new ArrayList<GameComponent>();
	public GameObject(PApplet p) {
		super(p);
		
	}

	public String name;
	public String tag;

	public Transform transform = new Transform();
	public abstract void start();
	public abstract void update();
	public abstract void render();
	public String ToString() {
		return this.name;
	}
}
