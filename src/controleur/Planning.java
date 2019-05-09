package controleur;

import java.sql.Date;
import java.sql.Time;

public class Planning 
{
	private int numHoraire;
	private String dateLec;
	private String heuredebut;
	private String heurefin;
	private String etat;
	private int numMon;
	private int numLec;
	private int numVoit;
	private int numCli;

	public Planning(int numHoraire,String dateLec,String heuredebut,String heurefin,String etat,int numMon,int numLec,int numVoit,int numCli) 
	{
		super();
		this.numHoraire = numHoraire;
		this.dateLec = dateLec;
		this.heuredebut = heuredebut;
		this.heurefin = heuredebut;
		this.etat = etat;
		this.numMon = numMon;
		this.numLec = numLec;
		this.numVoit = numVoit;
		this.numCli = numCli;
	}
	
	public Planning(String dateLec,String heuredebut,String heurefin,String etat,int numMon,int numLec,int numVoit,int numCli)
	{
		this.numHoraire = 0;
		this.dateLec = dateLec;
		this.heuredebut = heuredebut;
		this.heurefin = heurefin;
		this.etat = etat;
		this.numMon = numMon;
		this.numLec = numLec;
		this.numVoit = numVoit;
		this.numCli = numCli;
	}
	
	public Planning()
	{
		this.numHoraire = 0;
		this.dateLec = "";
		this.heuredebut = "";
		this.heurefin = "";
		this.etat = "";
		this.numMon = 0;
		this.numLec = 0;
		this.numVoit = 0;
		this.numCli = 0;
	}

	public int getNumHoraire() {
		return numHoraire;
	}

	public void setNumHoraire(int numHoraire) {
		this.numHoraire = numHoraire;
	}

	public String getDateLec() {
		return dateLec;
	}

	public void setDateLec(String dateLec) {
		this.dateLec = dateLec;
	}

	public String getHeuredebut() {
		return heuredebut;
	}

	public void setHeuredebut(String heuredebut) {
		this.heuredebut = heuredebut;
	}

	public String getHeurefin() {
		return heurefin;
	}

	public void setHeurefin(String heurefin) {
		this.heurefin = heurefin;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public int getNumMon() {
		return numMon;
	}

	public void setNumMon(int numMon) {
		this.numMon = numMon;
	}

	public int getNumLec() {
		return numLec;
	}

	public void setNumLec(int numLec) {
		this.numLec = numLec;
	}

	public int getNumVoit() {
		return numVoit;
	}

	public void setNumVoit(int numVoit) {
		this.numVoit = numVoit;
	}

	public int getNumCli() {
		return numCli;
	}

	public void setNumCli(int numCli) {
		this.numCli = numCli;
	}	
}
