package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public class PlayerWinOddStrategy implements IWhoWins {
    private final int game_maxScore = 21;

    //player have more chance to win 
    @Override
    public boolean IsDealerTheWinner(Dealer a_dealer, Player a_player) {
        if (a_player.CalcScore() > game_maxScore) {
            return true;
        } else if (a_dealer.CalcScore() > game_maxScore) {
            return false;
        } else if (a_dealer.CalcScore() == a_player.CalcScore()) {
            return false;
        }

        if (a_dealer.CalcScore() > a_player.CalcScore()) return true;
        else return false;
    }


}
