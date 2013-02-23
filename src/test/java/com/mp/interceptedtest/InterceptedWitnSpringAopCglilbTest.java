package com.mp.interceptedtest;

import com.mp.intercepted.cglibproxy.InterceptedWitnSpringAopCglilb;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: Michal
 * Date: 23.02.13
 * Time: 17:48
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-aop-cglibproxy.xml")
public class InterceptedWitnSpringAopCglilbTest {

    @Autowired
    private InterceptedWitnSpringAopCglilb interceptedWithSpringAopCglib;

    @Test
    public void testMethodToBeIntercepted() throws Exception {
        String result = interceptedWithSpringAopCglib.methodToBeIntercepted();
        Assert.assertTrue("Result did not start with \"Intercepted\"", result.startsWith("Intercepted"));
    }


}
