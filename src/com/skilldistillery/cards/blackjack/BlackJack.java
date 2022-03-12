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
	
	int newDealerHandValue = 0;

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
			if (dealerHandValue == 21 && userHandValue == 21) {
				System.out.println("Both the dealer and user were dealt a BlackJack");
				System.out.println("Push!");
				clear();
				break;
			} else if (dealerHandValue == 21) {
				System.out.println("Checking for BlackJack");
				System.out.println("Dealer Wins");
				clear();
				break;
			} else if ((userHandValue == 21)) {
				System.out.println("You got a BlackJack!");
				System.out.println("User Wins!");
				clear();
				break;

			} else {
				break;
			}
		}

	}

	public void hit() {
		int newUserHandValue = 0;
		userHand.add(d.dealCard());
		for (Card cardAdded : userHand) {
			newUserHandValue += cardAdded.getValue();
		}
		userHandValue = newUserHandValue;
		System.out.println("Your hand is now" + userHand + " " + userHandValue);
	}

	public void checkForBust() {
			if (userHandValue > 21) {
				System.out.println("User hand is over 21");
				System.out.println("Bust");
		}
	}
	public void checkForDealerBust() {
		if (dealerHandValue > 21) {
			System.out.println("Dealer hand is over 21");
			System.out.println("Bust");
		}
	}

	public void dealerBible() {
		System.out.println("The dealer hand is" + dealerHand + " " + dealerHandValue);
		boolean keepDrawing = true;
		while (keepDrawing) {
			if(dealerHandValue > userHandValue) {
				keepDrawing = false;
			}
		else if (dealerHandValue >= 17) {
				keepDrawing = false;
		
		}
			if (dealerHandValue < 17) {
				newDealerHandValue = 0;
				dealerHand.add(d.dealCard());
				
				for (Card cardAdded : dealerHand) {
					newDealerHandValue += cardAdded.getValue();
				}
				dealerHandValue = newDealerHandValue;
				System.out.println("The dealer's hand is now " + dealerHand + " " + dealerHandValue);
				break;
			}
		}
	}

	public void newDeck() {
		if (d.checkDeckSize() < 10) {
			Deck d = new Deck();
			d.shuffle();
		}
	}

	public void checkWinner() {
		if(dealerHandValue == userHandValue) {
			System.out.println("Push");
		}
		else if (newDealerHandValue > userHandValue) {
			System.out.println("Dealer Wins");
		}
		else if (userHandValue > newDealerHandValue) {
			System.out.println("User Wins");
		
		}
	}
	public void clear() {
		userHand.clear();
		int clearedUserHandValue = 0;
		userHandValue = clearedUserHandValue;
		dealerHand.clear();
		int clearedDealerHandValue = 0;
		dealerHandValue = clearedDealerHandValue;
	}
}
