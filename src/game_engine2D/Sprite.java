package game_engine2D;

import components2D.GameComponent;
import processing.core.PApplet;
import processing.core.PVector;

public abstract class Sprite extends GameObject {
	
	
	public PVector size = new PVector(12, 12);
	
	public Sprite(PApplet p)
	{
		super(p);
	}
	
	public Sprite(PApplet p, int x, int y)
	{
		super(p);
		this.transform.position.x = x;
		this.transform.position.y = y;
		
	}
	
	public abstract void render();

	@Override
	public void update() 
	{
		for (int i = this.components.size() -1; i >= 0; i--)
		{
			GameComponent comp = this.components.get(i);
			comp.update();
			comp.render();
		}
	}

	@Override
	public void start() 
	{
		for (int i = this.components.size() - 1; i >= 0; i--)
		{
			GameComponent comp = this.components.get(i);
			comp.start();
		}
	}
}
