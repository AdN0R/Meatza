package Grafikoa;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Meatza.Jokoa;
import Meatza.Ranking;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mezua extends JDialog {

	private JPanel contentPanel = new JPanel();


	public Mezua(String mezu) {
		super(new Frame(),"", true);
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(50, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			JLabel label = new JLabel(mezu);
			label.setVerticalAlignment(SwingConstants.BOTTOM);
			contentPanel.add(label);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Jokoa.getJokoa().tableroaErreseteatu();
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
				JButton rankingButton = new JButton("Irten");
				rankingButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Ranking.getRanking().gorde();
						Leihoa.getLeihoa().dispose();
						dispose();
					}
				});
				rankingButton.setActionCommand("Irten");
				buttonPane.add(rankingButton);
				
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
		}
		setVisible(true);
	}
	
}
