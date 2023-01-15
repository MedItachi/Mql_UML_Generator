package org.java.mql.reflection;

import java.io.File;
import java.util.List;
import java.util.Vector;

import org.java.mql.models.PackageModel;

@SuppressWarnings("rawtypes")
public class PackageExplorer {
	private List<PackageExplorer> packageNames;
	private List<PackageModel> packageModels;
	private List<Class> classes;
	private String name = "";
	private String abslutePath;
	private File dir;

	public PackageExplorer(String url) {
		packageNames = new Vector<PackageExplorer>();
		this.abslutePath = url;
		dir = new File(url);
		findPackages();

		this.classes = new Vector<Class>();
	}

	public PackageExplorer(String url, String name) {

		this(url);
		this.name = name;
		if (containClass(dir)) {
			loadClasses();
		}
	}

	private boolean isPackage(File file) {
		int i = 0;
		if (file.listFiles() != null) {
			for (File f : file.listFiles()) {
				if (f.isFile() && f.getName().endsWith(".class"))
					return true;
				else if (f.isDirectory())
					i++;
			}
		}

		return i > 1;

	}

	

	// define a method to traverse a directory and determine the packages and
	// subpackages
	private void findPackages() {

		for (File file : dir.listFiles()) {
			if (file.isDirectory()) {
				if (isPackage(file)) {
					if (isParent(dir, file)) {
						packageNames.add(new PackageExplorer(file.getAbsolutePath(), file.getAbsolutePath()));
					}
					

				} else {
					dir = new File("" + file.getAbsoluteFile());
					 findPackages();
				}
			}
		}

	}

	// private load Packages
	private void loadClasses() {
		classes.addAll(new ClassExplorer(abslutePath).getClasss());
		

	}

	public void show(List<PackageExplorer> packageNames) {
		for (PackageExplorer pack : packageNames) {
			System.out.println("-----debut Pack: " + pack.name + " -----");
			System.out.println("-----size: " + pack.getPackageNames().size() + "-----");
			show(pack.getPackageNames());
			System.out.println("-----fin Pack: " + pack.name + " -----");

		}
	}

	private boolean containClass(File dir) {

		if (dir.listFiles() != null) {
			for (File file : dir.listFiles()) {
				if (file.isFile()) {
					if (file.getName().endsWith(".class")) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static boolean isParent(File parent, File fils) {

		String parentFile = parent.getAbsolutePath();
		String filsFile = fils.getAbsolutePath();
		filsFile = filsFile.substring(0, filsFile.lastIndexOf("\\"));
		return parentFile.equals(filsFile);
	}

	public List<PackageExplorer> getPackageNames() {
		return packageNames;
	}

	public List<Class> getClasses() {
		return classes;
	}

	public String getName() {
		return name;
	}
	
	

}