package org.java.mql.reflection;

import java.util.List;
import java.util.Vector;

import org.java.mql.modelDataUi.ClassModel;
import org.java.mql.models.ClasseModel;
import org.java.mql.models.FieldModel;
import org.java.mql.models.MethodModel;

public class ClassModeltoClassUi {

	private ClasseModel clsModel;

	private String name;
	private List<String> fields;
	private List<String> methods;
	private int nbField;
	private int nbMethod;

	public ClassModeltoClassUi(ClasseModel clsModel) {
		fields = new Vector<>();
		methods = new Vector<>();
		this.clsModel = clsModel;
		this.name = clsModel.getName();
		loadFields();
		loadMethods();
		
		
	}

	private void loadFields() {
		nbField = clsModel.getFields().size();
		if (nbField > 0) {
			for (FieldModel field : clsModel.getFields()) {

				String sField = "";

				if (field.getModifier().equals("public")) {
					sField += "+ ";
				} else {
					sField += "- ";
				}
				sField += field.getType() + ": ";
				sField += field.getName();
				fields.add(sField);
			}

		}

	}

	private void loadMethods() {
		nbMethod = clsModel.getMethods().size();

		if (nbMethod > 0) {
			for (MethodModel method : clsModel.getMethods()) {
				String sMethod = "";

				if (method.getModifier().equals("public")) {
					sMethod += "+ ";
				} else {
					sMethod += "- ";
				}
				sMethod += method.getReturnType() + ": ";
				sMethod += method.getName();
				methods.add(sMethod);
			}
		}
	}

	public String getName() {
		return name;
	}

	public List<String> getFields() {
		return fields;
	}

	public List<String> getMethods() {
		return methods;
	}

	public int getNbField() {
		return nbField;
	}

	public int getNbMethod() {
		return nbMethod;
	}
	
	public ClassModel getClassModel() {
		
		ClassModel clsModel= new ClassModel(name);
		clsModel.setFields(fields);
		clsModel.setMethods(methods);
		
		
		return clsModel;
	}

}
