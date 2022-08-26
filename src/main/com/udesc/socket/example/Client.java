package com.udesc.socket.example;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String argv[]) throws Exception {
        System.out.println("Creating connection");

//        try (Socket conn = new Socket("10.60.182.53", 80);) {
        try (Socket conn = new Socket("10.60.89.169", 80);) {
            System.out.println("Connected");
            InputStream inputStream = conn.getInputStream();

            byte[] dataBytes = new byte[1024];
            int readedBytes = inputStream.read(dataBytes);
            while (readedBytes >= 0) {
                String dataString = new String(dataBytes, 0, readedBytes);
                System.out.println(dataString);
                readedBytes = inputStream.read(dataBytes);
            }

        } catch (UnknownHostException e) {
            System.out.println("Host not founded");
            e.printStackTrace();
        }

    }
}
