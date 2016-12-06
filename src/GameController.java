import java.util.ArrayList;

public class GameController {

	public static void main(String[] args) {
		Deck deck = new Deck();
		ArrayList player = deck.dealHand();
		ArrayList bot = deck.dealHand();
		System.out.println(player);
		System.out.println(bot);
		
		
	}

}
