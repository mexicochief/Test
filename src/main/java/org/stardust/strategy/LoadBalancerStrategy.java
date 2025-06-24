package org.stardust.strategy;

import org.stardust.server.Server;

import java.util.List;

public interface LoadBalancerStrategy {


    Server getNextServer(List<Server> servers);
}
