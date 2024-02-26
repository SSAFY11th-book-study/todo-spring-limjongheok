package com.example.toby_spring_ch5;


import com.example.toby_spring_ch5.toby_spring_ch5.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JUnitTest3 {

    @Autowired
    private ApplicationContext applicationContext;


    @Test
    public void test1(){


        assertThat(applicationContext == null || applicationContext == this.applicationContext , is(true));
        applicationContext = this.applicationContext;
    }


    @Test
    public void test2(){

        Assertions.assertTrue(applicationContext == null || applicationContext == this.applicationContext);
        applicationContext = this.applicationContext;
    }

}
