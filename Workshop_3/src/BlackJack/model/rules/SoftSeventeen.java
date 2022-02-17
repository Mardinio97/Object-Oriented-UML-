package BlackJack.model.rules;

import BlackJack.model.Card;
import BlackJack.model.Player;

public class SoftSeventeen implements IHitStrategy{


        private final int g_hitLimit = 17;

        public boolean DoHit(Player a_dealer) {


            int currentPlayerOrDealerScore = a_dealer.CalcScore();
            if (currentPlayerOrDealerScore < g_hitLimit) {
                return true;
            }
            if (g_hitLimit == currentPlayerOrDealerScore && a_dealer.checkIfAce()) {
                return true;
            }
            return false;
        }




//            if (a_dealer.CalcScore() == g_hitLimit) {
//                int cardScores[] = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11 };
//                int score = 0;
//                for (Card c : a_dealer.GetHand()) {
//                    if (c.GetValue() != Card.Value.Ace) {
//                        score += cardScores[c.GetValue().ordinal()];
//                    }
//                }
//                return score <= 6;
//            }
//            return a_dealer.CalcScore() < g_hitLimit;
//        }

    }

