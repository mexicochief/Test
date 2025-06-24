package org.stardust.strategy;

import org.stardust.server.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class RandomLoadBalancerStrategy implements LoadBalancerStrategy {

    ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();


    @Override
    public Server getNextServer(List<Server> servers) {

        int index = threadLocalRandom.nextInt(servers.size());
        return servers.get(index);
    }
}
