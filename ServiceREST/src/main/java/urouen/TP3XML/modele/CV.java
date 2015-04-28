package urouen.TP3XML.modele;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cv")
public class CV {
	
	String nom;
	String prenom;
	int age;
	String objectif;
	String competences;
	List<Langue> langues;
	List<CompetenceInfo> competencesInfo;
	List<Formation> formations;
	List<ExperiencePro> experiencesPro;
	
	public CV() {
		super();
	}
	
	public CV(String nom, String prenom, int age, String objectif,
			String competences, List<Langue> langues,
			List<CompetenceInfo> competencesInfo, List<Formation> formations,
			List<ExperiencePro> experiencesPro) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.objectif = objectif;
		this.competences = competences;
		this.langues = langues;
		this.competencesInfo = competencesInfo;
		this.formations = formations;
		this.experiencesPro = experiencesPro;
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

	public int getAge() {
		return age;
	}
	@XmlElement
	public void setAge(int age) {
		this.age = age;
	}

	public String getObjectif() {
		return objectif;
	}
	@XmlElement
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public String getCompetences() {
		return competences;
	}
	@XmlElement
	public void setCompetences(String competences) {
		this.competences = competences;
	}

	public List<Langue> getLangues() {
		return langues;
	}
	@XmlElement
	public void setLangues(List<Langue> langues) {
		this.langues = langues;
	}

	public List<CompetenceInfo> getCompetencesInfo() {
		return competencesInfo;
	}
	@XmlElement
	public void setCompetencesInfo(List<CompetenceInfo> competencesInfo) {
		this.competencesInfo = competencesInfo;
	}

	public List<Formation> getFormations() {
		return formations;
	}
	@XmlElement
	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public List<ExperiencePro> getExperiencesPro() {
		return experiencesPro;
	}
	@XmlElement
	public void setExperiencesPro(List<ExperiencePro> experiencesPro) {
		this.experiencesPro = experiencesPro;
	}
	
	
	
}
