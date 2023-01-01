package org.java.mql.reflection;

import java.util.Vector;



public class Example {
	
	public Example() {
		exp01();
	}
	
	public void exp01() {
		ClassExplorer cls =  new ClassExplorer("C:\\Users\\Mohamed\\Documents\\mqL\\PackageTest\\bin");
	}
	
	public void exp02() {
		  Class cls = Vector.class;
	}

	public static void main(String[] args) {
		new Example();
	}
}
