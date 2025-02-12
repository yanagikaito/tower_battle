package factory;

import panel.GamePanel;

import javax.swing.*;
import java.awt.*;

public class PanelFactory extends GamePanel {

    @Override
    public JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        return panel;
    }

    @Override
    public JPanel createStartButtonPanel() {
        JPanel startButtonPanel = new JPanel();
        startButtonPanel.setBackground(Color.BLACK);
        return startButtonPanel;
    }

    @Override
    public JPanel createMainTextPanel() {
        JPanel mainTextPanel = new JPanel();
        mainTextPanel.setBackground(Color.BLACK);
        return mainTextPanel;
    }

    @Override
    public JPanel createChoiceButtonPanel() {
        JPanel choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBackground(Color.BLACK);
        return choiceButtonPanel;
    }

    @Override
    public JPanel createPlayerStatusPanel() {
        JPanel playerStatusPanel = new JPanel();
        playerStatusPanel.setBackground(Color.BLACK);
        return playerStatusPanel;
    }

    @Override
    public JPanel createDevilsTowerPanel() {
        JPanel devilsTowerPanel = new JPanel();
        devilsTowerPanel.setBackground(Color.BLACK);
        return devilsTowerPanel;
    }

    @Override
    public JPanel createBattlePanel() {
        JPanel battlePanel = new JPanel();
        battlePanel.setBounds(20, 50, 683, 455);
        battlePanel.setLayout(new GridLayout(4, 6));
        battlePanel.setBackground(Color.BLACK);
        return battlePanel;
    }

    @Override
    public JPanel createMonsterDisplayPanel() {
        JPanel monsterDisplayPanel = new JPanel();
        monsterDisplayPanel.setBounds(20, 100, 500, 50);
        monsterDisplayPanel.setBackground(Color.BLACK);
        return monsterDisplayPanel;
    }
}