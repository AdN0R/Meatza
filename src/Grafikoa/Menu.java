package Grafikoa;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Meatza.Jokoa;

import java.awt.Component;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Box;
import javax.swing.JButton;

public class Menu extends JFrame {
	
	private JPanel contentPane;
	private int balio=1;
	private JTextField textua;
	private JSlider aukeraZ;
	

	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pAuk = new JPanel();
		contentPane.add(pAuk, BorderLayout.CENTER);
		
		aukeraZ= new JSlider();
		aukeraZ.setToolTipText("");
		aukeraZ.setValue(1);
		aukeraZ.setPaintLabels(true);
		aukeraZ.setPaintTicks(true);
		aukeraZ.setMajorTickSpacing(1);
		aukeraZ.setMaximum(3);
		aukeraZ.setMinimum(1);
		aukeraZ.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				balio=aukeraZ.getValue();
				
			}
		});
		pAuk.add(aukeraZ);
		
		Panel pBot = new Panel();
		contentPane.add(pBot, BorderLayout.SOUTH);
		
		JButton botoia = new JButton("ADOS");
		botoia.addActionListener(new ActionListener() {
			
			@Override

			public void actionPerformed(ActionEvent e) {
				if(textua.getText().isEmpty() || textua.getText().length() > 15){
					JOptionPane.showMessageDialog(null, "Erabiltzaile okerra, luzera 1-15 artean");
				}
				else{
					setVisible(false);	
					Jokoa.getJokoa().hasieratu(balio,textua.getText());
					Leihoa.getLeihoa().jokoNagusiaSortu();
				}
				
			}
		});
		pBot.add(botoia);
		getRootPane().setDefaultButton(botoia);
		
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
				
		setVisible(true);
		
	}

}