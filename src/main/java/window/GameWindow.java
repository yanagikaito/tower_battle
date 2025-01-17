package window;

import factory.GameElementFactory;

import javax.swing.*;
import java.awt.*;

public record GameWindow(GameElementFactory factory,
                         Container con,
                         JPanel titleNamePanel,
                         JPanel startButtonPanel,
                         JLabel titleNameLabel,
                         JButton startButton,
                         Font titleFont,
                         Font normalFont) implements Window {

    @Override
    public void frame() {

        // タイトルパネル作成
        titleNamePanel.setBounds(factory.createSize() + 52, factory.createSize() + 32,
                factory.createSize() * 11, factory.createSize() * 2);

        // タイトルラベル作成
        titleNamePanel.setBackground(Color.BLACK);
        titleNameLabel.setForeground(Color.WHITE);
        titleNameLabel.setFont(titleFont);

        // スタートボタンパネル作成
        startButtonPanel.setBounds((factory.createSize() * 5) + 40, (factory.createSize() * 7) +
                (factory.createSize() - 32), (factory.createSize() * 3) + 36, factory.createSize() + 32);
        startButtonPanel.setBackground(Color.BLUE);

        // スタートボタン作成
        startButton.setFont(normalFont);

        // ウィンドウに貼り付け
        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        con.add(titleNamePanel);
        con.add(startButtonPanel);
    }
}
