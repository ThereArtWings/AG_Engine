package components2D;

import game_engine2D.GameObject;
import game_engine2D.ProcessingEntity;
import game_engine2D.Transform;

public abstract class GameComponent extends ProcessingEntity
{

	public GameObject gameObject;
	public Transform transform;
	public abstract void start();
	public abstract void update();
	public abstract void render();

	public GameComponent(GameObject g)
	{
		super(g.parent);
		this.gameObject = g;
		this.transform = this.gameObject.transform;
		this.gameObject.components.add(this);
	}

}
