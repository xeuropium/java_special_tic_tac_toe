package gui;

import java.awt.Point;
import java.util.Scanner;

import classes.Pion;
import classes.Plateau;

public class Test {
	
	
	public static void main(String args[]) {
		Plateau plateau = new Plateau();
	
		plateau.ajouterJ1("felixX");
		plateau.ajouterJ2("felixO");
		
		Scanner scan = new Scanner(System.in);
		
		// flip pour savoir quel joueur commence
		// j1 = X 
		// j2 = O
		String currentFace = "X";
		
		while (! plateau.remplis()) {
			System.out.println("x : ");
			int x = Integer.parseInt(scan.next());
			System.out.println("y : ");
			int y = Integer.parseInt(scan.next());
			
			if (! plateau.ajouterPion(new Pion(new Point(x, y), currentFace)))
				System.out.println("Case deja prise");
			else if (plateau.verifierGagnant()) {
				System.out.println(currentFace + " a gagné la manche !");
				System.out.println(plateau.afficherPlateau());
				break;
			} else {
				if (currentFace == "X")
					currentFace = "O";
				else 
					currentFace = "X";
			}
			
			System.out.println(plateau.afficherPlateau());
			
			
			
		}
		
		System.out.println("draw !");
	}
	
	
}
