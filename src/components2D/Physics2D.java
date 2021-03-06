package components2D;

import java.util.ArrayList;

import game_engine2D.GameManager;
import game_engine2D.GameObject;
import processing.core.PApplet;
import processing.core.PVector;

public class Physics2D extends GameComponent {
	
	int frameDelay = 2;
	private PVector velocity = new PVector(0, 0);
	public BoxCollider2D boxCollider2D;
	float gravity = 0.1f;
	float friction = 0.9f;
	float frictionOveride = 1.0f;
	float frictionNormal = 0.9f;
	boolean isGrounded = false;
	public float speed = 5f;
	public float maxSpeed = 5f;
	
	public Physics2D(GameObject g)
	{
		super(g);
	}
	
	@Override
	public void start()
	{
		this.boxCollider2D = new BoxCollider2D(this.gameObject);
	}
	
	@Override
	public void update()
	{
		//this.transform.prev_position.x = this.transform.position.x;
		//this.transform.prev_position.y = this.transform.position.y;
		gravityEffect();
		
		if (this.isGrounded)
		{
			this.velocity.x *= friction;
		}
		
		if (PApplet.abs(velocity.x) >= maxSpeed)
		{
			if (velocity.x > 0) {
				velocity.x = maxSpeed;
			}
			else
			{
				velocity.x = -maxSpeed;
			}
		}
		
		if(isGrounded && PApplet.abs(velocity.x) <= 0.1f)
		{
			velocity.x =  0f;
		}
		
		this.transform.position.add(velocity);
		checkCollisions();
	}
	private void checkCollisions()
	{
		if (PApplet.abs(this.transform.prev_position.x - this.transform.position.x) < 0.001f)
		{
			if (PApplet.abs(this.transform.prev_position.y - this.transform.position.y) < 0.001f)
			{
				return;
			}
		}
		BoundingBox new_bb;
		new_bb = this.transform.NewWorldBoundingBox();
		ArrayList<BoundingBox> mySpatialLoc =  GameManager.basicSpatialGrid.queryGrid(new_bb);
		for (int i = 0; i < mySpatialLoc.size(); i++)
		{
			
			HitInfo hitInfo = new HitInfo();
			hitInfo.boundingBox = mySpatialLoc.get(i);
			hitInfo = this.boxCollider2D.checkCollision(hitInfo);
			if (hitInfo.didHit)
			{
				switch (hitInfo.hitSide)
				
				{
				case TOP:
					this.velocity.y = 0f;
					this.transform.position.y = hitInfo.boundingBox.bottom + this.transform.localBoundingBox.bottom;
					break;
					
				case BOTTOM:
					this.velocity.y = 0f;
					this.transform.position.y = hitInfo.boundingBox.top + this.transform.localBoundingBox.top;
					if(!this.isGrounded)
					{
						this.isGrounded = true;
						this.velocity.x *= 0.5f;
					}
					break;
				case LEFT:
					this.velocity.x *= -1f;
					this.transform.position.x = hitInfo.boundingBox.left + this.transform.localBoundingBox.left -2;
					this.isGrounded = false;
					break;
				case RIGHT:
					this.velocity.x *= -1f;
					this.transform.position.x = hitInfo.boundingBox.right + this.transform.localBoundingBox.right + 2;
					this.isGrounded = false;
					break;

				case NONE:
				this.isGrounded = false;
				break;
				}
			}
		}
	}
	@Override
	public void render() {
		
	}
	
	public void jump (float force)
	{
		if (this.isGrounded)
		{
			velocity.y = -force;
			isGrounded = false;
		}
	}
	
	private void gravityEffect() {
		velocity.y += gravity;
		if (velocity.y >= maxSpeed) {
			velocity.y = maxSpeed;
		}
	}
	
	public void setGravity(float g) {
		this.gravity = g;
	}
	
	public void move (float force)
	{
		//if (isGrounded) {
			this.friction = this.frictionOveride;
			this.velocity.x += force;
		//}
	}
	public void keyUp ()
	{
		//if (isGrounded)
		//{
			this.friction = this.frictionNormal;
		//}
	}
}
