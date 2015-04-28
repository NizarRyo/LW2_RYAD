package urouen.TP3XML.modele;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "experiencePro")
public class ExperiencePro {

	private String annee;
	private String lieu;
	private String fonction;
	
	public ExperiencePro() {
		super();
	}
	
	public ExperiencePro(String annee, String lieu, String fonction) {
		super();
		this.annee = annee;
		this.lieu = lieu;
		this.fonction = fonction;
	}
	
	public String getAnnee() {
		return annee;
	}
	@XmlElement
	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getLieu() {
		return lieu;
	}
	@XmlElement
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getFonction() {
		return fonction;
	}
	@XmlElement
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	
}
