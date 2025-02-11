package factory;

import scroll.GameScroll;

import javax.swing.*;
import java.awt.*;

public class BattleScreenFactory extends GameScroll {

    @Override
    public JScrollPane createBattleScreenScroll() {
        JTextArea battleLog = new JTextArea(10, 30);
        battleLog.setEditable(false);
        JFrame frame = new JFrame();
        JScrollPane battleScreenScroll = new JScrollPane(battleLog);
        battleScreenScroll.setBounds(20, 20, 700, 500);
        battleScreenScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        battleScreenScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        frame.getContentPane().add(battleScreenScroll, BorderLayout.CENTER);
        return battleScreenScroll;
    }
}
