package com.slasher.boot.guavaTest;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Map;

/**
 * 针对google的guava学习
 */
public class GuavaStudy {
    public static void main(String[] args) {
        ImmutableMap<String, Integer> map = ImmutableMap.of("k1", 1, "k2", 2);
        Map<Object, Object> map1 = Maps.newHashMap();
        map.entrySet().stream().forEach(System.out::println);
        ArrayList<String> list = Lists.newArrayList("apple", "orange", "watermelon");
        for (String s : list) {
            System.out.println("水果集合" + s);
        }
    }
}
