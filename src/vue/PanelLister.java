package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import org.jdesktop.swingx.border.DropShadowBorder;

import controleur.Planning;
import controleur.tableau;
import modele.Modele;

public class PanelLister extends panel implements ActionListener
{
	private static tableau unTableau;
	private JTable uneTable;
	private JPanel panelModif = new JPanel();
	
	private JTextField txtDateLec = new JTextField();
	private JTextField txtHeureDebut = new JTextField();
	private JTextField txtHeureFin = new JTextField();
	private JTextField txtNumCli = new JTextField();
	private JTextField txtEtat = new JTextField();
	private JTextField txtNumMon = new JTextField();
	private JTextField txtNumVoit = new JTextField();
	private JTextField txtNumLec = new JTextField();
	private JButton btModifier = new JButton("Modifier");
	
	public PanelLister(int numMon)
	{
		super();
		String enTete[] = {"Date","Heure Début","Heure Fin","Etat","Moniteur","Leçon","Voiture","Client"};
		unTableau = new tableau(this.getLesDonnees(numMon), enTete);
		uneTable = new JTable(unTableau);
		JScrollPane uneScroll = new JScrollPane(uneTable);
		uneScroll.setBounds(20,20,700,150);
		this.add(uneScroll);
		
		uneTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int ligne = uneTable.getSelectedRow();
				if (e.getClickCount() == 1)
				{
					txtDateLec.setText((String) uneTable.getValueAt(ligne, 1));
					txtHeureDebut.setText((String) uneTable.getValueAt(ligne, 2));
					txtHeureFin.setText((String) uneTable.getValueAt(ligne, 3));
					txtEtat.setText((String) uneTable.getValueAt(ligne, 4));
					txtNumMon.setText((int) uneTable.getValueAt(ligne, 5) +"");
					txtNumLec.setText((int) uneTable.getValueAt(ligne, 6) +"");
					txtNumVoit.setText((int) uneTable.getValueAt(ligne, 7) +"");
					txtNumCli.setText((int) uneTable.getValueAt(ligne, 8) +"");
				}
				else if (e.getClickCount() == 2)
				{
					int numHoraire = (int) uneTable.getValueAt(ligne, 0);
					int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment annuler ce cours?","Suppression Planning",JOptionPane.YES_NO_OPTION);
					if (retour == 0)
					{
						Modele.deletePlanning(numHoraire);
						unTableau.deleteTable(ligne);
					}
				}
			}
		});
		
		DropShadowBorder shadowTop = new DropShadowBorder();
		shadowTop.setShadowColor(new Color(150,150,150));
		shadowTop.setShowLeftShadow(true);
		shadowTop.setShowRightShadow(true);
		shadowTop.setShowBottomShadow(true);
		shadowTop.setShowTopShadow(true);
        
		Font police3 = new Font ("Arial", Font.BOLD, 10);
        
		panelModif.setLayout(new GridLayout(4,5));
		panelModif.setBounds(20,180,700,160);
		panelModif.setBorder(BorderFactory.createCompoundBorder(new EtchedBorder(), new EmptyBorder(10, 10, 10, 10)));
		panelModif.add(new JLabel("Date: "));
		panelModif.add(txtDateLec);
		panelModif.add(new JLabel(""));
		panelModif.add(new JLabel("Heure Début: "));
		panelModif.add(txtHeureDebut);
		panelModif.add(new JLabel("Heure Fin: "));
		panelModif.add(txtHeureFin);
		panelModif.add(new JLabel(""));
		panelModif.add(new JLabel("Etat: "));
		panelModif.add(txtEtat);
		panelModif.add(new JLabel("Moniteur: "));
		panelModif.add(txtNumMon);
		panelModif.add(new JLabel(""));
		panelModif.add(new JLabel("Leçon: "));
		panelModif.add(txtNumLec);
		panelModif.add(new JLabel("Voiture: "));
		panelModif.add(txtNumVoit);
		panelModif.add(new JLabel(""));
		panelModif.add(new JLabel("Client: "));
		panelModif.add(txtNumCli);
		panelModif.setBackground(Color.white);
		
		this.btModifier.setBounds(335,345,70,40);
		this.btModifier.setFont(police3);
		this.btModifier.setBorder(null);
		this.btModifier.setBackground(new Color(252,252,252));
		this.btModifier.setForeground(new Color(113,113,113));
		this.btModifier.setBorder(shadowTop);
		this.btModifier.addActionListener(this);
		this.add(btModifier);
		
		this.txtNumVoit.setEditable(false);
		this.txtNumLec.setEditable(false);
		this.txtNumCli.setEditable(false);
		this.txtNumMon.setEditable(false);
		this.txtEtat.setEditable(false);
		
		this.txtNumVoit.setBackground(new Color(245,245,245));
		this.txtNumLec.setBackground(new Color(245,245,245));
		this.txtNumCli.setBackground(new Color(245,245,245));
		this.txtNumMon.setBackground(new Color(245,245,245));
		this.txtEtat.setBackground(new Color(245,245,245));
		
		this.add(panelModif);
	}
	
	public Object [][] getLesDonnees (int numMon)
	{
		ArrayList<Planning> lesPlannings = Modele.selectAllPlanning(numMon);
		Object matrice [][] = new Object [lesPlannings.size()][8];
		int i = 0;
		for (Planning unP : lesPlannings)
		{
			matrice[i][0] = unP.getDateLec();
			matrice[i][1] = unP.getHeuredebut();
			matrice[i][2] = unP.getHeurefin();
			matrice[i][3] = unP.getEtat();
			matrice[i][4] = unP.getNumMon();
			matrice[i][5] = unP.getNumLec();
			matrice[i][6] = unP.getNumVoit();
			matrice[i][7] = unP.getNumCli();
			i++;
		}
		return matrice;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btModifier)
		{						
			int numMon = Integer.parseInt(txtNumMon.getText());
			int numLec = Integer.parseInt(txtNumLec.getText());
			int numVoit = Integer.parseInt(txtNumVoit.getText());
			int numCli = Integer.parseInt(txtNumCli.getText());
						
			int i = uneTable.getSelectedRow();
			int numHoraire  = (int) uneTable.getValueAt(0, 0);
			
			Object ligne [] = {numHoraire,txtDateLec.getText(),txtHeureDebut.getText(),txtHeureFin.getText(),txtEtat.getText(),numMon,numLec,numVoit,numCli};
			unTableau.updateTable(ligne, uneTable.getSelectedRow());
			
			Planning  unPlanning = new Planning(numHoraire,txtDateLec.getText(),txtHeureDebut.getText(),txtHeureFin.getText(),txtEtat.getText(),numMon,numLec,numVoit,numCli);
			Modele.updatePlanning(unPlanning);
		}
		
	}
}
