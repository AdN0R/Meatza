package Grafikoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Button;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import java.awt.Panel;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import java.awt.TextField;
import java.awt.TextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.JToggleButton;

public class Menu extends JFrame {
	
	private static Menu nireMenu;
	private JPanel contentPane;
	private AukeraZ datua;
	
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
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		
		AukeraZ auk = new AukeraZ();
		panel.add(auk);
		this.datua=auk;

		Panel panel_1 = new Panel();
		contentPane.add(panel_1, BorderLayout.WEST);
		
		Panel panel_2 = new Panel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		AdosZ botoia = new AdosZ("Ados");
		panel_2.add(botoia);
		
		Component verticalStrut_1 = Box.createVerticalStrut(30);
		panel_2.add(verticalStrut_1);
		
		Panel panel_3 = new Panel();
		contentPane.add(panel_3, BorderLayout.EAST);
		
		Panel panel_4 = new Panel();
		contentPane.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblZaitlasuna = new JLabel("- ZAILTASUNA -");
		panel_4.add(lblZaitlasuna);
		
		Component verticalStrut = Box.createVerticalStrut(40);
		panel_4.add(verticalStrut);
	}
	
	public int egoera(){
		return this.datua.egoera();
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}