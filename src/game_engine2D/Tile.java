package game_engine2D;

import processing.core.PApplet;

public abstract class Tile extends GameObject {
	public Tile(PApplet p) {
		super(p);
	}
	public Tile(PApplet p, int x, int y) {
		super(p);
		this.transform.position.x = x;
		this.transform.position.y = y;
		
	}
	public abstract void update();

	@Override
	public void render() {

	}

	@Override
	public void start() {
		
	}
}
