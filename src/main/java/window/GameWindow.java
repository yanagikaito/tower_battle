package window;

import factory.GameElementFactory;

import javax.swing.*;
import java.awt.*;

public record GameWindow(GameElementFactory factory,
                         JFrame window,
                         Container con,
                         JPanel titleNamePanel) implements Window {

    @Override
    public void frame() {

        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.BLUE);
        con.add(titleNamePanel);
    }
}
