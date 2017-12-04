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
        Finch finch = new Finch();
     
        System.out.print("Welcome to Finch plays Simon! The Finch will give you a command \n"+
            "and you will have five seconds to complete it. Once completed it will give you\n"+
            " another command and you will do the first command and the new one. Press \"Y\" to continue.");
        String s = scan.next();
        while (s.equalsIgnoreCase("y")){
            boolean play = true;
            int x, moves=0;
            while (play==true){
                moves++;
                finch.setLED(0,255,0);
                x = (int)(Math.random()*4);
                System.out.println(command.get(x));
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
                    long startTime = System.currentTimeMillis();
                    if(command.get(i).equals("Up")){
                        if(!finch.isBeakUp()){
                            play = false;
                            wrongMove(finch);
                            break;
                        }
                    }else if (command.get(i).equals("Down")){
                        if(!finch.isBeakDown()){
                            play = false;
                            wrongMove(finch);
                            break;
                        }
                    }else if (command.get(i).equals("Left")){
                        if(!finch.isRightWingDown()){
                            play = false;
                            wrongMove(finch);
                            break;
                        }
                    }else if (command.get(i).equals("Right")){
                        if(!finch.isLeftWingDown()){
                            play = false;
                            wrongMove(finch);
                            break;
                        }
                    }
                    long stopTime = System.currentTimeMillis();
                    long elapsedTime = stopTime - startTime;
                    if (elapsedTime>5000){
                        System.out.println("Too slow! You lose.");
                        finch.saySomething("Too slow! You lose.");
                        break;
                    }
                }
            }
            
            System.out.println("You had " + moves + " moves.");

            if(moves<4)
                System.out.println("Your memory is well under average. Get better soon.");
            else if (moves<8)
                System.out.println("Not bad, maybe next time you'll do better.");
            else
                System.out.println("Very impressive!");
            System.out.print("Play again (Y/N)?");
            s = scan.next();
        }        
        System.out.println("Thanks for playing!");
    }
    public static void wrongMove(Finch f){
        System.out.println("Wrong move! You lose.");
        f.saySomething("Wrong move! You lose.");
        f.setLED(0,255,0);
    }
}