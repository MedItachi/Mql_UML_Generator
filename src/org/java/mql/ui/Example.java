package org.java.mql.ui;

import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;

import org.java.mql.modelDataUi.ClassModel;

import java.awt.*;
import javax.swing.*;

public class Example extends JFrame {

	public Example() {
		exp01();
		
	}
	
	public void exp01() {
		// Create a JPanel to draw the diagram
	
		
		PackagePanel packPane = new PackagePanel(50, 50, 400, 400);
		
		//packPane.addClassPAnel(new ClassPanel(100, 100,100, 100));
		PackagePanel packPane2 = new PackagePanel(100, 100, 80, 50);
		JPanel p = new JPanel();
		p.setPreferredSize(new Dimension(800,600));
		p.add(packPane);
		p.add(packPane2);
		setContentPane(packPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setSize(800, 600);
		setVisible(true);
	}

	public void exp02() {
		ClassModel clsModel = new ClassModel("hhhh");

	}

	public static void main(String[] args) {
		new Example();

	}
}
