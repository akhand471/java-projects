import java.util.Scanner;

public class TicTacToe {
    static final int SIZE = 6;
    static final int WIN_COUNT = 4;
    static char[][] board = new char[SIZE][SIZE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameEnded = false;

        initializeBoard();
        System.out.println("🎮 6x6 Tic-Tac-Toe (Connect 4 to Win!)");
        printBoard();

        while (!gameEnded) {
            System.out.println("\nPlayer " + currentPlayer + ", enter your move (row[1-6] column[1-6]): ");
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                printBoard();

                if (checkWinner(currentPlayer)) {
                    System.out.println(" Player " + currentPlayer + " wins!");
                    gameEnded = true;
                } else if (isBoardFull()) {
                    System.out.println(" It's a draw!");
                    gameEnded = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println(" Invalid move. Try again.");
            }
        }

        sc.close();
    }

    // Initialize board with spaces
    public static void initializeBoard() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = ' ';
    }

    // Print the board
    public static void printBoard() {
        System.out.println("  -----------------------------");
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " | ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n  -----------------------------");
        }
        System.out.print("    ");
        for (int i = 1; i <= SIZE; i++) System.out.print(i + "   ");
        System.out.println();
    }

    // Check if move is valid
    public static boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == ' ';
    }

    // Check winner (4 in a row)
    public static boolean checkWinner(char player) {
        // Horizontal, Vertical, Diagonal (\), Diagonal (/)
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(player, i, j, 0, 1)) return true; // Horizontal
                if (checkLine(player, i, j, 1, 0)) return true; // Vertical
                if (checkLine(player, i, j, 1, 1)) return true; // Diagonal \
                if (checkLine(player, i, j, 1, -1)) return true; // Diagonal /
            }
        }
        return false;
    }

    // Helper to check line of WIN_COUNT
    public static boolean checkLine(char player, int row, int col, int dx, int dy) {
        int count = 0;
        for (int k = 0; k < WIN_COUNT; k++) {
            int r = row + k * dx;
            int c = col + k * dy;
            if (r >= 0 && r < SIZE && c >= 0 && c < SIZE && board[r][c] == player) {
                count++;
            } else {
                break;
            }
        }
        return count == WIN_COUNT;
    }

    // Check if board is full
    public static boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == ' ') return false;
        return true;
    }
}
