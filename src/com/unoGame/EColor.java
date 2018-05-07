package com.unoGame;

/**
 * 
 * @author Wagner
 *
 */
public enum EColor {
	R("RED"), Y("YELLOW"), G("GREEN"), B("BLUE"), S("SPECIAL");
	
	private String text;
	
	EColor(String text){
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}
	
}
