package com.test.other;

/**
 * @author yd
 * @version 1.0
 * @date 2021/11/25 21:29
 * java中如果两个类需要相互引用，不要在无参构造器中去实例化，这样会无限递归导致堆栈溢出
 */
class A{
    B b;
    public A(B b){
        this.b = b;
    }
    public A(){
        b = new B();
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    void af1(){
        System.out.println("A:f1");
    }
}
class B {
    A a;
    public B(A a){
        this.a = a;
    }
    public B(){
        a = new A();
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    void bf1(){
        System.out.println("B:f1");
    }
}
public class CommonTest{

    public static void main(String []args){
        A a = new A();
        B b = new B();
        a.setB(b);
        b.setA(a);
        System.out.println(a);
        System.out.println(a.b.a);
        a.b.a.b.a.af1();
    }
}
