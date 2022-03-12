package com.skilldistillery.cards.common;

public class BlackJackHand extends Hand {

	
	
	
	
	
	@Override
	public void addCard(Card card) {
		
		super.addCard(card);
	}
	
	
	
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
