package handler;

import window.GameWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public record ChoiceHandler(GameWindow gameWindow) implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        // 選択されたボタンのコマンドの文字列がこの変数に入る
        String yourChoice = e.getActionCommand();

        // プレイヤーの現在地
        switch (gameWindow.getPosition()) {
            case "ステータス" -> {
                switch (yourChoice) {
                    case "c3" -> gameWindow.statusScreen();
                }
            }
        }
    }
}
