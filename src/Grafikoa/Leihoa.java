package Grafikoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridLayout;

public class Leihoa extends JFrame {
	
	private static Leihoa nireLeihoa;
	private JPanel contentPane;
	private Lauki[][] matrix;

	/**
	 * Launch the application.
	 */
	public void hasieratu(){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try {
					Leihoa frame = getLeihoa();
					frame.setVisible(true);
				}
				catch (Exception e){
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public static Leihoa getLeihoa(){
		if(nireLeihoa==null){
			nireLeihoa = new Leihoa(10,10);
		}
		return nireLeihoa;
	}
	
	private Leihoa(int pI, int pJ) {
		
		this.matrix=new Lauki[pI][pJ];
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 600, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(pI, pJ, 0, 0));

		Lauki pLauki=null;
		for(int lerro=0; lerro<pI; lerro++){
			for(int zutabe=0; zutabe<pJ; zutabe++){
				pLauki = new Lauki(lerro,zutabe);
				this.matrix[lerro][zutabe]=pLauki;
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
	
	public void amaitu(){}
	
	public void eguneratu(int pI,int pJ,int pM){
		Leihoa l = Leihoa.getLeihoa();
		l.matrix[pI][pJ].aldatuIrudia(pM);
	}
}