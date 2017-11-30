
/**
 * Write a description of class Blackjack1 here.
 *
 * @author Connie Huang
 * @version 11/29/2017
 */
import java.util.Scanner;
public class Blackjack1
{
    public static void main(String[] args)
    {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        System.out.print("\fLet's play Blackjack! Type \"Y\" to begin. ");
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        
        int player, dealer;
        while (a.equalsIgnoreCase("y")){
            Card c1 = deck.dealCard();
            Card c2 = deck.dealCard();
            
            Card d1 = deck.dealCard();
            Card d2 = deck.dealCard();
            System.out.println("\nYour hand: \n\t" + c1 + "\n\t" + c2 +
                               "\n\nDealer's first card: " + d1);
            
            player = c1.points() + c2.points(); 
            dealer = d1.points() + d2.points();
            
            System.out.print("\nType \"HIT\" to hit or \"STAY\" to stay: ");
            String b = scan.next();
            
            while (b.equalsIgnoreCase("hit")){
                Card c3 = deck.dealCard();
                System.out.println("\n\t"+c3);
                player += c3.points();
                if(player>21){
                    if(c1.getFace().equals("Ace")||c2.getFace().equals("Ace")||
                       c3.getFace().equals("Ace"))
                       player -= 10;
                    else{
                        System.out.println("\nYou BUSTED with a score of " + player+ "!");
                        break;
                    }
                }
                System.out.print("\nHIT or STAY? ");
                b = scan.next();
            }
            
            System.out.println("\nDealer's hand: \n\t" + d1 + "\n\t"+d2);
            while (dealer<15 && player<22){
                Card d3 = deck.dealCard();
                System.out.println("\nDealer hits and recieves a "+d3);
                dealer+=d3.points();
                if(dealer>21){
                    if(d1.getFace().equals("Ace")||d2.getFace().equals("Ace")||
                       d3.getFace().equals("Ace"))
                       dealer-=10;
                    else
                        System.out.println("\nDealer BUSTS with a score of " + dealer + "!");
                }
            }
            System.out.println();
            if(player==dealer){
                System.out.println("Push.");
            }else if((player > dealer || dealer>21) && player<22){
                System.out.println("YOU WIN!!");
            }else if (dealer<22){
                System.out.println("Dealer wins.");
            }else{
                System.out.println("Nobody wins :(");
            }
            System.out.println("\nYour points: " +player+ "\tDealer points: "+dealer);
            System.out.print("\nPlay again(Y/N)? ");
            a = scan.next();
        }
        System.out.println("Thanks for playing!");
    }
}
