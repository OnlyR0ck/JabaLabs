package com.fourthLab.server;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Server {
    //region Fields

    private ServerSocket serverSocket;
    private Socket acceptedClientSocket;
    private FileWriter fileWriter;

    private int port;
    private String logFileName = "logs.txt";

    //endregion


    //region Properties

    public ServerSocket getServerSocket() {
        return serverSocket;
    }


    public int getPort() {
        return port;
    }


    public void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }


    //endregion


    //region Class lifecycle

    public Server() throws IOException {
        this.serverSocket = null;
        this.acceptedClientSocket = null;
        this.port = 0;
        fileWriter = new FileWriter(logFileName, true);
    }


    public Server(int port) throws IOException {
        this.port = port;
        fileWriter = new FileWriter(logFileName, true);
    }

    //endregion


    //region Public methods

    public void startTCPServer() throws IOException {

        ObjectInputStream clientInput;
        ObjectOutputStream clientOutput;

        try {

            serverSocket = new ServerSocket(port);

            String serverLog = String.format("TCP Server starting at %s:%d",
                    serverSocket.getInetAddress(),
                    serverSocket.getLocalPort());

            System.out.printf(serverLog);

            Log(serverLog);

            acceptedClientSocket = serverSocket.accept();
            serverLog = String.format("Date: %s, Time: %s\n",
                    LocalDate.now(),
                    LocalTime.now());
            serverLog += String.format("New connection: %s : %d",
                    acceptedClientSocket.getLocalAddress(),
                    acceptedClientSocket.getPort());
            Log(serverLog);
            clientInput = new ObjectInputStream(acceptedClientSocket.getInputStream());
            clientOutput = new ObjectOutputStream(acceptedClientSocket.getOutputStream());

            String receivedMessage;
            do {
                receivedMessage = (String) clientInput.readObject();

                Log(String.format("Message received: %s", receivedMessage));

                if (receivedMessage.equals("exit")) {
                    break;
                }

                float answer = calculateTax(Integer.parseInt(receivedMessage));
                Log(String.format("Server output: %f", answer));
                clientOutput.writeObject(answer);
            }
            while (true);

            Log("Shutting down...");

            clientInput.close();
            clientOutput.close();
            acceptedClientSocket.close();
            serverSocket.close();
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
            Log(e.getMessage());
        }
    }

    public void startUDPServer() {
        DatagramSocket datagramSocket = null;
        try {
            byte[] byteBuffer = new byte[256];
            datagramSocket = new DatagramSocket(port);

            String serverLog = String.format("UDP Server starting at %s:%d",
                    datagramSocket.getInetAddress(),
                    datagramSocket.getLocalPort());

            System.out.printf(serverLog);

            Log(serverLog);

            do {
                DatagramPacket receivedMessage = new DatagramPacket(byteBuffer, byteBuffer.length);
                datagramSocket.receive(receivedMessage);

                String message = new String(receivedMessage.getData());

                if (message.equals("exit")) {
                    Log("Shutting down");
                    break;
                }

                Log(String.format("Received message: %s", message));

                String[] splitedMessage = message.split(" ");
                ArrayList<Float> nums = new ArrayList<>();

                for (String variable : splitedMessage) {
                    nums.add(Float.parseFloat(variable));
                }

                double outputMessage = calculateFunction(nums);
                System.out.printf("The answer is: %f", outputMessage);

                byteBuffer = String.format("%f", outputMessage).getBytes(StandardCharsets.UTF_8);
                DatagramPacket outputResponse = new DatagramPacket(byteBuffer, byteBuffer.length,
                        receivedMessage.getAddress(), receivedMessage.getPort());

                outputResponse.setData(byteBuffer);
                outputResponse.setLength(byteBuffer.length);

                datagramSocket.send(outputResponse);

            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }
    }

    //endregion


    //region Private methods

    private void Log(String stringToAppend) throws IOException {
        if (fileWriter != null) {
            fileWriter.append(stringToAppend + "\n");
            fileWriter.flush();
        }
    }

    private float calculateTax(int salary) {

        if (salary < 100000) {
            return salary * 0.05f;
        } else if (salary < 500000) {
            return salary * 0.1f;
        } else if (salary > 500000) {
            return salary * 0.15f;
        }

        return Integer.MIN_VALUE;
    }

    private double calculateFunction(@NotNull ArrayList<Float> nums) {
        float x = nums.get(0);
        float y = nums.get(1);
        float z = nums.get(2);

        double answer = 2 * Math.cos(x - Math.PI / 6) /
                (Math.exp(0.5f) + Math.pow(Math.sin(y), 2) *
                        (1 + Math.pow(z, 2) / (3 - Math.pow(z, 5) / 5)));

        return answer;
    }


    private byte[] convertDoubleToByteArray(double number) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(Double.BYTES);
        byteBuffer.putDouble(number);
        return byteBuffer.array();
    }


    public static double toDouble(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getDouble();
    }
    //endregion
}