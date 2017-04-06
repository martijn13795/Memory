public class PlayGame {

    PlayerInfo player1 = new PlayerInfo();
    PlayerInfo player2 = new PlayerInfo();
    GetInput input = new GetInput();


    public static void main(String[] args) {
        new PlayGame().playGame();
    }

    public void playGame() {
        System.out.print("Multiplayer? >");
        if (new GetInput().getInput().equals("Yes")) {
            System.out.print("Player1 name >");
            player1.setName(input.getInput());

            System.out.print("Player2 name >");
            player2.setName(input.getInput());

            new Print().print("Player1: "+player1.getName()+" | Player2: "+player2.getName());
        } else {
            System.out.print("Player1 name >");
            player1.setName(input.getInput());
            new Print().print("Player1: "+player1.getName());
        }

        new ChoosePairOfCards().choosePairOfCards(player1, player2);

    }
}
