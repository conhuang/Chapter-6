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
        Finch finch = new Finch();
        FinchSimon simon = new FinchSimon();
        Scanner scan = new Scanner(System.in);
        System.out.print("Welcome to Finch plays Simon! The Finch will give you a command \n"+
            "and you will have five seconds to complete it. Once completed it will give you\n"+
            "another command and you will do the first command and the new one.\nThe game continues" +
            " for as many moves as you remember.\nPress \"Y\" to continue.\n");
        String s = scan.next();
        while (s.equalsIgnoreCase("y")){
            boolean play = true;
            int x, moves=0;
            while (play==true){
                moves++;
                finch.setLED(0,255,0);
                x = (int)( Math.random() *4);
                if (x==0){                   
                    command.add("Up");
                    System.out.println("Turn the Finch's beak up!");
                    finch.saySomething("Up");
                }
                else if(x==1){
                    command.add("Down");
                    System.out.println("Turn the Finch's beak down!");
                    finch.saySomething("Down");
                }
                else if(x==2){
                    command.add("Left");
                    System.out.println("Turn the Finch's left wing up!");
                    finch.saySomething("Left");
                }
                else{
                    command.add("Right");
                    System.out.println("Turn the Finch's right wing up!");
                    finch.saySomething("right");
                }
                if (moves>1)
                    System.out.println("Remember to repeat every move before this!");
                for (int i = 0; i<command.size(); i++){
                    if(!simon.moveCorrect(command.get(i), finch))
                        play=false;
                }
            }
            if(moves<4)
                System.out.println("Your memory is well under average. Get better soon.");
            else if (moves<8)
                System.out.println("Nice try, maybe next time you'll do better.");
            else
                System.out.println("Very impressive!");
            System.out.print("Play again (Y/N)? ");
            s = scan.next();
        }        
    }

    public boolean moveCorrect(String p, Finch e){
        long startTime = System.currentTimeMillis();
        boolean f=false;
        if (p.equals("Up")){
            if(e.isBeakUp())
                f = true;
        }else if (p.equals("Down")){
            if(e.isBeakDown())
                f = true;
        }else if (p.equals("Left")){
            if(e.isRightWingDown())
                f = true;
        }else if (p.equals("Right")){
            if(e.isLeftWingDown())
                f = true;
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        if(elapsedTime > 5000)
            f = false;
        return f;
    }
    public boolean is5sec(){
        long startTime = System.currentTimeMillis();
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        if (elapsedTime<5000)
            return true;
        return false;
    }
}


