public class Score {

    private int ScoreP1;
    private int ScoreP2;
    private boolean isMultiplayer;
    private Print scorePrinter;

    public void setScore(String currentPlayer,PlayerInfo player1, PlayerInfo player2){
        if (player2 == null) {
            isMultiplayer = false;
            ScoreP1++;
        }else {
            if (currentPlayer.equals(player1.getName())) {
                ScoreP1++;
            } else if (currentPlayer.equals(player2.getName())) {
                ScoreP2++;
            }
        }
    }

    public String getScoreP1(){
        return Integer.toString(ScoreP1);
        }

    public String getScoreP2(){
        return Integer.toString(ScoreP2);
    }


    public void getFinalScore(PlayerInfo player1, PlayerInfo player2){
        String winner = "null";
        int winnerScore = 0;

        if (isMultiplayer == false){
            scorePrinter.print("Congratulations " + player1.getName() + ", you scored " + Integer.toString(ScoreP1) + " points.");
        } else if (isMultiplayer == true){

            if (ScoreP1 > ScoreP2){
                winner = player1.getName();
                winnerScore = ScoreP1;
            }else if (ScoreP1 < ScoreP2){
                winner = player2.getName();
                winnerScore = ScoreP2;
            } else {
                scorePrinter.print("It seems like there is a draw, play again and find the one true winner!");
            }
            scorePrinter.print("Congratulations " + winner + ", you scored " + winnerScore + " points");
        }
    }


}
