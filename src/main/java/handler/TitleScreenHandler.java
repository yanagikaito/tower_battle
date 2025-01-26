package handler;

import window.GameWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public record TitleScreenHandler(GameWindow gameWindow) implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        gameWindow.createGameScreen();
    }
}
