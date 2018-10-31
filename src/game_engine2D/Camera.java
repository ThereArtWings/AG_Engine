package game_engine2D;

import processing.core.PApplet;
import processing.core.PVector;

public class Camera extends GameObject {
		public GameObject follow;
		public float offsetLimit = 10;
		public PVector cameraOffset = new PVector(0, 0);
		public Camera(PApplet p, GameObject f) {
			super(p);
			this.follow = f;
		}
		public Camera(PApplet p, GameObject f, float limit) {
			super(p);
			this.follow = f;
			offsetLimit = limit;
		}
		@Override
		public void start()
		{
			
		}
		@Override
		public void update()
		{
			
		}
		@Override
		public void render()
		{
			late_update_xy();
		}
		
		private void late_update_xy()
		{
			PVector virtualScreenCentre = GameManager.screenOffset.copy();
			
			virtualScreenCentre.add(GameManager.offset);
			
			PVector virtualPlayer = GameManager.offset.copy();
			
			virtualPlayer.add(this.follow.transform.position);
			
			float d = virtualScreenCentre.dist(virtualPlayer);
			
			if (d > offsetLimit) 
			{
				virtualScreenCentre.sub(virtualPlayer);
				
				virtualScreenCentre.add(this.cameraOffset);
				
				GameManager.offset.lerp(virtualScreenCentre, 0.02f);
			}
		}
}
