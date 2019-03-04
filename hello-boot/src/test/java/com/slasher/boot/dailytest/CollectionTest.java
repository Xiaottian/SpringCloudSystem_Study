package com.slasher.boot.dailytest;

import org.junit.Test;

import java.util.Stack;

public class CollectionTest {

    @Test
    public void test01(){
        Stack<Object> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        Object pop = stack.pop();
        System.out.println(stack);
        System.out.println(pop);

    }
}
