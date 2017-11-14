/**
 * creates a cart (of max capacity 5) for user to add items to
 *
 * @author Connie Huang
 * @version 11/9/2017
 */
import java.util.Scanner;
public class ShopTest
{
    public static void main(String[]args){
        Scanner scan=new Scanner(System.in);
        System.out.print("Welcome to the Store! Would you like add "+
                           "items to your cart(Y/N)? ");
        String h = scan.nextLine();
        ShoppingCart3 mycart = new ShoppingCart3();
        String s ="";
        int q = 0;
        double p = 0.0;
        int numItems=0;
        while (h.equalsIgnoreCase("y")){
            System.out.println("Please enter the item you want to buy, the "+ 
                        "price, and quantity (Press ENTER after each entry)");
            s = scan.next();           
            p = scan.nextDouble();
            q = scan.nextInt();
            
            mycart.addToCart(s, p, q);
            numItems++;
            System.out.print("Add another(Y/N)? ");
            h=scan.next();
        }
        System.out.println(mycart);
    }
}