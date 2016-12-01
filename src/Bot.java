import java.util.Random;

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

	public String haveTurn()
	{
		int num = r1.nextInt(getHand().size());
		asked = getHand().get(num).getSuit();
		System.out.println("The bot asked for a " + getHand().get(num));
		return asked;
	}

}
