
/**
 * Write a description of class Card here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Card
{
    private String face;
    private String suit;
    public Card (String cardFace, String cardSuit)
    {
        face = cardFace;
        suit = cardSuit;
    }
    public String getSuit()
    {
        return suit;
    }
    public String getFace()
    {
        return face;
    }
    public int points()
    {
        int player=0;
        if (getFace().equals("Ace"))
            player+=11;
        if (getFace().equals("Deuce"))
            player+=2;
        if (getFace().equals("Three"))
            player+=3; 
        if (getFace().equals("Four"))
            player+=4;
        if (getFace().equals("Five"))
            player+=5;
        if (getFace().equals("Six"))
            player+=6;
        if (getFace().equals("Seven"))
            player+=7;
        if (getFace().equals("Eight"))
            player+=8;
        if (getFace().equals("Nine"))
            player+=9;
        if (getFace().equals("Ten")||getFace().equals("Jack")||
            getFace().equals("Queen")||getFace().equals("King"))
            player+=10;
        return player;
    }
    public String toString()
    {
        return face + " of " + suit;
    }
}