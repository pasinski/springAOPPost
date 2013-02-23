package com.mp.intercepted.jvmproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Michal
 * Date: 23.02.13
 * Time: 12:44
 * To change this template use File | Settings | File Templates.
 */

@Component
public class InterceptedWithSpringAopJvmProxyImpl implements InterceptedWithSpringAopJvmProxy {
    private static final Logger LOGGER = LoggerFactory.getLogger(InterceptedWithSpringAopJvmProxyImpl.class);

    public String methodToBeIntercepted(){
        LOGGER.debug("Entering method to be intercepted");
        return "Not intercepted";
    }
}
