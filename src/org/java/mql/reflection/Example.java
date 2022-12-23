package org.java.mql.reflection;

public class Example {

	public static void main(String[] args) {
		ClassExplorer cls =  new ClassExplorer("C:\\Users\\Mohamed\\Documents\\mqL\\PackageTest\\bin");
		for(String c:cls.getClassNames()) {
			System.out.println(c);
		}
	}
}
