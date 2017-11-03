
/**
 * Write a description of class ShopTest2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class ShopTest2
{
    public static void main(String[]args){
        Scanner scan=new Scanner(System.in);
        System.out.print("Welcome to the Store! Would you like add "+
                           "items to your cart(Y/N)? ");
        String h = scan.nextLine();
        ShoppingCart mycart = new ShoppingCart();
        String s ="";
        int q = 0;
        double p = 0.0;
        int numItems=0;
        while (h.equalsIgnoreCase("y") && numItems!=8){
            System.out.println("Please enter the item you want to buy, the "+ 
                        "price, and quantity (Press ENTER after each entry)");
            s = scan.next();           
            p = scan.nextDouble();
            q = scan.nextInt();
            
            mycart.addToCart(s, p, q);
            numItems++;
            //System.out.println("Current cart: \n" + mycart);
            System.out.print("Add another(Y/N)? ");
            h=scan.next();
        }
        if (numItems == 5)
            System.out.println("Max capacity reached. You can't add more items.");
        System.out.println(mycart);
    }
}
