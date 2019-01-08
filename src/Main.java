import processing.core.PApplet;
import simple_platformer.Launcher;
public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main("Main");
	}
	Launcher launcher;
	public void setup() {
		background(0);
		launcher = new Launcher(this);
		launcher.StartGame();
	}
	public void draw() {
		launcher.UpdateAll();
	}
	public void settings() {
		size(640,640);
	}
	public void keyPressed()
	{
		launcher.keyPressed(key, keyCode);
	}
	public void keyReleased()
	{
		launcher.keyReleased(key, keyCode);
		
	}
	public void mouseClicked() {
		launcher.mouseClicked(mouseX, mouseY, mouseButton);
	}
}
