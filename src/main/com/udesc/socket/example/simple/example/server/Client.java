package com.udesc.socket.example.simple.example.server;

import com.udesc.socket.example.simple.example.model.Aluno;
import com.udesc.socket.example.simple.example.model.Pessoa;
import com.udesc.socket.example.simple.example.model.Professor;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static void main(String argv[]) throws Exception {

        Scanner scan = new Scanner(System.in);
        String ipConfig;

        System.out.println("Insira o ip do servidor");
        ipConfig = scan.nextLine();

        String inputData;

        System.out.println("Creating connection");


            System.out.println("Connected");
            while (true) {
                try (Socket conn = new Socket(ipConfig, 80);) {

//                    InputStream inputStream = conn.getInputStream();
                    System.out.println("");
                    System.out.println("Insira as informações");
                    inputData = scan.nextLine();

                    DataOutputStream outToServer = new DataOutputStream(conn.getOutputStream());


                    outToServer.writeBytes(inputData + '\n');

                    ObjectInputStream in = new ObjectInputStream(conn.getInputStream());
                    String response = (String) in.readObject();

                    System.out.println("Response received: " + response);
            } catch (UnknownHostException e) {
                    System.out.println("Host not founded");
                    e.printStackTrace();

            }




            }



    }

}
