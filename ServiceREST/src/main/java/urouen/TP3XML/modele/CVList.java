package urouen.TP3XML.modele;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CVList")
public class CVList {
	
	private List<CVEntry> collectionCV;

	public CVList(List<CVEntry> collectionCV) {
		super();
		this.collectionCV = collectionCV;
	}
	
	public CVList() {
		this.collectionCV = new LinkedList<CVEntry>();
	}

	public List<CVEntry> getCollectionCV() {
		return collectionCV;
	}
	@XmlElement
	public void setCollectionCV(List<CVEntry> collectionCV) {
		this.collectionCV = collectionCV;
	}
	
	public void addCV(CVEntry cvEntry) {
		cvEntry.setId(this.collectionCV.size());
		this.collectionCV.add(cvEntry);
	}

}
