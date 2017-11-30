
/**
 * Write a description of class FinchSimon here.
 * 
 * @author Connie Huang
 * @version 11/30/2017
 */
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.util.ArrayList;
import java.util.Scanner;
public class FinchSimon
{
   public static void main (String[] args){       
       ArrayList<String> command = new ArrayList<String>();
       Scanner scan = new Scanner(System.in);
       command.add("Up");
       command.add("Down");
       command.add("Left");
       command.add("Right");
       System.out.print("Would you like to play Finch plays Simon (Y/N)? ");
       boolean play = true;
       int x;
       while (play==true){
           x = (int)( Math.random() *4);
           System.out.println(command.get(x));
           
       }
       System.out.println("Wrong move!");
   }
}
