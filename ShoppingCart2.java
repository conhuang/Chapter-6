
/**
 * Write a description of class ShoppingCart2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.text.NumberFormat;
public class ShoppingCart2
{
    private int itemCount; // total number of items in the cart
    private double totalPrice; // total price of items in the cart
    private int capacity; 
    private Item [] cart;
    // -----------------------------------------------------------
    // Creates an empty shopping cart with a capacity of 5 items.
    // -----------------------------------------------------------
    public ShoppingCart2()
    {
        capacity = 5;
        itemCount = 0;
        totalPrice = 0.0;
        cart=new Item[capacity];
    }
    // -------------------------------------------------------
    // Adds an item to the shopping cart.
    // -------------------------------------------------------
    public void addToCart(String itemName, double price, int quantity)
    {
        cart[itemCount] = new Item (itemName, price, quantity);
        itemCount++;
        totalPrice += price*quantity;
        if(itemCount==5)
            increaseSize();
    }
    public double getTotalPrice(){
        return totalPrice;
    }
    /**
     * increases capacity of shopping cart by 3
     */
    private void increaseSize(){
        Item [] tempCart = new Item [capacity+3];
        for(int i = 0; i<cart.length; i++){
            tempCart[i] = cart[i];
        }
        cart = tempCart;
    }
    // -------------------------------------------------------
    // Returns the contents of the cart together with
    // summary information.
    // -------------------------------------------------------
    public String toString()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        String contents = "\nShopping Cart\n";
        contents += "\nItem\t\tUnit Price\tQuantity\tTotal\n";
        for (int i = 0; i < itemCount; i++)
            contents += cart[i].toString() + "\n";
        contents += "\nPlease pay: " + fmt.format(totalPrice);
        contents += "\n";
        return contents;
    }
}