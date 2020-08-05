package gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;

public class InterfaceGraphique extends JFrame {

	private JPanel contentPane;
	private JTextField txtJ1;
	private JTextField txtJ2;
	
	final int WIDTH = 700;
	final int HEIGHT = 500;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGraphique frame = new InterfaceGraphique();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfaceGraphique() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, WIDTH, HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJoueur = new JLabel("Joueur 1");
		lblJoueur.setFont(new Font("Modern No. 20", Font.PLAIN, 11));
		lblJoueur.setBounds(439, 45, 46, 14);
		contentPane.add(lblJoueur);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.WHITE);
		canvas.setBounds(10, 10, 400, 400);
		contentPane.add(canvas);
		
		JLabel lblJoueur_1 = new JLabel("Joueur 2");
		lblJoueur_1.setFont(new Font("Modern No. 20", Font.PLAIN, 11));
		lblJoueur_1.setBounds(439, 76, 46, 14);
		contentPane.add(lblJoueur_1);
		
		txtJ1 = new JTextField();
		txtJ1.setBounds(510, 42, 164, 20);
		contentPane.add(txtJ1);
		txtJ1.setColumns(10);
		
		txtJ2 = new JTextField();
		txtJ2.setBounds(510, 73, 164, 20);
		contentPane.add(txtJ2);
		txtJ2.setColumns(10);
		
		JButton btnJouer = new JButton("Jouer");
		
		btnJouer.setFont(new Font("Modern No. 20", Font.PLAIN, 24));
		btnJouer.setBounds(439, 120, 235, 71);
		contentPane.add(btnJouer);
		
		JLabel lblScore = new JLabel("Score :");
		lblScore.setFont(new Font("Modern No. 20", Font.PLAIN, 16));
		lblScore.setBounds(439, 286, 46, 14);
		contentPane.add(lblScore);
		
		JLabel label = new JLabel("Joueur 1");
		label.setFont(new Font("Modern No. 20", Font.PLAIN, 11));
		label.setBounds(495, 253, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Joueur 2");
		label_1.setFont(new Font("Modern No. 20", Font.PLAIN, 11));
		label_1.setBounds(565, 253, 46, 14);
		contentPane.add(label_1);
		
		JLabel lblScore1 = new JLabel("0");
		lblScore1.setBounds(495, 287, 46, 14);
		contentPane.add(lblScore1);
		
		JLabel lblScore2 = new JLabel("0");
		lblScore2.setBounds(565, 287, 46, 14);
		contentPane.add(lblScore2);
		
		
		// Draw graphics
		
		
		btnJouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		
	}
	
	
	@Override
	public void paint(Graphics g) {
		// g.setColor(Color.BLACK);
		// g.fillOval(100, 100, 200, 200);
		// g.drawLine(10, 10, 20, 20);
	}
}
