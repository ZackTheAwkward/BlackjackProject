package com.skilldistillery.cards.common;

public class BlackJackHand extends Hand {

	
	
	
	
	
	@Override
	public void addCard(Card card) {
		super.addCard(card);
	}
	
	
	
	@Override
	public int getHandValue() {
		int handValue = 0;
		for (Card card : cards) {
			handValue += card.getValue();
			
		}
		return handValue;
	}
	
	public boolean isBlackjack() {
		boolean isBlackjack = false;
		if(getHandValue() == 21) {
			isBlackjack = true;
		} else if(getHandValue() != 21) {
			isBlackjack = false;
		}
		return isBlackjack;
		
	}
	public boolean isBust() {
		boolean isBust = false;
		if(getHandValue() > 21) {
			isBust = true;
		} else if (getHandValue() < 21) {
			isBust = false;
		}
		
		return isBust;
	}

}
