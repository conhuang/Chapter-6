
/**
 * Write a description of class Blackjack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Blackjack
{
    public static void main(String[]args)
    {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        System.out.print("\fLet's play Blackjack! Type \"Y\" to begin. ");
        Scanner scan = new Scanner(System.in);
        String a = scan.next();

        ArrayList<Card> hand1 = new ArrayList<Card>();
        Card [] dealer = new Card[2];
        while(a.equalsIgnoreCase("y")){
            hand1.add(0,deck.dealCard());
            dealer[0]=deck.dealCard();
            hand1.add(1,deck.dealCard());
            dealer[1]=deck.dealCard();
            if(hand1.size()>2){
                for(int y=2; y<hand1.size(); y++){
                    hand1.remove(y);
                }
            }
            
            int points=0;
            for(int i = 0; i<2;i++){
                for (int j = 1; j<9; j++){
                    if(hand1.get(i).getFace().equals(deck.faces[j]))
                        points+=(j+1);
                }
                for (int k = 9; k<13; k++){
                    if(hand1.get(i).getFace().equals(deck.faces[k]))
                        points+=10;
                }
                if(hand1.get(i).getFace().equals("Ace"))
                    points+=11;
            }
            
            int dealerPoints = 0;
            for(Card x: dealer){
                for (int j = 1; j<9; j++){
                    if(x.getFace().equals(deck.faces[j]))
                        dealerPoints+=(j+1);
                }
                for (int k = 9; k<13; k++){
                    if(x.getFace().equals(deck.faces[k]))
                        dealerPoints+=10;
                }
                if(x.getFace().equals("Ace"))
                    dealerPoints+=11;
            }
            
            System.out.print("\nYour hand: \n\t"+hand1.get(0)+"\n\t"+hand1.get(1)+
                "\n\nType \"HIT\" to hit or \"STAY\" to stay: ");
            String b = scan.next();
            int index = 2;
            while(b.equalsIgnoreCase("hit")){
                hand1.add(deck.dealCard());
                for (int d = 1; d<9; d++){
                    if(hand1.get(index).getFace().equals(deck.faces[d]))
                        points+=(d+1);
                }
                for (int r = 9; r<13; r++){
                    if(hand1.get(index).getFace().equals(deck.faces[r]))
                        points+=10;
                }
                if(hand1.get(index).getFace().equals("Ace"))
                    points+=1;
                index++;
                System.out.println("\n\t"+hand1.get(hand1.size()-1));
                if (points > 21){
                    System.out.println("BUST");
                    break;
                }
                System.out.print("\nHIT or STAY? ");
                b = scan.next();
            }
            System.out.println("\nDealer's hand: \n\t"+dealer[0]+"\n\t"+dealer[1]);
            if (points == 21){
                System.out.println("\nBLACKJACK! YOU WIN!!");
            }
            System.out.println(points+ " "+dealerPoints);
            System.out.print("\nPlay again(Y/N)? ");
                a = scan.next();
            /*if(points>21){
                System.out.println("Dealer wins.");
            }
            */
        }
    }
}
