package BlackJack.view;

public class SwedishView implements IView {
    public void DisplayWelcomeMessage() {

        for (int i = 0; i < 50; i++) {
            System.out.print("\n");
        }
        ;

        System.out.println("Hej Black Jack Världen");
        System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta");
    }

    @Override
    public operation GetInput() {
        try {
            int input = System.in.read();
            if (input == 'p' || input == 'P') {
                return operation.Play;
            } else if (input == 'h' || input == 'H') {
                return operation.Hit;
            } else if (input == 's' || input == 'S') {
                return operation.Stand;
            } else if (input == 'q' || input == 'Q') {
                return operation.Quit;
            } 

        } catch (java.io.IOException e) {
            System.out.println("" + e);
        }
        return null;
    }


    public void DisplayCard(BlackJack.model.Card a_card) {
        if (a_card.GetColor() == BlackJack.model.Card.Color.Hidden) {
            System.out.println("Dolt Kort");
        } else {
            String colors[] =
                    {"Hjärter", "Spader", "Ruter", "Klöver"};
            String values[] =
                    {"två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess"};
            System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
        }
    }

    public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
        DisplayHand("Spelare", a_hand, a_score);
    }

    public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
        DisplayHand("Croupier", a_hand, a_score);
    }

    public void DisplayGameOver(boolean a_dealerIsWinner) {
        System.out.println("Slut: ");
        if (a_dealerIsWinner) {
            System.out.println("Croupiern Vann!");
        } else {
            System.out.println("Du vann!");
        }
    }

    @Override
    public void PrintError(String message) {
        System.out.println(message);
    }


    @Override
    public void DisplayDealingCard() {
        System.out.println("****************************** Vänta ***********************");
        System.out.println("givaren började dela korten");
    }

    private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score) {
        System.out.println(a_name + " Har: " + a_score);
        for (BlackJack.model.Card c : a_hand) {
            DisplayCard(c);
        }
        System.out.println("Poäng: " + a_score);
        System.out.println("");
    }
}
