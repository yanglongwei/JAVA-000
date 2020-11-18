package com.spring.homework.homework1.javaconfig;

import com.spring.homework.homework1.Address;
import com.spring.homework.homework1.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author lw_yang
 * @Date 2020/11/18 19:07
 **/
@Configuration
public class StudentConfig {

    @Bean(name = "student")
    public Student create(Address address) {
        Student student = new Student("根生", address);
        return student;
    }

    @Bean(name = "address")
    public Address createAddress() {
        Address address = new Address();
        address.setNumber(113);
        address.setStreet("pudongxinqu");
        return address;
    }

}
