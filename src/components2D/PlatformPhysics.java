package components2D;

import java.util.ArrayList;

import game_engine2D.GameManager;
import game_engine2D.GameObject;
import processing.core.PApplet;
import processing.core.PVector;

public class PlatformPhysics extends GameComponent {
	
	int frameDelay = 2;
	private PVector velocity = new PVector(0, -1);
	public BoxCollider2D platCollider;
	
	public PlatformPhysics(GameObject g)
	{
		super(g);
	}
	
	@Override
	public void start()
	{
		this.platCollider = new BoxCollider2D(this.gameObject);
	}
	
	@Override
	public void update()
	{
		this.transform.prev_position.x = this.transform.position.x;
		this.transform.prev_position.y = this.transform.position.y;
		this.transform.position.add(velocity);
	//	checkCollisions();
	}
	private void checkCollisions()
	{
		BoundingBox new_bb;
		new_bb = this.transform.NewWorldBoundingBox();
		ArrayList<BoundingBox> mySpatialLoc =  GameManager.basicSpatialGrid.queryGrid(new_bb);
		for (int i = 0; i < mySpatialLoc.size(); i++)
		{
			
			HitInfo hitInfo = new HitInfo();
			hitInfo.boundingBox = mySpatialLoc.get(i);
			hitInfo = this.platCollider.checkCollision(hitInfo);
			if (hitInfo.didHit)
			{
				switch (hitInfo.hitSide)
				
				{
				case TOP:
					this.transform.position.y = hitInfo.boundingBox.bottom + this.transform.localBoundingBox.bottom;
					break;
					
				case BOTTOM:
					this.transform.position.y = hitInfo.boundingBox.top + this.transform.localBoundingBox.top;
					break;
					
				case LEFT:
					this.transform.position.x = hitInfo.boundingBox.left + this.transform.localBoundingBox.left -2;
					break;
					
				case RIGHT:
					this.transform.position.x = hitInfo.boundingBox.right + this.transform.localBoundingBox.right + 2;
					break;

				}
			}
		}
	}
	@Override
	public void render() {
		
	}
}
