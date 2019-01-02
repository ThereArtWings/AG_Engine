package simple_platformer;


import game_engine2D.*;
import components2D.Physics2D;
import processing.core.PApplet;

public class Launcher extends BaseLauncher{
	
	public boolean started = false;
	int waiting = 0;

	public Launcher(PApplet p) 
	{
		super(p);
	}
	
	public void keyPressed(char key, int keyCode)
	{
		super.keyPressed(key, keyCode);
		if (keyCode == 'b' || keyCode == 'B')
		{
			this.Reload();
		}
	}
	
	public void keyReleased(char key, int keyCode)
	{
		super.keyReleased(key, keyCode);

	}
	
	public void Reload()
	{
		this.gameManager.Init();
		TestRestart();
	}
	
	public void StartGame()
	{
		
		if (this.started)
			return;
		
		super.StartGame();

		if (waiting < 90)
		{
			parent.background(100);
			parent.text("Initialising", parent.width / 2, parent.height / 2);
			waiting++;
			return;
		}
		
		TestRestart();
    }
	
	public void TestRestart()
	{
		Player player = new Player(parent, parent.width / 2,parent.height / 2, 60, 60);
        player.start();
        this.gameManager.addObject(player);
        this.gameManager.addPlayerGameObject(player);
        Camera camera = new Camera(parent, player, -10);
        camera.cameraOffset.y = 0;
        this.gameManager.addObject(camera);
                
        Platform platform;
        Wall wall;
        Floors floor;

        int tw = 50;
        int th = 20;
        
        for (int i = 0; i < 80; i++) 
        {
        	int x = (int) parent.random(2, 12) * tw;
        	int y = (int) parent.random(-10, 32) * th;
        	floor = new Floors(parent, x, y, tw, th);
        	floor.start();
        	this.gameManager.addObject(floor);
        	this.gameManager.addGameBoundingBoxes(floor);
        }
        
       for (int i = 0; i < 1; i++)
        {
        	platform = new Platform(parent, parent.width / 2, parent.height, tw, th);
        	
        	platform.strokeColour = parent.color(0, 200, 200);
        	platform.fillColour = parent.color(0, 200, 200);
        	this.gameManager.addObject(platform);

        	platform.start();
        	this.gameManager.addGameBoundingBoxes(platform);
        } 
        
        for (int i = 0; i < 300; i++)
        {
        	wall = new Wall(parent, 45, (-parent.height) + (th) * i, tw, th);
        	
        	wall.strokeColour = parent.color(0, 0, 0);
        	wall.fillColour = parent.color(0, 0, 0);
        	this.gameManager.addObject(wall);
        	wall.start();
        	this.gameManager.addGameBoundingBoxes(wall);
        }
        
        for (int i = 0; i < 300; i++)
        {
        	wall = new Wall(parent, parent.width - 40, (-parent.height * 1) + (th) * i, tw, th);
        	
        	wall.strokeColour = parent.color(0, 0, 0);
        	wall.fillColour = parent.color(0, 0, 0);
        	this.gameManager.addObject(wall);
        	wall.start();
        	this.gameManager.addGameBoundingBoxes(wall);
        	
        }
        
        int a = 0;
        int b = 5;
        
        if (a > b)
        {
            this.gameManager.removeObject(player);
        }
        
        else
        {
        	a ++;
        }
        
        this.gameManager.StartAll();
        this.started = true;
        
	}
	
	  public void UpdateAll(){
	        super.UpdateAll();
	        parent.fill(255);
	        parent.textSize(18);
	        parent.text("Hit 'B' to reload", 5, 20);
	    }
}
