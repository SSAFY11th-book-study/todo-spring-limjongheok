package com.example.toby_spring_ch5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;

import static org.hamcrest.MatcherAssert.assertThat;
public class JunitTest2 {

    static Set<JunitTest2> testObjects = new HashSet<JunitTest2>();

    @Test
    public void test1(){
        assertThat(testObjects, not(hasItems(this)));
        testObjects.add(this);
    }

    @Test
    public void test2(){
        assertThat(testObjects, not(hasItems(this)));
        testObjects.add(this);
    }

    @Test
    public void test3(){
        assertThat(testObjects, not(hasItems(this)));
        testObjects.add(this);
    }
}
