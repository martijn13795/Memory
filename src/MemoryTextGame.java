import java.util.Random;
import java.util.Scanner;

public class MemoryTextGame {
    private Card [][] board;
    private String[] words = {"Blue", "Blue", "Red", "Red", "Green", "Green", "Yellow", "Yellow", "Purple", "Purple", "Pink", "Pink", "Brown", "Brown", "Orange", "Orange"};
    private Random r;
    private Scanner reader;

    public static void main(String[] args) {
        new MemoryTextGame();
    }

    MemoryTextGame()
    {
        r = new Random();
        reader = new Scanner(System.in);
        board = new Card [4][4];
        shuffle();
        setCells();
        printCells();
        playGame();
    }

    public void playGame()
    {
        choosePairOfCards();
    }

    public void choosePairOfCards()
    {
        int cardChoise, row1, col1, row2, col2;
        System.out.println();
        System.out.println("Enter the number on the card.");
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
