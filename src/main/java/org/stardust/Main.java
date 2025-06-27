package org.stardust;

import io.vertx.core.Vertx;
import org.stardust.server.DefaultServer;
import org.stardust.strategy.LoadBalancerStrategy;
import org.stardust.strategy.RoundRobinLoadBalancerStrategy;

public class Main {
    public static void main(String[] args) {

        ServerStorage serverStorage = new DefaultServerStorage();
        serverStorage.add(new DefaultServer("Finland server"));
        serverStorage.add(new DefaultServer("Russia server"));
        serverStorage.add(new DefaultServer("USA server"));

        LoadBalancerStrategy loadBalancerStrategy = new RoundRobinLoadBalancerStrategy();
        LoadBalancer loadBalancer = new LoadBalancer(serverStorage, loadBalancerStrategy);

        Vertx vertx = Vertx.vertx();

        vertx.createHttpServer()
                .requestHandler(request -> {

                    loadBalancer.routeRequest(request.getParam("message"));
                    request.response().end("message received");
                })
                .listen(8081);
    }
}