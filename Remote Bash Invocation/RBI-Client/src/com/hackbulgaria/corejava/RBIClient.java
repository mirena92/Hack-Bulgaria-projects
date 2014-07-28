package com.hackbulgaria.corejava;

import java.net.Socket;
import java.util.Scanner;


public class RBIClient {

    public static void main(String[] args) {
        
        String hostName = args[0];
        Scanner sc = null;
        
        try {
            Socket socket = new Socket(hostName, RBIProtocol.PORT); 
            while(true) {
            sc = new Scanner(System.in);
            String command = sc.next();
            RBIProtocol.writeMessage(socket, command);
            System.out.println(RBIProtocol.readMessage(socket));
            }
        }
        catch (Exception e) {}       
        sc.close();
    }
}
