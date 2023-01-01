package org.java.mql.reflection;

import java.io.File;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.Vector;

@SuppressWarnings("rawtypes")
public class ClassExplorer {
	private List<String> classNames;
	private List<Class> classes;
	private String absolutePath;
	
	public ClassExplorer(String url) {
		classNames = new Vector<String>();
		classes = new Vector<Class>();
		this.absolutePath = url;
		getClasses(url);
		loadClasses();

	}
	
	private void getClasses(String url) {
		
		File dir = new File (url);
		for(File file:dir.listFiles()) {
			if(file.isFile()) {
				if(file.getName().endsWith(".class")) {
					String pathName = file.getAbsolutePath().replace(absolutePath+"\\","");
					String clasName = pathName.replace(".class", "");

					classNames.add(clasName.replace("\\","."));
				}
			}else if(file.isDirectory()) {
				getClasses(file.getAbsolutePath());
			}
		}
		
	}
	
	private void loadClasses() {
		
		try {
			URL[] classURLs = { new URL("file:///"+absolutePath+"/") };
			  for(String cls:classNames) {
				  URLClassLoader classLoader = new URLClassLoader(classURLs);
				  classes.add(classLoader.loadClass(cls));
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error: "+e.getMessage());
		}
		
		
	}
	
	
	public List<String> getClassNames() {
		return classNames;
	}
	
	public List<Class> getClasss() {
		return classes;
	}
	
	

}
