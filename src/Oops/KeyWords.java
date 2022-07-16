package Oops;

public class KeyWords {
    /*
    This --> refers to the address of the Current Object removes Confusion between class Attributes and Object
    https://www.javatpoint.com/this-keyword

    Super--> Used to Invoke Parents class constructor and Method

    Getters and Setters
    They are Just a Method used in Encapsulation of data

    static --> BluePrint of static Loaded In Heap Even Before Initialization of an Object
    Cannot Use "this" keyword Inside Static fn as it already a class Property

     finally

     final


     */
    public static void main(String[] args) {
        child1 cc = new child1();
    }
}

class Parent3 {
    public int age() {
        return 2;
    }
}

class child1 extends Parent3 {
    private int aage() {
        return super.age();
    }
}