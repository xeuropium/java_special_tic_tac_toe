package classes;

import java.awt.Point;

public class Plateau {

	private Pion[][] matrice;

	private Joueur j1;
	private Joueur j2;
	private Joueur currentPlayer;

	public Plateau() {
		resetTableau();
	}

	public void ajouterJ1(String nom) {
		this.j1 = new Joueur(nom, "X");
	}

	public void ajouterJ2(String nom) {
		this.j2 = new Joueur(nom, "O");
	}
	
	public Joueur getJoueur1() {
		return j1;
	}
	
	public Joueur getJoueur2() {
		return j2;
	}
	
	public Joueur joueurCommence() {
		int random = (int) Math.round(Math.random());
		
		if (random == 0) {
			currentPlayer = j1;
			return j1;
		}
		else {
			currentPlayer = j2;
			return j2;
		}
	}
	
	public Joueur getCurrentPlayer() {
		return currentPlayer;
	}
	
	public void switchCurrentPlayer() {
		if (currentPlayer.getNom().equals(j1.getNom())) 
			currentPlayer = j2;
		else 
			currentPlayer = j1;
	}

	// true on peut ajouter un pion
	public boolean ajouterPion(Pion pion) {
		if (this.matrice[pion.getY()][pion.getX()].getFace().equals(" ")) {
			this.matrice[pion.getY()][pion.getX()] = pion;
			return true;
		}
		else
			return false;
	}

	// if verif() reset plat and 
	public boolean verifierGagnant() {
		String face = "";

		// MATRICE[y][x]
		// horizontal
		for (int i = 0; i < 3; i ++) {
			if ( ! matrice[i][0].getFace().equals(" ") && faceEquals(i, i, i, 0, 1, 2)) {
				face = matrice[i][0].getFace();
			}
		}
		
		// vertical
		for (int i = 0; i < 3; i ++) {
			if (! matrice[0][i].getFace().equals(" ") && faceEquals(0, 1, 2, i, i, i)) {
				face = matrice[0][i].getFace();
			}
		}

		// diagonal 1 && 2
		if (! matrice[0][0].getFace().equals(" ") && faceEquals(0, 1, 2, 0, 1, 2)) {
			face = matrice[0][0].getFace();
		} else if (! matrice[2][0].getFace().equals(" ") && faceEquals(2, 1, 0, 0, 1, 2)) {
			face = matrice[2][0].getFace();
		}
		

		if (face != "")
			return true;
		else 
			return false;
	}
	
	public boolean faceEquals(int posY1, int posY2, int posY3, int posX1, int posX2, int posX3) {
		if (matrice[posY1][posX1].getFace().equals(matrice[posY2][posX2].getFace()) && 
				matrice[posY1][posX1].getFace().equals(matrice[posY3][posX3].getFace()))
			return true;
		else 
			return false;
	}

	public boolean remplis() {
		for( int i = 0; i < 3; i ++) {
			for (int j = 0; j < 3; j++) {
				if (matrice[i][j].getFace().equals(" "))
					return false;
			}
		}
		return true;
	}
	
	public void resetTableau() {
		this.matrice = new Pion[3][3];

		// fill with empty pawns to avoid a null test
		for( int i = 0; i < 3; i ++) {
			for (int j = 0; j < 3; j++) {
				matrice[i][j] = new Pion(new Point(i, j), " ");
			}
		}
	}

	public String afficherPlateau() {
		String msg = "";

		for( int i = 0; i < 3; i ++) {
			for (int j = 0; j < 3; j++) {
				msg += "|" + matrice[i][j] + " |";
			}
			msg += "\n------------\n";
		}

		return msg;
	}

	




}
