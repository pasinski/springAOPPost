package com.mp.interceptedtest;

import com.mp.intercepted.jvmproxy.InterceptedWithSpringAopJvmProxy;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: Michal
 * Date: 23.02.13
 * Time: 13:16
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-aop-jvmproxy.xml")
public class InterceptedWithSpringAopJvmProxyTest {

    @Autowired
    private InterceptedWithSpringAopJvmProxy interceptedWithSpringAop;

    @Test
    public void testMethodToBeIntercepted() throws Exception {
        String result = interceptedWithSpringAop.methodToBeIntercepted();
        Assert.assertTrue("Result did not start with \"Intercepted\"", result.startsWith("Intercepted"));
    }
}
