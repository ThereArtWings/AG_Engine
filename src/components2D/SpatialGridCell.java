package components2D;

import java.util.ArrayList;

public class SpatialGridCell 
{
	public BoundingBox boundingBox;
	public ArrayList<BoundingBox> subBoundingBoxes;
	public SpatialGridCell(int _1, int _r, int _t, int _b) 
	{
		boundingBox = new BoundingBox(_1,_r,_t,_b);
		subBoundingBoxes = new ArrayList<BoundingBox>();
	}
}
