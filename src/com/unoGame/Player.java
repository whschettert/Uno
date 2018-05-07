/**
 * 
 */
package com.unoGame;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wagner
 *
 */
public class Player {

	private int pId;
    private String pName;
    private List<Card> cardsInHand = new ArrayList<>();
    private int points = 0;

	public Player(String pName) {
		this.pName = pName;		
	}

	/**
	 * @return the pId
	 */
	public int getpId() {
		return pId;
	}

	/**
	 * @param pId the pId to set
	 */
	public void setpId(int pId) {
		this.pId = pId;
	}

	/**
	 * @return the pName
	 */
	public String getpName() {
		return pName;
	}

	/**
	 * @param pName the pName to set
	 */
	public void setpName(String pName) {
		this.pName = pName;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points the points to add
	 */
	public void addPoints(int points) {
		this.points += points;
	}
	
	/**
	 * 
	 * @return all the cards in the player hand
	 */
	public String showCardsInHand() {
        int index = 0;
        String handString = "Hand:"; 
        for (Card card: cardsInHand)             
            handString += "\n"+ (++index) +": "+card.toString();
        
        return handString; 
	}
	
	/**
	 * 
	 * @param index specified card
	 * @return the card that was played
	 */
	public Card playCard(int index) {
		return cardsInHand.remove(index-1);		
	}
	
	/**
	 * 
	 * @param cards, can be Null. add collection of cards, as per a draw 2 or 4
	 * @param card, can be Null. add a card
	 */
	public void addCards(ArrayList<Card> cards, Card card){
		if (cards!=null)
			cardsInHand.addAll(cards);
		else
			cardsInHand.add(card);
	}
	
	@Override
	public String toString() {
		return "Name: "+ pName + " ID: " + pId;
	}
}
