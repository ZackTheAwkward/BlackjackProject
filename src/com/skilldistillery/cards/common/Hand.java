package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> cards;

	public Hand() {
		super();
		this.cards = new ArrayList<Card>();
	}
	

		@Override
	public String toString() {
		return "Hand: " + cards;
	}


		public void addCard(Card card) {
			this.cards.add(card);
		}
		
		public void clear() {
			cards.clear();
		}
		public abstract int getHandValue();
}
