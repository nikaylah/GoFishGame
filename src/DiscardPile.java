import java.util.ArrayList;

//collects the matches for each player--each player has their own discard pile

public class DiscardPile {

	public ArrayList<Card> discard = new ArrayList<Card>();
	
	
	
	public String toString(){
		return discard.toString();
	}
}
