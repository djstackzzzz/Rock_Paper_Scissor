import java.util.Scanner;

class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String playerA, playerB;
        boolean playAgain = true;

        while (playAgain) {
            // Get valid move from Player A
            do {
                System.out.print("Player A, enter your move (R, P, S): ");
                playerA = scanner.next().toUpperCase();
            } while (!playerA.equals("R") && !playerA.equals("P") && !playerA.equals("S"));

            // Get valid move from Player B
            do {
                System.out.print("Player B, enter your move (R, P, S): ");
                playerB = scanner.next().toUpperCase();
            } while (!playerB.equals("R") && !playerB.equals("P") && !playerB.equals("S"));

            // Determine winner
            if (playerA.equals(playerB)) {
                System.out.println("It's a Tie! Both chose " + playerA + ".");
            } else if ((playerA.equals("R") && playerB.equals("S")) ||
                    (playerA.equals("P") && playerB.equals("R")) ||
                    (playerA.equals("S") && playerB.equals("P"))) {
                System.out.println("Player A wins! " + getResultPhrase(playerA, playerB));
            } else {
                System.out.println("Player B wins! " + getResultPhrase(playerB, playerA));
            }

            // Prompt to play again
            System.out.print("Do you want to play again? (Y/N): ");
            playAgain = scanner.next().equalsIgnoreCase("Y");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static String getResultPhrase(String winner, String loser) {
        if (winner.equals("R") && loser.equals("S")) {
            return "Rock breaks Scissors!";
        } else if (winner.equals("P") && loser.equals("R")) {
            return "Paper covers Rock!";
        } else {
            return "Scissors cuts Paper!";
        }
    }
}
