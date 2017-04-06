public class ChoosePairOfCards {

    private String currentPlayer;
    GetInput input = new GetInput();
    MakeCards cards = new MakeCards();
    Card[][] board = cards.makeCards();

    public void choosePairOfCards(PlayerInfo player1, PlayerInfo player2) {
        cards.printCards(board);
        currentPlayer = player1.getName();
        int cardChoice, row1, col1, row2, col2;
        System.out.println();
        System.out.println(currentPlayer+" enter the number on the card.");
        System.out.print("First Card Choice? >");
        cardChoice = Integer.parseInt(input.getInput());
        row1 = cardChoice / 4;
        col1 = cardChoice % 4;
        board[row1][col1].setShowingStatus();

        System.out.print("Second Card Choice? >");
        cardChoice = Integer.parseInt(input.getInput());
        row2 = cardChoice / 4;
        col2 = cardChoice % 4;
        board[row2][col2].setShowingStatus();

        System.out.print('\u000C'); //clears the screen

        cards.printCards(board);

        int a = 0;
        int gameOver = 0;
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[0].length; col++)
            {
                if (!board[row][col].showing) {
                    gameOver++;
                }
                a++;
            }
        }

        if (gameOver == 0) {
            System.out.println();
            System.out.println("Game Over");
            System.out.println(player1.getName()+"\'s score: " + "Score");
            if (player2.getName() != null) {
                System.out.println(player2 + "\'s score: " + "score");
            }
            return;
        }

        if (board[row1][col1].back.equals(board[row2][col2].back)) {

            choosePairOfCards(player1, player2);
        } else {
            board[row1][col1].setShowingStatus();
            board[row2][col2].setShowingStatus();
            System.out.print('\u000C');
            choosePairOfCards(player1, player2);
        }
    }
}
