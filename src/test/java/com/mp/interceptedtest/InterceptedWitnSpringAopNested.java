package com.mp.interceptedtest;

import com.mp.intercepted.cglibproxy.InterceptedWitnSpringAopCglilb;
import com.mp.nestedintercepted.InterceptedWithSpringAopNested;
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
@ContextConfiguration(locations = "classpath:spring-aop-nested.xml")
public class InterceptedWitnSpringAopNested {

    @Autowired
    private InterceptedWithSpringAopNested interceptedWithSpringAopCglib;

    @Test
    public void testMethodToBeIntercepted() throws Exception {
        Integer result = interceptedWithSpringAopCglib.nested();
        Assert.assertEquals(new Integer(3), result);  //If self-invoked nested(String) method was intercepted, It would be 4
    }


}
