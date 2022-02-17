package BlackJack.view;

import BlackJack.model.Card;

public class SimpleView implements IView {


    public void DisplayWelcomeMessage() {
        for (int i = 0; i < 50; i++) {
            System.out.print("\n");
        }

        System.out.println("Hello Black Jack World");
        System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit");

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


    public void DisplayCard(Card a_card) {
        System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
    }

    public void DisplayPlayerHand(Iterable<Card> a_hand, int a_score) {
        DisplayHand("Player", a_hand, a_score);
    }

    public void DisplayDealerHand(Iterable<Card> a_hand, int a_score) {
        DisplayHand("Dealer", a_hand, a_score);
    }

    private void DisplayHand(String a_name, Iterable<Card> a_hand, int a_score) {
        System.out.println(a_name + " Has: ");
        for (Card c : a_hand) {
            DisplayCard(c);
        }
        System.out.println("Score: " + a_score);
        System.out.println("");
    }

    public void DisplayGameOver(boolean a_dealerIsWinner) {
        System.out.println("GameOver: ");
        if (a_dealerIsWinner) {
            System.out.println("Dealer Won!");
        } else {
            System.out.println("You Won!");
        }

    }

    @Override
    public void PrintError(String message) {
        System.out.println(message);

    }

    @Override
    public void DisplayDealingCard() {
        System.out.println("****************************** W A I T ***********************");
        System.out.println("Dealer started dealing cards");
    }


}
