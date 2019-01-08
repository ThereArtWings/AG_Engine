package game_engine2D;

import processing.core.PApplet;

public abstract class ProcessingEntity {
	public String name;
	public int ID;
    public PApplet parent;
    
    public ProcessingEntity(PApplet p){
        parent = p;
    }
}
