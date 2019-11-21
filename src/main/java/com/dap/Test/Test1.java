package com.dap.Test;

public class Test1 {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = new Integer(3000);

        a = b;
        b = new Integer(5000);

        System.out.println(a);
    }

}
