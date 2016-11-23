import java.util.ArrayList;
import java.util.Collections;

public class Deck{
	
	public ArrayList<Card> deck = new ArrayList<Card>();//creates an array of cards---provides a place to add all card---we call it deck
	public int deckSize = 36;//creates the size of the deck which is a maximum of 36 cards
	
	//creates an array of strings called suit that holds the names of each card name
	public String[] suit = new String[]{"shark","jellyfish","octopus","seahorse", "clownfish", "angularfish", "seaturtle", "crab", "dolphin"};
	
//	public Card[] discardPile = new Card[36];
//	public int discardPileSize;
	
	//build all card in a deck array
	public Deck(){
		
		for(int i = 0; i < 9; i++ ){//creates a new card name through the loop--there are 9 different card names so we go through 9 times
			for(int a = 0; a < 4; a++){//creates 4 cards of each card name through a loop--- there are four of each card so we go through 4 times
				deck.add(new Card(suit[i]));//adds the card to the deck array list
			}
		}
		
	}
	
	public void shuffle(){
		Collections.shuffle(deck);//simply shuffles the deck---since the shuffle method is a collection of arrayList we are able to easily do this for our deck
		
	}
	
	public Card getCard(){
		return deck.remove(0);//gets the top card from the deck and returns that card that was removed
	}
	
	public ArrayList<Card> dealHand(){
		ArrayList<Card> hand = new ArrayList<Card>();//creating a new array list of cards called hand
		for(int i = 0; i < 6 ; i++){//goes through the loop 6 times for 6 cards
		hand.add(deck.remove(0));//creates a new array list and adds the top card to the hand---6 times = 6 cards
		}
		
		return hand;//returns the 6 cards that should now be in the hand
	}
	
	
	
	public String toString(){
		return deck.toString();
	}

}
