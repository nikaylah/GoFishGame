import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Player {

	/**
	 * @summary Plays a round of the game.
	 * @return The action that the player has decided to take. The action is
	 *         comprised of a boolean (the first bit), which indicates whether
	 *         or not the player has decided to play. If set to a 1, it
	 *         indicates the player has decided to play. If set to 0, it
	 *         indicates that the player does not want to take a turn. The next
	 *         two bits indicate the player number (who they are asking for a
	 *         card). The remaining bits represent the index of the card in the
	 *         player's hand to choose.
	 */
	public abstract int play(Scanner scanner, int numberOfPlayers, boolean canPutDown);

	private ArrayList<Card> hand = new ArrayList<Card>();// creates an a array
															// of cards called
															// hand using
															// ArrayLists
	private int points;// used for keeping score

	public void setHand(ArrayList<Card> c) {// using this to so that the
											// controller can set the hand to
											// whatever amount the getCard()
											// method give--- this will all
											// happen in the controller
		hand = c;// set the arraylist of cards into the hand we created in this
					// Player class
	}

	public int score;
	public int playerIndex;

	public ArrayList<Card> getHand() {
		return hand;// get the cards in the players hand---controller can use
					// this to show how many cards the player has
	}

	public int getHandSize() {// gets the size of the hand
		return hand.size();

	}

	public Card getCard(Card c) {// gets the card--first check to see in the
									// hand contains it then removes and returns

		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).getSuit().equals(c.getSuit())) {
				hand.remove(i);
				return c;
			}
		}

		// else
		return null;
	}

	public ArrayList getPairs() {
		ArrayList list = new ArrayList();
		HashMap matchedIndices = new HashMap();
		for (int i = 0; i < hand.size(); i++) {
			Card search = hand.get(i);
			for (int c = 0; c < hand.size(); c++) {
				if (c != i && search.getSuit().equals(hand.get(c).getSuit())) {
					if (matchedIndices.containsKey(i) || matchedIndices.containsKey(c)) {
						continue;
					}
					matchedIndices.put(i, true);
					matchedIndices.put(c, true);
					Card[] cards = new Card[2];
					cards[0] = search;
					cards[1] = hand.get(c);
					list.add(cards);
					break;
				}
			}
		}
		return list;
	}

	public void giveCard(Card c) {// adds the new given card to the hand
		hand.add(c);
	}

	public boolean contains(Card c) {
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).getSuit().equals(c.getSuit())) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return hand.toString();
	}

}