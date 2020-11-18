package com.spring.homework.homework2;

import com.spring.homework.homework2.Student;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @Author lw_yang
 * @Date 2020/11/18 19:31
 **/
@Configuration
@ConditionalOnClass(Student.class)
public class KlassConfiguration {

    @Bean
    @ConditionalOnMissingBean(Klass.class)
    @ConditionalOnProperty(prefix = "kls", value = "enabled", havingValue = "true")
    public Klass stu() {
        Klass klass = new Klass();
        Student student = new Student();
        student.setName("wild");
        klass.setStudents(Arrays.asList(student));
        return klass;
    }

}
