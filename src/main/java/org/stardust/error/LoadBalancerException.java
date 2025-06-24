package org.stardust.error;

import org.stardust.LoadBalancer;

public class LoadBalancerException extends RuntimeException {


    public LoadBalancerException(String message) {
        super(message);
    }
}
