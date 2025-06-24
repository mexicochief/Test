package org.stardust;

import org.stardust.server.Server;

import java.util.List;

public interface ServerStorage {


    void add(Server server);

    boolean contains(Server server);

    int getSize();

    void remove(Server server);

    boolean isEmpty();

    List<Server> getAll();
}
