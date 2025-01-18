package window;

import factory.GameElementFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public record GameWindow(GameElementFactory factory,
                         Container con,
                         JPanel titleNamePanel,
                         JPanel startButtonPanel,
                         JPanel mainTextPanel,
                         JLabel titleNameLabel,
                         JButton startButton,
                         JTextArea mainTextArea,
                         Font titleFont,
                         Font normalFont) implements Window, ActionListener {

    @Override
    public void frame() {

        // タイトルパネル作成
        titleNamePanel.setBounds(factory.createSize() + 52, factory.createSize() + 32,
                factory.createSize() * 11, factory.createSize() * 2);

        // タイトルラベル作成
        titleNameLabel.setForeground(Color.WHITE);
        titleNameLabel.setFont(titleFont);

        // スタートボタンパネル作成
        startButtonPanel.setBounds((factory.createSize() * 5) + 40, (factory.createSize() * 7) +
                (factory.createSize() - 32), (factory.createSize() * 3) + 36, factory.createSize() + 32);

        // スタートボタン作成
        startButton.setFont(normalFont);
        startButton.addActionListener(this);

        // ウィンドウに貼り付け
        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        con.add(titleNamePanel);
        con.add(startButtonPanel);
    }

    @Override
    public void createGameScreen() {

        // 2つのパネルを無効にする。
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        // ゲームメインのパネル作成
        mainTextPanel.setBounds(100, 100, 600, 250);
        con.add(mainTextPanel);

        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        createGameScreen();
    }
}
