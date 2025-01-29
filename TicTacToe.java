import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

public class TicTacToe {
    
    static String[] board;
    static String turn;

    static String checkWinner()
    {
        
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            
            if (line.equals("XXX")) {
                return "X";
            }

            else if (line.equals("OOO")) {
                return "O";
            }
        }

        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(
                String.valueOf(a + 1))) {
                break;
            }
            else if (a == 8) {
                return "Draw";
            }
        }

        System.out.println("Turn of: "+
            turn + "; Select the number you wish to place "
            + turn);
        return null;
    }

    /* 
    |---|---|---|
    | 1 | 2 | 3 |
    |-----------|
    | 4 | 5 | 6 |
    |-----------|
    | 7 | 8 | 9 |
    |---|---|---|
    */

    static void printBoard()
    {
        
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
            + board[1] + " | " + board[2]
            + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
            + board[4] + " | " + board[5]
            + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
            + board[7] + " | " + board[8]
            + " |");
        System.out.println("|---|---|---|");
    }

    public static void main(String[] args)
    {
        System.out.print('\u000C');
        Scanner in = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;

        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }
        System.out.println("|-----------|");
        System.out.println("|Tic Tac Toe|");
        System.out.println("|-----------|");
        printBoard();

        System.out.println(
            "X:");

        while (winner == null) {
            int numInput;

            try {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println(
                        "Invalid; rewrite a valid number:");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println(
                    "Invalid; rewrite a valid number:");
                continue;
            }


            if (board[numInput - 1].equals(
                String.valueOf(numInput))) {
                board[numInput - 1] = turn;

                if (turn.equals("X")) {
                    turn = "O";
                }
                else {
                    turn = "X";
                }

                printBoard();
                winner = checkWinner();
            }
            else {
                System.out.println(
                    "Already chosen; rewrite a valid number:");
            }
        }

        if (winner.equalsIgnoreCase("Draw")) {
            System.out.println(
                "It's a draw! Thanks for playing.");
        }

        else {
            System.out.println(
                "Congrats! " + winner
                + " You win! Thanks for playing.");
        }
        in.close();
    }
}
