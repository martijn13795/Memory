import javax.swing.*;

public class ChoosePairOfCards {

    private String currentPlayer = "";
    GetInput input = new GetInput();
    MakeCards cards = new MakeCards();
    Card[][] board = cards.makeCards();
    Print print = new Print();

    public void choosePairOfCards(PlayerInfo player1, PlayerInfo player2) {
        new Print().printCards(board);
        if (currentPlayer.equals("")) {
            currentPlayer = player1.getName();
        }
        int cardChoice, row1, col1, row2, col2;
        System.out.println();
        System.out.println(currentPlayer+" enter the number on the card.");
        System.out.print("First Card Choice? >");
        cardChoice = Integer.parseInt(input.getInput());
        row1 = cardChoice / 4;
        col1 = cardChoice % 4;
        board[row1][col1] = new StateVisible().setShowingStatus(true, board[row1][col1]);

        System.out.print("Second Card Choice? >");
        cardChoice = Integer.parseInt(input.getInput());
        row2 = cardChoice / 4;
        col2 = cardChoice % 4;
        board[row2][col2] = new StateVisible().setShowingStatus(true, board[row2][col2]);

        System.out.print('\u000C'); //clears the screen

        print.printCards(board);


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
                System.out.println(player2.getName() + "\'s score: " + "score");
            }
            return;
        }

        if (board[row1][col1].back.equals(board[row2][col2].back)) {
            Score score = new Score();
            score.setScore(currentPlayer, player1, player2);
            System.out.println("You have scored!");
            print.print("Player 1 score: " + score.getScoreP1());
            if (player2 != null){
                print.print("Player 2 score: " + score.getScoreP2());
            }
            choosePairOfCards(player1, player2);
        } else {
            System.out.println("Better luck next time");
            if (currentPlayer.equals(player1.getName())){
                currentPlayer = player2.getName();
            } else {
                currentPlayer = player1.getName();
            }
            board[row1][col1] = new StateInvisible().setShowingStatus(false, board[row1][col1]);
            board[row2][col2] = new StateInvisible().setShowingStatus(false, board[row2][col2]);
            System.out.print('\u000C');
            choosePairOfCards(player1, player2);
        }
    }
}
