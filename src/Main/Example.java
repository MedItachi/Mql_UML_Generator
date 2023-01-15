package Main;

import java.util.List;
import java.util.Vector;

import org.java.mql.controlles.Controller;
import org.java.mql.controlles.ControllerPackage;
import org.java.mql.models.ClasseModel;
import org.java.mql.persist.Persistance;
import org.java.mql.reflection.ClassExplorer;
import org.java.mql.reflection.PackageExplorer;

public class Example {

	public Example() {
		exp02();
	}

	void exp01() {
		ClassExplorer cls = new ClassExplorer("C:\\Users\\Mohamed\\Documents\\mqL\\PackageTest\\bin");
		Controller cont = new Controller(cls.getClasss());

	}

	void exp02() {
		PackageExplorer packageExplore = new PackageExplorer("C:\\Users\\Mohamed\\Documents\\mqL\\UmlGenTest\\bin");
		// packageExplore.show(packageExplore.getPackageNames());
		ControllerPackage cont = new ControllerPackage(packageExplore.getPackageNames());
		Persistance per = new Persistance(cont.getPackageModels());
		
		
		per.saveDoc("PackageDoc");
        
	}

	void exp03() {
		//PackageExplorer pack = new PackageExplorer("C:\\Users\\Mohamed\\Documents\\mqL\\PackageTest\\bin");
		// PackageExplorer pack = new
		// PackageExplorer("C:\\Users\\Mohamed\\Documents\\mqL\\UML_Generator\\bin");
		// System.out.println("taille:"+pack.getPackageNames().size());
        //new ControllerPackage(pack.getPackageNames());

	}

	void exp04() {
		PackageExplorer packageExplore = new PackageExplorer("C:\\Users\\Mohamed\\Documents\\mqL\\PackageTest\\bin");
		packageExplore.show(packageExplore.getPackageNames());
	}
	
	void exp05() {
		ClassExplorer clsExplorer = new ClassExplorer("C:\\Users\\Mohamed\\Documents\\mqL\\PackageTest\\bin\\demo\\org\\test");
	
	}
	
	//Example For parser
	
	public static void main(String[] args) {
		new Example();

	}

}
