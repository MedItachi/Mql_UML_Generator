package org.java.mql.models;

import java.util.List;
import java.util.Vector;

import org.java.mql.annotation.Entities;
import org.java.mql.annotation.XmlElement;

@Entities("Method")
public class MethodModel {
	@XmlElement
	private String name;
	@XmlElement
	private String returnType;
	@XmlElement
	private String modifier;
	@XmlElement(name="params")
	private List<String> params;

	public MethodModel() {
		super();
		this.params = new Vector<String>();
	}

	public MethodModel(String name, String returnType, List<String> params, String modifier) {
		super();
		this.name = name;
		this.returnType = returnType;
		this.modifier = modifier;
		this.params = params;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String type) {
		this.returnType = type;
	}

	public List<String> getParams() {
		return params;
	}

	public void setParams(List<String> params) {
		this.params = params;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	@Override
	public String toString() {
		return "MethodModel [name=" + name + ", returnType=" + returnType + ", modifier=" + modifier + ", params="
				+ params + "]";
	}

}
