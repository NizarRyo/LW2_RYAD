package restClient;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


public class ParserGETCVList {

	RestTemplate restTemplate;
	Source cvList;
	
	public ParserGETCVList(RestTemplate restTemplate, Source cv) {
		super();
		this.restTemplate = restTemplate;
		this.cvList = cv;
	}
	
	public void ElementToStream(Element element, OutputStream out) {
	    try {
	      DOMSource source = new DOMSource(element);
	      StreamResult result = new StreamResult(out);
	      TransformerFactory transFactory = TransformerFactory.newInstance();
	      Transformer transformer = transFactory.newTransformer();
	      transformer.transform(source, result);
	    } catch (Exception ex) {
	    }
	  }
	
	public InputSource sourceToInputSource() {
	      if (cvList instanceof SAXSource) {
	          return ((SAXSource) cvList).getInputSource();
	      } else if (cvList instanceof DOMSource) {
	          ByteArrayOutputStream baos = new ByteArrayOutputStream();
	          Node node = ((DOMSource) cvList).getNode();
	          if (node instanceof Document) {
	              node = ((Document) node).getDocumentElement();
	          }
	          Element domElement = (Element) node;
	          ElementToStream(domElement, baos);
	          InputSource isource = new InputSource(cvList.getSystemId());
	          isource.setByteStream(new ByteArrayInputStream(baos.toByteArray()));
	          return isource;
	      } else if (cvList instanceof StreamSource) {
	          StreamSource ss = (StreamSource) cvList;
	          InputSource isource = new InputSource(ss.getSystemId());
	          isource.setByteStream(ss.getInputStream());
	          isource.setCharacterStream(ss.getReader());
	          isource.setPublicId(ss.getPublicId());
	          return isource;
	      }
	      else return null;
	  }
	
	public List<Object[]> ReadXMLInput(InputSource isource){
		List<Object[]> cvList = new LinkedList<Object[]>();
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(isource);
		 
			doc.getDocumentElement().normalize();
		 
			NodeList nList = doc.getElementsByTagName("collectionCV");
		 
			for (int temp = 0; temp < nList.getLength(); temp++) {
		 
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
					Element eElement = (Element) nNode;
					Object[] row ={eElement.getElementsByTagName("id").item(0).getTextContent(),
   		     		     	eElement.getElementsByTagName("nom").item(0).getTextContent(), 
   		    		     	eElement.getElementsByTagName("prenom").item(0).getTextContent()};
					cvList.add(row);
				}
			}
			return cvList;
		    } catch (Exception e) {
			e.printStackTrace();
			System.out.println("Les informations du CV n'ont pas pu être récupéré !");
			cvList.add(new String[] {"Les informations du CV n'ont pas pu être récupéré !"});
			return cvList;
		    }
	}
	
}
