package org.java.mql.controlles;

import java.util.List;
import java.util.Vector;

import org.java.mql.models.ClasseModel;
import org.java.mql.models.ConstructeurModel;
import org.java.mql.models.FieldModel;
import org.java.mql.models.MethodModel;
import org.java.mql.reflection.ClassInfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

@SuppressWarnings("rawtypes")
public class Controller {
	
	private List<ClasseModel> classeModels;
	private List<Class> classes;
	public Controller(List<Class> classes) {	
		this.classes = classes;
		config();
		
	}
	
	
	private void config() {
		
		classeModels = new Vector<ClasseModel>();
		for(Class cls:classes) {
			loadClass(new ClassInfo(cls));
		}
	}
	
	private void loadClass(ClassInfo cls) {
		ClasseModel clsModel  = new ClasseModel();
		clsModel.setName(cls.getName());
		for(Field field:cls.getFields()) {
			FieldModel f = new FieldModel();
			f.setModifier(Modifier.toString(field.getModifiers()));
			f.setType(field.getType().getSimpleName().toString());
			f.setName(field.getName());
			clsModel.addField(f);
		
		}
		
		
		for(Method method:cls.getMethods()) {
			MethodModel m = new MethodModel();
			m.setModifier(Modifier.toString(method.getModifiers()));
			m.setReturnType(method.getReturnType().toString());
		    m.setName(method.getName());
		    
		    List<String> params = new Vector<String>();
		    
		    for(Parameter param:method.getParameters()) {
		    	params.add(param.getType().toString());
		    }
		    m.setParams(params);
		    clsModel.addMethod(m);
			
		}
		
		for(Constructor cons:cls.getConstructors()) {
			ConstructeurModel consModel = new ConstructeurModel();
			consModel.setModifier(Modifier.toString(cons.getModifiers()));
			consModel.setName(cons.getName());
			List<String> params = new Vector<String>();
			 for(Parameter param:cons.getParameters()) {
				 params.add(param.getType().toString());
			 }
			 consModel.setParams(params);
			 clsModel.addConstructeur(consModel);
		}
		classeModels.add(clsModel);
		
	}
	
	public void showField() {
		
		for(ClasseModel model:classeModels) {
			System.out.println("-----Field------");
			System.out.println("name: "+model.getName());

			System.out.println(model.getFields());
			
			System.out.println("-----Constructeur-----");
			System.out.println(model.getConstructors());
			
			System.out.println("-----Methods-----");
			
			System.out.println(model.getMethods());
			System.out.println("----------");
		}
	}
	
	public ClasseModel getModel() {
		return classeModels.get(0);
	}
	

}
