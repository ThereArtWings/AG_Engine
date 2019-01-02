package simple_platformer;

import game_engine2D.*;
import processing.core.PApplet;
import processing.core.PVector;

public class Floors extends Sprite{

	public int stroke = parent.color(0, 150, 150);
	public float playerY;
	
	public Floors(PApplet p)
	{
		super(p);
	}

	 public Floors(PApplet p, float x, float y, float w, float h) {
			super(p);
			size = new PVector(50, 10);
			 this.transform.position.x = x;
			 this.transform.position.y = y;

	 }

	 public void start()
	 {
		super.start();
		this.transform.localBoundingBox.fromSize(size);
	 }
	 
		public void render()
		{
			parent.pushMatrix();
			parent.translate(this.transform.position.x, this.transform.position.y);
			parent.fill(this.fillColour);
			parent.rectMode(PApplet.CENTER);
			parent.stroke(this.stroke);
			parent.rect(0, 0, this.size.x, this.size.y);
			parent.popMatrix();
		}	
		
		public void update()
		{
	 		super.update();
	 	}

}