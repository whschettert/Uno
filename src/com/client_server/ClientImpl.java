/**
 * 
 */
package com.client_server;


import java.rmi.RemoteException;
import java.util.Scanner;

import com.unoGame.IUnoGame;

/**
 * @author Wagner
 *
 */
public class ClientImpl {
	
	private IUnoGame game;
	private int pId;
	private Scanner scanner;
	private boolean isTest;
	
	
	public ClientImpl(IUnoGame game, int pId, boolean isTest) throws RemoteException, InterruptedException{
		this.game = game;
		this.pId = pId;
		this.isTest = isTest;
	}
	
	public void start() throws RemoteException, InterruptedException{
		int matchFound = game.temPartida(pId);
		
		if (matchFound == 0);
			System.out.println("Waiting for match..");
			
		while(matchFound == 0) {
			Thread.sleep(3000);
			matchFound = game.temPartida(pId);
		}
		
		switch (matchFound) {
			case 2:
				System.out.println("Match found and you are player two");
				
				play();
			case 1:
				System.out.println("Match found and you are player one");
				play();
			case -1:
				System.out.println("An error has occured");
				break;
			case -2:
				System.out.println("Timeout reached");
				break;
			default:
				break;
		}
		
	}

	private void play() throws RemoteException, InterruptedException{
		int myTurn = 0;
		
		while (true) {
			myTurn = game.ehMinhaVez(pId);
			
			switch (myTurn) {
				case -2:
					System.out.println("Error: No two players yet");
					return;
				case -1 :
					System.out.println("An error has occured");
					return;
				case 0 :
					Thread.sleep(2000); // wait for your turn
					break;
				case 1 :
					int resultado = makeAMove();
					
					if (resultado == 2)
						System.out.println("Partida encerrada, voce demorou muito para jogar.");
					
					if (resultado == -3)
						System.out.println("Partida encerrada.");
					
					break;
				case 2 :
					System.out.println("You Won");
					return;
				case 3 :					
					System.out.println("You Lost");
					return;
				case 4 :
					System.out.println("There was a tie");
					return;
				case 5 :					
					System.out.println("You won by WO");
					return;
				case 6 :					
					System.out.println("You lost by WO");
					return;
				default:
					return;
}
			}
		}	
		
	private int makeAMove() throws RemoteException, InterruptedException{
		int currentCard = game.obtemCorAtiva(pId);
		
		return 0;
	}
	
}
