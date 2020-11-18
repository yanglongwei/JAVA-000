package com.spring.homework.homework2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KlassController {

    @Autowired
    Klass klass;

    @RequestMapping(value = "/klass", method = RequestMethod.GET)
    public String sayHello() {
        klass.dong();
        return "hello klass";
    }
}