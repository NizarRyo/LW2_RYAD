package urouen.TP3XML.modele;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "competenceInfo")
public class CompetenceInfo {
	
	private String nomCompetence;
	private String niveauCompetence;
	
	public CompetenceInfo() {
		super();
	}
	
	public CompetenceInfo(String nomCompetence, String niveauCompetence) {
		super();
		this.nomCompetence = nomCompetence;
		this.niveauCompetence = niveauCompetence;
	}

	public String getNomCompetence() {
		return nomCompetence;
	}
	@XmlElement
	public void setNomCompetence(String nomCompetence) {
		this.nomCompetence = nomCompetence;
	}

	public String getNiveauCompetence() {
		return niveauCompetence;
	}
	@XmlElement
	public void setNiveauCompetence(String niveauCompetence) {
		this.niveauCompetence = niveauCompetence;
	}
	
	

}
