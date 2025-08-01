import java.util.Random;
import java.util.Scanner;

public class Guessgame{
    public static void main(String[] args) {
        
        //declaration
        Random random = new Random();
        int target = random.nextInt(100)+1;
        Scanner scanner = new Scanner(System.in);
        Guessgame obj1 = new Guessgame();

        //get choice 
        System.out.print("1. Start Game\n2. Exit\nNote: Maximum 10 attempts\n");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                obj1.game(target);
                break;
            case 2:
                System.out.println("Exiting Game");
                break;
            default:
                System.out.println("enter a valid choice!");
        }
    }

    //game function
    void game(int target){
        Scanner scanner = new Scanner(System.in);
        //score 
        int[] score = {10,9,8,7,6,5,4,3,2,1,0};
        //game loop
        for(int i = 1; i<=10; i++){
                    
            System.out.print("Guess a value(0 to 100):");
            int userinput = scanner.nextInt();
            if (userinput == target) {
                System.out.println("Congratulations, You found the number...!\nYour score is "+score[i]);
                break;
            }
            else if (userinput > target) {
                System.out.println("Guess is High..\n");
            }
            else if (userinput < target) {
                System.out.println("Guess is Low..\n");
            }
            else if (userinput != target) {
                System.out.println("Oops!, Attempts over..\nYour score is "+score[5]);
            }
        }
        
        //play again
        System.out.print("Try again[1/0]?:");
        int c = scanner.nextInt();
        if (c == 1) {
            game(target);
        }
    }
}