package factory;

import javax.swing.*;
import java.awt.*;

public abstract class GameElementFactory {

    public abstract JFrame createFrame();

    public abstract JPanel createPanel();

    public abstract int createSize();

    public abstract Font createFont();

    public abstract JLabel createLabel(String text);

    public abstract JButton createButton(String text);

    public abstract JTextArea createTextArea(String text);
}
