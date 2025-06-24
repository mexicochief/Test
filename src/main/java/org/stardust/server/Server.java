package org.stardust.server;

public interface Server {

    void handle(String request);

    String getName();
}
