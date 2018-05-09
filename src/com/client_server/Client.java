package com.client_server;
import com.unoGame.IUnoGame;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.UUID;

public class Client {

    private static Scanner scanner;

    public static void main(String[] args) throws InterruptedException {
        try {
            IUnoGame game = (IUnoGame)Naming.lookup("//localhost/UnoGame");

            scanner = new Scanner(System.in);
            String name;

            if (args.length > 0 && args[0].equals("t"))
                name = UUID.randomUUID().toString();
            else {
                System.out.println("Your name:");
                name = scanner.nextLine();
            }

            int idP = game.registraJogador(name);

            if (idP == -1) {
                System.out.println("User already exists.");
                return;
            }

            if (idP == -2) {
                System.out.println("Max number of players reached.");
                return;
            }

            System.out.println("Your id: " + idP);

            ClientImpl client = new ClientImpl(game, idP, args.length > 0 && args[0].equals("t"));

            client.start();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

}
