public class StateVisible implements State {

    public Card setShowingStatus(Boolean isVisible, Card board)
    {
        if (isVisible)
            board.showing = true;
        return board;
    }
}
