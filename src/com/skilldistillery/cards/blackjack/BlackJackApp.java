package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class BlackJackApp {

	public static void main(String[] args) {
		BlackJack bj = new BlackJack();
		Scanner sc = new Scanner(System.in);

		System.out.println("Are you ready to play some BlackJack?");
		System.out.println();
		System.out.println("Lets get started by shuffling the deck!");
		System.out.println("Commence Shuffling");
		bj.shuffleDeck();
		System.out.println();
		System.out.println("Alrighty now that we have a shuffled deck, lets play");
		System.out.println("I'm going to deal you a hand, and you just follow the options provided");
		bj.dealHand();
		bj.checkForTwentyOne();
		
		int userInput = sc.nextInt();
		
		while(userInput != 4) {
			System.out.println("1. Hit");
			System.out.println("2. Stand");
			if(userInput == 1) {
				
			}
			
		}
		
	}
}