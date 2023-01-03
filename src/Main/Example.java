package Main;

import java.util.Vector;

import org.java.mql.controlles.Controller;
import org.java.mql.persist.Persist;
import org.java.mql.persist.Persistance;
import org.java.mql.reflection.ClassExplorer;
import org.java.mql.reflection.XMLAnnotationTarget;

public class Example {
	
	public Example() {
		exp01();
	}
	
	void exp01() {
		ClassExplorer cls = new ClassExplorer("C:\\Users\\Mohamed\\Documents\\mqL\\PackageTest\\bin");
		Controller cont = new Controller(cls.getClasss());
		
		Persistance per = new Persistance(cont.getAllModels());
		per.saveDoc("PackageDoc");
		
	}
	
	void exp02() {
		
//		new XMLAnnotationTarget(Example.class);
	}

	public static void main(String[] args) {
		
		new Example();

	}

}
