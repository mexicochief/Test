package org.stardust;

import org.stardust.error.LoadBalancerException;
import org.stardust.server.Server;
import org.stardust.strategy.LoadBalancerStrategy;

import java.util.List;

public class LoadBalancer {

    private static final int CAPACITY = 10;

    public static final String NULL_SERVICE_EXCEPTION = "Server instance should not to be null";

    public static final String CAPACITY_REACHED_EXCEPTION = "Max server capacity reached";

    public static final String NO_SERVERS_AVAILABLE = "No servers available";

    private LoadBalancerStrategy strategy;

    private final ServerStorage serverStorage;

    public LoadBalancer(ServerStorage serverStorage, LoadBalancerStrategy loadBalancerStrategy) {
        this.serverStorage = serverStorage;
        this.strategy = loadBalancerStrategy;
    }

    public synchronized void addServer(Server server) {

        if (server == null) {
            throw new LoadBalancerException(NULL_SERVICE_EXCEPTION);
        }
        if (serverStorage.getSize() >= CAPACITY) {
            throw new LoadBalancerException(CAPACITY_REACHED_EXCEPTION);
        }
        if (!serverStorage.contains(server)) {
            serverStorage.add(server);
        }
    }

    public synchronized void removeServer(Server server) {
        serverStorage.remove(server);
    }

    public void routeRequest(String request) {
        if (serverStorage.isEmpty()) {
            throw new LoadBalancerException(NO_SERVERS_AVAILABLE);
        }

        Server server = strategy.getNextServer(serverStorage.getAll());
        server.handle(request);
    }

    public void setStrategy(LoadBalancerStrategy strategy) {
        this.strategy = strategy;
    }
}
