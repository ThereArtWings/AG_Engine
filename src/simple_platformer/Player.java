package simple_platformer;

import game_engine2D.*;
import processing.core.PApplet;
import processing.core.PVector;
import components2D.Physics2D;
import java.util.concurrent.TimeUnit;
/* import java.lang.Object;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JComponent;
import javax.swing.text.JTextComponent;
import javax.swing.JTextArea; */

public class Player extends Sprite {
	float speed = 5f;
	float jump = 10f;
	private Physics2D physics;
	private PVector size = new PVector(12,12);
	public int stroke = parent.color(120,120,255);
	public int fill = parent.color(255);
	public float playerY = this.transform.position.y;

	public Player(PApplet p) 
	{
		super(p);
	}
	
	 public Player(PApplet p, float x, float y, float w, float h) 
	    {
	        super(p);
	    }
	 
	 public void start() 
	 {
		 this.transform.position.x = parent.width / 2;
		 this.transform.position.y = parent.height / 3;
		 this.transform.localBoundingBox.fromSize( size);
		 this.physics = new Physics2D(this);
		 this.physics.start();
		 this.physics.speed = speed;
	 }

	@Override
	public void update() 
	{
		super.update();
		this.transform.prev_position.x = this.transform.position.x;
		this.transform.prev_position.y = this.transform.position.y;
		
        if (this.transform.position.y <= -60)
        {
        	this.UpdateAll();
        }
	}
	@Override
	public void render()
	{
		
		parent.fill(this.fill);
		parent.stroke(this.stroke);
		parent.rect(this.transform.position.x, this.transform.position.y, this.size.x, this.size.y);
	}
	public void keyPressed(char key, int keyCode)
	{
		super.keyPressed(key, keyCode);
		
		if (keyCode == PApplet.UP)
		{
			this.physics.jump(jump);
		}
		
		if (keyCode == PApplet.LEFT)
		{
			this.physics.move(-speed);
		}
		if (keyCode == PApplet.RIGHT)
		{
			this.physics.move(speed);
		}
	}
	public void keyReleased(char key, int keyCode)
	{
		this.physics.keyUp();
	}
	public void UpdateAll()
	{
		parent.textSize(20);
        parent.fill(255);
        parent.text("GG Fam",  parent.width / 2, parent.height / 2);
        parent.println("I Want Die");
        try
        {
        	TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.exit(0);
	}
}
