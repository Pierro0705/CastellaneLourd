package controleur;

import java.sql.Date;

public class Inscriptions 
{
	private String typeCli;
	private String mois;
	private int nbInscriptions;

	public Inscriptions(String typeCli,String mois,int nbInscriptions) 
	{
		super();
		this.typeCli = typeCli;
		this.mois = mois;
		this.nbInscriptions = nbInscriptions;
	}
	
	public Inscriptions()
	{
		this.typeCli = "";
		this.mois = "";
		this.nbInscriptions = 0;
	}

	public String getTypeCli() {
		return typeCli;
	}

	public void setTypeCli(String typeCli) {
		this.typeCli = typeCli;
	}

	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}

	public int getNbInscriptions() {
		return nbInscriptions;
	}

	public void setNbInscriptions(int nbInscriptions) {
		this.nbInscriptions = nbInscriptions;
	}
}