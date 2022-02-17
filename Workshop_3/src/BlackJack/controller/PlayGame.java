package BlackJack.controller;

import BlackJack.model.Game;
import BlackJack.model.IObserver;
import BlackJack.view.IView;
import BlackJack.view.IView.operation;


public class PlayGame implements IObserver {
    private Game m_game;
    private IView m_view;
    private int latency = 1000;

    public PlayGame(Game x_game, IView x_view) {
        m_game = x_game;
        m_view = x_view;
        save(this);
    }

    //@SuppressWarnings("resource")
    public boolean Play() {
        m_view.DisplayWelcomeMessage();
        m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
        m_view.DisplayPlayerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());

        if (m_game.IsGameOver()) {
            m_view.DisplayGameOver(m_game.IsDealerWinner());
        }

        operation input = m_view.GetInput();
        if (input == operation.Play) {
            m_game.NewGame();
        } else if (input == operation.Hit) {
            m_game.Hit();
        } else if (input == operation.Stand) {
            m_game.Stand();
            m_game.IsGameOver();
        }
        return input != operation.Quit;

    }


    @Override
    public void update(int a_delay) {

        try {
            m_view.DisplayDealingCard();
            Thread.sleep(a_delay);
            m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
            m_view.DisplayDealingCard();
            Thread.sleep(a_delay);
            m_view.DisplayPlayerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());
            Thread.sleep(a_delay);
        } catch (InterruptedException e) {
            m_view.PrintError(e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        }

    }


    public void save(IObserver a_observer) {
        this.m_game.save(a_observer);
    }


}