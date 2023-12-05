package tw.brad.classes;

import java.io.Serializable;

public class Bike extends Object implements Serializable {
	protected double speed;
	
	public void upSpeed() {
		speed = speed < 1 ? 1 : speed * 1.4;
	}
	
	public void downSpeed() {
		speed = speed < 1 ? 0 : speed * 0.5;
	}
	
	public double getSpeed() {
		return speed;
	}
}
