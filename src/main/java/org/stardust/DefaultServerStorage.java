package org.stardust;

import org.stardust.server.Server;

import java.util.ArrayList;
import java.util.List;

public class DefaultServerStorage implements ServerStorage {


    private final List<Server> servers = new ArrayList<>();


    @Override
    public void add(Server server) {
        servers.add(server);
    }

    @Override
    public boolean contains(Server server) {
        return servers.contains(server);
    }

    @Override
    public int getSize() {
        return servers.size();
    }

    @Override
    public void remove(Server server) {
        servers.remove(server);
    }

    @Override
    public boolean isEmpty() {
        return servers.isEmpty();
    }

    @Override
    public List<Server> getAll() {
        return servers;
    }
}
