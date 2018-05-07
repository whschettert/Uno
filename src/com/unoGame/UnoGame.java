package com.unoGame;

import com.States.GameState;
import com.States.PlayerState;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 
 * @author Wagner
 *
 */
public class UnoGame extends UnicastRemoteObject implements IUnoGame{

    public UnoGame() throws RemoteException{
        super();
    }

    /**
     * @param pName string with player name
     * @return user ID - unique identifier
     * -1 if user already exists
     * -2 if max number of players reached
     * @throws RemoteException
     */
    @Override
    public int registraJogador(String pName) throws RemoteException {

        Player p = new Player(pName);
        int id = PlayerState.registerPlayer(p);
        GameState.addPlayer(PlayerState.findPlayer(id));

        return id;
    }

    /**
     * @param pID user ID
     * @return -1 if error, 0 if ok
     * @throws RemoteException
     */
    @Override
    public int encerraPartida(int pID) throws RemoteException {
        return 0;
    }

    /**
     * @param pID user ID
     * @return -2 Timeout
     * -1 Error
     * 0 no match yet
     * 1 match found and you are player one
     * 2 match found and you are player two
     * @throws RemoteException
     */
    @Override
    public int temPartida(int pID) throws RemoteException {
        return 0;
    }

    /**
     * @param pID user ID
     * @return empty string for error, otherwise opponent name
     * @throws RemoteException
     */
    @Override
    public String obtemOponente(int pID) throws RemoteException {
        return null;
    }

    /**
     * @param pID user ID
     * @return -2 error no two players yet
     * -1 error
     * 0 not your turn
     * 1 yes your turn
     * 2 you won
     * 3 you lose
     * 4 there was a tie
     * 5 win by WO
     * 6 lose by WO
     * @throws RemoteException
     */
    @Override
    public int ehMinhaVez(int pID) throws RemoteException {
        return 0;
    }

    /**
     * @param pID user ID
     * @return -2 error no two players yet
     * -1 error
     * otherwise number of cards left in the trunk
     * @throws RemoteException
     */
    @Override
    public int obtemNumCartasBaralho(int pID) throws RemoteException {
        return 0;
    }

    /**
     * @param pID user ID
     * @return -2 error no two players yet
     * -1 error
     * otherwise number of cards in the player hand
     * @throws RemoteException
     */
    @Override
    public int obtemnumCartas(int pID) throws RemoteException {
        return 0;
    }

    /**
     * @param pID user ID
     * @return -2 error no two players yet
     * -1 error
     * otherwise number of cards in the opponent hand
     * @throws RemoteException
     */
    @Override
    public int obtemNumCartasOponente(int pID) throws RemoteException {
        return 0;
    }

    /**
     * @param pID user ID
     * @return empty String if error, otherwise String with the cards in player hand
     * @throws RemoteException
     */
    @Override
    public String mostraMao(int pID) throws RemoteException {
        return null;
    }

    /**
     * @param pID user ID
     * @return empty String if error, otherwise String with the card in the top of the discard pile
     * @throws RemoteException
     */
    @Override
    public String obtemCartaMesa(int pID) throws RemoteException {
        return null;
    }

    /**
     * @param pID user ID
     * @return value of the current color card
     * 0 for blue
     * 1 for yellow
     * 2 for green
     * 3 for red
     * @throws RemoteException
     */
    @Override
    public int obtemCorAtiva(int pID) throws RemoteException {
        return 0;
    }

    /**
     * @param pID user ID
     * @return 0 for success, -1 for error
     * @throws RemoteException
     */
    @Override
    public int compraCarta(int pID) throws RemoteException {
        return 0;
    }

    /**
     * @param pID user ID
     * @return 1 for ok
     * 0 invalid card
     * -1 player not found
     * -2 match not started
     * -3 invalid param
     * -4 not player turn
     * @throws RemoteException
     */
    @Override
    public int jogaCarta(int pID) throws RemoteException {
        return 0;
    }

    /**
     * @param pID user ID
     * @return -1 player not found
     * -2 match not started
     * -3 match not finished
     * otherwise points for player
     * @throws RemoteException
     */
    @Override
    public int obtemPontos(int pID) throws RemoteException {
        return 0;
    }

    /**
     * @param pID user ID
     * @return -1 player not found
     * -2 match not started
     * -3 match not finished
     * otherwise points for opponent
     * @throws RemoteException
     */
    @Override
    public int obtemPontosOponente(int pID) throws RemoteException {
        return 0;
    }
}