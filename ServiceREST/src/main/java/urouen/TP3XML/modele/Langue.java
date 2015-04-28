package urouen.TP3XML.modele;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "langue")
public class Langue {

	private String nomLangue;
	private String niveauLangue;
	
	public Langue() {
		super();
	}
	
	public Langue(String nomLangue, String niveauLangue) {
		super();
		this.nomLangue = nomLangue;
		this.niveauLangue = niveauLangue;
	}

	public String getNomLangue() {
		return nomLangue;
	}
	@XmlElement
	public void setNomLangue(String nomLangue) {
		this.nomLangue = nomLangue;
	}

	public String getNiveauLangue() {
		return niveauLangue;
	}
	@XmlElement
	public void setNiveauLangue(String niveauLangue) {
		this.niveauLangue = niveauLangue;
	}
	
}
