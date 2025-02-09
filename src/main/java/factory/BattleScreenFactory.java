package factory;

import scroll.GameScroll;

import javax.swing.*;

public class BattleScreenFactory extends GameScroll {

    @Override
    public JScrollPane createBattleScreenScroll() {
        JScrollPane battleScreenScroll = new JScrollPane();
        battleScreenScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        battleScreenScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        return battleScreenScroll;
    }
}
