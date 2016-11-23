import java.util.ArrayList;

public class Player {

	public ArrayList<Card> hand = new ArrayList<Card>();//creates an a array of cards called hand using ArrayLists 
	
	public void setHand(ArrayList<Card> c){//using this to so that the controller can set the hand to whatever amount the getCard() method give--- this will all happen in the controller
		hand = c;//set the arraylist of cards into the hand we created in this Player class
	}
	
	public ArrayList<Card> getHand(){
		return hand;//get the cards in the players hand---controller can use this to show how many cards the player has
	}
	
}
