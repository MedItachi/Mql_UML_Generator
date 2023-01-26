package org.java.mql.modelDataUi;

import java.util.List;
import java.util.Vector;

public class ClassModel {
	
	private String name;
	private List<String> fields;
	private List<String> methods;
	
	
	public ClassModel() {
		this.name = "";
		this.fields = new Vector<>();
		this.methods = new Vector<>();
	}


	public ClassModel(String name) {
		this.fields = new Vector<>();
		this.methods = new Vector<>();
		this.name = name;
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<String> getFields() {
		return fields;
	}


	public void setFields(List<String> fields) {
		this.fields = fields;
	}


	public List<String> getMethods() {
		return methods;
	}


	public void setMethods(List<String> methods) {
		this.methods = methods;
	}
}
