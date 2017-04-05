import java.util.Random;

public class MakeCards {

    private Card [][] board;
    private String[] names = {"Jochen", "Jochen", "Winnie", "Winnie", "René", "René", "Niels", "Niels", "Rob", "Rob", "Elleke", "Elleke", "Jeroen", "Jeroen", "Albert", "Albert"};
    private Random r;

    public Card[][] makeCards() {
        shuffle();
        board = new Card [4][4];
        int a = 0;
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[0].length; col++)
            {
                {
                    board[row][col] = new Card(names[a], a);
                    a++;
                }
            }
        }
        return board;
    }

    public void shuffle() {
        r = new Random();
        for (int a = 0; a < names.length; a++)
        {
            int pos = r.nextInt(names.length);
            String temp = names[a];
            names[a] = names[pos];
            names[pos] = temp;
        }
    }

    public void printCards(Card[][] board) {
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
}
