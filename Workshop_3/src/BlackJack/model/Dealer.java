package BlackJack.model;

import BlackJack.model.rules.IHitStrategy;
import BlackJack.model.rules.INewGameStrategy;
import BlackJack.model.rules.IWhoWins;
import BlackJack.model.rules.RulesFactory;

public class Dealer extends Player {

    private Deck m_deck;
    private INewGameStrategy m_newGameRule;
    private IHitStrategy m_hitRule;
    private IWhoWins m_winRule;

    public Dealer(RulesFactory a_rulesFactory) {

        m_newGameRule = a_rulesFactory.GetNewGameRule();
        m_hitRule = a_rulesFactory.GetHitRule();
        m_winRule = a_rulesFactory.GetWinRule();

    }


    public boolean NewGame(Player a_player) {
        if (m_deck == null || IsGameOver()) {
            m_deck = new Deck();
            ClearHand();
            a_player.ClearHand();
            return m_newGameRule.NewGame(this, a_player);
        }
        return false;
    }

    public boolean Hit(Player a_player) {
        if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
            // Card c;
//      c = m_deck.GetCard(); /// no changes in this part **
//      c.Show(true);
            DealCard(a_player, true);

            return true;
        }
        return false;
    }

    public boolean IsDealerWinner(Player a_player) {
        return m_winRule.IsDealerTheWinner(this, a_player);
    }

    public boolean IsGameOver() {
        if (m_deck != null && m_hitRule.DoHit(this) != true) {
            return true;
        }
        return false;
    }

    public boolean Stand() {
        if (m_deck != null) {
            ShowHand();
            while (m_hitRule.DoHit(this)) {
                DealCard(this, true);
            }
            return true;
        }
        return false;

    }

    public void DealCard(Player the_player, boolean is_Shown) {

        Card c = m_deck.GetCard();
        c.Show(is_Shown);
        the_player.DealCard(c);
    }
}