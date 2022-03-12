package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class BlackJackApp {

	public static void main(String[] args) {
		BlackJack bj = new BlackJack();
		Scanner sc = new Scanner(System.in);

		bj.newDeck();
		bj.shuffleDeck();
		System.out.println("Lets play some BlackJack, we've got a new deck shuffled and ready");
		boolean keepPlaying = true;
		while (keepPlaying) {

			bj.dealHand();
			bj.checkForTwentyOne();
			System.out.println("Neither player has a BlackJack, let's continue");

			System.out.println("1. Hit");
			System.out.println("2. Stand");

			int userInput = sc.nextInt();

			if (userInput == 1) {
				bj.hit();
				bj.checkForBust();
				System.out.println("1. Hit");
				System.out.println("2. Stand");
				continue;
			}
			if (userInput == 2) {
				bj.dealerBible();
				bj.checkForBust();
				bj.checkWinner();
				continue;
			}

			System.out.print("Would you like to keep going?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			if (userInput == 1) {
				continue;
			} else if (userInput == 2) {
				System.out.println("GoodBye!");
				keepPlaying = false;
				break;
			}
		}
	}
}
