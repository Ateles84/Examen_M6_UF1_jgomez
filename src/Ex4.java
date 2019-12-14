import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Ex4 {

	public static void main(String[] args)	//PARA CORRECTO FUNCIONAMIENTO NO DEJAR LINEAS EN BLANCO!!!!!
			throws ParserConfigurationException, IOException, TransformerConfigurationException {

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.newDocument();
		Element elementPare = doc.createElement("Configurations");
		doc.appendChild(elementPare);

		ArrayList<String> arr = new ArrayList<String>();
		
		Files.lines(Path.of("examConfig.conf")).forEach(x -> arr.add(x));
		
		for (String x: arr) {
								
			x.replace("\"", "");
			
			String[] aux = x.split(" ");
			
			System.out.println(aux[0]);
			
			Element e = doc.createElement(aux[0]);
			e.appendChild(doc.createTextNode(aux[2]));
			elementPare.appendChild(e);
		}

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("examConfig.xml"));

		try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
