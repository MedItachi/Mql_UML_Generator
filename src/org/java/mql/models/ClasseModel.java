package org.java.mql.models;

import java.util.List;
import java.util.Vector;

import org.java.mql.annotation.XmlElement;

public class ClasseModel {
	
	@XmlElement(name="Name")
	private String name;
	
	@XmlElement(name="Fields")
	private List<FieldModel> fields;
	
	@XmlElement(name="Methods")
	private List<MethodModel> methods;
	private List<ConstructeurModel> constructors;
	private List<ClasseModel> supperClass;
	

	public ClasseModel() {
		fields = new Vector<FieldModel>();
		methods = new Vector<MethodModel>();
		constructors = new Vector<ConstructeurModel>();
		
	}
    public ClasseModel(String name,List<FieldModel> fields, List<MethodModel> methods,
    		List<ConstructeurModel> constructors, List<ClasseModel> supperClass) {
		this.name = name;
		this.fields = fields;
		this.methods = methods;
		this.constructors = constructors;
		this.supperClass = supperClass;
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

	public List<ClasseModel> getSupperClass() {
		return supperClass;
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
	public void setSupperClass(List<ClasseModel> supperClass) {
		this.supperClass = supperClass;
	}
}
