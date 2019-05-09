package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.jdesktop.swingx.border.DropShadowBorder;

import controleur.Clients;
import controleur.Moniteur;
import controleur.Planning;
import controleur.Statistique;
import controleur.tableau;
import modele.Modele;
import modele.ModeleMoniteur;

public class PanelClients extends panel implements ActionListener
{

	private JTable uneTable;
	private static tableau unTableau;
	private JPanel panelModif = new JPanel(); 	
	public PanelClients(int numMon)
	{
		super();
		String enTete[] = {"Numéro Client","Nom","Adresse E-mail","Téléphone"};
		unTableau = new tableau(this.getLesDonnees(numMon), enTete);
		uneTable = new JTable(unTableau);
		
		JScrollPane uneScroll = new JScrollPane(uneTable);
		uneScroll.setBounds(20,20,700,170);
		this.add(uneScroll);		
	}
	
	public Object[][] getLesDonnees(int numMon)
	{
		ArrayList<Statistique> lesStatistiques = Modele.selectAllStatistique(numMon);
		Object matrice [][] = new Object [lesStatistiques.size()][5];
		int i = 0;
		for (Statistique uneS : lesStatistiques)
		{
			matrice[i][0] = uneS.getNumCli();
			matrice[i][1] = uneS.getNomCli();
			matrice[i][2] = uneS.getEmailCli();
			matrice[i][3] = uneS.getTelCli();
			matrice[i][4] = uneS.getNumMon();
			i++;
		}
		return matrice;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
