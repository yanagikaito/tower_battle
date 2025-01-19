package handler;

import window.GameWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreenHandler implements ActionListener {

    GameWindow gameWindow;

    public TitleScreenHandler(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameWindow.createGameScreen();
    }
}
