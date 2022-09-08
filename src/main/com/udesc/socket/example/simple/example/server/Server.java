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
            outToClient.writeBytes(response);
        }
    }

    private static String handlerCrud(String[] data) {
        Handler handler = new Handler(Integer.parseInt(data[1]));

        System.out.println("data:" + Arrays.toString(data));

        return switch (data[0]) {
            case "INSERT" -> handler.AddPessoa(data);
            case "GET" -> handler.GetPessoa(data);
            case "UPDATE" -> handler.UpdatePessoa(data);
            case "DELETE" -> handler.DeletePessoa(data);
            case "LIST" -> handler.ListPessoas();
            default -> "Not implemented";
        };
    }
}
