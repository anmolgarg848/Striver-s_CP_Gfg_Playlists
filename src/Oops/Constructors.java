package Oops;

public class Constructors {
    public static void main(String[] args) {
     /*
     https://www.geeksforgeeks.org/constructors-in-java/
     The rules for writing constructors are as follows:
     Constructor(s) of a class must have the same name as the class name in which it resides.
     A constructor in Java can not be abstract, final, static, or Synchronized.
     Access modifiers can be used in constructor declaration to control its access i.e which other class can call the
     constructor.
     constructor OverLoading is Possible but Not Over-Riding.

      */
        child c = new child();
    }
}
class Parent1 {
    Parent1() {
        System.out.println("Parent 1  Constructor");
    }
    protected    Parent1(int n) {
        System.out.println("Parent Constructor");
    }
}

class Parent extends Parent1{
    Parent() {
        System.out.println("Parent Constructor");
    }
    protected    Parent(int n) {
        System.out.println("Parent Constructor");
    }
}

class child extends Parent {
    child() {
        System.out.println("child constructor");
    }
}