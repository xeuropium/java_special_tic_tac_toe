package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class MyPanel extends JPanel {

	// for the canvas
	private final int WIDTH = 400;
	private final int HEIGHT = 400;
	private final int OFFSET = 10;

	public MyPanel() {
		super();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		this.setBounds(OFFSET, OFFSET, 700, 500);

		
		reDrawPlateau(g);

		// paintPion(g, 0, 1, "X");
	}
	
	public void reDrawPlateau(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 400, 400);


		//Draw tic tac toe bound
		int thickness = 5;

		g.setColor(Color.black);

		g.fillRect(WIDTH / 3, 10, 5, HEIGHT - 20);
		g.fillRect(WIDTH - (WIDTH/3), 10, 5, HEIGHT - 20);

		g.fillRect(10, HEIGHT / 3 , HEIGHT - 20, 5);
		g.fillRect(10, HEIGHT - (HEIGHT/3), HEIGHT - 20, 5);
	}


	public void paintPion(Graphics g, int x, int y, String face) {

		if (face == "X") {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.blue);

			Rectangle rect1 = null;
			Rectangle rect2 = null;

			if (x == 0 && y == 0) { // top left
				rect1 = new Rectangle(50, 0, 100, 10);
				rect2 = new Rectangle(95, - 45, 10, 100);
				
			} else if (x == 1 && y == 0) { // top mid
				rect1 = new Rectangle(150, - 100, 100, 10);
				rect2 = new Rectangle(195, - 145, 10, 100);
				
			} else if (x == 2 && y == 0) { // top right
				rect1 = new Rectangle(245, - 195, 100, 10);
				rect2 = new Rectangle(290, - 240, 10, 100);
				
			}  else if (x == 0 && y == 1) { // mid left
				rect1 = new Rectangle(145, 95, 100, 10);
				rect2 = new Rectangle(190, 50, 10, 100);
				
			} else if (x == 1 && y == 1) { // mid mid 
				rect1 = new Rectangle(245, - 5, 100, 10);
				rect2 = new Rectangle(290, - 50, 10, 100);
				
			} else if (x == 2 && y == 1) { // mid right
				rect1 = new Rectangle(340, - 100, 100, 10);
				rect2 = new Rectangle(385, - 145, 10, 100);
				
			} else if (x == 0 && y == 2) { // bot left
				rect1 = new Rectangle(245, 195, 100, 10);
				rect2 = new Rectangle(290, 150, 10, 100);
				
			} else if (x == 1 && y == 2) { // bot mid
				rect1 = new Rectangle(345, 100, 100, 10);
				rect2 = new Rectangle(390, 50, 10, 100);
				
			} else if (x == 2 && y == 2) { // bot right
				rect1 = new Rectangle(445, 0, 100, 10);
				rect2 = new Rectangle(490, - 50, 10, 100);
				
			}
			

			g2d.rotate(Math.toRadians(45));
			g2d.draw(rect1);
			g2d.fill(rect1);

			g2d.draw(rect2);
			g2d.fill(rect2);
			
			// rotate back because it's rotating user interface to
			g2d.rotate(Math.toRadians(- 45));
			

		} else { 
			// Cercle
			int x1 = 0;
			int y1 = 0;

			if (x == 0 && y == 0) {
				x1 = 15; 
				y1 = 15;
			} else if (x == 1 && y == 0) {
				x1 = 150; 
				y1 = 15;
			} else if (x == 2 && y == 0) {
				x1 = 280; 
				y1 = 15;
			} else if (x == 0 && y == 1) {
				x1 = 15; 
				y1 = 150;
			} else if (x == 1 && y == 1) {
				x1 = 150; 
				y1 = 150;
			} else if (x == 2 && y == 1) {
				x1 = 280; 
				y1 = 150;
			} else if (x == 0 && y == 2) {
				x1 = 15; 
				y1 = 280;
			} else if (x == 1 && y == 2) {
				x1 = 150; 
				y1 = 280;
			} else if (x == 2 && y == 2) {
				x1 = 280; 
				y1 = 280;
			}

			g.setColor(Color.blue);
			g.fillOval(x1, y1, 100, 100);

			g.setColor(Color.white);
			g.fillOval(x1 + 10, y1 + 10, 80, 80);
		}
	}

}
