import java.util.Random;
import java.util.Scanner;

public class Bot extends Player {
	private Random r1 = new Random ();
	public String asked;    
	public Bot() {
		super();
	}
	public void add(Card c) {
		getHand().add(c);
	}

	public int getLocation(Card c)
	{
		int location = 0;
		for(int i=0; i<getHand().size();i++)
		{
			if(getHand().get(i).getSuit().equals(c.getSuit()))
			{
				location = i;
				break;
			}
		}
		return location;
	}

	public Card give(Card c)
	{
		return getHand().remove(getLocation(c));
	}

	
	@Override
	public int play(Scanner scanner, int numberOfPlayers) {
		int chosenCard = r1.nextInt() % getHand().size();
		
		int chosenPlayer = r1.nextInt() % numberOfPlayers;
		while(chosenPlayer == playerIndex) {
			chosenPlayer = r1.nextInt() % numberOfPlayers;
		}
		
		boolean willPlay = r1.nextInt() % 2 == 0;
		return willPlay ? 1 : 0 | chosenPlayer << 1 | chosenCard << 3; //First bit indicates willPlay true or false (1 or 0), next 2 bits represent the player number (requires only 2 bits since there can be a maximum of 4 players), the remaining bits indicate the chosen card.
	}

}
