import java.util.Scanner;

public class TicTacToe {

    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int rowLocation;
        int colLocation;

        System.out.println("welcome to tic tac toe\nplayer one is X and player two is O");
        do {
            clearBoard();
            display();
            do {
                do {
                    rowLocation = SafeInput.getRangedInt(in,"player one what row do you want to mark",1,3) - 1;
                    colLocation = SafeInput.getRangedInt(in,"player one what column do you want to mark",1,3) - 1;
                    if (!isValidMove(rowLocation, colLocation))
                    {
                        System.out.println("invalid move, space already taken");
                    }
                }
                while (!isValidMove(rowLocation, colLocation));

                board[rowLocation][colLocation] = "x";

                if (isWin("x"))
                {
                    System.out.println("player one wins!");
                }
                else if (isTie())
                {
                    System.out.println("the game is tied");
                }
                display();

                do {
                    rowLocation = SafeInput.getRangedInt(in,"player two what row do you want to mark",1,3) - 1;
                    colLocation = SafeInput.getRangedInt(in,"player two what column do you want to mark",1,3) - 1;
                    if (!isValidMove(rowLocation, colLocation)){
                        System.out.println("invalid move, space already taken");
                    }
                }
                while (!isValidMove(rowLocation, colLocation));

                board[rowLocation][colLocation] = "y";

                if (isWin("y"))
                {
                    System.out.println("player one wins!");
                }
                else if (isTie())
                {
                    System.out.println("the game is tied");
                }
                display();
            }
            while (!isWin("x") || !isWin("y") || isTie());
        }
        while (!SafeInput.getYNConfirm(in, "would you like to play again?"));
    }



    private static void clearBoard()
    {
        for (int row = 0;row < ROW; row++)
        {
            for (int col = 0;row < COL; row++)
            {
                board[row][col] = "-";
            }
        }
    }

    private static void display()
    {
        for (int row = 0;row < ROW; row++)
        {
            System.out.println(board[row][0] + " | " + board[row][1] + " | " + board[row][2]);
            System.out.println("---------");
        }
    }

    private static boolean isValidMove(int row, int col)
    {
        if (board[row][col].equalsIgnoreCase("x") || board[row][col].equalsIgnoreCase("y"))
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    private static boolean isWin(String player)
    {
        if (isColWin(player) || isRowWin(player) || isDiagnalWin(player))
        {
            return true;
        }
        return false;
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

    private static boolean isDiagnalWin(String player)
    {
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
        {
            return true;
        }
        else if (board[2][0].equals(player) && board[1][1].equals(player) && board[0][2].equals(player))
        {
            return true;
        }
        return false;
    }

    private static boolean isTie()
    {
        for (int row = 0;row < ROW; row++)
        {
            for (int col = 0;row < COL; row++)
            {
                if (board[row][col].equals("-"))
                {
                    return false;
                }
            }
        }
        return true;
    }
}
