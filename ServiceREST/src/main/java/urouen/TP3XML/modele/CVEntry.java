package urouen.TP3XML.modele;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CVEntry")
public class CVEntry {
	
	private String nom;
	private String prenom;
	private int id;

	public CVEntry(String nom, String prenom, int id) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.id = id;
	}

	public CVEntry() {
	}
	
	public String getNom() {
		return nom;
	}
	@XmlElement
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	@XmlElement
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public int getId() {
		return id;
	}
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	
	

}
