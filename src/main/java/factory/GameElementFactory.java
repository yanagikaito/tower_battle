package factory;

import javax.swing.*;

public abstract class GameElementFactory {
    public abstract JFrame createFrame();

    public abstract JPanel createPanel();

    public abstract JLabel createLabel(String text);

    public abstract JButton createButton(String text);

    public abstract JTextArea createTextArea(String text);
}
