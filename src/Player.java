import java.util.ArrayList;

public class Player {

	private ArrayList<Card> hand = new ArrayList<Card>();//creates an a array of cards called hand using ArrayLists 
	private int points;//used for keeping score
	
	public void setHand(ArrayList<Card> c){//using this to so that the controller can set the hand to whatever amount the getCard() method give--- this will all happen in the controller
		hand = c;//set the arraylist of cards into the hand we created in this Player class
	}
	
	public ArrayList<Card> getHand(){
		return hand;//get the cards in the players hand---controller can use this to show how many cards the player has
	}
	
	public int getHandSize(){//gets the size of the hand
		return hand.size();
				
	}
	
	public Card getCard(Card c){//gets the card--first check to see in the hand contains it then removes and returns
		if(hand.contains(c)){
			hand.remove(c);
			return c;
		}
		//else
		return null;
	}
	
	public void giveCard(Card c){//adds the new given card to the hand
		hand.add(c);
	}
	public String toString(){
		return hand.toString();
	}
	
}
