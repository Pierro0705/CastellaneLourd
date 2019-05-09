package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.border.DropShadowBorder;

import controleur.Clients;
import controleur.Main;
import controleur.Moniteur;

public class vueGenerale extends JFrame implements ActionListener
{
	private JButton btQuitter = new JButton("Déconnexion");
	private JButton btClients = new JButton("Clients");
	private JButton btLister = new JButton("Lister");
	private JPanel panelProfil = new JPanel();
	private JPanel unHeader = new JPanel();
	
	private static PanelLister unPanelLister;
	private static PanelClients unPanelClients;
	private static PanelInscriptions unPanelInscriptions;
	
	public vueGenerale(Moniteur unMoniteur)
	{
		Font police1 = new Font ("Arial", Font.BOLD, 16);
		Font police2 = new Font ("Arial", Font.BOLD, 11);
		Font police3 = new Font ("Arial", Font.BOLD, 10);
		
		ImageIcon uneImage = new ImageIcon("src/Image/logo.png");
		JLabel monImage = new JLabel(uneImage);
		monImage.setBounds(-115,-65,500,200);
		this.setTitle("Administration Castellane");
		this.setResizable (false);
		this.setBounds(100,100,1070,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(248,248,248));
		
		DropShadowBorder shadowTop = new DropShadowBorder();
		shadowTop.setShadowColor(new Color(150,150,150));
		shadowTop.setShowLeftShadow(true);
		shadowTop.setShowRightShadow(true);
		shadowTop.setShowBottomShadow(true);
		shadowTop.setShowTopShadow(true);
        this.unHeader.setBorder(shadowTop);
        
		DropShadowBorder shadowBottom = new DropShadowBorder();
		shadowBottom.setShadowColor(new Color(150,150,150));
		shadowBottom.setShowLeftShadow(true);
		shadowBottom.setShowRightShadow(true);
		shadowBottom.setShowBottomShadow(true);
		shadowBottom.setShowTopShadow(false);
		
		DropShadowBorder shadowMiddle = new DropShadowBorder();
		shadowMiddle.setShadowColor(new Color(150,150,150));
		shadowMiddle.setShowLeftShadow(true);
		shadowMiddle.setShowRightShadow(true);
		shadowMiddle.setShowBottomShadow(false);
		shadowMiddle.setShowTopShadow(true);
        
        this.unPanelLister = new PanelLister(unMoniteur.getNumMon());
        this.unPanelLister.setBounds(300,100,740,400);
        this.unPanelLister.setBorder(shadowTop);
        this.add(unPanelLister);
        
		this.unPanelClients = new PanelClients(unMoniteur.getNumMon());
		this.unPanelClients.setBounds(300,100,740,200);
		this.unPanelClients.setBorder(shadowMiddle);
		this.add(unPanelClients);
		
		this.unPanelInscriptions = new PanelInscriptions();
		this.unPanelInscriptions.setBounds(300,300,740,200);
		this.unPanelInscriptions.setBorder(shadowBottom);
		this.add(unPanelInscriptions);
		
		this.unHeader.setBounds(25,100,250,70);
		this.unHeader.setBackground(new Color (252,252,252));
		this.unHeader.setLayout(null);
		this.unHeader.setBorder(shadowTop);
		JLabel ibProfil = new JLabel("Récapitulatif profil");
		ibProfil.setForeground(new Color(113,113,113));
		ibProfil.setFont(police1);
		ibProfil.setBounds(20,9,150,50);
		this.unHeader.add(ibProfil);
		
		this.panelProfil.setBounds(25,160,250,230);
		this.panelProfil.setBackground(Color.white);
		this.panelProfil.setLayout(null);
		this.panelProfil.setBorder(shadowBottom);
		
		JLabel ibNom = new JLabel("Nom :");
		ibNom.setForeground(new Color(138,138,138));
		ibNom.setFont(police2);
		ibNom.setBounds(54,30,150,50);
		this.panelProfil.add(ibNom);
		
		JLabel ibNomMon = new JLabel(unMoniteur.getNomMon());
		ibNomMon.setBounds(100,30,100,50);
		this.panelProfil.add(ibNomMon);
		
		JLabel ibEmail = new JLabel("E-mail :");
		ibEmail.setForeground(new Color(138,138,138));
		ibEmail.setFont(police2);
		ibEmail.setBounds(46,80,150,50);
		this.panelProfil.add(ibEmail);
		
		JLabel ibEmailMon = new JLabel(unMoniteur.getMailMon());
		ibEmailMon.setBounds(100,80,100,50);
		this.panelProfil.add(ibEmailMon);
		
		JLabel ibTelephone = new JLabel("Téléphone :");
		ibTelephone.setForeground(new Color(138,138,138));
		ibTelephone.setFont(police2);
		ibTelephone.setBounds(20,130,150,50);
		this.panelProfil.add(ibTelephone);
		
		JLabel ibTelMon = new JLabel(unMoniteur.getTelMon());
		ibTelMon.setBounds(100,130,100,50);
		this.panelProfil.add(ibTelMon);
		
		this.btQuitter.setBounds(950,510,85,35);
		this.btQuitter.setFont(police3);
		this.btQuitter.setBorder(null);
		this.btQuitter.setBackground(new Color(255,40,40));
		this.btQuitter.setForeground(Color.white);
		
		this.btClients.setBounds(420,60,70,40);
		this.btClients.setFont(police3);
		this.btClients.setBorder(null);
		this.btClients.setBackground(new Color(252,252,252));
		this.btClients.setForeground(new Color(113,113,113));
		this.btClients.setBorder(shadowTop);
		
		this.btLister.setBounds(340,60,70,40);
		this.btLister.setFont(police3);
		this.btLister.setBorder(null);
		this.btLister.setBackground(new Color(252,252,252));
		this.btLister.setForeground(new Color(113,113,113));
		this.btLister.setBorder(shadowTop);
		
		this.add(monImage);
		this.add(this.unHeader);
		this.add(this.panelProfil);
		this.add(this.btQuitter);
		this.add(this.btLister);
		this.add(this.btClients);
		
		this.btQuitter.addActionListener(this);
		this.btLister.addActionListener(this);
		this.btClients.addActionListener(this);
		
		unPanelLister.setVisible(true);
		
		this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btQuitter)
		{
			this.dispose();
			Main.setVisible(true);
		}else if(e.getSource() == this.btClients) {
			unPanelLister.setVisible(false);
			unPanelClients.setVisible(true);
			unPanelInscriptions.setVisible(true);
		}else if (e.getSource() == this.btLister) {
			unPanelLister.setVisible(true);
			unPanelClients.setVisible(false);
			unPanelInscriptions.setVisible(false);
		}
		
	}
	
}
