package org.java.mql.reflection;

import java.io.File;
import java.util.List;
import java.util.Vector;

public class ClassExplorer {
	private List<String> classNames;
	private String absolutePath;
	
	public ClassExplorer(String url) {
		classNames = new Vector<String>();
		this.absolutePath = url;
		loadClasse(url);

	}
	
	private void loadClasse(String url) {
		
		File dir = new File (url);
		for(File file:dir.listFiles()) {
			if(file.isFile()) {
				if(file.getName().endsWith(".class")) {
					String pathName = file.getAbsolutePath().replace(absolutePath+"\\","");
					classNames.add(pathName+"\\"+file.getName().replace(".class", ""));
				}
			}else if(file.isDirectory()) {
				loadClasse(file.getAbsolutePath());
			}
		}
		
	}
	
	
	public List<String> getClassNames() {
		return classNames;
	}
	
	

}
