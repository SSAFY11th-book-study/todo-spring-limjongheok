package com.example.toby_spring_ch5;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JUnitTest {

    static  JUnitTest testObject;

    @Test
    public void test1(){
        Assertions.assertThat(this).isNotInstanceOf(testObject.getClass());
        testObject = this;
    }

    @Test
    public void test2(){
        Assertions.assertThat(this).isNotInstanceOf(testObject.getClass());
        testObject = this;
    }

    @Test
    public void test3(){
        Assertions.assertThat(this).isNotInstanceOf(testObject.getClass());
        testObject = this;
    }
}
