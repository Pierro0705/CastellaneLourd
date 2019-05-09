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
import controleur.Inscriptions;
import controleur.Moniteur;
import controleur.Planning;
import controleur.Statistique;
import controleur.tableau;
import modele.Modele;
import modele.ModeleMoniteur;

public class PanelInscriptions extends panel implements ActionListener
{

	private JTable uneTable;
	private static tableau unTableau;
	private JPanel panelModif = new JPanel();
	public PanelInscriptions()
	{
		super();
		String enTete[] = {"Type Client","Mois","Nombre d'inscriptions"};
		unTableau = new tableau(this.getLesDonnees(),enTete);
		uneTable = new JTable(unTableau);
		
		JScrollPane uneScroll = new JScrollPane(uneTable);
		uneScroll.setBounds(20,10,700,170);
		this.add(uneScroll);
	}
	
	public Object[][] getLesDonnees()
	{
		ArrayList<Inscriptions> lesInscriptions = Modele.selectAllInscriptions();
		Object matrice [][] = new Object [lesInscriptions.size()][3];
		int i = 0;
		for (Inscriptions uneI : lesInscriptions)
		{
			matrice[i][0] = uneI.getTypeCli();
			matrice[i][1] = uneI.getMois();
			matrice[i][2] = uneI.getNbInscriptions();
			i++;
		}
		return matrice;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
