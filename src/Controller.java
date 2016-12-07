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
		
		System.out.println();
		System.out.println("PLAYER 1 HAND: " + p1);
		System.out.println("PLAYER 2 HAND: " + p2);
		
		System.out.println();
		System.out.println("------DO YOU WANT TO PLAY OR PUT DOWN YOUR MATCHES?------");
		System.out.println("------TYPE (play) or (matches)-----");
		
		
		Scanner input = new Scanner(System.in);
		String answer;
		answer = input.next();
		int location;
		
		int location1;//used for keeping track of matches
		int location2;
	
		if(answer.equals("play")){//The Play
			System.out.println("---Which card?(Type a location)----"); 
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
			p1.giveCard(d1.getCard());//player 1 draws from deck
			}
			
		}
		else if(answer.equals("matches"))//(Putting down matches)
		{
			System.out.println("------Which 2 cards -----");
			System.out.println("------(Type in first Location)------");
			System.out.print(p1.getHand());
			location1 = input.nextInt();
			Card c1 = p1.getHand().get(location1 -1);
			System.out.println("-------(Type in second Location)------- ");
			System.out.print(p1.getHand());
			location2 = input.nextInt();
			Card c2 = p1.getHand().get(location2 -1);
			
			if(c1.getSuit().equals(c2.getSuit())){
				p1.getCard(c1);
				p1.getCard(c2);
				
				p1Score ++;
				
				System.out.println();
				System.out.println(p1.getHand());
			}
		}
	
	}
	

}
