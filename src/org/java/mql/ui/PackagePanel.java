package org.java.mql.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;

public class PackagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private int x, y, w, h;
	List<ClassPanel> classPanels;
	
	public PackagePanel(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		classPanels = new Vector<>();
	}
	
	@Override
	public void paint(Graphics g) {
		System.out.println("paint");
		// TODO Auto-generated method stub
		super.paintComponent(g);
		for(ClassPanel cls:classPanels) {
			cls.paintClass(g);
		}
		paintRect(g);

 
	}
	
	
	public void paintRect(Graphics g) {
		System.out.println("rect draw");
		g.setColor(Color.black);
//		g.drawRect(x, y, w, h);
		g.drawRect(0, 0, 600, 600);
	}
	
	public void addClassPAnel(ClassPanel cls) {
		classPanels.add(cls);
	}

}
