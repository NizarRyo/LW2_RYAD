package restClient;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

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
import org.xml.sax.InputSource;


public class ParserGETid {
	
	RestTemplate restTemplate;
	Source cv;
	String id;
	
	public ParserGETid(String id) {
		super();
		this.id = id;
		restTemplate = new RestTemplate();
		cv = restTemplate.getForObject("http://servicerestryad-ryad.rhcloud.com/ServiceREST/resume/{id}", Source.class, id);
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
	      if (cv instanceof SAXSource) {
	          return ((SAXSource) cv).getInputSource();
	      } else if (cv instanceof DOMSource) {
	          ByteArrayOutputStream baos = new ByteArrayOutputStream();
	          Node node = ((DOMSource) cv).getNode();
	          if (node instanceof Document) {
	              node = ((Document) node).getDocumentElement();
	          }
	          Element domElement = (Element) node;
	          ElementToStream(domElement, baos);
	          InputSource isource = new InputSource(cv.getSystemId());
	          isource.setByteStream(new ByteArrayInputStream(baos.toByteArray()));
	          return isource;
	      } else if (cv instanceof StreamSource) {
	          StreamSource ss = (StreamSource) cv;
	          InputSource isource = new InputSource(ss.getSystemId());
	          isource.setByteStream(ss.getInputStream());
	          isource.setCharacterStream(ss.getReader());
	          isource.setPublicId(ss.getPublicId());
	          return isource;
	      }
	      else return null;
	  }

}
