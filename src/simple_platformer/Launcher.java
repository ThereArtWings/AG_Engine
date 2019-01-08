package simple_platformer;

import game_engine2D.*;
import components2D.Physics2D;
import processing.core.PApplet;
import java.util.concurrent.TimeUnit;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.event.MouseInputAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import simple_platformer.Player;


public class Launcher extends BaseLauncher{
	
	public boolean inEditor = false;
	public boolean started = false;
	int waiting = 0;
	JFrame frame = new JFrame("Mouse Events");
	JPanel pane = new JPanel();
	JPanel clickBox = new JPanel();
	Player playerInst;

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
			inEditor = false;
		}
		
		if (keyCode == 'c' || keyCode == 'C')
		{
			this.Editor();
			inEditor = true;
		}
	}
	
	public void keyReleased(char key, int keyCode)
	{
		super.keyReleased(key, keyCode);

	}
	
	public void AddPlatform(int x, int y) {
		 Wall wall;
	        Floors floor;

	        int tw = 50;
	        int th = 20;
	        
	        if (this.parent.mouseButton == 37)
	        {
	            parent.println("Help me");
	        	floor = new Floors(parent, x, y, tw, th);
	        	floor.start();
	        	this.gameManager.addObject(floor);
	        	this.gameManager.addGameBoundingBoxes(floor);
	        	
	        }
	}
	
	public void Editor()
	{
		
        Wall wall;
        Floors floor;

        int tw = 50;
        int th = 20;
        
        if (this.parent.mouseButton == 37)
        {
            parent.println("Help me");
        	floor = new Floors(parent, this.parent.mouseX, this.parent.mouseY, tw, th);
        	floor.start();
        	this.gameManager.addObject(floor);
        	this.gameManager.addGameBoundingBoxes(floor);
        	
        }
        
        for (int i = 0; i < 300; i++)
        {        	
        	wall = new Wall(parent, 45, (-parent.width) + (th) * i, tw, th);
        	
        	wall.strokeColour = parent.color(0, 0, 0);
        	wall.fillColour = parent.color(0, 0, 0);
        	this.gameManager.addObject(wall);
        	wall.start();
        	this.gameManager.addGameBoundingBoxes(wall);
        }
        
        for (int i = 0; i < 300; i++)
        {
        	wall = new Wall(parent, parent.width - 40, (-parent.width * 1) + (th) * i, tw, th);
        	
        	wall.strokeColour = parent.color(0, 0, 0);
        	wall.fillColour = parent.color(0, 0, 0);
        	this.gameManager.addObject(wall);
        	wall.start();
        	this.gameManager.addGameBoundingBoxes(wall);
        	
        	
        }
        
        
        
        
        this.started = true;
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
			waiting++;
			return;
		}
		
		TestRestart();
    }
	
	public void TestRestart()
	{
		Player player = new Player(parent, parent.width / 2, 630, 10, 10);
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
	

		public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		if(mouseButton == 37 && inEditor) {
			AddPlatform(mouseX, mouseY);
			
		}
        
	}
	
	  public void UpdateAll(){
	        super.UpdateAll();
	        if (started == false) {
	        parent.fill(255);
	        parent.textSize(18);
	        parent.text("Hit 'B' to reload", 250, 145);
	        parent.text("Hit 'C' to access editor", 220, 220);
	        
	        UIElement UIPiece1;
	        UIElement UIPiece2;
       
	        
	        
	        
        	UIPiece1 = new UIElement(parent, parent.width / 2, parent.height - 500, 0, 0);        	
        	UIPiece1.strokeColour = parent.color(0, 200, 200);
        	UIPiece1.fillColour = parent.color(0, 50, 50);
        	this.gameManager.addObject(UIPiece1);
        	UIPiece1.start();        	
        	this.gameManager.addGameBoundingBoxes(UIPiece1);
        	
        	UIPiece2 = new UIElement(parent, parent.width / 2, parent.height - 425, 0, 0);        	
        	UIPiece2.strokeColour = parent.color(0, 200, 200);
        	UIPiece2.fillColour = parent.color(0, 50, 50);
        	this.gameManager.addObject(UIPiece2);
        	UIPiece2.start();
        	this.gameManager.addGameBoundingBoxes(UIPiece2);
	        
       
	        }	   
	     }
    }