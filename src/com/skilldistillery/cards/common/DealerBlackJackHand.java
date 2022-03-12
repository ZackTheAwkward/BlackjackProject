package com.skilldistillery.cards.common;

public class DealerBlackJackHand extends Hand {

	
	
	
	
	
	
	@Override
	public int getHandValue() {
		return 0;
	}
	public boolean isBlackjack() {
		return true;
		
	}
	public boolean isBust() {
		return true;
	}

}
