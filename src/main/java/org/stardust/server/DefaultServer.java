package org.stardust.server;

public class DefaultServer implements Server {

    private final String name;

    public DefaultServer(String name) {
        this.name = name;
    }

    @Override
    public void handle(String request) {
        System.out.println("server: " + name + " got " + request);
    }

    @Override
    public String getName() {
        return name;
    }
}
