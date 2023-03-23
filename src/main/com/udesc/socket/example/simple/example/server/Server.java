package com.udesc.socket.example.simple.example.server;

import com.udesc.socket.example.simple.example.model.Turma;
import com.udesc.socket.example.simple.example.service.Handler;
import com.udesc.socket.example.simple.example.service.PessoaService;
import com.udesc.socket.example.simple.example.service.TurmaService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(80);
        server.setReuseAddress(true);

        String clientSentence;
        String capitalizedSentence;
        while (true) {
            try {
                System.out.println("Waiting for connection");

                Socket connectionSocket = server.accept();
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                ObjectOutputStream out = new ObjectOutputStream(connectionSocket.getOutputStream());

                clientSentence = inFromClient.readLine();

                String[] data = clientSentence.split(";");

                String response = handlerCrud(data);

                System.out.println("Received: " + response);

                out.writeObject(response);
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    private static String handlerCrud(String[] data) {
        if (data.length <= 1) {
            return "Invalid command";
        }
        String dataType = data[1].toUpperCase();
        if (Objects.equals(dataType, PessoaService.ALUNO) || Objects.equals(dataType, PessoaService.PROFESSOR)) {
            return handlerPessoa(data);
        } else if (Objects.equals(dataType, TurmaService.TURMA)) {
            return handlerTurma(data);
        }
        return "Invalid command";
    }

    private static String handlerPessoa(String[] data) {
        Handler handler = new Handler(data[1].toUpperCase());

        System.out.println("data:" + Arrays.toString(data));

        switch (data[0].toUpperCase()) {
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
    private static String handlerTurma(String[] data) {
        Handler handler = new Handler(data[1].toUpperCase());

        System.out.println("data:" + Arrays.toString(data));

        switch (data[0].toUpperCase()) {
            case "INSERT":
                return handler.CreateTurma(data);
            case "GET":
                return handler.GetTurma(data);
//            case "UPDATE":
//                return handler.UpdatePessoa(data);
            case "DELETE":
                return handler.DeleteTurma(data);
            case "LIST":
                return handler.ListTurma();
            case "INSERTP":
                return handler.AddPessoaTurma(data);
            case "DELETEP":
                return handler.RemovePessoaTurma(data);
            default:
                return "Not implemented";
        }
    }
}
