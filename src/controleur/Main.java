package controleur;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modele.BDD;
import modele.Modele;
import modele.ModeleMoniteur;
import vue.vueConnexion;
import vue.vueGenerale;

public class Main 
{
	private static vueConnexion uneVueConnexion;
	private static vueGenerale uneVueGenerale;
	
	public static void setVisible (boolean action)
	{
		uneVueConnexion.setVisible(action);
	}
	
	public static void main(String[] args) 
	{
		uneVueConnexion = new vueConnexion();
		
	}

	public static void verifConnexion(String mailMon, String mdp) {
		if (mailMon.equals("") || mdp.equals(""))
		{
			JOptionPane.showConfirmDialog(null, "Veuillez remplir tous les champs ", "Erreur", JOptionPane.DEFAULT_OPTION);
		} else {
			Moniteur unMoniteur = ModeleMoniteur.selectWhereMoniteur(mailMon, mdp);
			if (unMoniteur == null)
			{
				JOptionPane.showConfirmDialog(null, "Veuillez vérifier vos identifiants ", "Erreur", JOptionPane.DEFAULT_OPTION);
			} else {
				uneVueGenerale = new vueGenerale(unMoniteur);
				uneVueConnexion.setVisible(false);
			}
		}
		
	}
}
