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
            ObjectOutputStream out = new ObjectOutputStream(connectionSocket.getOutputStream());

            clientSentence = inFromClient.readLine();

            String[] data = clientSentence.split(";");

            String response = handlerCrud(data);

            System.out.println("Received: " + response);
//            outToClient.writeBytes(response);

//            OutputStream outputStream = connectionSocket.getOutputStream();

            out.writeObject(response);

        }
    }

    private static String handlerCrud(String[] data) {
        Handler handler = new Handler(Integer.parseInt(data[1]));

        System.out.println("data:" + Arrays.toString(data));

        switch (data[0]) {
            case "INSERT":
                return handler.AddPessoa(data);
            case "GET":
                return handler.GetPessoa(data);
            case "UPDATE":
                return handler.UpdatePessoa(data);
            case "DELETE":
                return handler.DeletePessoa(data);
            case "LIST":
                return handler.ListPessoas();
            default:
                return "Not implemented";
        }
    }
}
