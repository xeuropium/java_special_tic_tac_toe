package classes;

public class Joueur {
	
	private String nom;
	private String face;
	private int score;
	
	public Joueur(String nom, String face) {
		this.nom = nom;
		this.face = face;
		this.score = 0;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	public void incrScore() {
		this.score ++;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}
	
	

}
