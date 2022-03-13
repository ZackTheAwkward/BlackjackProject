package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.BlackJackHand;
import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.DealerBlackJackHand;
import com.skilldistillery.cards.common.Deck;

public class BlackJackApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BlackJackHand bj = new BlackJackHand();
		DealerBlackJackHand dh = new DealerBlackJackHand();

		System.out.println("Welcome to the table user, we're about to shuffle a new deck");
		Deck d = new Deck();
		d.shuffle();

		boolean keepPlaying = true;

		try {
			while (keepPlaying) {
				System.out.println("Are you ready to get a new hand?");
				System.out.println("1. Deal me in!");
				System.out.println("2. No count me out");
				int userInput = sc.nextInt();
				sc.nextLine();

				if (userInput == 1) {
					System.out.println("Alrighty let's deal out this hand");
					bj.addCard(d.dealCard());
					dh.addCard(d.dealCard());
					bj.addCard(d.dealCard());
					dh.addCard(d.dealCard());
					System.out.println("Your hand is " + bj.toString() + " " + bj.getHandValue());
					System.out.println("The dealer shows his one card " + dh.partName() + " " + dh.partValue());

				}

				if (userInput == 2) {
					System.out.println("Okay we'll see you next time then!");
					keepPlaying = false;
					break;
				} else if (userInput != 1 && userInput != 2) {
					System.out.println("Invalid Response, please try again");
					continue;
				}

				System.out.println("Okay lets check for BlackJacks");

				if (dh.isBlackjack() == true) {
					System.out.println("The dealer has a BlackJack");
					break;
				}

				if (bj.isBlackjack() == true) {
					System.out.println("WINNER WINNER CHICKEN DINNER");
					break;
				}

				System.out.println("Neither player has a BlackJack, let's continue");
				System.out.println();

				System.out.println("1. Hit");
				System.out.println("2. Stand");

				boolean hitAgain = true;
				while (hitAgain) {
					int hitOpt = sc.nextInt();
					sc.nextLine();

					if (hitOpt == 1) {

						bj.addCard(d.dealCard());
						bj.getHandValue();

						System.out.println("Okay your hand is now " + bj.toString() + " " + bj.getHandValue());

						if (bj.isBust() == true) {
							break;
						}
						if (bj.isBust() != true) {
							System.out.println();
							System.out.println("1. Hit Again");
							System.out.println("2. Stand");
							continue;
						}

					} else if (hitOpt == 2) {
						hitAgain = false;
					} else if (hitOpt != 1 && hitOpt != 2) {
						System.out.println("Invalid Response, Please try again");
						continue;
					}

					if (bj.isBust() == true) {
						System.out.println("You Busted, Dealer wins");
						break;
					}

					System.out.println("The dealer reveals his hand");
					System.out.println(dh.toString() + dh.getHandValue());
					boolean dealerBible = true;
					while (dealerBible) {

						if (dh.getHandValue() >= 17) {
							dealerBible = false;
							continue;
						} else if (dh.getHandValue() > bj.getHandValue()) {
							dealerBible = false;
							continue;
						} else if (dh.getHandValue() < 17) {
							dh.addCard(d.dealCard());
							System.out.println(
									"The dealer hits, his hand is now " + dh.toString() + " " + dh.getHandValue());
							dealerBible = true;

							if (dh.isBust() == true) {
								System.out.println("WOOHOO Dealer Busted");
								System.out.println("You win");
								break;
							} else if (dh.isBust() != true) {
								continue;
							}
						}
					}

					while (dh.isBust() != true && bj.isBust() != true) {
						if (dh.getHandValue() == bj.getHandValue()) {
							System.out.println("Push");
							break;
						} else if (dh.getHandValue() > bj.getHandValue()) {
							System.out.println("Dealer Wins");
							break;
						} else if (bj.getHandValue() > dh.getHandValue()) {
							System.out.println("You win!!");
							break;
						}

					}
					dh.clear();
					bj.clear();

				}
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
