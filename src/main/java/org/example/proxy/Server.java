package org.example.proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    public static void main(String[] args) throws IOException {
        // Instancia del proxy
        Sumador sumador = new SumadorProxy();

        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Servidor TCP iniciado. Esperando conexión...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Cliente conectado desde: " + clientSocket.getInetAddress().getHostName());

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            try {
                List<Integer> sumandos = StringAListaDeIntegers(inputLine);
                out.println("Resultado: " + sumador.sumar(sumandos));
            } catch (Exception e){
                out.println("Error: " + e.getMessage());
            }
        }

        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    public static List<Integer> StringAListaDeIntegers(String numeros) throws Exception{
        List<Integer> sumandos = new ArrayList<>();
        String[] subcadenas = numeros.split(" ");
        for (String cadena: subcadenas){
            sumandos.add(Integer.parseInt(cadena));
        }
        return sumandos;
    }

}