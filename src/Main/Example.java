package Main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;

import org.java.mql.controlles.Controller;
import org.java.mql.controlles.ControllerPackage;
import org.java.mql.models.ClasseModel;
import org.java.mql.persist.Persistance;
import org.java.mql.reflection.ClassExplorer;
import org.java.mql.reflection.ClassModeltoClassUi;
import org.java.mql.reflection.PackageExplorer;
import org.java.mql.ui.UmlDraw;

public class Example extends JFrame  {

	private static final long serialVersionUID = 1L;

	public Example() {
		exp03();
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
	


	 //Draw
	void exp03() {
		
		PackageExplorer packageExplore = new PackageExplorer("C:\\Users\\Mohamed\\Documents\\mqL\\UmlGenTest\\bin");
		// packageExplore.show(packageExplore.getPackageNames());
		ControllerPackage cont = new ControllerPackage(packageExplore.getPackageNames());
		Persistance per = new Persistance(cont.getPackageModels());
		per.saveDoc("PackageDoc");
		
		
	
        
        pack();
        this.setVisible(true);
        Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
        UmlDraw uml = new UmlDraw(cont.getPackageModels(),(int)DimMax.getWidth(),(int) DimMax.getHeight());
        this.setContentPane(uml);
        setMaximumSize(DimMax);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
	}

	void exp04() {
		PackageExplorer packageExplore = new PackageExplorer("C:\\Users\\Mohamed\\Documents\\mqL\\PackageTest\\bin");
		packageExplore.show(packageExplore.getPackageNames());
	}
	
	void exp05() {
		
	}
	
	//Example For parser
	
	public static void main(String[] args) {
		new Example();

	}

}
