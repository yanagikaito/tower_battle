package factory;

import font.GameFont;

import javax.swing.*;
import java.awt.*;

public class FontFactory extends GameFont {

    @Override
    public Font createFont() {
        return new Font("アリアル", Font.PLAIN, 65);
    }

    @Override
    public Font createNormalFont() {
        return new Font("アリアル", Font.PLAIN, 25);
    }

    @Override
    public JTextArea createTextArea(String text) {
        JTextArea textArea = new JTextArea("町の施設");
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setLineWrap(true);
        return textArea;
    }
}