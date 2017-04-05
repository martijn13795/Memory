public class Card {
    boolean showing;
    String back;
    int front;

    public Card(String theBack, int theFront)
    {
        showing = false;
        back = theBack;
        front = theFront;
    }

    public void showCard()
    {
        if (showing)
            System.out.print(String.format("%10s", back));
        else
            System.out.print(String.format("%10s","["+front+"]"));
    }

    public void setShowingStatus()
    {
        if (showing)
            showing = false;
        else
            showing = true;
    }
}
