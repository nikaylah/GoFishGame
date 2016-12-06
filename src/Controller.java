import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

	
//	public boolean checkCard(Card c){ // would check contains and call the players hand---can' t access hand directly
//	return hand.contains(Card);
//	}
//	
//	public addCard(Card c){
//		hand.add(c);
//	}
	
	public static void main(String[] args) {
		
		Player p1 = new Player();
		Player p2 = new Player();

		Deck d1 = new Deck();
		
		int p1Score = 0;
		int p2Score = 0;
		
		d1.shuffle();
		//deal the cards
		p1.setHand(d1.dealHand());
		p2.setHand(d1.dealHand());
		
		System.out.println("player 1: " + p1);
		System.out.println("player 2: " + p2);
		
		System.out.println();
		System.out.println("Start");
		
		
		//create a print player that shows each persons card so that we know who is winning---looping construct
		System.out.println();
		System.out.print("Randomly Testing the size: " + d1.getSize());
		
		System.out.println();
		System.out.println("------------------------------------------------------");
		System.out.println("-----Play or Put Down Matches?------");
		
		
		String answer;
		int location;
		Scanner input = new Scanner(System.in);
		answer = input.next();
		
		int location1;
		int location2;
	
		if(answer.equals("play")){
			System.out.println("Which card?(Type a location)"); 
			System.out.print(p1.getHand());
			location = input.nextInt();
			Card card = p1.getHand().get(location - 1);
			System.out.println("Player 2 do you have this card " + card);
			
			if(p2.contains(card)){
				p1.giveCard(p2.getCard(card));
				
				System.out.println(p1.getHand());
				System.out.println(p2.getHand());
			}
			else
			{
			System.out.println("Player 2 says 'Go Fish'");
			p1.giveCard(d1.getCard());
			}
			
		}
		else
		{
			System.out.println("Which 2 cards (Type in first Location) ");
			System.out.print(p1.getHand());
			location1 = input.nextInt();
			Card c1 = p1.getHand().get(location1 -1);
			System.out.println("Which 2 cards (Type in second Location) ");
			System.out.print(p1.getHand());
			location2 = input.nextInt();
			Card c2 = p1.getHand().get(location2 -1);
			
			if(c1.getSuit().equals(c2.getSuit())){
				p1.getCard(c1);
				p1.getCard(c2);
				
				p1Score ++;
				
				System.out.println(p1.getHand());
			}
		}

			
		//create exceptions for (if they hit the keyboard) the user input
//		Scanner input = new Scanner(System.in);
		//int input = 0;
//		s = input.next();)
//		System.out.println(" Play(1) or Put Down Matches(2)?: " );
//		String play;   //scanner.nextLine();
//		String discard; //scanner.nextLine();
//		
//		input = scanner.nextInt();
//		
//		
//		if (input == 1)
//		{
//			System.out.println("Let " + " play");
//		}
//		System.out.println("Play" + play);
//		System.out.println("Discard" + discard);
		
		
		
		
	}
	

}
