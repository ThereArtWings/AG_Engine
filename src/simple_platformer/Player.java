package simple_platformer;

import game_engine2D.Sprite;
import processing.core.PApplet;
import processing.core.PVector;
import components2D.Physics2D;

public class Player extends Sprite {
	float speed = 3f;
	float gravity = 0.1f;
	private Physics2D physics;
	private PVector size = new PVector(12,12);
	private PVector velocity = new PVector (0,0);
	public int stroke = parent.color(120,120,255);
	public int fill = parent.color(255);

	public Player(PApplet p) {
		super(p);

	}
	 public Player(PApplet p, float x, float y, float w, float h) {
	        super(p);
	        speed = 3.0f;
	    }
	 public void start() {
		 this.transform.position.x = parent.width / 2;
		 this.transform.position.y = parent.height / 3;
		 this.transform.localBoundingBox.fromSize(size);
		 this.physics = new Physics2D(this);
		 this.physics.start();
		 this.physics.speed = speed;
	 }

	@Override
	public void update() {
super.update();
	//	velocity.y += this.gravity;
	//	this.transform.position.y += velocity.y;
	}
	@Override
	public void render(){
		
		parent.fill(this.fill);
		parent.stroke(this.stroke);
		parent.rect(this.transform.position.x, this.transform.position.y, this.size.x, this.size.y);
	//	parent.textSize(12);
//		parent.text("#"+this.physics.collisionCount, this.transform.position.x-4, this.transform.position.y-15);
	}
}
