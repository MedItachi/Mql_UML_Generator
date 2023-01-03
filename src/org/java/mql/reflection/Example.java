package org.java.mql.reflection;

import java.util.Vector;

import org.java.mql.models.ClasseModel;
import org.java.mql.models.MethodModel;
import org.java.mql.persist.Persist;



public class Example {
	
	public Example() {
		exp03();
	}
	
	public void exp01() {
		ClassExplorer cls =  new ClassExplorer("C:\\Users\\Mohamed\\Documents\\mqL\\PackageTest\\bin");
	}
	
	public void exp02() {
		  Class cls = Vector.class;
	}
	
	public void exp03() {
		Persist per = new Persist();
		//new XMLAnnotationTarget(new ClasseModel(), per);
	}

	public static void main(String[] args) {
		new Example();
	}
}
