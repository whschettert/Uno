package com.States;

import java.util.ArrayList;
import java.util.List;

import com.unoGame.Player;
/**
 * 
 * @author Wagner
 *
 */
public class PlayerCollections {

	private static List<Player> fullListOfPlayers;

	public static void PlayerCollections(){
		fullListOfPlayers = new ArrayList<>();
	}

	public static int registerPlayer(Player p) {
		if (fullListOfPlayers.contains(p))
			return -1;
		fullListOfPlayers.add(p);
		return p.getpId();
	}

	public static Player findPlayer(int id) {
		for (Player p : fullListOfPlayers)
			if (p.getpId() == id)
				return p;
		return null;
	}
}
