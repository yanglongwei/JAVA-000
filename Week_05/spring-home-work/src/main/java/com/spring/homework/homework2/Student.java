package com.spring.homework.homework2;

import com.spring.homework.homework1.Address;
import org.springframework.stereotype.Component;

/**
 * @Author lw_yang
 * @Date 2020/11/18 18:52
 **/
@Component
public class Student {

    private String name;


    public Student() {
    }

    public Student(String name, Address address) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }



}
