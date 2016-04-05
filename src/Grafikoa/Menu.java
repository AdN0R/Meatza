package Grafikoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Component;

import java.awt.Panel;
import javax.swing.SwingConstants;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.Box;

public class Menu extends JFrame {
	
	private static Menu nireMenu;
	private JPanel contentPane;
	private int balio=1;
	private JTextField textua;
	
	public static Menu getMenu(){
		if(nireMenu==null){
			nireMenu=new Menu();
		}
		return nireMenu;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	private Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pAuk = new JPanel();
		contentPane.add(pAuk, BorderLayout.CENTER);
		
		AukeraZ auk = new AukeraZ();
		pAuk.add(auk);
		
		Panel pBot = new Panel();
		contentPane.add(pBot, BorderLayout.SOUTH);
		
		Ados botoia = new Ados();
		pBot.add(botoia);
		
		Component zBot = Box.createVerticalStrut(40);
		pBot.add(zBot);
		
		Panel pTex = new Panel();
		contentPane.add(pTex, BorderLayout.NORTH);
		pTex.setLayout(new BorderLayout(0, 0));
		
		Panel pGoi = new Panel();
		pTex.add(pGoi, BorderLayout.NORTH);
		
		JLabel mTex = new JLabel("- IDENTIFIKAZIOA -");
		pGoi.add(mTex);
		mTex.setHorizontalAlignment(SwingConstants.CENTER);
		
		Component zTex = Box.createVerticalStrut(40);
		pGoi.add(zTex);
		
		Panel pBeh = new Panel();
		pTex.add(pBeh, BorderLayout.SOUTH);
		
		JLabel mAuk = new JLabel("- ZAILTASUNA -");
		pBeh.add(mAuk);
		mAuk.setHorizontalAlignment(SwingConstants.CENTER);
		
		Component zAuk = Box.createVerticalStrut(40);
		pBeh.add(zAuk);
		
		Panel pErd = new Panel();
		pTex.add(pErd, BorderLayout.CENTER);
		
		textua = new JTextField();
		pErd.add(textua);
		textua.setColumns(10);
	}
	
	public String textuaItzuli(){
		return this.textua.getText();
	}
	
	public void balioaAldatu(int pBal){
		this.balio=pBal;
	}
	
	public int egoera(){
		return this.balio;
	}
}