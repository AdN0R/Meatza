package Grafikoa;

import Meatza.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridLayout;
import javax.swing.JButton;

public class Leihoa extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Leihoa frame = new Leihoa(10,10); //meter dos parametros
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
	public Leihoa(int pI, int pJ) { //dos parametros para crear el tablero
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(pI, pJ, 0, 0));
		
		Lauki pLauki;
		for(int lerro=0; lerro<pI; lerro++){
			for(int zutabe=0; zutabe<pJ; zutabe++){
				pLauki = new Lauki(lerro,zutabe,lerro+"-"+zutabe);
				panel.add(pLauki);
			}
		}
		
		Component pGoi = Box.createVerticalStrut(125);
		contentPane.add(pGoi, BorderLayout.NORTH);
		
		Component pEzkerra = Box.createHorizontalStrut(40);
		contentPane.add(pEzkerra, BorderLayout.WEST);
		
		Component pBehe = Box.createVerticalStrut(40);
		contentPane.add(pBehe, BorderLayout.SOUTH);
		
		Component pEskuma = Box.createHorizontalStrut(40);
		contentPane.add(pEskuma, BorderLayout.EAST);
		
	}
}