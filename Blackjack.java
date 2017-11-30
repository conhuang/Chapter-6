
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
        ArrayList<Card> dealer = new ArrayList<Card>();
        int points, dealerPoints, index, d;
        while(a.equalsIgnoreCase("y")){
            points=0;
            dealerPoints=0;
            hand1 = new ArrayList<Card>();
            dealer = new ArrayList<Card>();

            hand1.add(0,deck.dealCard());
            dealer.add(0,deck.dealCard());
            hand1.add(1,deck.dealCard());
            dealer.add(1,deck.dealCard());

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

            for(int i = 0; i<2;i++){
                for (int j = 1; j<9; j++){
                    if(dealer.get(i).getFace().equals(deck.faces[j]))
                        dealerPoints+=(j+1);
                }
                for (int k = 9; k<13; k++){
                    if(dealer.get(i).getFace().equals(deck.faces[k]))
                        dealerPoints+=10;
                }
                if(dealer.get(i).getFace().equals("Ace"))
                    dealerPoints+=11;
            }

            System.out.print("\nYour hand: \n\t"+hand1.get(0)+"\n\t"+hand1.get(1)+
                "\n\nType \"HIT\" to hit or \"STAY\" to stay: ");
            String b = scan.next();
            index = 2;
            while(b.equalsIgnoreCase("hit")){
                hand1.add(deck.dealCard());
                for (int f = 1; f<9; f++){
                    if(hand1.get(index).getFace().equals(deck.faces[f]))
                        points+=(f+1);
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
            d = 2;

            while (dealerPoints<15){
                System.out.println("\nDealer hits.");
                dealer.add(deck.dealCard());
                for (int j = 1; j<9; j++){
                    if(dealer.get(d).getFace().equals(deck.faces[j]))
                        dealerPoints+=(j+1);
                }
                for (int k = 9; k<13; k++){
                    if(dealer.get(d).getFace().equals(deck.faces[k]))
                        dealerPoints+=10;
                }
                if(dealer.get(d).getFace().equals("Ace"))
                    dealerPoints+=1;
                d++;
            }

            System.out.println("\nDealer's hand: ");
            for(int i = 0; i<dealer.size(); i++){
                System.out.println("\t"+dealer.get(i));
            }

            if(points==dealerPoints){
                System.out.println("Push.");
            }else if((points > dealerPoints || dealerPoints>21) && points<22){
                System.out.println("YOU WIN!!");
            }else if (dealerPoints<22){
                System.out.println("Dealer wins.");
            }else{
                System.out.println("Nobody wins :(");
            }

            System.out.println(points+ " "+dealerPoints);
            System.out.print("\nPlay again(Y/N)? ");
            a = scan.next();

        }
        System.out.println("Thanks for playing!");
    }
}
