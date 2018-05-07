/**
 * 
 */
package com.unoGame;

/**
 * @author Wagner
 *
 */
public enum ETurn {
	P("Player"), O("Opponent");
	
	private String text;
	
	ETurn(String text){
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}
}
