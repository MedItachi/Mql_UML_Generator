package org.java.mql.interfac;

@SuppressWarnings("rawtypes")

public interface ClassVisitor {
	
	void visitClass( Class cls);
	void visitInterface(Class cls);
    void visitEnum(Class cls);
    void visitAnnotation(Class cls);

}
