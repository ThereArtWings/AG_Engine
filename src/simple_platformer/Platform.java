package simple_platformer;

import game_engine2D.Tile;
import processing.core.PApplet;
import processing.core.PVector;

public class Platform extends Tile{
	
	private PVector size = new PVector(48, 12);
	public int stroke = parent.color(255, 255, 255);
	public int fill = parent.color(61, 255, 255);

	public Platform(PApplet p) {
		super(p);
	}
	
	 public Platform(PApplet p, float x, float y, float w, float h) {
			super(p);
			 this.transform.position.x = x;
			 this.transform.position.y = y;
	    }
	
	 public void start() {
		
	 }
	 	@Override
		public void update() {

		}
		
		@Override
		public void render(){
			
			parent.fill(this.fill);
			parent.stroke(this.stroke);
			parent.rect(this.transform.position.x, this.transform.position.y, this.size.x, this.size.y);

		}

}
