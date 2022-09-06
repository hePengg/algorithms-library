package com.base.lambda;

import java.util.function.BinaryOperator;

/**
 * @author
 */
public class LambdaTest {

    public static void main(String[] args) {
        BinaryOperator<Integer> add = (x, y) -> x + y;
        System.out.println(add.apply(1, 3));
    }
}
