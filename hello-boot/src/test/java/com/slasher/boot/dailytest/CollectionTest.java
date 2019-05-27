package com.slasher.boot.dailytest;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
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

    /**
     * linkedHahMap存入的数据是有序的。
     * hashmap则会根据key进行排序，所以是相对存入顺序无序的
     */
    @Test
    public void testLinkedHasMap(){
        Map map = new LinkedHashMap<>();
        map.put("1",1);
        map.put("3",3);
        map.put("2",2);
        System.out.println("linkedhashmap中的顺序为"+map);
        Map map1 = new HashMap<>();
        map1.put("1",1);
        map1.put("3",3);
        map1.put("2",2);
        System.out.println("hashmap中的顺序为"+ map1);
    }
}
