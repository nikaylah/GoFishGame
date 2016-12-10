import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

	// public boolean checkCard(Card c){ // would check contains and call the
	// players hand---can' t access hand directly
	// return hand.contains(Card);
	// }
	//
	// public addCard(Card c){
	// hand.add(c);
	// }

	public static void main(String[] args) {

		Player p1 = new Player();
		Player p2 = new Player();

		Deck d1 = new Deck();

		int p1Score = 0;
		int p2Score = 0;

		d1.shuffle();
		// deal the cards
		p1.setHand(d1.dealHand());
		p2.setHand(d1.dealHand());

		System.out.println();
		System.out.println("PLAYER 1 HAND: " + p1);
		System.out.println("PLAYER 2 HAND: " + p2);

		// --------------------(Player 1 Go)----------------------------------

		System.out.println();
		System.out.println("(Player 1)");
		System.out.println("------DO YOU WANT TO PLAY OR PUT DOWN YOUR MATCHES?------");
		System.out.println("------TYPE (play) or (matches)-----");
		
		System.out.println();
		System.out.println("(Player 1) This is your hand: ");
		System.out.print(p1.getHand());
		System.out.println();
		Scanner input = new Scanner(System.in);
		String answer;
		answer = input.next();
		int location;

		int location1;// used for keeping track of matches
		int location2;

		while (true) {
			if (answer.equals("play")) {// The Play
				System.out.println();
				System.out.println("---Which card?(Type a location)----");
				System.out.println();
				System.out.println(p1.getHand());
				
				
//				while(true){
//					
//					try{
//						location = input.nextInt();
//						break;
//					}
//					
//					catch(InputMismatchException E){
//						
//					}
//					
//				}
				
				location = input.nextInt();
				
				
				Card card = p1.getHand().get(location - 1);
				System.out.println("Player 2 do you have this card " + card);

				if (p2.contains(card)) {
					p1.giveCard(p2.getCard(card));

					System.out.println(p1.getHand());
					System.out.println(p2.getHand());
				} else {
					System.out.println("Player 2 says 'Go Fish'");
					p1.giveCard(d1.getCard());// player 1 draws from deck
				}

			} else if (answer.equals("matches"))// (Putting down matches)
			{
				System.out.println("------Which 2 cards -----");
				System.out.println("------(Type in first Location)------");
				System.out.print(p1.getHand());
				location1 = input.nextInt();
				Card c1 = p1.getHand().get(location1 - 1);
				System.out.println("-------(Type in second Location)------- ");
				System.out.print(p1.getHand());
				location2 = input.nextInt();
				Card c2 = p1.getHand().get(location2 - 1);

				if (c1.getSuit().equals(c2.getSuit())) {
					p1.getCard(c1);
					p1.getCard(c2);

					p1Score++;

					System.out.println();
					System.out.println(p1.getHand());
					System.out.println("Player 1 score: " + p1Score);
				}
				
				
			}

			if (p1.getHand().size() == 0 && d1.getSize() == 0) {
				break;
			}

			// --------------------(Player 2
			// Go)----------------------------------

			System.out.println();
			System.out.println("----------------------------(Player 2)----------------------------");
			System.out.println("------DO YOU WANT TO PLAY OR PUT DOWN YOUR MATCHES?------");
			System.out.println("------TYPE (play) or (matches)-----");
			System.out.println("This is your hand: ");
			System.out.println(p2.getHand());
			
			if (answer.equals("play")) {// The Play
				System.out.println("---Which card?(Type a location)----");
				System.out.println(p2.getHand());
				location = input.nextInt();
				Card card = p2.getHand().get(location - 1);
				System.out.println("Player 1 do you have this card " + card);

				if (p1.contains(card)) {
					p1.giveCard(p1.getCard(card));

					System.out.println(p2.getHand());
					System.out.println(p1.getHand());
				} else {
					System.out.println("Player 1 says 'Go Fish'");
					p2.giveCard(d1.getCard());// player 1 draws from deck
				}

			} else if (answer.equals("matches"))// (Putting down matches)
			{
				System.out.println("------Which 2 cards -----");
				System.out.println("------(Type in first Location)------");
				System.out.println(p2.getHand());
				location1 = input.nextInt();
				Card c3 = p2.getHand().get(location1 - 1);
				System.out.println("-------(Type in second Location)------- ");
				System.out.println(p2.getHand());
				location2 = input.nextInt();
				Card c4 = p2.getHand().get(location2 - 1);

				if (c3.getSuit().equals(c4.getSuit())) {
					p2.getCard(c3);
					p2.getCard(c4);

					p1Score++;

					System.out.println();
					System.out.println(p2.getHand());
					System.out.println("Player 2 score: " + p2Score);
				}

				if (p2.getHand().size() == 0 && d1.getSize() == 0) {
					break;
				}

			} // end while

		} // end main

	}// end class

}

