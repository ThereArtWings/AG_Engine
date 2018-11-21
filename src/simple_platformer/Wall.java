package simple_platformer;

import game_engine2D.Sprite;
import processing.core.PApplet;
import processing.core.PVector;

public class Wall extends Sprite{
	
	public int stroke = parent.color(255, 255, 255);
	public int fill = parent.color(61, 255, 255);
	
	public Wall(PApplet p)
	{
		super(p);
	}

	 public Wall(PApplet p, float x, float y, float w, float h) {
			super(p);
			size = new PVector(5, 50);
			 this.transform.position.x = x;
			 this.transform.position.y = y;
			 this.strokeColour = parent.color(0, 255, 255);
			 this.fillColour = parent.color(255, 255, 155);
	    }
	@Override
	 public void start() {
		super.start();
		this.transform.localBoundingBox.fromSize(size);
	 }
	 	@Override
		public void update() {
	 		super.update();
		}
		
		@Override
		public void render(){
			parent.pushMatrix();
			parent.translate(this.transform.position.x, this.transform.position.y);
			parent.fill(this.fillColour);
			parent.rectMode(PApplet.CENTER);
			parent.stroke(this.stroke);
			parent.rect(0, 0, this.size.x, this.size.y);
			parent.popMatrix();

		}

}
