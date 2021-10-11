package com.fourthLab.server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Server server;
        try {
            server = new Server(2525);
            server.startTCPServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
