package Grafikoa;

import static java.lang.Math.toIntExact;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Meatza.Jokoa;
import Meatza.Kronometro;
import Meatza.Ranking;
import Meatza.RDatua;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

public class Leihoa extends JFrame implements Observer{
	
	private static Leihoa nireLeihoa;
	private JPanel contentPane;
	private Lauki[][] matrix;
	private boolean amaituta;
	private JLabel markaKont;
	private JLabel kron;

	public static Leihoa getLeihoa(){
		if(nireLeihoa==null){
			nireLeihoa = new Leihoa();
		}
		return nireLeihoa;
	}

	private Leihoa(){
		Jokoa.getJokoa().addObserver(this);
	}
	 public void hasiera(){
		 new Menu();
	 }
	
	
	public void jokoNagusiaSortu(){
		
		amaituta=false;
		Jokoa j = Jokoa.getJokoa();
		int pI = j.tableroarenAltuera();
		int pJ = j.tableroarenZabalera();
		
		this.matrix=new Lauki[pI][pJ];
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent event) {
	        	Ranking.getRanking().gorde();
	            System.exit(0);
	        }
	    });
		if(pI<9){
			setBounds(50, 50, 595, 505);
		}
		else if(pI>11){
			setBounds(50, 50, 1205, 725);
		}
		else{
			setBounds(50, 50, 655, 685);
		}
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
		
		Panel pKont = new Panel();
		contentPane.add(pKont, BorderLayout.NORTH);
		pKont.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 5));
		
		JButton hasieratu= new JButton();
		hasieratu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Jokoa.getJokoa().tableroaErreseteatu();				
			}
		});
		hasieratu.setText(String.format("\t"));

		markaKont = new JLabel();
		minaKopEguneratu();
		markaKont.setForeground(Color.red);
		markaKont.setHorizontalTextPosition(SwingConstants.CENTER);
		markaKont.setHorizontalAlignment(SwingConstants.CENTER);
		markaKont.setBackground(null);
		markaKont.setOpaque(true);
		markaKont.setFont(new Font("Lucida Grande", Font.BOLD, 30));

		kron = new JLabel();
		kron.setText("0");
		kron.setForeground(Color.red);
		kron.setHorizontalTextPosition(SwingConstants.CENTER);
		kron.setHorizontalAlignment(SwingConstants.CENTER);
		kron.setBackground(null);
		kron.setOpaque(true);
		kron.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		
		pKont.add(markaKont);
		pKont.add(hasieratu);
		pKont.add(kron);
		
		Component pEzkerra = Box.createHorizontalStrut(40);
		contentPane.add(pEzkerra, BorderLayout.WEST);
		
		Component pBehe = Box.createVerticalStrut(40);
		contentPane.add(pBehe, BorderLayout.SOUTH);
		
		Component pEskuma = Box.createHorizontalStrut(40);
		contentPane.add(pEskuma, BorderLayout.EAST);
		this.setResizable(false);
		setVisible(true);
	}
	
	public void amaitu(){
		this.amaituta=true;
	}
	public boolean amaituta(){
		return amaituta;
	}
	
	public void eguneratu(int pI,int pJ,int pM){
		matrix[pI][pJ].aldatuIrudia(pM);
	}

	private void galdu(){
		this.amaitu();
		this.minakErakutsi();
		new Mezua (":(");		
	}
	
	private void irabazi(){
		this.amaitu();
		Ranking.getRanking().konprobatu(new RDatua( Jokoa.getJokoa().getIzena(),toIntExact(Kronometro.getKronometro().getDenboraTartea()),Jokoa.getJokoa().getZailtasuna()));
		new Mezua("ZORIONAK!!! Irabazi duzu");
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		int i=Jokoa.getJokoa().getAzkenI();
		int j=Jokoa.getJokoa().getAzkenJ();
		if(i>=0 && j>=0){
			this.eguneratu(i,j, Jokoa.getJokoa().gelaxkarenMotaLortu(i, j));
			this.minaKopEguneratu();
			if(Jokoa.getJokoa().galdu()){
				this.galdu();
			}
			if(Jokoa.getJokoa().irabazi()){
				this.irabazi();
			}
		}
		
	}
	
	private void minakErakutsi(){
		for (int i=0; i<matrix.length; i++){
			for (int j=0; j<matrix[0].length; j++){
				int mota =Jokoa.getJokoa().gelaxkarenAzkenMotaLortu(i, j);
				if (mota==-1){
					eguneratu(i, j, mota);
				}
			}
		}
	}
	
	private void minaKopEguneratu(){
		String kop = Integer.toString(Jokoa.getJokoa().getMinaKop());
		markaKont.setText(kop);
	}

	public void kronEguneratu(long pD){
		kron.setText(Long.toString(pD));
	}
}