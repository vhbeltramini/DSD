package com.udesc.socket.example.simple.example.server;

import com.udesc.socket.example.simple.example.service.Handler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(80);
        server.setReuseAddress(true);

        String clientSentence;
        String capitalizedSentence;
        while (true) {
            System.out.println("Waiting for connection");

            Socket connectionSocket = server.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();

            String[] data = clientSentence.split(";");

            String response = handlerCrud(data);


            System.out.println("Received: " + response);
            capitalizedSentence = clientSentence.toUpperCase() + '\n';
            outToClient.writeBytes(capitalizedSentence);
        }
    }

    private static String handlerCrud(String[] data) {
        Handler handler = new Handler(Integer.parseInt(data[1]));

        System.out.println("data:" + Arrays.toString(data));

        switch (data[0]) {
            case "CREATE":
                if (handler.addPessoa(data)) {
                    return "Pessoa Adicionada";
                }
                return "Err";
            case "GET":
                return handler.getPessoa(data);
            case "UPDATE":
            case "DELETE":
            case "LIST":
            default:
                return "Not implemented";
        }

    }
}
