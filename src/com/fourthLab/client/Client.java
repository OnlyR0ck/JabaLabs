package com.fourthLab.client;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Client {
    private Socket clientSocket;
    private int port;
    private String IPAddress;


    public Client() {
        this.port = 0;
        this.IPAddress = "";
    }


    public Client(String iPAddress, int port) {
        this.port = port;
        this.IPAddress = iPAddress;
    }


    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }


    public void setPort(int port) {
        this.port = port;
    }


    public Socket getClientSocket() {
        return clientSocket;
    }

    public void startConnection() {
        try {
            System.out.print("Trying to connect...");

            clientSocket = new Socket(IPAddress, port);

            System.out.printf("Connection established");
            System.out.print("\nType \"exit\" to exit.");

            BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
            ObjectOutputStream serverOut = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream serverIn = new ObjectInputStream(clientSocket.getInputStream());

            String clientMessage;
            while (true) {
                System.out.printf("\nEnter employee salary: ");

                clientMessage = cin.readLine();
                serverOut.writeObject(clientMessage);
                if (clientMessage.equals("exit")) {
                    System.out.print("Shutting down...");
                    break;
                }

                System.out.printf("\nServer response: the amount of tax %s", serverIn.readObject());
            }
            clientSocket.close();

            cin.close();
            serverOut.close();
            serverIn.close();

        } catch (Exception ex) {
            System.out.printf("Exception: %s.\n", ex.getMessage());
        }
    }

    public void startUdpClient() throws IOException {
        DatagramSocket clientDatagramSocket = null;
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));


        try {
            byte[] byteBuffer = new byte[256];
            clientDatagramSocket = new DatagramSocket();

            System.out.print("Udp client started!\n");
            while(true) {
                System.out.print("\nType \"exit\" to exit.");
                System.out.print("\nEnter x, y, z variables splited by spaces: ");
                String clientMessage = cin.readLine();

                if(clientMessage.equals("exit"))
                {
                    break;
                }

                byteBuffer = clientMessage.getBytes(StandardCharsets.UTF_8);
                DatagramPacket clientPacket = new DatagramPacket(byteBuffer, byteBuffer.length,
                        InetAddress.getByName("127.0.0.1"), port);

                clientDatagramSocket.send(clientPacket);

                DatagramPacket receivedPacket = new DatagramPacket(byteBuffer, byteBuffer.length);
                clientDatagramSocket.receive(receivedPacket);

//                clientMessage = new String(receivedPacket.getData()).trim();
                String answer = new String(receivedPacket.getData());
                System.out.printf("The answer is: %s", answer);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if (clientDatagramSocket != null)
            {
                clientDatagramSocket.close();
            }

            cin.close();
        }
    }

    public static double toDouble(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getDouble();
    }
}

