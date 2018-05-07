package com.unoGame;

/**
 * 
 * @author Wagner
 *
 */
public enum ECardType {	
    Z("Zero"), O("One"), TW("Two"), TH("Three"),
    FO("Four"), FI("Five"), SI("Six"), SE("Seven"),
    E("Eight"), N("Nine"), SKIP("Skip"), REVERSE("Reverse"),
    P_TWO("Plus Two"), P_FOUR("Plus Four"), WILD("Wild");
	
	private String text;	
	
	ECardType(String text){
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}
	
}
