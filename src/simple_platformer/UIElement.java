package simple_platformer;

import game_engine2D.*;
import processing.core.PApplet;
import processing.core.PVector;

public class UIElement extends Sprite{

	public int stroke = parent.color(50, 200, 200);
	public float playerY;
	
	public UIElement(PApplet p)
	{
		super(p);
	}

	 public UIElement(PApplet p, float x, float y, float w, float h) {
			super(p);
			size = new PVector(250, 50);
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
	 		this.transform.prev_position.x = this.transform.position.x;
			this.transform.prev_position.y = this.transform.position.y;
	 	}

}