package controleur;

import java.sql.Date;

public class Moniteur 
{
	private int numMon;
	private String nomMon;
	private String telMon;
	private String mailMon;
	private String mdp;
	private Date dateEmbMon;
	private int dispoMon;
	private String nbLecon;

	public Moniteur( int numMon,
					 String nomMon,
					 String telMon,
					 String mailMon,
					 String mdp,
					 Date dateEmbMon,
					 int dispoMon,
					 String nbLecon) 
	{
		super();
		this.numMon = numMon;
		this.nomMon = nomMon;
		this.telMon = telMon;
		this.mailMon = mailMon;
		this.mdp = mdp;
		this.dateEmbMon = dateEmbMon;
		this.dispoMon = dispoMon;
		this.nbLecon = nbLecon;
	}
	
	public Moniteur(String nomMon,
			 		String telMon,
			 		String mailMon,
			 		String mdp,
			 		Date dateEmbMon,
			 		int dispoMon,
			 		String nbLecon)
	{
		this.numMon = 0;
		this.nomMon = nomMon;
		this.telMon = telMon;
		this.mailMon = mailMon;
		this.mdp = mdp;
		this.dateEmbMon = dateEmbMon;
		this.dispoMon = dispoMon;
		this.nbLecon = nbLecon;
	}
	
	public Moniteur()
	{
		this.numMon = 0;
		this.nomMon = "";
		this.telMon = "";
		this.mailMon = "";
		this.mdp = "";
		this.dateEmbMon = null;
		this.dispoMon = 0;
		this.nbLecon = "";
	}

	public int getNumMon() {
		return numMon;
	}

	public void setNumMon(int numMon) {
		this.numMon = numMon;
	}

	public String getNomMon() {
		return nomMon;
	}

	public void setNomMon(String nomMon) {
		this.nomMon = nomMon;
	}

	public String getTelMon() {
		return telMon;
	}

	public void setTelMon(String telMon) {
		this.telMon = telMon;
	}

	public String getMailMon() {
		return mailMon;
	}

	public void setMailMon(String mailMon) {
		this.mailMon = mailMon;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Date getDateEmbMon() {
		return dateEmbMon;
	}

	public void setDateEmbMon(Date dateEmbMon) {
		this.dateEmbMon = dateEmbMon;
	}

	public int getDispoMon() {
		return dispoMon;
	}

	public void setDispoMon(int dispoMon) {
		this.dispoMon = dispoMon;
	}

	public String getNbLecon() {
		return nbLecon;
	}

	public void setNbLecon(String nbLecon) {
		this.nbLecon = nbLecon;
	}

	
}
