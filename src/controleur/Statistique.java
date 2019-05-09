package controleur;

import java.sql.Date;
import java.sql.Time;

public class Statistique 
{
	private int numCli;
	private String nomCli;
	private String emailCli;
	private String telCli;
	private int numMon;

	public Statistique(int numCli,String nomCli,String emailCli,String telCli, int numMon) 
	{
		super();
		this.numCli = numCli;
		this.nomCli = nomCli;
		this.emailCli = emailCli;
		this.telCli = telCli;
		this.numMon = numMon;
	}
	
	public Statistique()
	{
		this.numCli = 0;
		this.nomCli = "";
		this.emailCli = "";
		this.telCli = "";
		this.numMon = 0;
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
	
	public int getNumMon() {
		return numMon;
	}

	public void setNumMon(int numMon) {
		this.numMon = numMon;
	}
}
