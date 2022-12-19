package org.java.mql.reflection;

import java.io.File;
import java.util.List;
import java.util.Vector;

public class PackageExplorer {
	private List<String> packageNames;
	private String urlProjet;
	
	public PackageExplorer(String urlProjet) {
		packageNames = new Vector<String>();
		this.urlProjet = urlProjet;
		this.getPackageList();
	}
	
	
	private void getPackageList(){
		
		File projetDir = new File(urlProjet+"\\bin");
		for(File file:projetDir.listFiles()) {
			System.out.println(file.getName());
		}
	}
	
}
