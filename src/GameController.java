import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class GameController {

	public static void main(String[] args) {

		// creates an array of players with a maximum of four players.
		Scanner input = new Scanner(System.in);
		Player[] players;
		while (true) {
			System.out.println("How many players do you want?");
			players = new Player[Integer.parseInt(input.nextLine())];
			if (players.length > 4) {
				System.out.println("You cannot have more than 4 players.");

			} else {
				break;
			}
		}
		// while (true) {

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
		System.out.println("*************Start****************");
		System.out.println();

		// create a print player that shows each persons card so that we know
		// who is winning---looping construct

		System.out.println("Current size of the Deck:" + d1.getSize());
		System.out.println("***************************************");
		System.out.println("***************************************");
		int currentPlayer = 0;

		while (true) {

			System.out.println();
			// System.out.println(player(i));
			System.out.println();
			System.out.println("Below is your hand: ");
			System.out.println(players[currentPlayer].getHand()); // current
																	// hand
			System.out.println();
			System.out.println("-------------------------------------------------");
			System.out
					.println("----- Player " + currentPlayer + ": do you want to *PLAY* or *PUT DOWN MATCHES*?------");

			boolean hadTurn = false;
			boolean putdownAvailable = true;
			while (!hadTurn) {
				// Have player take turn
				if(players[currentPlayer].getHand().size() == 0) {
					System.out.println("Game over!");
					int maxScore = 0;
					Player maxPlayer = players[0];
					for(Player i:players) {
						if(i.score>maxScore) {
							maxPlayer = i;
							maxScore = i.score;
						}
					}
					System.out.println("Player "+maxPlayer.playerIndex+" wins with "+maxPlayer.score+" points!");
					return;
				}
				int action = players[currentPlayer].play(input, players.length,putdownAvailable);
				
				if ((action & 1) != 0) { // checks the rightmost bit. Anding
											// this
											// with a 1 checks that the
											// rightmost
											// bit is either a 1 or a zero. A
											// nonzero value is returned if it
											// is a
											// 1.
					// TODO: Properly extract bits here
					// Rightmost bit is action flag (correct)
					// Next bits are player number (2 bits)
					/// card number (rest of integer value)
					hadTurn = true;
					int playerno = (action >> 1) & ~(-1 << 2); // To generate a
																// mask
																// to and with,
																// pick
																// the largest
																// possible
																// number
																// we can
																// represent
																// (-1, which is
																// all
																// ones), shift
																// it
																// by the number
																// of
																// bits we want,
																// and
																// invert.
					int cardno = (action >> 3);
					Card card = players[currentPlayer].getHand().get(cardno);
					System.out.println("Player " + currentPlayer + " plays a " + card.getSuit() + ".");
					if (players[playerno].contains(card)) {
						players[currentPlayer].giveCard(players[playerno].getCard(card));
						System.out.println(
								"Congratulations! You guessed right!\nThe matching card was " + card.getSuit() + ".");
					} else {
						System.out.println("Go fish!");
						Card ocard = d1.getCard();
						if (ocard == null) {
							int maxScore = 0;
							int winner = 0;
							for (Player i : players) {
								if (i.score > maxScore) {
									maxScore = i.score;
									winner = i.playerIndex;
								}
							}
							System.out
									.println("Player " + (winner + 1) + " wins the game with " + maxScore + " points.");
							return;
						}
						players[currentPlayer].giveCard(ocard);

					}
				} else {
					int cardno = action >> 1;
					Card card = players[currentPlayer].getHand().get(cardno);
				    players[currentPlayer].getCard(card);
				    players[currentPlayer].getCard(card);
					players[currentPlayer].score++;
					System.out.println("Player " + currentPlayer + " has " + players[currentPlayer].score + " points.");
					putdownAvailable = false;
					hadTurn = true;
				}

			} // end while

			currentPlayer = (currentPlayer + 1) % players.length;
		}

	}
}
