package org.java.mql.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;

import org.java.mql.modelDataUi.ClassModel;

public class ClassPanel {

	int x, y, w, h;
	private int stateY = 0;
	private List<String> fields;
	private List<String> methods;
	private String name = "";

	public ClassPanel(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		stateY = y;
		fields = new Vector<>();
		methods = new Vector<>();

	}

	public ClassPanel(String name, int x, int y, int w, int h) {
		this(x, y, w, h);
		this.name = name;

	}

	
	public void paintClass(Graphics g) {

		
		System.out.println("paint");
		printName(g);
		printField(g);
		printMethod(g);
		paintRect(g);

	}

	public void paintRect(Graphics g) {

		g.setColor(Color.black);
		// g.drawRect(180, 80, 500, 200);
		g.drawRect(x, y, w, stateY);

	}

	public void printName(Graphics g) {
		stateY += ((int) (h * 0.2));

		g.setColor(Color.black);
		g.drawLine(x, stateY, x + w, stateY);
		g.drawString(name, x + 80, y + 30);
	}

	public void printField(Graphics g) {
		int x = this.x + 20;
		int y = stateY + 15;

		for (String field : fields) {
			g.drawString(field, x, y);
			y += 15;
		}
		g.drawLine(this.x, y + 5, this.x + w, y + 5);
		stateY = y + 10;
	}

	public void printMethod(Graphics g) {

		int x = this.x + 20;
		int y = stateY + 15;

		for (String method : methods) {
			g.drawString(method, x, y);
			y += 15;
		}
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}

	public void setMethods(List<String> methods) {
		this.methods = methods;
	}

}
