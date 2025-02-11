package handler;

import window.GameWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public record ChoiceHandler(GameWindow gameWindow) implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        // 選択されたボタンのコマンドの文字列がこの変数に入る
        String yourChoice = e.getActionCommand();

        // デバッグ用に現在のattackPositionを出力
//        System.out.println("現在 Position: " + gameWindow.getAttackPosition());
//        System.out.println("yourChoice: " + yourChoice);

        // プレイヤーの現在地
        switch (gameWindow.getStatusPosition()) {
            case "ステータス" -> {
                switch (yourChoice) {
                    case "c3" -> gameWindow.statusScreen();
                }
            }
        }
        switch (gameWindow.getDevilsPosition()) {
            case "魔の塔" -> {
                switch (yourChoice) {
                    case "c4" -> gameWindow.devilsTowerScreen();
                }
            }
        }
        switch (gameWindow.getAttackPosition()) {
            case "プレイヤーの攻撃" -> {
                switch (yourChoice) {
                    case "c1" -> gameWindow.playerAttack();
                }
            }
        }
    }
}