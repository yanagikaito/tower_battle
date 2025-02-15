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
        switch (gameWindow.getPosition()) {
            case "町の施設" -> {
                switch (yourChoice) {
                    case "c1" -> gameWindow.doorGuard();
                    case "c2" -> gameWindow.attackGuard();
                    case "c3" -> gameWindow.crossRoad();
                    case "c4" -> gameWindow.devilsTowerScreen();
                }
            }
            case "門番", "門番に攻撃" -> {
                switch (yourChoice) {
                    case "c1" -> gameWindow.town();
                }
            }
            case "分かれ道" -> {
                switch (yourChoice) {
                    case "c1" -> gameWindow.north();
                    case "c2" -> gameWindow.east();
                    case "c3" -> gameWindow.town();
                    case "c4" -> gameWindow.west();
                }
            }
            case "北", "東", "西" -> {
                switch (yourChoice) {
                    case "c1" -> gameWindow.crossRoad();
                }
            }
            case "負け" -> {
                switch (yourChoice) {
                    case "c1" -> gameWindow.crossRoad();
                }
            }
            case "魔の塔" -> {
                switch (yourChoice) {
                    case "c1" -> gameWindow.fight();
                    case "c2" -> gameWindow.crossRoad();
                }
            }
            case "勝ち" -> {
                switch (yourChoice) {
                    case "c1" -> gameWindow.crossRoad();
                }
            }
            case "たたかう" -> {
                switch (yourChoice) {
                    case "c1" -> gameWindow.playerAttack();
                    case "c2" -> gameWindow.crossRoad();
                }
            }
            case "プレイヤーの攻撃" -> {
                switch (yourChoice) {
                    case "c1" -> {
                        if (gameWindow.getMonsterHp() < 1) {
                            gameWindow.win();
                        } else {
                            gameWindow.monsterAttack();
                        }
                    }
                }
            }
            case "スライムの攻撃" -> {
                switch (yourChoice) {
                    case "c1" -> {
                        if (gameWindow.getPlayerHp() < 1) {
                            gameWindow.lose();
                        } else {
                            gameWindow.fight();
                        }
                    }
                }
            }
        }
    }
}