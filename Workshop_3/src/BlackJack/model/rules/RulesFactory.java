package BlackJack.model.rules;

public class RulesFactory {

    public IHitStrategy GetHitRule() {
        return new SoftSeventeen();
    }

    public INewGameStrategy GetNewGameRule() {
        return new AmericanNewGameStrategy();
    }

    public IWhoWins GetWinRule() {
        return new PlayerWinOddStrategy();
    }
}