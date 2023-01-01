package org.java.mql.reflection;

import java.util.List;
import java.util.Random;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;

import org.java.mql.annotation.XmlElement;
import org.java.mql.persist.Persist;
import org.w3c.dom.Element;

public class XMLAnnotationTarget {
	int i = 0;
	Persist persist;

	public XMLAnnotationTarget(Object target, Persist persist) {
		this.persist = persist;
		try {
			createElment(target);
			persist.saveDoc();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());

		}
	}

	@SuppressWarnings("unchecked")
	public void createElment(Object target) throws Exception {
		int id = this.randomNumb();
		Element root = persist.createElment("Class");
		root.setAttribute("id", ""+id);
		persist.appendElment(root);
		Field fields[] = target.getClass().getDeclaredFields();
		for (Field f : fields) {
			XmlElement xmlElm = f.getDeclaredAnnotation(XmlElement.class);
			if (xmlElm != null) {
				int modifers = f.getModifiers();
				if(Modifier.isPrivate(modifers)) {
					f.setAccessible(true);
				}
				if(List.class.isAssignableFrom(f.getType())){
					
					if(!isStringClass(f)) {
						parcourList(f,target, root);
					}else {
						parcourListString(f,target, root);
					}

				}else {
					
						Element child = persist.createElment(annotationName(f));
						child.setTextContent((String)f.get(target));
						root.appendChild(child);
					
				}
				
				if(Modifier.isPrivate(modifers)) {
					f.setAccessible(false);
				}

			}
		}
	}
  
	@SuppressWarnings("unchecked")
	public void parcourList(Field field,Object target, Element parent ) {
		

		try {
         List<Object> list = (List<Object>) field.get(target);
			
			
			Element elment = persist.createElment(annotationName(field));
			parent.appendChild(elment);

			for (Object l : list) {
				Element subElm = persist.createElment(singular(annotationName(field)));
				elment.appendChild(subElm);
				for (Field f : l.getClass().getDeclaredFields()) {
					int modifers = f.getModifiers();
					if(Modifier.isPrivate(modifers)) {
						f.setAccessible(true);
					}
					if(List.class.isAssignableFrom(f.getType())) {
						
						if(!isStringClass(f)){
							parcourList(f,l, subElm);
						}else {
							parcourListString(f,l, subElm);
						}
					}else {
						Element child = persist.createElment(annotationName(f));
						child.setTextContent((String)f.get(l));
						subElm.appendChild(child);
					}
					
					
					if(Modifier.isPrivate(modifers)) {
						f.setAccessible(false);
					}
				}

			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
	
	private void parcourListString(Field field,Object target, Element parent) {
		 try {
			 List<Object> list = (List<Object>) field.get(target);
				Element elment = persist.createElment(annotationName(field));
				parent.appendChild(elment);
				
				for(Object l : list) {
					Element child = persist.createElment(singular(annotationName(field)));
					child.setTextContent(""+l);
					elment.appendChild(child);
				}
				
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}
	
	private int randomNumb() {
		Random random = new Random();
		int min = 1;
		int max = 9999;
		return random.nextInt((max - min) + 1) + min;
	}
	
	private void showList(List<Object> list) {
		System.out.println();
		try {
			for(Object l : list) {
				System.out.println("-----------");
			}
		} catch (Exception e) {
			System.out.println("Except");
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	private boolean isStringClass(Field field) {
		
        ParameterizedType type = (ParameterizedType) field.getGenericType();
        Class<?> elementType = (Class<?>) type.getActualTypeArguments()[0];
        return elementType == String.class;
	}
	
	private String annotationName(Field f) {
		XmlElement xmlElm = f.getDeclaredAnnotation(XmlElement.class);
		if(xmlElm!=null) {
			
			if(!"".equals(xmlElm.name())) {
				return xmlElm.name();
			}
			return f.getName();
			
		}
		
		return "";
	}
	
	private String singular(String str) {
		if(str.endsWith("s")) {
			return str.substring(0, str.length()-1);
		}
		return str;
	}

}
