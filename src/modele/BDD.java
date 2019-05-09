package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDD {

	private String serveur, user, mdp, bdd;
	private Connection maConnection;
	
	public BDD (String serveur, String bdd, String user, String mdp)
	{
		this.serveur = serveur;
		this.bdd = bdd;
		this.user = user;
		this.mdp = mdp;
		this.maConnection = null;
	}
	
	public void chargerPilote ()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException exp)
		{
			System.out.println("Absence du pilote JBC");
		}
	}
	
	public void seConnecter ()
	{
		this.chargerPilote();
		String url ="jdbc:mysql://"+this.serveur+"/"+this.bdd;
		try {
			this.maConnection = DriverManager.getConnection(url, this.user, this.mdp);
		}
		catch (SQLException exp)
		{
			System.out.println("Connexion impossible à : " + url);
		}
	}
	
	public void seDeConnecter ()
	{
		try {
			if (this.maConnection != null)
			{
				this.maConnection.close();
			}
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible de fermer la connexion !");
		}
	}
	
	public Connection getMaConnexion ()
	{
		 return this.maConnection;
	}
}
