package BlackJack.model.rules;

import BlackJack.model.Card;
import BlackJack.model.Dealer;
import BlackJack.model.Player;

class AmericanNewGameStrategy implements INewGameStrategy {

    public boolean NewGame(Dealer a_dealer, Player a_player) {
        Card c;
        a_dealer.DealCard(a_player, true);

        a_dealer.DealCard(a_dealer, true);

        a_dealer.DealCard(a_player, true);

        a_dealer.DealCard(a_dealer, false);

        return true;

    }
}