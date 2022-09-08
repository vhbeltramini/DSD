package com.udesc.socket.example.simple.example.server;

import com.udesc.socket.example.simple.example.model.Aluno;
import com.udesc.socket.example.simple.example.model.Pessoa;
import com.udesc.socket.example.simple.example.model.Professor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static void main(String argv[]) throws Exception {
        while (true) {
            String testResult;
            int readedBytes;

            Scanner scan = new Scanner(System.in);
            System.out.println("Insira as informações");
            testResult = scan.nextLine();

            System.out.println("Creating connection");
            try (Socket conn = new Socket("192.168.31.155", 80);) {
                System.out.println("Connected");
                InputStream inputStream = conn.getInputStream();
                DataOutputStream outToServer = new DataOutputStream(conn.getOutputStream());

//                System.out.println(inputStream.read());

                outToServer.writeBytes(testResult + '\n');

                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(inputStream));
                System.out.println(inFromServer.readLine());


//                byte[] dataBytes = new byte[1024];
//                readedBytes = inputStream.read(dataBytes);
//                while (readedBytes >= 0) {
//                    String dataString = new String(dataBytes, 0, readedBytes);
//                    System.out.println(dataString);
//                    readedBytes = inputStream.read(dataBytes);
//                }

            } catch (UnknownHostException e) {
                System.out.println("Host not founded");
                e.printStackTrace();
            }
        }



    }

}
