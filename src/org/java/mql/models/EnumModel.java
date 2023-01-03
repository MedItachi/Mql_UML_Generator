package org.java.mql.models;

import java.util.List;
import java.util.Vector;

import org.java.mql.annotation.Entities;
import org.java.mql.annotation.XmlElement;

@Entities("Enumeration")
public class EnumModel {
	@XmlElement
	private String name;
	@XmlElement(name="Enums")
	private List<Enume> enums;
	@XmlElement(name="Fields")
	private List<FieldModel> fields;
	
	@XmlElement(name="Methods")
	private List<MethodModel> methods;
	@XmlElement(name="Constructors")
	private List<ConstructeurModel> constructors;
	private List<ClasseModel> supperClass;
	
	public EnumModel() {
		this.enums = new Vector<Enume>();
		fields = new Vector<FieldModel>();
		methods = new Vector<MethodModel>();
		constructors = new Vector<ConstructeurModel>();
	}
	public EnumModel(String name, List<Enume> enums,
			List<FieldModel> fields, List<MethodModel> methods,
    		List<ConstructeurModel> constructors) {
		super();
		this.name = name;
		this.enums = enums;
		this.fields = fields;
		this.methods = methods;
		this.constructors = constructors;
	}
	
	public void addField(FieldModel fieldModel) {
    	fields.add(fieldModel);
    }
    
    public void addMethod(MethodModel methodModel) {
    	methods.add(methodModel);
    }
    
    public void addConstructeur(ConstructeurModel constModel) {
    	constructors.add(constModel);
    }
 
	public String getName() {
		return name;
	}

	public List<FieldModel> getFields() {
		return fields;
	}

	public List<MethodModel> getMethods() {
		return methods;
	}

	public List<ConstructeurModel> getConstructors() {
		return constructors;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setFields(List<FieldModel> fields) {
		this.fields = fields;
	}
	public void setMethods(List<MethodModel> methods) {
		this.methods = methods;
	}
	public void setConstructors(List<ConstructeurModel> constructors) {
		this.constructors = constructors;
	}
	

	
	
	
	
	
}

class Enume{
	@XmlElement
	private String name;
	@XmlElement
	private String value;
	
	public Enume() {}
	
	public Enume(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
