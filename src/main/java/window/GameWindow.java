package window;

import factory.ConcreteGameElementFactory;
import factory.GameElementFactory;
import handler.TitleScreenHandler;

import javax.swing.*;
import java.awt.*;

public class GameWindow implements Window {

    GameElementFactory factory = new ConcreteGameElementFactory();

    // ウィンドウ作成
    JFrame window;
    Container con;
    JPanel titleNamePanel = factory.createPanel();
    JPanel startButtonPanel = factory.createStartButtonPanel();
    JPanel mainTextPanel = factory.createMainTextPanel();
    JLabel titleNameLabel = factory.createLabel("TOWER BATTLE");
    JButton startButton = factory.createButton("スタート");
    JTextArea mainTextArea = factory.createTextArea("これはメインのテキストエリア");
    Font titleFont = factory.createFont();
    Font normalFont = factory.createNormalFont();
    TitleScreenHandler tsHandler = new TitleScreenHandler(this);

    @Override
    public void frame() {

        window = factory.createFrame();
        con = window.getContentPane();

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
        startButton.addActionListener(tsHandler);

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
}
