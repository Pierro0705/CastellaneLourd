package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.jdesktop.swingx.border.DropShadowBorder;

import controleur.Main;

public class vueConnexion extends JFrame implements ActionListener, KeyListener
{

	private JPanel unPanel = new JPanel();
	private JPanel unHeader = new JPanel();
	private JTextField txtMailMon = new JTextField();
	private JPasswordField txtMdp = new JPasswordField();
	private JButton btSeConnecter = new JButton("Connexion");
	
	
	public vueConnexion ()
	{
		this.setTitle("Administration Castellane");
		this.setResizable (false);
		this.setBounds (200,200,590,400);
		this.getContentPane().setBackground(new Color(248,248,248));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.unHeader.setLayout(null);
		this.unPanel.setLayout(null);
		this.setLayout(null);
		
		Font police1 = new Font ("Arial", Font.BOLD, 16);
		Font police2 = new Font ("Arial", Font.BOLD, 11);
		Font police3 = new Font ("Arial", Font.BOLD, 10);
		
		ImageIcon uneImage = new ImageIcon("src/Image/logo.png");
		JLabel monImage = new JLabel(uneImage);
		monImage.setBounds(-115,-65,500,200);
		
		this.unHeader.setBounds(60,90,470,55);
		this.unHeader.setBackground(new Color (252,252,252));
		this.unPanel.setBounds(60,135,470,165);
		this.unPanel.setBackground(new Color (255,255,255));
		
		JLabel ibCon = new JLabel("Connexion");
		ibCon.setBounds(20,2,100,50);
		ibCon.setForeground(new Color(113,113,113));
		ibCon.setFont(police1);
		JLabel ibMdp = new JLabel("Mot de passe");
		ibMdp.setBounds(53,50,100,50);
		ibMdp.setForeground(new Color(138,138,138));
		ibMdp.setFont(police2);
		JLabel ibEmail = new JLabel("Nom d'utilisateur");
		ibEmail.setBounds(35,12,100,50);
		ibEmail.setForeground(new Color(138,138,138));
		ibEmail.setFont(police2);
		
		this.txtMailMon.setBounds(140,26,260,23);
		this.txtMailMon.setForeground(new Color(113,113,113));
		this.txtMdp.setBounds(140,65,260,23);
		this.txtMdp.setForeground(new Color(113,113,113));
		
		this.btSeConnecter.setBounds(390,116,65,35);
		this.btSeConnecter.setFont(police3);
		this.btSeConnecter.setBorder(null);
		this.btSeConnecter.setBackground(new Color(15,110,255));
		this.btSeConnecter.setForeground(Color.white);
		
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
        this.unPanel.setBorder(shadowBottom);
		
		this.add(this.unHeader);
		this.add(this.unPanel);
		this.add(monImage);
		
		this.unHeader.add(ibCon);
		this.unPanel.add(ibMdp);
		this.unPanel.add(this.txtMdp);
		this.unPanel.add(ibEmail);
		this.unPanel.add(this.txtMailMon);
		this.unPanel.add(this.btSeConnecter);
		

		this.btSeConnecter.addActionListener(this);
		this.txtMailMon.addKeyListener(this);
		this.txtMdp.addKeyListener(this);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand())
		{
			case "Connexion" :
				String mailMon = this.txtMailMon.getText();
				String mdp = new String (this.txtMdp.getPassword());
				Main.verifConnexion (mailMon,mdp);
				break;
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			String mailMon = this.txtMailMon.getText();
			String mdp = new String (this.txtMdp.getPassword());
			Main.verifConnexion (mailMon,mdp);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
}
