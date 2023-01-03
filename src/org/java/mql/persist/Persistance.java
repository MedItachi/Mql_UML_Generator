package org.java.mql.persist;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.java.mql.reflection.XMLAnnotationTarget;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Persistance {
	
	private List<Object> objects;
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document doc;
	
	public Persistance(List<Object> objects) {
		init(objects);
		persist();
	}
	
	public void init(List<Object> objects) {
		try {
			this.objects = objects;
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			doc = builder.newDocument();
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	
   public void persist() {
	   Element root = doc.createElement("UmlModel");
	   doc.appendChild(root);
	   for(Object obj:objects) {
		   new XMLAnnotationTarget(obj, doc, root);
	   }
   }
   
   public void saveDoc(String name) {
		 try {
			 TransformerFactory transformerFactory = TransformerFactory.newInstance();
			 Transformer transformer = transformerFactory.newTransformer();
		        DOMSource source = new DOMSource(doc);
		        StreamResult result = new StreamResult(new File("ressources/UmlModel.xml"));
		        transformer.transform(source, result);
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	
	
   }

}
