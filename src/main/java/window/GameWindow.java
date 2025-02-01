package window;

import factory.ConcreteGameElementFactory;
import factory.GameElementFactory;
import handler.ChoiceHandler;
import handler.TitleScreenHandler;
import status.PlayerStatus;
import status.Status;

import javax.swing.*;
import java.awt.*;

public class GameWindow implements Window {

    private GameElementFactory factory = new ConcreteGameElementFactory();
    private Status status = new PlayerStatus(1, 10, 5, 3);

    // ウィンドウ作成
    private JFrame window;
    private Container con;
    private String position = "ステータス";
    private JPanel titleNamePanel = factory.createPanel();
    private JPanel startButtonPanel = factory.createStartButtonPanel();
    private JPanel mainTextPanel = factory.createMainTextPanel();
    private JPanel choiceButtonPanel = factory.createChoiceButtonPanel();
    private JPanel playerStatusPanel = factory.createPlayerStatusPanel();
    private JLabel titleNameLabel = factory.createLabel("TOWER BATTLE");
    private JLabel lvLabel = factory.createLvLabelText("LV");
    private JLabel lvLabelNumber = factory.createLvLabelNumber();
    private JLabel hpLabel = factory.createHPLabelText("HP");
    private JLabel hpLabelNumber = factory.createHPLabelNumber();
    private JLabel atkLabel = factory.createATKLabelText("攻撃力");
    private JLabel atkLabelNumber = factory.createATKLabelNumber();
    private JLabel defLabel = factory.createDEFLabelText("防御力");
    private JLabel defLabelNumber = factory.createDEFLabelNumber();
    private JButton startButton = factory.createButton("スタート");
    private JButton weaponShopButton = factory.createWeaponShopButton("武器屋");
    private JButton armorShopButton = factory.createArmorShopButton("防具屋");
    private JButton statusButton = factory.createStatusButton("ステータス");
    private JButton devilsTowerButton = factory.createDevilsTowerButton("魔の塔");
    private JTextArea mainTextArea = factory.createTextArea("町の施設");
    private Font titleFont = factory.createFont();
    private Font normalFont = factory.createNormalFont();
    private ChoiceHandler csHandler = new ChoiceHandler(this);
    private TitleScreenHandler tsHandler = new TitleScreenHandler(this);

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
        mainTextPanel.setBounds(factory.createSize() + 32, factory.createSize() + 32,
                (factory.createSize() * 10) + 120, (factory.createSize() * 5) + 10);
        con.add(mainTextPanel);

        mainTextArea.setBounds((factory.createSize() * 2) + 4, (factory.createSize() * 2) + 4,
                (factory.createSize() * 10) + 120, (factory.createSize() * 5) + 10);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        // 選択ボタン作成
        choiceButtonPanel.setBounds((factory.createSize() * 5) - 10,
                (factory.createSize() * 5) + 110,
                (factory.createSize() * 5) + 60, (factory.createSize() * 3) + 6);
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

        hpLabelNumber.setText("" + status.hp());
        lvLabelNumber.setText("" + status.lv());
        atkLabelNumber.setText("" + status.atk());
        defLabelNumber.setText("" + status.def());
    }

    public String getPosition() {
        return position;
    }
}