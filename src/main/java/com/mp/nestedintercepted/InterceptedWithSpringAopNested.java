package com.mp.nestedintercepted;

import com.mp.intercepted.jvmproxy.InterceptedWithSpringAopJvmProxy;
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
public class InterceptedWithSpringAopNested  {
    private static final Logger LOGGER = LoggerFactory.getLogger(InterceptedWithSpringAopNested.class);

    public Integer nested(){
        LOGGER.debug("Entering method to be intercepted");
        return nested("") + 1;

    }

    public Integer nested(String arg){
        return 1;
    }


}
