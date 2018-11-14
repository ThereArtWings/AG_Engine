package simple_platformer;

import game_engine2D.*;
import processing.core.PApplet;
import processing.core.PVector;
import components2D.Physics2D;

public class Player extends Sprite {
	float speed = 5f;
	float jump = 10f;
	private Physics2D physics;
	private PVector size = new PVector(12,12);
	public int stroke = parent.color(120,120,255);
	public int fill = parent.color(255);

	public Player(PApplet p) 
	{
		super(p);

	}
	
	 public Player(PApplet p, float x, float y, float w, float h) 
	    {
	        super(p);
	    }
	 
	 public void start() 
	 {
		 this.transform.position.x = parent.width / 2;
		 this.transform.position.y = parent.height / 3;
		 this.transform.localBoundingBox.fromSize(size);
		 this.physics = new Physics2D(this);
		 this.physics.start();
		 this.physics.speed = speed;
	 }

	@Override
	public void update() 
	{
		super.update();

	}
	@Override
	public void render(){
		
		parent.fill(this.fill);
		parent.stroke(this.stroke);
		parent.rect(this.transform.position.x, this.transform.position.y, this.size.x, this.size.y);

	}
	public void keyPressed(char key, int keyCode)
	{
		super.keyPressed(key, keyCode);
		
		if (keyCode == PApplet.UP)
		{
			this.physics.jump(jump);
			System.out.println("Test");
		}
		
		if (keyCode == PApplet.LEFT)
		{
			this.physics.move(-speed);
		}
		if (keyCode == PApplet.RIGHT)
		{
			this.physics.move(speed);
		}
	}
	public void keyReleased(char key, int keyCode)
	{
		//super.keyReleased(key, keyCode);
		this.physics.keyUp();
		
	}
}
