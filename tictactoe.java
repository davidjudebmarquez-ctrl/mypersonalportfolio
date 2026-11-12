import java.util.Scanner;
public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char current = 'X';
        int moves = 0;
        boolean gameWon = false;
        while (moves < 9 && !gameWon) {
            System.out.println("\n " + board[0] + " | " + board[1] + " | " + board[2]);
            System.out.println("---+---+---");
            System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
            System.out.println("---+---+---");
            System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
            System.out.print("\nPlayer " + current + ", pick a slot (1-9): ");
            int slot = scanner.nextInt();
            if (slot < 1 || slot > 9 || board[slot - 1] == 'X' || board[slot - 1] == 'O') {
                System.out.println("Invalid move, try again.");
                continue;
            }
            board[slot - 1] = current;
            moves++;
            // Win check
            int[][] wins = {
                {0,1,2},{3,4,5},{6,7,8},   // rows
                {0,3,6},{1,4,7},{2,5,8},   // cols
                {0,4,8},{2,4,6}            // diagonals
            };
            for (int[] line : wins) {
                if (board[line[0]] == current &&
                    board[line[1]] == current &&
                    board[line[2]] == current) {
                    gameWon = true;
                }
            }
            if (gameWon) {
                System.out.println("\n Player " + current + " WINS!");
            } else {
                current = (current == 'X') ? 'O' : 'X';
            }
        }
        if (!gameWon) {
            System.out.println("\n It's a DRAW!");
        }
        scanner.close();
    }
}