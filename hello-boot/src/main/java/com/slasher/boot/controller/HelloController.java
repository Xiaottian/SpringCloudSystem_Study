package com.slasher.boot.controller;

import com.slasher.boot.bean.Book;
import com.slasher.boot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Logger;

@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        ServiceInstance instance = client.getLocalServiceInstance();

        int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime:" + sleepTime);
        //Thread.sleep(sleepTime);
        logger.info("hello,host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return "Hello World";
    }

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello(@RequestParam String name){
        return "Hello" + name;
    }

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age){
        return new User(name,age);
    }

    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
    public String hello(@RequestBody User user){
        return "Hello " + user.getName() + ", " + user.getAge();
    }

    @RequestMapping(value = "testMap",method = RequestMethod.POST)
    public String testMap(@RequestBody Map<String,String> map){
        String flag;
        if(map.size() > 0){
            flag = "success";
        }else {
            flag = "fail";
        }
        System.out.println(map.size());
        return flag;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        float v =  0.75f;
        System.out.println(Float.isNaN(v));
        ArrayList ll = new ArrayList(10);
        ll.add("1");
        ll.add("2");
        ll.add(1, 3);
        for (Object o : ll) {
            System.out.println(o);
        }
        System.out.println(ll.size());
        System.out.println(ll.indexOf("1"));
        ll.set(1,"1");
        System.out.println(ll.get(0));
        System.out.println(ll.get(1));

        ArrayList<Student> list=new ArrayList<Student>();
        //添加两个元素
        Student stJack=new Student("Jack", 13);
        Student stTom=new Student("Tom", 15);
        list.add(stJack);
        list.add(stTom);
        //深克隆
        ArrayList<Student> listCopy=new ArrayList<Student>();
        for (Student student : list) {
            listCopy.add(student.clone());
        }
        //移除且不修改
        listCopy.get(0).setAge(20);
        System.out.println(list);
        System.out.println(listCopy);
    }
}

class Student{
    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
    @Override
    protected Student clone(){
        Student stuent = new Student(this.name,this.age);
        return stuent;
    }

}
