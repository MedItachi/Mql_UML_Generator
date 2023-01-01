package org.java.mql.persist;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Persist {

	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	static Document doc;
	Object target;
	
	public Persist() {
		init();
	}

	public Persist(Object target) {
		this.target = target;
		init();
	}

	private void init() {

		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			doc = builder.newDocument();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  Element createElment(String name) {
		return doc.createElement(name);
	}
	
	public void appendElment(Element child) {
		doc.appendChild(child);
	}
	public void saveDoc() {
		 try {
			 TransformerFactory transformerFactory = TransformerFactory.newInstance();
			 Transformer transformer = transformerFactory.newTransformer();
		        DOMSource source = new DOMSource(doc);
		        StreamResult result = new StreamResult(new File("ressources/output.xml"));
		        transformer.transform(source, result);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
