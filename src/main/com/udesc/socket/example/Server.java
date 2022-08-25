package com.udesc.socket.example;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(80);
        server.setReuseAddress(true);

        while (true) {
            System.out.println("Waiting for connection");
            try (Socket conn = server.accept()) {
                System.out.println("Connecting with: " + conn.getInetAddress().getHostAddress());

                OutputStream outputStream = conn.getOutputStream();
                String message = "Hello Dark side";
                outputStream.write(message.getBytes());
            }
        }

    }

}
