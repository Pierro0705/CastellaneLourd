package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Moniteur;

public class ModeleMoniteur {
	private static BDD uneBdd = new BDD("localhost", "autoecole", "root", "");
	
	
	public static ArrayList<Moniteur> selectAllMoniteur()
	{
		ArrayList<Moniteur> lesMoniteurs = new ArrayList<Moniteur>();
		String requete = "select * from moniteur;";
		ModeleMoniteur.uneBdd.seConnecter();
		try
		{
			Statement unStat = ModeleMoniteur.uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while(desResultats.next())
			{
				Moniteur unMoniteur = new Moniteur(
						desResultats.getInt("numMon"),
						desResultats.getString("nomMon"),
						desResultats.getString("telMon"),
						desResultats.getString("mailMon"),
						desResultats.getString("mdp"),
						desResultats.getDate("dateEmbMon"),
						desResultats.getInt("dispoMon"),
						desResultats.getString("nbLecon")
						);
				lesMoniteurs.add(unMoniteur);
			}
			unStat.close();
			desResultats.close();
		}
		
		catch(SQLException exp)
		{
			System.out.println("Erreur execution : " + requete);
		}
		ModeleMoniteur.uneBdd.seDeConnecter();
		return lesMoniteurs;
	}
			
	public static void updateMoniteur (Moniteur unMoniteur)
	{
		String requete ="update moniteur set nomMon = '"+unMoniteur.getNomMon()+"',telMon = '"
														   +unMoniteur.getTelMon()+"',mailMon = '"
														   +unMoniteur.getMailMon()+"',mdp = '"
														   +unMoniteur.getMdp()+"',dateEmbMon = '"
														   +unMoniteur.getDateEmbMon()+"',dispoMon = "
														   +unMoniteur.getDispoMon()+",nbLecon = '"
														   +unMoniteur.getDispoMon()+"' where numMon = "
														   +unMoniteur.getNumMon()+";";
		ModeleMoniteur.uneBdd.seConnecter();
		try
		{
		Statement unStat = ModeleMoniteur.uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur connection : "+requete);
		}
	}
	
	public static Moniteur selectWhereMoniteur (String mailMon, String mdp)
	{
		Moniteur unMoniteur = null;
		String requete ="select * from moniteur where mailMon = '"+mailMon+"' and mdp ='"+mdp+"';";
		ModeleMoniteur.uneBdd.seConnecter();
		
		try
		{
			Statement unStat = ModeleMoniteur.uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next())
			{
				unMoniteur = new Moniteur (
						unRes.getInt("numMon"),
						unRes.getString("nomMon"),
						unRes.getString("telMon"),
						unRes.getString("mailMon"),
						unRes.getString("mdp"),
						unRes.getDate("dateEmbMon"),
						unRes.getInt("dispoMon"),
						unRes.getString("nbLecon")
						);
			}
			unStat.close();
			unRes.close();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur d'execution : " +requete);
		}
		ModeleMoniteur.uneBdd.seDeConnecter();
		return unMoniteur;
	}
}
