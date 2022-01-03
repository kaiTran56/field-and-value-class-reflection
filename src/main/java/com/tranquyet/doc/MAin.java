package com.tranquyet.doc;

public class MAin {
    public static void main(String ... args){
        CheckLambda check = ()-> System.out.println("Hell World");
        check.hello();
    }
}
@FunctionalInterface
interface CheckLambda{
    void hello();
}