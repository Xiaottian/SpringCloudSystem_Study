package com.slasher.boot.dailytest;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SeTest {

    /**
     * 使用递归实现对字符串的反转
     * @param originStr
     * @return
     */
    public static String reverse(String originStr) {
        if(originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }



    public static void main(String[] args) {
        short s1 = 1;
        //关于    short s1 = 1; s1 = s1 + 1;有错吗?short s1 = 1; s1 += 1;有错吗?
        /**
        * s1 = s1 + 1; 编译不通过，需要进行强制类型转换
         * 即s1 = (short)(s1 + 1);
        */
        s1 += 1;

        //关于int和integer的区别
        /**
         * 简单的说，如果字面量的值在-128到127之间，那么不会new新的Integer对象，
         * 而是直接引用常量池中的Integer对象
         */
        Integer f1 = 100,f2 = 100,f3 = 150, f4 = 150;
        System.out.println(f1 == f2);   //true
        System.out.println(f3 == f4);   //false

        System.out.println(Math.round(11.5));   //12
        System.out.println(Math.round(-11.5));  //-11

        System.out.println(Long.MIN_VALUE); //-9223372036854775808
        System.out.println(((Long.MIN_VALUE) + "").length());   //

        String ss = "abcde";

        System.out.println(SeTest.reverse(ss));
        System.out.println("-----------------");

        Map map = new HashMap();
        map.put("key1","lisi1");
        map.put("key2","lisi2");
        map.put("key3","lisi3");
        map.put("key4","lisi4");
        //先获取map集合的所有键的set集合，keyset（）
        Iterator it = map.keySet().iterator();
        //获取迭代器
        while(it.hasNext()){
            Object key = it.next();
            System.out.println(map.get(key));
        }

    }
}
