package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class BlackJack {
	Deck d = new Deck();
	List<Card> userHand = new ArrayList<>();
	List<Card> dealerHand = new ArrayList<>();
	int userHandValue = 0;
	int dealerHandValue = 0;

	public void shuffleDeck() {
		d.shuffle();
	}

	public void dealHand() {

		userHand.add(d.dealCard());
		dealerHand.add(d.dealCard());
		userHand.add(d.dealCard());
		dealerHand.add(d.dealCard());

		for (Card dealCard : userHand) {
			userHandValue += dealCard.getValue();
		}

		for (Card dealCard : dealerHand) {
			dealerHandValue += dealCard.getValue();
		}

		System.out.println("Your hand: " + userHand + " " + userHandValue);
		System.out.println("The dealer shows: " + dealerHand.get(0) + " " + dealerHand.get(0).getValue());

	}

	public void checkForTwentyOne() {

		while (true) {
			if (dealerHandValue == 21) {
				System.out.println("Dealer Wins");
				break;
			} else {
				if (userHandValue == 21) {
					System.out.println("User Wins");
					break;
				} else {
					continue;
				}
			}

		}

	}














}
