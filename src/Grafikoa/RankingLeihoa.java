package Grafikoa;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Meatza.Jokoa;
import Meatza.RDatua;
import Meatza.Ranking;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

public class RankingLeihoa extends JDialog {

	private JPanel contentPane;


	public RankingLeihoa() {
		super(new Frame(),"", true);
		setTitle("TOP 10");
		setResizable(false);
		setBounds(500, 200, 450, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(20, 50, 20, 50));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblRanking = new JLabel("RANKING");
		panel.add(lblRanking, BorderLayout.NORTH);
		lblRanking.setFont(new Font("Snap ITC", Font.PLAIN, 25));
		lblRanking.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("IRTEN");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}
		});
		panel_1.add(btnNewButton, BorderLayout.EAST);
		getRootPane().setDefaultButton(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 75, 10));
		
		int zailtasuna = Jokoa.getJokoa().getZailtasuna();
		RDatua[] zerrenda = Ranking.getRanking().getZerrenda();
		
		for (int i=(zailtasuna-1)*10; i<zailtasuna*10; i++){
			JLabel label = new JLabel((i+1-10*(zailtasuna-1))+".  "+ zerrenda[i].getIzena() +"      "+ zerrenda[i].getDenbora()+ " s");
			label.setFont(new Font("Arial", Font.PLAIN, 15));
			panel_2.add(label);
		}
		
		this.setVisible(true);
	}

}
