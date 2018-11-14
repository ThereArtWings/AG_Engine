package game_engine2D;
import processing.core.PApplet;

public abstract class BaseLauncher {
    public PApplet parent;

   
    public BaseLauncher(PApplet p){
        parent = p;
    }
  
    public GameManager gameManager;
    public void StartGame(){
        gameManager = new GameManager(parent);
      
    }
    public void UpdateAll(){
        gameManager.UpdateAll();
    }
    public void keyPressed(char key, int keyCode) {
    	gameManager.keyPressed(key, keyCode);
    }
    
    public void keyReleased(char key, int keyCode) {
    	gameManager.keyReleased(key, keyCode);
    }

}
