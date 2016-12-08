import java.util.ArrayList;
import java.util.Scanner;

public class GameController {

	public static void main(String[] args) {
		//creates an array of players with a maximum of four players.
		Scanner input = new Scanner(System.in);
		Player[] players;
		while(true) {
		System.out.println("How many players do you want?");
		players = new Player[Integer.parseInt(input.nextLine())];
		if (players.length > 4) {
			System.out.println("You cannot have more than 4 players.");
			

		}else {
			break;
		}
		}
		
		for (int i = 0; i < players.length; i++) {
			System.out.println("Is player " + i + " a bot (0), or a person (1)? (Please type 0 or 1)");
			int type = Integer.parseInt(input.nextLine());
			switch (type) {
			case 0:
				players[i] = new Bot();
				break;
			case 1:
				players[i] = new Human();
				break;
			}
			players[i].playerIndex = i;
		}

		Deck d1 = new Deck();

		// deal the cards
		for (int i = 0; i < players.length; i++) {
			players[i].setHand(d1.dealHand());
		}

		System.out.println();
		System.out.println("Start");

		// create a print player that shows each persons card so that we know
		// who is winning---looping construct
		
		System.out.print("Randomly Testing the size: " + d1.getSize());
		
		int currentPlayer = 0;

		while (true) {

			System.out.println();
			System.out.println("------------------------------------------------------");
			System.out.println("-----Play or skip turn?------ (type either play or skip)");

			// Have player take turn
			int action = players[currentPlayer].play(input, players.length);

			if ((action & 1) != 0) { // checks the rightmost bit. Anding this
										// with a 1 checks that the rightmost
										// bit is either a 1 or a zero. A
										// nonzero value is returned if it is a
										// 1.
				// TODO: Properly extract bits here
				// Rightmost bit is action flag (correct)
				// Next bits are player number (2 bits)
				/// card number (rest of integer value)
				int playerno = (action >> 1) & ~(-1 << 2); // To generate a mask
															// to and with, pick
															// the largest
															// possible number
															// we can represent
															// (-1, which is all
															// ones), shift it
															// by the number of
															// bits we want, and
															// invert.
				int cardno = (action >> 3);
				Card card = players[currentPlayer].getHand().get(cardno);
				System.out.println("Player " + currentPlayer + " plays a " + card.getSuit() + ".");
				if (players[playerno].contains(card)) {
					players[currentPlayer].giveCard(players[playerno].getCard(card));
					players[currentPlayer].score++;
					System.out.println("Congratulations! You guessed right!");
				} else {
					System.out.println("Go fish!");
					//return deck.remove(0);
					Card ocard = d1.getCard();
					if(ocard == null) {
						int maxScore = 0;
						int winner = 0;
						for(Player i:players) {
							if(i.score>maxScore) {
								maxScore = i.score;
								winner = i.playerIndex;
							}
						}
						System.out.println("Player "+(winner+1)+" wins the game with "+maxScore+" points.");
						return;
					}
					players[currentPlayer].giveCard(ocard);
					
				}
			} else {
				System.out.println("Player " + currentPlayer + " decided to not take a turn.");
			}

			// Move to next player
			currentPlayer = (currentPlayer + 1) % players.length;

			for (Player i : players) {
				System.out.println("Player " + i.playerIndex + " has " + i.score + " points.");
			}

		}
	}

}
