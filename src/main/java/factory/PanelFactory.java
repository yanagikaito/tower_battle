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
}