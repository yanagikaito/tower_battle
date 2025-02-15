package factory;

import button.GameButton;

import javax.swing.*;
import java.awt.*;

public class ButtonFactory extends GameButton {

    @Override
    public JButton createButton(String text) {
        JButton button = new JButton("スタート");
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        return button;
    }

    @Override
    public JButton createChoiceButton1(String text) {
        JButton choiceButton1 = new JButton("選択 1");
        choiceButton1.setBackground(Color.BLACK);
        choiceButton1.setForeground(Color.WHITE);
        choiceButton1.setFocusPainted(false);
        return choiceButton1;
    }

    @Override
    public JButton createChoiceButton2(String text) {
        JButton choiceButton2 = new JButton("選択 2");
        choiceButton2.setBackground(Color.BLACK);
        choiceButton2.setForeground(Color.WHITE);
        choiceButton2.setFocusPainted(false);
        return choiceButton2;
    }

    @Override
    public JButton createChoiceButton3(String text) {
        JButton choiceButton3 = new JButton("選択 3");
        choiceButton3.setBackground(Color.BLACK);
        choiceButton3.setForeground(Color.WHITE);
        choiceButton3.setFocusPainted(false);
        return choiceButton3;
    }

    @Override
    public JButton createChoiceButton4(String text) {
        JButton choiceButton4 = new JButton("選択 4");
        choiceButton4.setBackground(Color.BLACK);
        choiceButton4.setForeground(Color.WHITE);
        choiceButton4.setFocusPainted(false);
        return choiceButton4;
    }
}