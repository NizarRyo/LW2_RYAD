package urouen.TP3XML.modele;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "formation")
public class Formation {
	
	private String ecole;
	private String anneeFormation;
	private String diplome;
	
	public Formation() {
		super();
	}
	
	public Formation(String ecole, String anneeFormation, String diplome) {
		super();
		this.ecole = ecole;
		this.anneeFormation = anneeFormation;
		this.diplome = diplome;
	}

	public String getEcole() {
		return ecole;
	}
	@XmlElement
	public void setEcole(String ecole) {
		this.ecole = ecole;
	}

	public String getAnneeFormation() {
		return anneeFormation;
	}
	@XmlElement
	public void setAnneeFormation(String anneeFormation) {
		this.anneeFormation = anneeFormation;
	}

	public String getDiplome() {
		return diplome;
	}
	@XmlElement
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	

	
}
