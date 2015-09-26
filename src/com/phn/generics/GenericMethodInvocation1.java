package com.phn.generics;
public class GenericMethodInvocation1 {
 
    public static void main(final String[] args) {
        // 1. returns true
        System.out.println(Compare1.<String> genericCompare("1", "1"));
        // 2. compilation error
//        System.out.println(Compare1.<String> genericCompare("1", new Long(1)));
        // 3. returns false
        System.out.println(Compare1.genericCompare("1", new Long(1)));
    }
}
 
class Compare1 {
 
    public static <T> boolean genericCompare(final T object1, final T object2) {
        System.out.println("Inside generic");
        return object1.equals(object2);
    }
}