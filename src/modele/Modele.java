package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Clients;
import controleur.Inscriptions;
import controleur.Moniteur;
import controleur.Planning;
import controleur.Statistique;

public class Modele 
{
	private static BDD uneBdd = new BDD("localhost", "autoecole", "root", "");
	
	public static ArrayList<Planning> selectAllPlanning(int numMon)
	{
		ArrayList<Planning> lesArticles = new ArrayList<Planning>();
		String requete = "select * from planning where numMon = "+numMon+";";
		Modele.uneBdd.seConnecter();
		try
		{
			Statement unStat = Modele.uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while(desResultats.next())
			{
				Planning unPlanning = new Planning(
						desResultats.getInt("numHoraire"),
						desResultats.getString("dateLec"),
						desResultats.getString("heuredebut"),
						desResultats.getString("heurefin"),
						desResultats.getString("etat"),
						desResultats.getInt("numMon"),
						desResultats.getInt("numLec"),
						desResultats.getInt("numVoit"),
						desResultats.getInt("numCli"));
				lesArticles.add(unPlanning);
			}
			unStat.close();
			desResultats.close();
		}
		
		catch(SQLException exp)
		{
			System.out.println("Erreur execution : " + requete);
		}
		Modele.uneBdd.seDeConnecter();
		return lesArticles;
	}
	
	public static ArrayList<Clients> selectAllClients()
	{
		ArrayList<Clients> lesClients = new ArrayList<Clients>();
		String requete = "select numCli, nomCli, emailCli, telCli from client;";
		Modele.uneBdd.seConnecter();
		try
		{
			Statement unStat = Modele.uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while(desResultats.next())
			{
				Clients unC = new Clients(
						desResultats.getInt("numCli"),
						desResultats.getString("nomCli"),
						desResultats.getString("emailCli"),
						desResultats.getString("telCli"));
				lesClients.add(unC);
			}
			unStat.close();
			desResultats.close();
		}
		
		catch(SQLException exp)
		{
			System.out.println("Erreur execution : " + requete + " " + exp);
		}
		Modele.uneBdd.seDeConnecter();
		return lesClients;
	}
	
	public static ArrayList<Inscriptions> selectAllInscriptions()
	{
		ArrayList<Inscriptions> lesInscriptions = new ArrayList<Inscriptions>();
		String requete = "select * from nbinscriptions;";
		Modele.uneBdd.seConnecter();
		try
		{
			Statement unStat = Modele.uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while(desResultats.next())
			{
				Inscriptions uneI = new Inscriptions(
						desResultats.getString("typeCli"),
						desResultats.getString("mois"),
						desResultats.getInt("nbInscriptions"));
				lesInscriptions.add(uneI);
			}
			unStat.close();
			desResultats.close();
		}
		
		catch(SQLException exp)
		{
			System.out.println("Erreur execution : " + requete + " " + exp);
		}
		Modele.uneBdd.seDeConnecter();
		return lesInscriptions;
	}
	
	public static ArrayList<Statistique> selectAllStatistique(int numMon)
	{
		ArrayList<Statistique> lesStatistiques = new ArrayList<Statistique>();
		String requete = "select distinct(client.numCli), nomCli, emailCli, telCli, numMon from planning, client where client.numCli = planning.numCli and numMon = "+numMon+";";
		Modele.uneBdd.seConnecter();
		try
		{
			Statement unStat = Modele.uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while(desResultats.next())
			{
				Statistique uneStatistique = new Statistique(
						desResultats.getInt("numCli"),
						desResultats.getString("nomCli"),
						desResultats.getString("emailCli"),
						desResultats.getString("telCli"),
						desResultats.getInt("numMon"));
				lesStatistiques.add(uneStatistique);
			}
			unStat.close();
			desResultats.close();
		}
		
		catch(SQLException exp)
		{
			System.out.println("Erreur execution : " + requete + " " + exp);
		}
		Modele.uneBdd.seDeConnecter();
		return lesStatistiques;
	}
		
	public static void deletePlanning (int numHoraire)
	{
		String requete ="delete from planning where numHoraire="+numHoraire+";";
		Modele.uneBdd.seConnecter();
		try
		{
		Statement unStat = Modele.uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur connexion : "+requete);
		}
	}
	
	public static void updatePlanning (Planning unPlanning)
	{
		String requete ="update planning set dateLec = '"+unPlanning.getDateLec()+"',heuredebut = '"
														   +unPlanning.getHeuredebut()+"',heurefin = '"
														   +unPlanning.getHeurefin()+"',etat = '"
														   +unPlanning.getEtat()+"',numMon = "
														   +unPlanning.getNumMon()+",numLec = "
														   +unPlanning.getNumLec()+",numVoit = "
														   +unPlanning.getNumVoit()+",numCli = "
														   +unPlanning.getNumCli()+" where numHoraire = "
														   +unPlanning.getNumHoraire()+";";
		Modele.uneBdd.seConnecter();
		try
		{
		Statement unStat = Modele.uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur connexion : "+requete);
		}
	}
	
	public static Planning selectWherePlanning(Planning unPlanning) {
		Planning unP = null;
		String requete = "select numHoraire from planning where "
				+ " dateLec = '"+unPlanning.getDateLec()
				+ "' and heuredebut = "+unPlanning.getHeuredebut()
				+ " and heurefin = "+unPlanning.getHeurefin()
				+ " and etat = "+unPlanning.getEtat()
				+ " and numMon = "+unPlanning.getNumMon()
				+ " and numLec = "+unPlanning.getNumLec()
				+ " and numVoit = "+unPlanning.getNumVoit()
				+" and numCli = '"+unPlanning.getNumCli()+"';";
		try
		{
			Statement unStat = Modele.uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			
			if (unRes.next())
			{
				unP = new Planning (unRes.getInt("numhoraire"),
						unPlanning.getDateLec(),
						unPlanning.getHeuredebut(),
						unPlanning.getHeurefin(),
						unPlanning.getEtat(),
						unPlanning.getNumMon(),
						unPlanning.getNumLec(),
						unPlanning.getNumVoit(),
						unPlanning.getNumCli());
			}
			unStat.close();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur connexion : "+requete);
		}
		Modele.uneBdd.seConnecter();	
		return unP;
	}
}
