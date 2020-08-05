package classes;

import java.awt.Point;

public class Pion {
	
	private String face;
	private Point position;
	
	public Pion(Point position, String face) {
		this.position = position;
		this.face = face;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
	
	public int getX() {
		return (int) position.getX();
	}
	
	public int getY() {
		return (int) position.getY();
	}
	
	@Override
	public String toString() {
		return this.face;
	}
	
	
}
