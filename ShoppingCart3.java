/**
 * creates the cart that holds items
 *
 * @author Connie Huang
 * @version 11/9/2017
 */
import java.util.ArrayList;
import java.text.NumberFormat;
public class ShoppingCart3
{
    private int itemCount;
    private double totalPrice; 
    private ArrayList<Item> cart;
    /**
     * Creates an empty shopping cart with a capacity of 5 items.
     */
    public ShoppingCart3()
    {
        itemCount = 0;
        totalPrice = 0.0;
        cart=new ArrayList<Item>();
    }
    /**
     * Adds an item to the shopping cart.
     */
    public void addToCart(String itemName, double price, int quantity)
    {
        Item item = new Item (itemName, price, quantity);
        cart.add (item);
        itemCount++;
        totalPrice += price*quantity;
    }
    /**
     * allows user to obtain their total price
     * @return total price
     */
    public double getTotalPrice(){
        return totalPrice;
    }
    /**
     * Returns the contents of the cart together with summary information.
     * @return String that shows the shopping cart
     */
    public String toString()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        String contents = "\nShopping Cart\n";
        contents += "\nItem\t\tUnit Price\tQuantity\tTotal\n";
        for (int i = 0; i < itemCount; i++)
            contents += cart.get(i).toString() + "\n";
        contents += "\nPlease pay: " + fmt.format(totalPrice);
        contents += "\n";
        return contents;
    }
}