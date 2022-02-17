package BlackJack;

import BlackJack.controller.PlayGame;
import BlackJack.model.Game;
import BlackJack.view.IView;
import BlackJack.view.SimpleView;

public class Program {

    public static void main(String[] a_args) {

        Game theGame = new Game();
        IView theView = new SimpleView();
        PlayGame ctrl = new PlayGame(theGame, theView);

        while (ctrl.Play()) ;
    }
}