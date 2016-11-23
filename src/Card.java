
public class Card {
	
	public String suit;
	
	/**
	 * 
	 * @param suit "shark","jellyfish","octopus","seahorse", "clownfish", "angularfish", "seaturtle", "crab", "dolphin"
	 * @param faceValue
	 */
	public Card(String suit){
		 this.suit = suit;
		 
	}
	
	public String getSuit(){
		return suit;
		
	}
	
	public void setSuit(){
		this.suit = suit;
	}
	
	public String toString(){
		return "Suit: " + suit;
	}
}
