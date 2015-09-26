package com.phn.generics;
public class GenericMethodInvocation {
 
    public static void main(final String[] args) {
        // 1. returns true
        System.out.println(Compare.<String> genericCompare("1", "1"));
        // 2. compilation error
        System.out.println(Compare.<String> genericCompare("1", new Long(1)));
        // 3. returns false
        System.out.println(Compare.genericCompare("1", new Long(1)));
 
        // compilation error
//        Compare.<? extends Number> randomMethod();
        // runs fine
        Compare.<Number> randomMethod();
    }
}
 
class Compare {
 
    public static <T> boolean genericCompare(final T object1, final T object2) {
        System.out.println("Inside generic");
        return object1.equals(object2);
    }
 
    public static boolean genericCompare(final String object1, final Long object2) {
        System.out.println("Inside non-generic");
        return object1.equals(object2);
    }
 
    public static void randomMethod() {}
}
