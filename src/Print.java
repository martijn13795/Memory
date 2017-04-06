public class Print {
    public void print(String print) {
        System.out.println();
        System.out.println(print);
    }

    public void printCards(Card[][] board) {
        Card aCard;
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[0].length; col++)
            {
                aCard = board [row][col];
                //aCard.showCard();
                showCard(aCard);
            }
            System.out.println();
        }
    }

    public void showCard(Card acard)
    {
        if (acard.showing)
            System.out.print(String.format("%10s", acard.back));
        else
            System.out.print(String.format("%10s","["+acard.front+"]"));
    }
}
