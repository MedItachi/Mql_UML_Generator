package org.java.mql.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.java.mql.models.ClasseModel;
import org.java.mql.models.PackageModel;
import org.java.mql.reflection.ClassModeltoClassUi;

public class UmlDraw extends JPanel {

	private static final long serialVersionUID = -5813238875409739828L;

	List<PackageModel> packages;
	 private int maxClassesPerRow = 4;
	    private int classWidth = 200;
	    private int classHeight = 200;
	    private int stateX = 0;
	    private int stateY = 0;
	    private JPanel mainPanel;

	public UmlDraw(List<PackageModel> packages,int sizeX, int sizeY) {
		this.packages = packages;
		
		mainPanel = new JPanel();
		draw();
	}
	
	public void draw() {
		 int classesDrawn = 0;
	        int row = 0;
	        for(PackageModel pack:packages) {
	        	
	        	int packageWidth = 10;
	        	int packageHeight = 10;
	        	if(pack.getClasses().size()<=4) {
	        		packageWidth += pack.getClasses().size()*classWidth;
	        		packageHeight +=200;
	        	}else {
	        		packageWidth += 800;
	        		packageHeight += (pack.getClasses().size()/4)*200;
	        	}
	        		
	        	System.out.println(packageWidth+" "+packageHeight);
	        	
	        	PackagePanel packPanel = new PackagePanel(stateX,stateY, packageWidth, packageHeight);
	        	stateY +=packageHeight+10;
	        	stateX +=packageWidth+10;
	        	drawClass(pack.getClasses(),packPanel,stateX,stateY);
	        	add(packPanel);
	        	
	        	
	        }
	     //   add(mainPanel);
	}
	
	public void drawClass(List<Object> classes,PackagePanel packPanel,int startX, int startY) {
		int i=0;
		int x= startX;
		int y = startY;
	   for(Object cls:classes) {
		   
		   if(i>3) {
			   x = startX;
			   y += classHeight;
		   }else {
			   startX +=210;
		   }
			ClassModeltoClassUi clsUi = new ClassModeltoClassUi((ClasseModel)cls);
			ClassPanel clsPanel = new ClassPanel(clsUi.getName(),startX, startY, classWidth, classHeight);
			clsPanel.setFields(clsUi.getFields());
			clsPanel.setMethods(clsUi.getMethods());
			packPanel.addClassPAnel(clsPanel);
			
			i++;
			
	   }
		
	}
	
	

}
