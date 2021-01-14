package novi.basics;

public class DrawBoard {

    public static void drawBoard(char[][] board) {
        System.out.println("Board:");
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }

            System.out.println();
        }
    }
}
