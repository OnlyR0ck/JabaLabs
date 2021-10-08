package com.fourthLab.client;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("0.0.0.0", 2525);
        try {
            client.startUdpClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}