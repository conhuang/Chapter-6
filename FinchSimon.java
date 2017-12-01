
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
    private Finch e = new Finch();
    public static void main (String[] args){       
        ArrayList<String> command = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        Finch f = new Finch();
        /*command.add("Up");
        command.add("Down");
        command.add("Left");
        command.add("Right");
        */
        System.out.print("Welcome to Finch plays Simon! The Finch will give you a command \n"+
                         "and you will have five seconds to complete it. Once completed it will give you\n"+
                         " another command and you will do the first command and the new one. Press \"Y\" to continue.");
        String s = scan.next();
        while (s.equalsIgnoreCase("y")){
            boolean play = true;
            int x, moves=0;
            while (play==true){
                moves++;
                x = (int)( Math.random() *4);
                System.out.println(command.get(x));
                if (x==0){                   
                    command.add("Up");
                    System.out.println("Turn the Finch's beak up!");
                    
                }
                else if(x==1){
                    command.add("Down");
                    System.out.println("Turn the Finch's beak down!");
                }
                else if(x==2){
                    command.add("Left");
                    System.out.println("Turn the Finch's left wing up!");
                }
                else{
                    command.add("Right");
                    System.out.println("Turn the Finch's right wing up!");
                }
                if (moves>1)
                    System.out.println("Remember to repeat every move before this!");
                  
            }
            
            if(moves<4)
                System.out.println("Your memory is well under average. Get better soon.");
            else if (moves<8)
                System.out.println("Nice try, maybe next time you'll do better.");
            else
                System.out.println("Very impressive!");
            System.out.print("Play again (Y/N)?");
            s = scan.next();
        }
    }
    public boolean moveCorrect(String p){
        long startTime = System.currentTimeMillis();
        if (p.equals("Up")){
            if(e.isBeakUp())
                return true;
        }else if (p.equals("Down")){
            if(e.isBeakDown())
                return true;
        }else if (p.equals("Left")){
            if(e.isRightWingDown())
                return true;
        }else if (p.equals("Right")){
            if(e.isLeftWingDown())
                return true;
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        return false;
    }
}
