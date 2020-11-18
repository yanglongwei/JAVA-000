package com.spring.homework.homework1;

import com.spring.homework.homework1.javaconfig.StudentConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author lw_yang
 * @Date 2020/11/18 18:56
 **/
public class Solution {

    public static void main(String[] args) {
        solution1();
//        solution2();
    }

    public static void solution1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }

    public static void solution2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }

}
