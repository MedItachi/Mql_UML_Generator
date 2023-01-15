package org.java.mql.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.java.mql.annotation.Entities;
import org.java.mql.annotation.XmlElement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLAnnotationTarget {
	Document doc;
	Object target;

	public XMLAnnotationTarget(Object target, Document doc, Element root) {
		this.target = target;
		this.doc = doc;
		parseObject(root);
	}

	public void parseObject(Element root) {
		try {
			String name = "";
			Entities enti = target.getClass().getDeclaredAnnotation(Entities.class);

			if (enti != null) {
				name = enti.value();
			} else
				name = target.getClass().getName();

			Element parentElment = createElment(name);
			root.appendChild(parentElment);
			Field fields[] = target.getClass().getDeclaredFields();

			for (Field field : fields) {
				field.setAccessible(true);
				
				if (List.class.isAssignableFrom(field.getType())) {
					System.out.println(field.getName());
					System.out.println(fieldisEmpty(field, target));
				  

						if (!isStringClass(field)) {
							parcoursList(field,target, parentElment);
						} else {
							parcourListString(field, target, parentElment);
						}
				  
				} else {
					Element child = createElment(annotationName(field));
					child.setTextContent((String) field.get(target));
					parentElment.appendChild(child);
				}

				field.setAccessible(false);

			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	private Element createElment(String name) {
		return doc.createElement(name);
	}

	private boolean isEntities(Field field) {
		Entities ent = field.getDeclaredAnnotation(Entities.class);
		return ent != null;
	}

	private boolean isStringClass(Field field) {

		ParameterizedType type = (ParameterizedType) field.getGenericType();
		Class<?> elementType = (Class<?>) type.getActualTypeArguments()[0];
		return elementType == String.class;
	}

	private String annotationName(Field f) {
	
		if (isEntities(f)) {
			System.out.println("isEnt");
			Entities entities = f.getDeclaredAnnotation(Entities.class);
			return entities.value();
		}

		XmlElement xmlElm = f.getDeclaredAnnotation(XmlElement.class);
		if (xmlElm != null) {

			if (!"".equals(xmlElm.name())) {
				return xmlElm.name();
			}
			return f.getName();

		}

		return "";
	}
	
	public void parcoursList(Field field, Object target, Element parent) {
		try {

			Element elment = createElment(annotationName(field));
			parent.appendChild(elment);
			List<Object> list = (List<Object>) field.get(target);
			
			
			for (Object l : list) {
				Field fields[] = l.getClass().getDeclaredFields();
                Entities ent = l.getClass().getDeclaredAnnotation(Entities.class);
				if(ent!=null) {
					Element parentElment = createElment(ent.value()); 
					elment.appendChild(parentElment);
					for (Field f : fields) {
						
						if (f.getDeclaredAnnotation(XmlElement.class) != null) {
							
							f.setAccessible(true);
							if (List.class.isAssignableFrom(f.getType())) {
								Element subElm = createElment(singular(annotationName(f)));
								parentElment.appendChild(subElm);
								if (!isStringClass(f)) {
									parcoursList(f, l, subElm);
								} else {
									parcourListString(f, l, subElm);
								}
							} else {
								Element child = createElment(annotationName(f));
								child.setTextContent((String) f.get(l));
								parentElment.appendChild(child);
							}
							f.setAccessible(false);
						}
					}
				}
				}
			
			
		} catch (Exception e) {
		
			System.out.println("From parcoursList");
			System.out.println("s#"+target.getClass().getName());
			System.out.println("field: "+field.getName());
			System.out.println("Error: " + e.getMessage());
		}

	}


	private void parcourListString(Field field, Object target, Element parent) {
		try {
			List<Object> list = (List<Object>) field.get(target);
			Element elment = createElment(annotationName(field));
			parent.appendChild(elment);

			for (Object l : list) {
				
				Element child = createElment(singular(annotationName(field)));
				child.setTextContent("" + l);
				elment.appendChild(child);
			}

		} catch (Exception e) {
			System.out.println("From parcourListString");
		
			System.out.println("Error: " + e.getMessage());
		}

	}

	private String singular(String str) {
		if (str.endsWith("s")) {
			return str.substring(0, str.length() - 1);
		}
		return str;
	}
	
	private boolean hasAnnotation(Field f) {
		
		Entities ent = f.getAnnotation(Entities.class);
		XmlElement xml = f.getAnnotation(XmlElement.class);
		if(ent!=null) return true;
		else if(xml!=null) return true;
		
		return false;
		
	}
	
	private boolean fieldisEmpty(Field f, Object target) {
		
		try {
			List<Object>  list = (List<Object>) f.get(target);
			return list.isEmpty();
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
		
	}
	
	
	
	
	

}
