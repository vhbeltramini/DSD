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

        String test = "teste";
        String testResult;
        Pessoa pessoa;

//        Scanner scan = new Scanner(System.in);
//
//        System.out.println("A pessoa a ser adicionada é 1:professora ou 2:aluno?");
//        int personType = Integer.parseInt(scan.nextLine());
//        switch (personType) {
//            case 1:
//                pessoa = new Aluno();
//            case 2:
//                pessoa = new Professor();
//            default:
//                System.out.println("melhorar isso aqui");
//        }
//
//        System.out.println("Nome da pessoa");
//





        System.out.println("Creating connection");
        try (Socket conn = new Socket("10.60.89.169", 80);) {
            System.out.println("Connected");
            InputStream inputStream = conn.getInputStream();
            DataOutputStream outToServer = new DataOutputStream(conn.getOutputStream());

            outToServer.writeBytes(test + '\n');

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            testResult = inFromServer.readLine();
            System.out.println(testResult);
            conn.close();
        } catch (UnknownHostException e) {
            System.out.println("Host not founded");
            e.printStackTrace();
        }

    }

}