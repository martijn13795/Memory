public class PlayerInfo {
    private Boolean multiplayer = false;
    private String player1;
    private String player2;

    public String setName() {
        System.out.print("Multiplayer? >");
        if (new GetInput().getInput().equals("Yes")) {
            multiplayer = true;
            System.out.print("Player1 name >");
            player1 = new GetInput().getInput();
            System.out.print("Player2 name >");
            player2 =  new GetInput().getInput();
            return player1 + player2;
        } else {
            multiplayer = false;
            System.out.print("Player1 name >");
            player1 =  new GetInput().getInput();
            return player1;
        }
    }

    public String getName() {
        if (multiplayer) {
            return player1 + player2;
        } else {
            return player1;
        }
    }
}
