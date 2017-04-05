import java.util.Scanner;

public class GetInput {

    private Scanner reader;

    public String getInput() {
        reader = new Scanner(System.in);
        String input = reader.nextLine();
        return input;
    }
}
