public class StateInvisible implements State {

    public Card setShowingStatus(Boolean isVisible, Card board)
    {
        if (isVisible == false)
            board.showing = false;
        return board;
    }
}
