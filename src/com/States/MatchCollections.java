package com.States;

import java.util.ArrayList;
import java.util.List;

import com.unoGame.UnoGame;

/**
 * 
 * @author Wagner
 *
 */
public class GameState {

	private static final int P_LIMIT = 2;
	
	private static List<Match> matches = new ArrayList<>();
	
	public static void addPlayer(Player p) {
		for (Match match : matches) {
			if(match.getPNumbers() < P_LIMIT) {
				match.addPlayer(p)
				if(match.getNumPlayers() == P_LIMIT)
					match.setIsMatchStarted();
				return;
			}
		}

		Match match = new Match();
		match.addPlayer(p);
		matches.add(match);
		return;
	}


}
