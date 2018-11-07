package simple_platformer;


import game_engine2D.*;
import processing.core.PApplet;


public class Launcher extends BaseLauncher{

	public Launcher(PApplet p) {
		super(p);
	}

	public void StartGame(){
		super.StartGame();
        Player player = new Player(parent, parent.width/2,parent.height/2, 60, 60);
        player.start();
        this.gameManager.addObject(player);
        Camera camera = new Camera(parent, player, 0);
        camera.cameraOffset.y = 0;
        this.gameManager.addObject(camera);
        int platforms = 500;
        Platform platform;
        int tw = 50;
        int th = 20;
        int numPlatformsX = 2 * parent.width / tw;
        int numPlatformsY = 2 * parent.height / th;
        for (int i = 0; i < platforms; i++) 
        {
        	int x = (int) parent.random(0, numPlatformsX) * tw;
        	int y = (int) parent.random(-numPlatformsY, numPlatformsY) * th;
        	platform = new Platform(parent, x, y, tw, th);
        	platform.start();
        	this.gameManager.addObject(platform);
        	this.gameManager.addGameBoundingBoxes(platform);
        }
        
        for (int i = 0; i < platforms; i++)
        {
        	Platform platformL = new Platform(parent, 10 + i * 50, parent.height-700, 50, 50);
        	platformL.start();
        	this.gameManager.addObject(platformL);
        	this.gameManager.addGameBoundingBoxes(platformL);
        }
        
        for (int i = 0; i < platforms; i++)
        {
        	Platform platformL2 = new Platform(parent, 10 + i * 50, parent.height-50, 50, 50);
        	platformL2.start();
        	this.gameManager.addObject(platformL2);
        	this.gameManager.addGameBoundingBoxes(platformL2);
        }
        
        this.gameManager.StartAll(); 
    }
	  public void UpdateAll(){
	        super.UpdateAll();
	    }

}
