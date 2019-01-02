package game_engine2D;

import components2D.GameComponent;
import processing.core.PApplet;
import processing.core.PVector;

public abstract class Sprite extends GameObject {
	
	public int strokeColour;
	public int fillColour;
	
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
		this.transform.prev_position.x = this.transform.position.x;
		this.transform.prev_position.y = this.transform.position.y;
		
	}

	@Override
	public void start() 
	{
		this.transform.localBoundingBox.fromSize(size);
		for (int i = this.components.size() - 1; i >= 0; i--)
		{
			GameComponent comp = this.components.get(i);
			comp.start();
		}
	}
}
