package window;

import factory.GameElementFactory;

import javax.swing.*;
import java.awt.*;

public record GameWindow(GameElementFactory factory,
                         JFrame window,
                         Container con,
                         JPanel titleNamePanel,
                         JLabel titleNameLabel,
                         Font titleFont) implements Window {

    @Override
    public void frame() {

        titleNamePanel.setBounds(factory.createSize() + 52, factory.createSize() + 32,
                factory.createSize() * 11, factory.createSize() * 2);
        titleNamePanel.setBackground(Color.BLUE);
        titleNameLabel.setForeground(Color.WHITE);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);
        con.add(titleNamePanel);
    }
}
