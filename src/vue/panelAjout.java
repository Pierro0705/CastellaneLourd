/*
package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controleur.Planning;
import modele.Modele;

public class panelAjout extends panel implements ActionListener
{
	private JTextField txtDateLec = new JTextField();
	private JTextField txtHeureDebut = new JTextField();
	private JTextField txtHeureFin = new JTextField();
	private JTextField txtNumCli = new JTextField();
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
		
	public panelAjout ()
	{
		super ();
		this.setLayout((new GridLayout(5, 1)));
		this.add(new JLabel("Date de leçon :"));
		this.add(this.txtDateLec);
		this.add(new JLabel("Heure de début de leçon :"));
		this.add(this.txtHeureDebut);
		this.add(new JLabel("Heure de fin de leçon :"));
		this.add(this.txtHeureFin);
		this.add(new JLabel("Eleve :"));
		this.add(this.txtNumCli);
		this.add(this.btAnnuler);
		this.add(this.btEnregistrer);
		
		this.btAnnuler.setBounds(300,80,70,70);
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler)
		{
			this.txtDateLec.setText("");
			this.txtHeureDebut.setText("");
			this.txtHeureFin.setText("");
			this.txtNumCli.setText("");
		} else if (e.getSource() == this.btEnregistrer) {
			if (this.txtDateLec.getText().equals("") || this.txtHeureDebut.getText().equals("") || this.txtHeureFin.getText().equals("") || this.txtNumCli.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Veuillez remplir tous les champs !");
			} else {
				String dateLec = this.txtDateLec.getText();
				String heureDebut = this.txtHeureDebut.getText();
				int qte = 0;
				float prix = 0;
				
				try {
					qte = Integer.parseInt(this.txtQte.getText());
					prix = Float.parseFloat(this.txtPrix.getText());
				}
				catch (NumberFormatException exp)
				{
					JOptionPane.showMessageDialog(this,"erreur sur le format du nombre !");
				}
				if (qte > 0 && prix > 0)
				{
					Article unArticle = new Article (designation,prix,qte,categorie);
					Modele.insertArticle(unArticle);
					PanelLister.insertTable(Modele.selectWhereArticle(unArticle));
					JOptionPane.showMessageDialog(this, "Insertion effectuée avec succès !");
					this.txtDésignation.setText("");
					this.txtPrix.setText("");
					this.txtQte.setText("");
					this.txtCategorie.setText("");
					this.setVisible(false);
				}else if (qte < 0)
				{
					this.txtQte.setBackground(Color.red);
				}else if (prix < 0)
				{
					this.txtPrix.setBackground(Color.red);
				}
			}
		}
		
	}
}
*/