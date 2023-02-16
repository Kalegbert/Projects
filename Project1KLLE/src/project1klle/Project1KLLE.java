package project1klle;

import java.util.Scanner;

class Project1KLLE {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int roundScore = 0;
        int roundRolls = 0;
        boolean stopRound = false;
        int gameScore = 0;
        int gameRolls = 0;

        System.out.println("Enter a knockout number 1-6:");
        int knockout = scan.nextInt();

        for (int i = 1; i <= 10; i++) {

            System.out.println("Begin Round " + i);

            while (stopRound == false) {

                roundRolls = roundRolls + 1;
                int roll1 = (int) (Math.random() * 6) + 1;
                int roll2 = (int) (Math.random() * 6) + 1;
                System.out.println("Your rolls are " + roll1 + " and " + roll2);

                if (roll1 != knockout && roll2 != knockout) {

                    if (roll1 == roll2) {
                        roundScore = roundScore + ((roll1 + roll2) * 2);
                        System.out.println("Bonus!");
                        if (gameScore + roundScore >= 100) {
                            i = 11;
                            break;
                        }

                    } else {
                        roundScore = roundScore + roll1 + roll2;
                        if (gameScore + roundScore >= 100) {
                            i = 11;
                            break;
                        }

                    }
                    System.out.println("Roll again? y/n");
                    char yesNo = scan.next().charAt(0);
                    if (yesNo == 'n') {
                        stopRound = true;
                        System.out.println("Stop game y/n");
                        char stopGame = scan.next().charAt(0);

                        if (stopGame == 'y') {
                            i = 11;
                            break;
                        } else if (stopGame == 'n') {
                            stopRound = true;
                        } else {
                            System.out.println("invalid input");
                            stopRound = true;
                        }
                    } else if (yesNo == 'y') {
                        stopRound = false;

                    } else {
                        System.out.println("Invalid response");
                        stopRound = true;
                    }

                } else if (roll1 == knockout && roll2 == knockout) {
                    roundScore = 25;
                    stopRound = true;
                    System.out.println("Busted");
                    if (gameScore + roundScore >= 100) {
                        i = 11;
                        break;
                    }

                } else {

                    System.out.println("You got one knockout number, this round ends");
                    System.out.println("Stop game y/n");
                        char stopGame = scan.next().charAt(0);

                        if (stopGame == 'y') {
                            i = 11;
                            break;
                        } else if (stopGame == 'n') {
                            stopRound = true;
                        } else {
                            System.out.println("invalid input");
                            stopRound = true;
                        }

                    stopRound = true;

                }

            }

            gameScore = gameScore + roundScore;
            gameRolls = gameRolls + roundRolls;
            System.out.println("Round over. You rolled " + roundRolls + " time(s). Round score was " + roundScore + ". Your game score is currently " + gameScore);
            System.out.println(" ");
            roundScore = 0;
            roundRolls = 0;

            stopRound = false;

        }

        if (gameScore >= 100) {
            System.out.println("Congratulations, you won!");
            System.out.println("Your score was: " + gameScore + ". You had " + gameRolls + " rolls.");
        } else {
            System.out.println("Game over. Your score was: " + gameScore + ". You had " + gameRolls + " rolls.");

        }
    }
}
