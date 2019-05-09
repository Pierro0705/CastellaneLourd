package controleur;

import java.sql.Date;

public class Clients 
{
	private int numCli;
	private String nomCli;
	private String emailCli;
	private String telCli;

	public Clients( int numCli,
					 String nomCli,
					 String emailCli,
					 String telCli) 
	{
		super();
		this.numCli = numCli;
		this.nomCli = nomCli;
		this.emailCli = emailCli;
		this.telCli = telCli;
	}
	
	public Clients(String nomCli,
			 		String emailCli,
			 		String telCli,
			 		String mdp)
	{
		this.numCli = 0;
		this.nomCli = nomCli;
		this.emailCli = emailCli;
		this.telCli = telCli;
	}
	
	public Clients()
	{
		this.numCli = 0;
		this.emailCli = "";
		this.nomCli = "";
		this.telCli = "";
	}

	public int getNumCli() {
		return numCli;
	}

	public void setNumCli(int numCli) {
		this.numCli = numCli;
	}

	public String getNomCli() {
		return nomCli;
	}

	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}

	public String getEmailCli() {
		return emailCli;
	}

	public void setEmailCli(String emailCli) {
		this.emailCli = emailCli;
	}

	public String getTelCli() {
		return telCli;
	}

	public void setTelCli(String telCli) {
		this.telCli = telCli;
	}
	
	
}
