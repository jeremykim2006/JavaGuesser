import java.util.*;

public class Main {  

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean keepGoing = true;
        int num;
        
        while (keepGoing) {
            menu();
            num = input.nextInt();
            if (num == 1) {
                human();
            }
            if (num == 2) {
                computer();
            }
            if (num == 0) {
                keepGoing = false;
            }
        }
    } 

    static void menu() {
        System.out.println("0) Exit");
        System.out.println("1) Human Guesser");
        System.out.println("2) Computer Guesser");
        System.out.println("Please enter 0-2: ");
    }

    static void human() {
        boolean keepGoing = true;
        int i = 0;
        int humGuess;
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int randomInt = random.nextInt(100) + 1;

        while (keepGoing) {
            i++;
            System.out.print(i + ") Please enter a number: ");
            humGuess = input.nextInt();
            if (randomInt < humGuess) {
                System.out.println("Too high");
            }
            if (randomInt > humGuess) {
                System.out.println("Too low");
            }
            if (randomInt == humGuess) {
                System.out.println("Correct\n");
                keepGoing = false;
            }
        }
    }

    static void computer() {
        boolean keepGoing = true;
        int i = 0;
        int highNum = 100;
        int lowNum = 1;
        int comGuess;
        Scanner input = new Scanner(System.in);

        System.out.println("Think of a number between 1 and 100.");
        
        while (keepGoing) {
            comGuess = (lowNum + highNum) / 2;
            i++;
            System.out.println(i + ") I guess " + comGuess);
            System.out.println("Too (H)igh, too (L)ow, or (C)orrect? ");
            String humHint = input.nextLine();

            if (humHint.equalsIgnoreCase("H")) {
                highNum = comGuess - 1;
            } else if (humHint.equalsIgnoreCase("L")) {
                lowNum = comGuess + 1;
            } else if (humHint.equalsIgnoreCase("C")) {
                System.out.println("Yay! I guessed your number.");
                keepGoing = false;
            }

            if (lowNum > highNum) {
                System.out.println("Something went wrong! Did you change your number?");
                break;
            }
        }
    }
}
