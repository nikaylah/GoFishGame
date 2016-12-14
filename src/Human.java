import java.util.ArrayList;
import java.util.Scanner;

public class Human extends Player {

	@Override
	public int play(Scanner scanner, int numberOfPlayers) {
		System.out.println("To play a card (type 0), or (type 1) to put down matches.");
		while(true) {
		if (scanner.nextLine().equals("0")) {
			while (true) {

				// Play card
				
				System.out.println("\nPlease type the index (starting from one) of the card you want to use.");
				int index = Integer.parseInt(scanner.nextLine())-1;
				System.out.println(
						"Which player do you want to ask? (pick a number between 0 and " + (numberOfPlayers-1) + ")");
				int playernum = Integer.parseInt(scanner.nextLine());
				if (playernum == this.playerIndex) {
					System.out.println("You can't play yourself. Please choose a different player.");
				} else {
					Card card = (Card) getHand().get(index);
					return 1 | playernum << 1 | (index) << 3; // Returns a
																	// 1,
																	// indicating
																	// that the
																	// player
																	// wants to
																	// take a
																	// turn.
																	// Sets the
																	// remaining
																	// bits to
																	// the value
																	// of index.
				}
			}
		}else {
			ArrayList matches = getPairs();
			if(matches.size() == 0) {
				System.out.println("You don't have any matches to put down.");
				
			}
			Card[] realMatches = new Card[matches.size()/2];
			
			System.out.println("Below is a list of your matches; please select one:\n");
			
		}
		}

		// returns a zero, indicating that the player does not want to take
		// a turn.
	}
}