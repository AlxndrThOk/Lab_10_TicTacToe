import java.util.Scanner;

public class TicTacToe {

    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("welcome to tic tac toe\nplayer player X will go first and player O will go second");
        do {
            clearBoard();
            display();
            do {
                getPlayerMove(in, "X");
                if (gameOverCheck("X"))
                {
                    break;
                }
                getPlayerMove(in, "O");
                if (gameOverCheck("O"))
                {
                    break;
                }
            }
            while (!(gameOverCheck("X") || gameOverCheck("O")));
        }
        while (SafeInput.getYNConfirm(in, "would you like to play again?"));
    }



    private static void clearBoard()
    {
        for (int row = 0;row < ROW; row++)
        {
            for (int col = 0;col < COL; col++)
            {
                board[row][col] = "-";
            }
        }
    }

    private static void display()
    {
        for (int row = 0;row < ROW - 1; row++)
        {
            System.out.println(" " + board[row][0] + " | " + board[row][1] + " | " + board[row][2]);
            System.out.println("-----------");
        }
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }

    private static boolean isValidMove(int row, int col)
    {
        return !board[row][col].equals("X") && !board[row][col].equals("O");
    }

    private static void getPlayerMove(Scanner pipe, String player)
    {
        int rowLocation;
        int colLocation;
        do {
            rowLocation = SafeInput.getRangedInt(pipe,player + " player what row do you want to mark",1,3) - 1;
            colLocation = SafeInput.getRangedInt(pipe,player + " player what column do you want to mark",1,3) - 1;
            if (!isValidMove(rowLocation, colLocation))
            {
                System.out.println("invalid move, space already taken");
                display();
            }
        }
        while (!isValidMove(rowLocation, colLocation));

        board[rowLocation][colLocation] = player;

        if (isWin(player))
        {
            System.out.println(player + " player wins!");
        }
        else if (isTie())
        {
            System.out.println("the game is tied");
        }

        display();
    }

    private static boolean gameOverCheck(String player)
    {
        return isWin(player) || isTie();
    }

    private static boolean isWin(String player)
    {
        return isColWin(player) || isRowWin(player) || isDiagonalWin(player);
    }

    private static boolean isColWin(String player)
    {
        for (int col = 0;col < ROW; col++)
        {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isRowWin(String player)
    {
        for (int row = 0;row < ROW; row++)
        {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player)
    {
        return board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player) ||
                board[2][0].equals(player) && board[1][1].equals(player) && board[0][2].equals(player);
    }

    private static boolean isTie()
    {
        return boardFull() || isEarlyTie();
    }

    private static boolean boardFull()
    {
        for (int row = 0;row < ROW; row++)
        {
            for (int col = 0;col < COL; col++)
            {
                if (board[row][col].equals("-"))
                {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isEarlyTie()
    {
        return isEarlyRowTie() && isEarlyColTie() && isEarlyDiagonalTie();
    }

    private static boolean isEarlyRowTie()
    {
        return ((board[0][0].equals("X") || board[0][1].equals("X") || board[0][2].equals("X")) &&
                (board[0][0].equals("O") || board[0][1].equals("O") || board[0][2].equals("O")))
                &&
                ((board[1][0].equals("X") || board[1][1].equals("X") || board[1][2].equals("X")) &&
                        (board[1][0].equals("O") || board[1][1].equals("O") || board[1][2].equals("O")))
                &&
                ((board[2][0].equals("X") || board[2][1].equals("X") || board[2][2].equals("X")) &&
                        (board[2][0].equals("O") || board[2][1].equals("O") || board[2][2].equals("O")));
    }

    private static boolean isEarlyColTie()
    {
        return ((board[0][0].equals("X") || board[1][0].equals("X") || board[2][0].equals("X")) &&
                (board[0][0].equals("O") || board[1][0].equals("O") || board[2][0].equals("O")))
                &&
                ((board[0][1].equals("X") || board[1][1].equals("X") || board[2][1].equals("X")) &&
                        (board[0][1].equals("O") || board[1][1].equals("O") || board[2][1].equals("O")))
                &&
                ((board[0][2].equals("X") || board[1][2].equals("X") || board[2][2].equals("X")) &&
                        (board[0][2].equals("O") || board[1][2].equals("O") || board[2][2].equals("O")));
    }

    private static boolean isEarlyDiagonalTie()
    {
        return (board[0][0].equals("X") || board[1][1].equals("X") || board[2][2].equals("X")) &&
                (board[0][0].equals("O") || board[1][1].equals("O") || board[2][2].equals("O"))
                &&
                (board[2][0].equals("X") || board[1][1].equals("X") || board[0][2].equals("X")) &&
                (board[2][0].equals("O") || board[1][1].equals("O") || board[0][2].equals("O"));
    }
}
