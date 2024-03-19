package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {
        String serverHostname = "localhost";
        int serverPort = 12345;

        System.out.println("Conectándose al servidor " + serverHostname + " en el puerto " + serverPort + "...");

        Socket clientSocket = new Socket(serverHostname, serverPort);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        String userInput;
        while (!(userInput = stdIn.readLine()).isEmpty()) {
            out.println(userInput);
            System.out.println("Servidor: " + in.readLine());
        }
        System.out.println("Cerrando conexión");
        out.close();
        in.close();
        stdIn.close();
        clientSocket.close();
    }
}

