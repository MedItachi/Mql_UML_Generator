package org.java.mql.reflection;

import java.lang.reflect.Constructor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Vector;
import java.util.Arrays;
import java.util.Collection;
public class ClassInfo {
	
	private List<Field> fields;
	private List<Method> methods;
	private List<Constructor<?>> constructors;
	private Class<?> classe;
	private List<Enum> constants;
	private List<ClassInfo> superClass;
	private String name = "";
	
	public ClassInfo(Class<?> classe) {
		this.classe = classe;
		init();
		config();
	}
	
	private void init() {
		fields = new Vector<Field>();
		methods = new Vector<Method>();
		constructors = new Vector<Constructor<?>>();
		superClass = new Vector<ClassInfo>();
		constants = new Vector<Enum>();
	}
	
	private void config() {
		if(classe.isAnnotation()) {
			loadAnnotation();
		}else if(classe.isInterface()) {
			loadInterface();
		}else {
			loadClass();
		}
	}
	
     private void loadClass() {
    	//set Name
 		name = classe.getName();
 		//set fields
 		for(Field field:classe.getDeclaredFields()) {
 			fields.add(field);
 		}
 		
 		//set Methods
 		
 		for(Method method:classe.getDeclaredMethods()) {
 			methods.add(method);
 		}
 		
 		//Set Constructors
 		
 		for(Constructor<?> cons:classe.getDeclaredConstructors()) {
 			constructors.add(cons);
 		}
 		
 		//set SuperClasse
 		superClasse();
     }
     
     private void loadInterface() {
    	//set Name
  		name = classe.getName();
  		//set fields
  		for(Field field:classe.getDeclaredFields()) {
  			fields.add(field);
  		}
  		
  		//set Methods
  		
  		for(Method method:classe.getDeclaredMethods()) {
  			methods.add(method);
  		}
     }
     
     private void loadEnum() {
    	//set Name
   		name = classe.getName();
   		
   		//set Constant 
   		for(Object conste:classe.getEnumConstants()) {
   			constants.add((Enum)conste);
   		}
     }
     
     private void loadAnnotation() {
    	 
     }
     
    
	
	private void superClasse() {
		Class<?> currentClass = this.classe;
		 while(!currentClass.getName().equals("java.lang.Object")) {
			 superClass.add(new ClassInfo(currentClass.getSuperclass()));
			 currentClass = currentClass.getSuperclass();
		 }
		
	}
	
		

	public List<Field> getFields() {
		return fields;
	}

	public List<Method> getMethods() {
		return methods;
	}

	public List<Constructor<?>> getConstructors() {
		return constructors;
	}

	public List<ClassInfo> getSuperClass() {
		return superClass;
	}

	public String getName() {
		return name;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public void setMethods(List<Method> methods) {
		this.methods = methods;
	}

	public void setConstructors(List<Constructor<?>> constructors) {
		this.constructors = constructors;
	}

	public void setClasse(Class<?> classe) {
		this.classe = classe;
	}

	public void setConstants(List<Enum> constants) {
		this.constants = constants;
	}

	public void setSuperClass(List<ClassInfo> superClass) {
		this.superClass = superClass;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	
	

}
