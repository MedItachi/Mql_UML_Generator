package org.java.mql.models;

import java.util.List;
import java.util.Vector;

public class ConstructeurModel {
	 private String name;
	 private String modifier;
	 private List<String> params;
	 
	public ConstructeurModel() {
		super();
		this.params = new Vector<String>();
	}
	public ConstructeurModel(String name,
			List<String> params, String modifier) {
		super();
		this.name = name;
		this.modifier = modifier;
		this.params = params;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "ConstructeurModel [name=" + name  + ", modifier=" + modifier + ", params="
				+ params + "]";
	}
	
	
	
	
	 
	 

}

