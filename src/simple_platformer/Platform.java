package simple_platformer;

import game_engine2D.Sprite;
import processing.core.PApplet;
import processing.core.PVector;

public class Platform extends Sprite{

	public int stroke = parent.color(0, 150, 150);
	
	public Platform(PApplet p)
	{
		super(p);
	}

	 public Platform(PApplet p, float x, float y, float w, float h) {
			super(p);
			size = new PVector(48, 1);
			 this.transform.position.x = x;
			 this.transform.position.y = y;
			 
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
