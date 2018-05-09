package com.client_server;
import java.rmi.Naming;
import java.rmi.RemoteException;

import com.unoGame.UnoGame;

/**
 * 
 * @author Wagner
 *
 */
public class Server {

    public static void main(String[] args) {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(8080);
            System.out.println("RMI registry ready.");
        } catch (RemoteException e) {
            System.out.println("RMI registry already running.");
        }
        try {
            Naming.rebind ("UnoGame", new UnoGame());
            System.out.println ("UnoGame is ready.");
        } catch (Exception e) {
            System.out.println ("UnoGame failed:");
            e.printStackTrace();
        } 
    }

}