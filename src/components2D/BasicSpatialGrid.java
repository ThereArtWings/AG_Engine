package components2D;

import java.util.ArrayList;
import game_engine2D.GameManager;
import processing.core.*;

public class BasicSpatialGrid
{
	class Coord 
	{
		int x, y;
		public Coord(int _x, int _y)
		{
			x = _x;
			y = _y;
		}
	}
	int outOfBounds = 0;
	private int height, gridLengthX, gridLengthY, gridSize;
	private int gridRes = 2;
	private Coord globalMin = new Coord(999999,999999);
	private Coord globalMax = new Coord(-999999,-999999);
	
	private ArrayList<SpatialGridCell> spaticalGridCells;
	
	public BasicSpatialGrid(int h, int _gridRes)
	{
		height = h;
		gridRes = _gridRes;
		
		defineMinMax();
		makeSpatialGrid();
		
		populateGrid();
	}
	
	private void defineMinMax() 
	{
		for (int i = 0; i < GameManager.gameBoundingBoxes.size(); i++)
		{
			BoundingBox bb = GameManager.gameBoundingBoxes.get(i);
			if (bb.left < globalMin.x)
			{
				globalMin.x = (int)bb.left;
			}
			if (bb.top < globalMin.y) 
			{
				globalMin.y = (int)bb.top;
			}
			if (bb.bottom > globalMax.y)
			{
				globalMax.y = (int)bb.bottom;
			}
		}
	}
	private void makeSpatialGrid()
	{
		gridSize = height / gridRes;
		gridLengthX = PApplet.floor(globalMax.x / gridSize);
		gridLengthY = PApplet.floor(globalMax.y / gridSize);
		spatialGridCells = new ArrayList<SpatialGridCell>();
		
		for (int x = 0; x<=gridLengthX ;x++)
		{
			for (int y=0; y<=gridLengthY; y++)
			{
				int 1 = x * gridSize;
				int r = (x +1) * gridSize;
				int t = t * gridSize;
				int b = (y +1) * gridSize;
				spatialGridCells.add(new SpatialGridCell(1, r, t, b))
			}
		}
	}
	private void populateGrid ()
	{
		for (int i = 0; i < GameManager.gameBoundingBoxes.get(i))
		{
			BoundingBox bb = GameManager.gameBoundingBoxes.get(i);
			addToGrid(bb);
		}
	}
	private void addToGrid(BoundingBox _bb)
	{
		Coord pos = gridCoordinated(_bb.right, _bb.bottom);
		int index = pos.x * gridLengthX + pos.y;
		addByIndexTo(index, _bb);
		pos = gridCoordinates(_bb.left, _bb.bottom);
		
	}
}
