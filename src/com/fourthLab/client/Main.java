package com.fourthLab.client;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("0.0.0.0", 2525);
        client.startConnection();
    }
}