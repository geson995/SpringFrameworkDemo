package com.springmvc;

class Base {
    public int i = 2;

    public Base() {
        System.out.println("father is coming ");
        this.display();
    }

    public void display() {
        System.out.println("old" + i);
    }
}

class Derived extends Base {
//    private int i = 22;

    public Derived() {
//        super();
        i = 222;
    }

    public void display() {
        System.out.println("new" + i);
    }
}

public class Test {
    public static void main(String[] args) {
        new Derived();                                                  //①
    }
} 