package visitor;

import syntaxtree.*;

/**
 * Automatically comments certain fields in the Java v1 syntax.
 */
public class Commenter extends TreeDumper {
  private String classFormat =
      "/*************\n" +
      "New %s %s\n" +
      "*************/";
  private String variableFormat =
      "\n// Class variable definition %s";

  @Override
  public void visit(ClassDeclaration n) {
    System.out.println(String.format(
        classFormat, "class", n.f1.f1
    ));
    super.visit(n);
  }
  @Override
  public void visit(NestedClassDeclaration n) {
    System.out.println();
    System.out.print(String.format(
        classFormat, "nested class", n.f1.f1
    ));
    super.visit(n);
  }
  @Override
  public void visit(MethodDeclaration m) {
    System.out.println();
    System.out.print(String.format(
        classFormat, "method", m.f2.f0
    ));
    super.visit(m);
  }
  @Override
  public void visit(ConstructorDeclaration c) {
    System.out.println();
    System.out.print(String.format(
        classFormat, "constructor", c.f1
    ));
    super.visit(c);
  }
  @Override
  public void visit(FieldDeclaration v) {
    System.out.print(String.format(
        variableFormat, "begins"
      ));
    super.visit(v);
    System.out.print(String.format(
        variableFormat, "ends"
    ));
  }
}
