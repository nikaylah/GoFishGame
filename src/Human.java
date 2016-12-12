import java.util.Scanner;

public class Human extends Player {

	@Override
	public int play(Scanner scanner, int numberOfPlayers) {

		System.out.println("To play a card (type 0)");
		if (scanner.nextLine().equals("0")) {
			while (true) {

				// Play card
				System.out.println("Below is a list of your cards.\n" + getHand()
						+ "\nPlease type the index (starting from one) of the card you want to use.");
				int index = Integer.parseInt(scanner.nextLine());
				System.out.println(
						"Which player do you want to ask? (pick a number between 1 and " + numberOfPlayers + ")");
				int playernum = Integer.parseInt(scanner.nextLine()) - 1;
				if (playernum == this.playerIndex) {
					System.out.println("You can't play yourself. Please choose a different player.");
				} else {
					Card card = (Card) getHand().get(index - 1);
					return 1 | playernum << 1 | (index - 1) << 3; // Returns a
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
		}
		return 0;

		// returns a zero, indicating that the player does not want to take
		// a turn.
	}
}
