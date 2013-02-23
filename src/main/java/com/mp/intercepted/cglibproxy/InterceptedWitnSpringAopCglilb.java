package com.mp.intercepted.cglibproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class InterceptedWitnSpringAopCglilb {

    private static final Logger LOGGER = LoggerFactory.getLogger(InterceptedWitnSpringAopCglilb.class);

    public String methodToBeIntercepted(){
        LOGGER.debug("Entering method to be intercepted, CGLIB");
        return "Not intercepted CGLIB";
    }
}
