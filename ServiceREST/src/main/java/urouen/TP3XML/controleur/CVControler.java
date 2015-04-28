package urouen.TP3XML.controleur;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import urouen.TP3XML.modele.CV;
import urouen.TP3XML.modele.CVEntry;
import urouen.TP3XML.modele.CVList;
import urouen.TP3XML.modele.CompetenceInfo;
import urouen.TP3XML.modele.ExperiencePro;
import urouen.TP3XML.modele.Formation;
import urouen.TP3XML.modele.Langue;

@Controller
@RequestMapping(value="/resume")
public class CVControler {
	
	// MAP pour les Cv et leur id
			Map<Integer, CV> mapCVid;
			//Liste des CV
			CVList cvList;
			
	public CVControler() {
		super();
		
		// MAP pour les Cv et leur id
		mapCVid = new HashMap<Integer, CV>();
		//Liste des CV
		cvList = new CVList();
		
		//Langues
		Langue langue1 = new Langue("Francais", "courant");
		Langue langue2 = new Langue("Anglais", "courant");
		List<Langue> langues = new LinkedList<Langue>();
		langues.add(langue1);
		langues.add(langue2);

		//Formations
		Formation formation = new Formation("Universite de Rouen", "2015", "Master");
		List<Formation> formations = new LinkedList<Formation>();
		formations.add(formation);
		
		//Competences informatiques
		CompetenceInfo competenceInfo1 = new CompetenceInfo("JAVA", "Bon");
		CompetenceInfo competenceInfo2 = new CompetenceInfo("PHP", "Bon");
		List<CompetenceInfo> competencesInfo = new LinkedList<CompetenceInfo>();
		competencesInfo.add(competenceInfo1);
		competencesInfo.add(competenceInfo2);
		
		//Experiences professionnelles
		ExperiencePro experiencePro = new ExperiencePro("2015", "Orange", "Developpeur");
		List<ExperiencePro> experiencesPro = new LinkedList<ExperiencePro>();
		experiencesPro.add(experiencePro);
		
		
		// CV
		CV cv1 = new CV("Ryad", "Mohamed Nizar", 20, "Developper mes connaissances",
				"", langues,
				competencesInfo, formations,
				experiencesPro);
		CV cv2 = new CV("Marc", "Reus", 24, "Atteindre un bon niveau",
				"", langues,
				competencesInfo, formations,
				experiencesPro);
		
		//CVEntry
		CVEntry cvEntry1 = new CVEntry(cv1.getNom(), cv1.getPrenom(), 0);
		CVEntry cvEntry2 = new CVEntry(cv2.getNom(), cv2.getPrenom(), 0);
		// Ajout dans la liste des CV
		cvList.addCV(cvEntry1);
		mapCVid.put(cvEntry1.getId(), cv1);
		cvList.addCV(cvEntry2);
		mapCVid.put(cvEntry2.getId(), cv2);
	}
	

	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public @ResponseBody CV getCVInXML(@PathVariable int id) {
		CV cv = mapCVid.get(id);
		return cv;
	}
	
	@RequestMapping(method= RequestMethod.GET)
	public @ResponseBody CVList getCVListInXML() {
		return cvList;
	}
	
	@RequestMapping(method=RequestMethod.POST)
    public @ResponseBody CVEntry addCV(@RequestBody CV cv) {
		CV cvForAdd = cv;
		CVEntry cvEntry = new CVEntry(cvForAdd.getNom(), cvForAdd.getPrenom(), 0); 
		cvList.addCV(cvEntry);
		mapCVid.put(cvEntry.getId(), cvForAdd);
		System.out.println("Ajout éfféctué !");
        return cvEntry;
    }
	
}
