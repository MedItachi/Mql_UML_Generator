package org.java.mql.models;

import java.util.List;
import java.util.Vector;

import org.java.mql.annotation.Entities;
import org.java.mql.annotation.XmlElement;

@Entities("Interface")
public class InterfaceModel {

	@XmlElement(name="Name")
	private String name;
	@XmlElement(name="Methods")
	private List<MethodModel> methods;
	@XmlElement(name="Fields")
	private List<FieldModel> fields;
	

	public InterfaceModel() {
		methods = new Vector<MethodModel>();
		fields = new Vector<FieldModel>();

	}

	public InterfaceModel(String name, List<MethodModel> methods
			, List<FieldModel> fields) {
		super();
		this.name = name;
		this.methods = methods;
		this.fields = fields;
	}
	
	public void addField(FieldModel field) {
		fields.add(field);
	}
	
	public void addMethod(MethodModel method) {
		methods.add(method);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MethodModel> getMethods() {
		return methods;
	}

	public void setMethods(List<MethodModel> methods) {
		this.methods = methods;
	}

	public List<FieldModel> getFields() {
		return fields;
	}

	public void setFields(List<FieldModel> fields) {
		this.fields = fields;
	}
	
	
}
