package org.stardust.strategy;

import org.stardust.server.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobinLoadBalancerStrategy implements LoadBalancerStrategy {

    private final AtomicInteger counter = new AtomicInteger(0);

    @Override
    public Server getNextServer(List<Server> servers) {

        int index = counter.incrementAndGet() % servers.size();
        return servers.get(index);
    }
}
