package components2D;

import game_engine2D.GameObject;
import game_engine2D.ProcessingEntity;
import game_engine2D.Transform;
import game_engine2D.SIDES;

public class BoxCollider2D extends ProcessingEntity
{
	public Transform transform = new Transform();
	
	public BoxCollider2D(GameObject g)
	{
		super(g.parent);
		this.transform = g.transform;
	}
	
	public HitInfo checkCollision(HitInfo hitInfo)
	{
		BoundingBox new_bb;
		new_bb = this.transform.NewWorldBoundingBox();
		BoundingBox prev_bb;
		prev_bb = this.transform.PreviousWorldBoundingBox();
		BoundingBox platform_bb = hitInfo.boundingBox;
		if(this.transform.position.y > platform_bb.top && this.transform.position.y < platform_bb.bottom)
		{
			if (new_bb.left < platform_bb.right && new_bb.right > platform_bb.right)
			{
				hitInfo.hitSide = SIDES.RIGHT;
				hitInfo.didHit = true;
			}
			if (new_bb.left < platform_bb.left && new_bb.right > platform_bb.left)
			{
				hitInfo.hitSide = SIDES.LEFT;
				hitInfo.didHit = true;
			}
		}
		else if (new_bb.right > platform_bb.left && new_bb.left < platform_bb.right)
		{
			if (new_bb.bottom > platform_bb.top && prev_bb.top < platform_bb.top)
			{
				hitInfo.hitSide = SIDES.BOTTOM;
				hitInfo.didHit = true;
			}
			if (new_bb.top < platform_bb.bottom && prev_bb.bottom > platform_bb.bottom)
			{
				hitInfo.hitSide = SIDES.TOP;
				hitInfo.didHit = true;
			}
		} else {
			
		}
		return hitInfo;
	}
}