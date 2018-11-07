package components2D;

import game_engine2D.SIDES;

public class HitInfo {
	public SIDES hitSide = SIDES.NONE;
	public BoundingBox boundingBox;
	public boolean didHit = false;
}
