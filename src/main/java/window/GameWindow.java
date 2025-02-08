package window;

import factory.ConcreteGameElementFactory;
import factory.FrameFactoryImpl;
import factory.GameElementFactory;
import frame.GameFrame;
import handler.ChoiceHandler;
import handler.TitleScreenHandler;
import status.PlayerStatus;

import javax.swing.*;
import java.awt.*;

import static frame.FrameApp.*;

public class GameWindow implements Window {

    private GameFrame gameFrame = FrameFactoryImpl.createFrame(baseDisplay());
    private GameElementFactory factory = new ConcreteGameElementFactory();

    // ウィンドウ作成
    private JFrame window;
    private Container con;
    private String position = "ステータス";
    private JPanel titleNamePanel = factory.createPanel();
    private JPanel startButtonPanel = factory.createStartButtonPanel();
    private JPanel mainTextPanel = factory.createMainTextPanel();
    private JPanel choiceButtonPanel = factory.createChoiceButtonPanel();
    private JPanel playerStatusPanel = factory.createPlayerStatusPanel();
    private JLabel titleNameLabel = factory.createLabel("");
    private JLabel lvLabel = factory.createLvLabelText("");
    private JLabel lvLabelNumber = factory.createLvLabelNumber();
    private JLabel hpLabel = factory.createHPLabelText("");
    private JLabel hpLabelNumber = factory.createHPLabelNumber();
    private JLabel atkLabel = factory.createATKLabelText("");
    private JLabel atkLabelNumber = factory.createATKLabelNumber();
    private JLabel defLabel = factory.createDEFLabelText("");
    private JLabel defLabelNumber = factory.createDEFLabelNumber();
    private JButton startButton = factory.createButton("");
    private JButton weaponShopButton = factory.createWeaponShopButton("");
    private JButton armorShopButton = factory.createArmorShopButton("");
    private JButton statusButton = factory.createStatusButton("");
    private JButton devilsTowerButton = factory.createDevilsTowerButton("");
    private JTextArea mainTextArea = factory.createTextArea("");
    private Font titleFont = factory.createFont();
    private Font normalFont = factory.createNormalFont();
    private ChoiceHandler csHandler = new ChoiceHandler(this);
    private TitleScreenHandler tsHandler = new TitleScreenHandler(this);

    @Override
    public void frame() {

        window = gameFrame.createFrame();
        con = window.getContentPane();

        // タイトルパネル作成
        titleNamePanel.setBounds(createSize() + 52, createSize() + 32,
                createSize() * 11, createSize() * 2);

        // タイトルラベル作成
        titleNameLabel.setForeground(Color.WHITE);
        titleNameLabel.setFont(titleFont);

        // スタートボタンパネル作成
        startButtonPanel.setBounds((createSize() * 5) + 40, (createSize() * 7) +
                (createSize() - 32), (createSize() * 3) + 36, createSize() + 32);

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
        mainTextPanel.setBounds(createSize() + 32, createSize() + 32,
                (createSize() * 10) + 120, (createSize() * 5) + 10);
        con.add(mainTextPanel);

        mainTextArea.setBounds((createSize() * 2) + 4, (createSize() * 2) + 4,
                (createSize() * 10) + 120, (createSize() * 5) + 10);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        // 選択ボタン作成
        choiceButtonPanel.setBounds((createSize() * 5) - 10,
                (createSize() * 5) + 110,
                (createSize() * 5) + 60, (createSize() * 3) + 6);
        choiceButtonPanel.setLayout(new FlowLayout());
        con.add(choiceButtonPanel);

        weaponShopButton.setFont(normalFont);
        choiceButtonPanel.add(weaponShopButton);

        armorShopButton.setFont(normalFont);
        choiceButtonPanel.add(armorShopButton);

        statusButton.setFont(normalFont);
        statusButton.addActionListener(csHandler);
        statusButton.setActionCommand("c3");
        choiceButtonPanel.add(statusButton);

        devilsTowerButton.setFont(normalFont);
        choiceButtonPanel.add(devilsTowerButton);
    }

    @Override
    public void statusScreen() {

        // 2つのパネルを無効にする。
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);

        con.add(playerStatusPanel);
        playerStatusPanel.setBounds(80, 20, 600, 200);
        playerStatusPanel.setLayout(new GridLayout(5, 4));

        lvLabel.setFont(normalFont);
        playerStatusPanel.add(lvLabel);

        lvLabelNumber.setFont(normalFont);
        playerStatusPanel.add(lvLabelNumber);

        hpLabel.setFont(normalFont);
        playerStatusPanel.add(hpLabel);

        hpLabelNumber.setFont(normalFont);
        playerStatusPanel.add(hpLabelNumber);

        atkLabel.setFont(normalFont);
        playerStatusPanel.add(atkLabel);

        atkLabelNumber.setFont(normalFont);
        playerStatusPanel.add(atkLabelNumber);

        defLabel.setFont(normalFont);
        playerStatusPanel.add(defLabel);

        defLabelNumber.setFont(normalFont);
        playerStatusPanel.add(defLabelNumber);

        PlayerStatus.save(status -> {
            hpLabelNumber.setText("" + status.hp());
            lvLabelNumber.setText("" + status.lv());
            atkLabelNumber.setText("" + status.atk());
            defLabelNumber.setText("" + status.def());
        });
    }

    public String getPosition() {
        return position;
    }
}