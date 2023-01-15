package org.java.mql.controlles;

import java.util.List;
import java.util.Vector;

import org.java.mql.annotation.XmlElement;
import org.java.mql.models.PackageModel;
import org.java.mql.reflection.PackageExplorer;

public class ControllerPackage {
	
	private List<PackageModel> packageModels;
	private List<PackageExplorer> packages;

	public ControllerPackage(List<PackageExplorer> packages) {
		packageModels = new Vector<PackageModel>();
		this.packages = packages;
		loadPackageModel(packages);
	}
	
	private void loadPackageModel(List<PackageExplorer> packages) {
		
		for(PackageExplorer packag:packages) {
			packageModels.add(new PackageModel(packag));
		}
	}
	
	public List<PackageModel> getPackageModels() {
		return packageModels;
	}

	public void setPackageModels(List<PackageModel> packageModels) {
		this.packageModels = packageModels;
	}
	
	
	public List<Object> getAllModels(){
		List<Object> models = new Vector<>();
		
		models.addAll(packageModels);
		return models;
	}
	
	public void show(List<PackageModel> packageModels) {
		for(PackageModel pack:packageModels) {
			System.out.println(pack.getName());
			show(pack.getPackages());
		}
	}
	

}
