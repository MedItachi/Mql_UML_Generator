package org.java.mql.models;

import java.util.List;

import java.util.Vector;

import org.java.mql.annotation.Entities;
import org.java.mql.annotation.XmlElement;
import org.java.mql.controlles.Controller;
import org.java.mql.reflection.PackageExplorer;

@Entities("Packages")
public class PackageModel {
	@XmlElement(name = "name")
	private String name;
	@XmlElement(name = "SubPacakges")
	private List<PackageModel> packages;
	@XmlElement(name = "ListClase")
	private List<Object> classes;

	public PackageModel(PackageExplorer pkg) {
		name = pkg.getName();
		packages = new Vector<PackageModel>();
		classes = new Controller(pkg.getClasses()).getAllModels();
		packages = convertToPackgeModelList(pkg.getPackageNames());
	}

	public void addPackage(PackageModel pack) {
		packages.add(pack);
	}

	public void addClass(ClasseModel classe) {
		classes.add(classe);
	}

	public List<PackageModel> getPackages() {
		return packages;
	}

	public void setPackages(List<PackageModel> packages) {
		this.packages = packages;
	}

	public List<Object> getClasses() {
		return classes;
	}

	public void setClasses(List<Object> classes) {
		this.classes = classes;
	}

	public String getName() {
		return name;
	}

	private List<PackageModel> convertToPackgeModelList(List<PackageExplorer> packgeExplorers) {
		List<PackageModel> packgeModels = new Vector<>();
		for (PackageExplorer packgeExplorer : packgeExplorers) {
			packgeModels.add(new PackageModel(packgeExplorer));
		}
		return packgeModels;
	}

	public void show(List<PackageModel> packages) {

		for (PackageModel model : packages) {
			System.out.println("pack: " + model.getName());
			show(model.getPackages());

			System.out.println("fin pack: " + model.getName());
		}

	}

}
