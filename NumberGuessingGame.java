

// Number Guessing Game.........................

import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame
{
    public static void main(String[] args)
    {
       Scanner sc = new Scanner(System.in);
       Random rand = new Random();
       int RandomNumber = rand.nextInt(100) + 1;
       int cnt=0;
        //System.out.println(RandomNumber);
       int attempt=5;

        System.out.println("Enter your Guess from 1 To 100 (You Have Only 5 Attempt):");
        while(cnt<attempt)
        {
        int UserGuess = sc.nextInt();
         cnt++;


            if(RandomNumber==UserGuess)
            {
                System.out.println("Correct, You Win! ");
                System.out.println("You takes "+cnt+" Attempt to Win....");
                break;
            }
            else if(RandomNumber>UserGuess)
            {
                System.out.println("Enter the Higher Number....");
            }
            else
            {
                System.out.println("Enter the Lower Number....");
            }
        }
        if(cnt>=5) {
            System.out.println("You have reached your 5 Attempt.........");
        }
        if(cnt==1)
        {
            System.out.println("You Got 100 Points");
        }
        else if(cnt==2)
        {
            System.out.println("You Got 80 Points....");
        }
        else if(cnt==3)
        {
            System.out.println("You Got 60 Points....");
        }
        else if(cnt==4)
        {
            System.out.println("You Got 40 Points....");
        }
        else if(cnt==5)
        {
            System.out.println("You Got 20 Points....");
        }
        else
        {
            System.out.println("You LOSS.....");
        }

    }
}
