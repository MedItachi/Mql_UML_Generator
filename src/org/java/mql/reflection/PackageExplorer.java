package org.java.mql.reflection;

import java.io.File;
import java.util.List;
import java.util.Vector;

public class PackageExplorer {
	private List<String> classNames;
	private List<PackageExplorer> packageNames;
	private static String urlProjet;
	private boolean containPackage = false;
	private boolean containeClasse = false;
	

    private PackageExplorer(String packageName) {
          classNames = new Vector<String>();
          packageNames = new Vector<PackageExplorer>();
          listClasse(packageName);
	 }
	
	
	public PackageExplorer() {
		packageNames = new Vector<PackageExplorer>();
		  listClasse();
		 
	}
	
     
	private void listClasse(String packageName) {
		   File dirPack = new File(urlProjet+"\\\\bin\\"+packageName);
		   if(dirPack.listFiles()!=null) {
			   for(File file:dirPack.listFiles()) {
				   if(file.isFile()) {
					   if(file.getName().endsWith(".class")) {
						   containeClasse = true;
						   classNames.add(file.getName().replace(".class", ""));
					   }
				   }else if(file.isDirectory()) {
					   if(isPackage(file)) {
						   containPackage = true;
						   packageNames.add(new PackageExplorer(file.getAbsolutePath().replace(urlProjet+"\\bin\\", "")));
						   
					   }else {
						   String pack = getPackage(file);
						   if(pack!=null) {
							   
							   containPackage = true; 
							   packageNames.add(new PackageExplorer(pack));
						   } 
					   }
				   }
			   }
		   }
	}
	
	private void listClasse() {
		File dirBin = new File(urlProjet+"\\bin");
		 if (dirBin.listFiles()!=null) {
			   for(File file:dirBin.listFiles()) {
				   if(isPackage(file)) {
					   containPackage = true;
					   packageNames.add(new PackageExplorer(file.getName()));
				   }else if(file.isDirectory()) {
					   String pack = getPackage(file);
					   if(pack!=null) {
						   containPackage = true; 
						   packageNames.add(new PackageExplorer(pack));
					   }
				   }
			   }
		}
		
	}
	
	private boolean containCLass(File directory) {
		   if(directory.listFiles()!=null) {
			   for(File file:directory.listFiles()) {
				   if(file.getName().endsWith(".class")) {
					   return true;
				   }
			   }
		   }
		return false;
	}
	
	private boolean isPackage(File directory) {
		   
		int nb = 0;
            if(directory.listFiles()!=null) {
            	for(File file:directory.listFiles()) {
            		if(file.isFile()) {
            			if(file.getName().endsWith(".class")) {
            				return true;
            			}
            		}if(file.isDirectory()) {
            			nb++;
            		}
            	}
            }
		return nb>1;
	}
	
	private void addClasses(File file) {
		if(file.listFiles()!=null) {
			   for(File f:file.listFiles()) {
				   if(f.getName().endsWith(".class")) {
					   classNames.add(file.getName().replace(".class", ""));
				   }
			   }
		}
	}
	private String getPackage(File file) {
           if(!isPackage(file)) {
        	   if(file.listFiles().length>0) {
        		   return getPackage(new File(file.getAbsolutePath()+"\\"
            			   +file.listFiles()[0].getName()));
        	   }
        	   
           }
        	   
           
           return file.getAbsolutePath().replace(urlProjet+"\\bin\\", "");
		
		
	}
	
	
	
	public static void setUrlProject(String urlProjet) {
		PackageExplorer.urlProjet = urlProjet;
	}
	
	public List<String> getclassNames(){
		return classNames;
	}

	public List<PackageExplorer> getPackageNames() {
		return packageNames;
	}


	public boolean isContainPackage() {
		return containPackage;
	}


	public boolean isContaineClasse() {
		return containeClasse;
	}
	
}
