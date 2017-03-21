import java.util.Random;
import java.util.Scanner;

public class MemoryTextGame {
    private Card [][] board;
    private String[] words = {"Blue", "Blue", "Red", "Red", "Green", "Green", "Yellow", "Yellow", "Purple", "Purple", "Pink", "Pink", "Brown", "Brown", "Orange", "Orange"};
    private Random r;
    private Scanner reader;
    private Boolean multiplayer;
    private String player1;
    private String player2;
    private int player1Score;
    private int player2Score;
    private String currentPlayer;


    public static void main(String[] args) {
        new MemoryTextGame();
    }

    MemoryTextGame()
    {
        r = new Random();
        reader = new Scanner(System.in);
        board = new Card [4][4];
        playGame();
    }

    public void playGame()
    {
        getPlayerInfo();
        shuffle();
        setCells();
        printCells();
        choosePairOfCards();
    }

    public void getPlayerInfo()
    {
        multiplayer = false;
        System.out.print("Multiplayer? >");
        if (getInputAsString().equals("Yes")) {
            multiplayer = true;
            System.out.print("Player1 name >");
            player1 = getInputAsString();
            System.out.print("Player2 name >");
            player2 = getInputAsString();
            currentPlayer = player1;
        } else {
            System.out.print("Player1 name >");
            player1 = getInputAsString();
            currentPlayer = player1;
        }
    }

    public void choosePairOfCards()
    {
        int cardChoise, row1, col1, row2, col2;
        System.out.println();
        System.out.println(currentPlayer+" enter the number on the card.");
        System.out.print("First Card Choise? >");
        cardChoise = getInputAsInt();
        row1 = cardChoise / 4;
        col1 = cardChoise % 4;
        board[row1][col1].setShowingStatus();

        System.out.print("Second Card Choise? >");
        cardChoise = getInputAsInt();
        row2 = cardChoise / 4;
        col2 = cardChoise % 4;
        board[row2][col2].setShowingStatus();

        System.out.print('\u000C'); //clears the screen

        printCells();

        int a = 0;
        int gameOver = 0;
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[0].length; col++)
            {
                if (board[row][col].showing == false) {
                    gameOver++;
                }
                a++;
            }
        }

        if (gameOver == 0) {
            System.out.println();
            System.out.println("Game Over");
            System.out.println(player1+"\'s score: "+player1Score);
            if (multiplayer.equals(true)) {
                System.out.println(player2 + "\'s score: " + player2Score);
            }
            return;
        }

        if (board[row1][col1].back.equals(board[row2][col2].back)) {
            if (currentPlayer.equals(player1)) {
                player1Score++;
                System.out.println(player1+"\'s score: "+player1Score);
                if (multiplayer.equals(true)) {
                    System.out.println(player2 + "\'s score: " + player2Score);
                }
            } else {
                player2Score++;
                System.out.println(player1+"\'s score: "+player1Score);
                if (multiplayer.equals(true)) {
                    System.out.println(player2 + "\'s score: " + player2Score);
                }
            }
            choosePairOfCards();
        } else {
            board[row1][col1].setShowingStatus();
            board[row2][col2].setShowingStatus();

            if (currentPlayer.equals(player1)) {
                if (multiplayer.equals(true)) {
                    currentPlayer = player2;
                }
                System.out.println(player1+"\'s score: "+player1Score);
                if (multiplayer.equals(true)) {
                    System.out.println(player2 + "\'s score: " + player2Score);
                }
            } else {
                currentPlayer = player1;
                System.out.println(player1+"\'s score: "+player1Score);
                if (multiplayer.equals(true)) {
                    System.out.println(player2 + "\'s score: " + player2Score);
                }
            }
            System.out.print('\u000C');
            choosePairOfCards();
        }
    }

    public void setCells()
    {
        int a = 0;
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[0].length; col++)
            {
                {
                    board[row][col] = new Card(words[a], a);
                    a++;
                }
            }
        }
    }

    public void printCells()
    {
        Card aCard;
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[0].length; col++)
            {
                aCard = board [row][col];
                aCard.showCard();
            }
            System.out.println();
        }
    }

    public void shuffle()
    {
        for (int a = 0; a < words.length; a++)
        {
            int pos = r.nextInt(words.length);
            String temp = words[a];
            words[a] = words[pos];
            words[pos] = temp;
        }
    }

    public int getInputAsInt()
    {
        String temp = reader.nextLine();
        return Integer.parseInt(temp);
    }

    public String getInputAsString()
    {
        return  reader.nextLine();
    }
}
