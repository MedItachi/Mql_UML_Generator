package org.java.mql.models;

import org.java.mql.annotation.XmlElement;

public class FieldModel {
	@XmlElement(name="Modifier")
	private String modifier;
	@XmlElement
	private String type;
	@XmlElement
	private String name;
	
	public FieldModel(String modifier, String type, String name) {
		this.modifier = modifier;
		this.type =type;
		this.name = name;
	}
	
	public FieldModel() {
		// TODO Auto-generated constructor stub
	}

	public String getModifier() {
		return modifier;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "FieldModel [modifier=" + modifier + ", type=" + type + ", name=" + name + "]";
	}
	
	
	
	
	
	

}
