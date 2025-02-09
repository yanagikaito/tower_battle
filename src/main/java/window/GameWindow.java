package window;

import button.GameButton;
import factory.*;
import font.GameFont;
import frame.GameFrame;
import handler.ChoiceHandler;
import handler.TitleScreenHandler;
import label.GameLabel;
import panel.GamePanel;
import scroll.GameScroll;
import status.MonsterStatus;
import status.PlayerStatus;

import javax.swing.*;
import java.awt.*;

import static frame.FrameApp.*;

public class GameWindow implements Window {

    private GameFrame gameFrame = FrameFactoryImpl.createFrame(baseDisplay());
    private GameFont gameFont = new FontFactory();
    private GamePanel gamePanel = new PanelFactory();
    private GameLabel gameLabel = new LabelFactory();
    private GameButton gameButton = new ButtonFactory();
    private GameScroll gameScroll = new BattleScreenFactory();

    // ウィンドウ作成
    private JFrame window;
    private Container con;
    private String statusPosition = "ステータス";
    private String devilsPosition = "魔の塔";
    private JPanel titleNamePanel = gamePanel.createPanel();
    private JPanel startButtonPanel = gamePanel.createStartButtonPanel();
    private JPanel mainTextPanel = gamePanel.createMainTextPanel();
    private JPanel choiceButtonPanel = gamePanel.createChoiceButtonPanel();
    private JPanel playerStatusPanel = gamePanel.createPlayerStatusPanel();
    private JPanel devilsTowerPanel = gamePanel.createDevilsTowerPanel();
    private JLabel titleNameLabel = gameLabel.createLabel("");
    private JLabel playerLvLabel = gameLabel.createPlayerLvLabelText("");
    private JLabel playerLvLabelNumber = gameLabel.createPlayerLvLabelNumber();
    private JLabel hpLabel = gameLabel.createHPLabelText("");
    private JLabel hpLabelNumber = gameLabel.createHPLabelNumber();
    private JLabel atkLabel = gameLabel.createATKLabelText("");
    private JLabel atkLabelNumber = gameLabel.createATKLabelNumber();
    private JLabel defLabelText = gameLabel.createDEFLabelText("");
    private JLabel defLabelNumber = gameLabel.createDEFLabelNumber();
    private JLabel weaponLabel = gameLabel.createWeaponLabel("");
    private JLabel weaponLabelName = gameLabel.createWeaponLabelTextName();
    private JLabel defLabel = gameLabel.createDEFLabel("");
    private JLabel monsterLabel = gameLabel.createMonsterLabel("");
    private JLabel monsterLabelName = gameLabel.createMonsterLabelName();
    private JLabel monsterLvLabel = gameLabel.createMonsterLvLabel("");
    private JLabel monsterLvLabelNumber = gameLabel.createMonsterLvLabelNumber();
    private JLabel playerLabel = gameLabel.createPlayerLabel("");
    private JLabel playerLabelName = gameLabel.createPlayerLabelName();
    private JLabel defLabelName = gameLabel.createDEFLabelTextName();
    private JButton startButton = gameButton.createButton("");
    private JButton weaponShopButton = gameButton.createWeaponShopButton("");
    private JButton armorShopButton = gameButton.createArmorShopButton("");
    private JButton statusButton = gameButton.createStatusButton("");
    private JButton devilsTowerButton = gameButton.createDevilsTowerButton("");
    private JTextArea mainTextArea = gameFont.createTextArea("");
    private JScrollPane battleScreenScroll = gameScroll.createBattleScreenScroll();
    private Font titleFont = gameFont.createFont();
    private Font normalFont = gameFont.createNormalFont();
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
        weaponShopButton.addActionListener(csHandler);
        weaponShopButton.setActionCommand("c1");
        choiceButtonPanel.add(weaponShopButton);

        armorShopButton.setFont(normalFont);
        armorShopButton.addActionListener(csHandler);
        armorShopButton.setActionCommand("c2");
        choiceButtonPanel.add(armorShopButton);

        statusButton.setFont(normalFont);
        statusButton.addActionListener(csHandler);
        statusButton.setActionCommand("c3");
        choiceButtonPanel.add(statusButton);

        devilsTowerButton.setFont(normalFont);
        devilsTowerButton.addActionListener(csHandler);
        devilsTowerButton.setActionCommand("c4");
        choiceButtonPanel.add(devilsTowerButton);
    }

    @Override
    public void statusScreen() {

        // 2つのパネルを無効にする。
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);

        con.add(playerStatusPanel);
        playerStatusPanel.setBounds(80, 20, 600, 200);
        playerStatusPanel.setLayout(new GridLayout(6, 1));

        weaponLabel.setFont(normalFont);
        playerStatusPanel.add(weaponLabel);

        weaponLabelName.setFont(normalFont);
        playerStatusPanel.add(weaponLabelName);

        defLabel.setFont(normalFont);
        playerStatusPanel.add(defLabel);

        defLabelName.setFont(normalFont);
        playerStatusPanel.add(defLabelName);

        playerLvLabel.setFont(normalFont);
        playerStatusPanel.add(playerLvLabel);

        playerLvLabelNumber.setFont(normalFont);
        playerStatusPanel.add(playerLvLabelNumber);

        hpLabel.setFont(normalFont);
        playerStatusPanel.add(hpLabel);

        hpLabelNumber.setFont(normalFont);
        playerStatusPanel.add(hpLabelNumber);

        atkLabel.setFont(normalFont);
        playerStatusPanel.add(atkLabel);

        atkLabelNumber.setFont(normalFont);
        playerStatusPanel.add(atkLabelNumber);

        defLabelText.setFont(normalFont);
        playerStatusPanel.add(defLabelText);

        defLabelNumber.setFont(normalFont);
        playerStatusPanel.add(defLabelNumber);

        PlayerStatus.save(status -> {

            weaponLabelName.setText(status.weaponName());
            defLabelName.setText(status.armorName());
            hpLabelNumber.setText("" + status.hp());
            playerLvLabelNumber.setText("" + status.lv());
            atkLabelNumber.setText("" + status.atk());
            defLabelNumber.setText("" + status.def());
        });
    }

    @Override
    public void devilsTowerScreen() {

        // 2つのパネルを無効にする。
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);

        con.add(devilsTowerPanel);
        devilsTowerPanel.setBounds(0, 0, 768, 576);
        devilsTowerPanel.setLayout(new FlowLayout());
        devilsTowerPanel.add(battleScreenScroll);

        monsterLabel.setFont(normalFont);
        devilsTowerPanel.add(monsterLabel);

        monsterLabelName.setFont(normalFont);
        devilsTowerPanel.add(monsterLabelName);

        monsterLvLabel.setFont(normalFont);
        devilsTowerPanel.add(monsterLvLabel);

        monsterLvLabelNumber.setFont(normalFont);
        devilsTowerPanel.add(monsterLvLabelNumber);

        hpLabel.setFont(normalFont);
        devilsTowerPanel.add(hpLabel);

        hpLabelNumber.setFont(normalFont);
        devilsTowerPanel.add(hpLabelNumber);

        MonsterStatus.save(status -> {
            monsterLabelName.setText(status.monsterName());
            hpLabelNumber.setText(" " + status.hp());
            monsterLvLabelNumber.setText(" " + status.lv());
        });

        playerLabel.setFont(normalFont);
        devilsTowerPanel.add(playerLabel);

        playerLabelName.setFont(normalFont);
        devilsTowerPanel.add(playerLabelName);

        playerLvLabel.setFont(normalFont);
        devilsTowerPanel.add(playerLvLabel);

        playerLvLabelNumber.setFont(normalFont);
        devilsTowerPanel.add(playerLvLabelNumber);

        hpLabel.setFont(normalFont);
        devilsTowerPanel.add(hpLabel);

        hpLabelNumber.setFont(normalFont);
        devilsTowerPanel.add(hpLabelNumber);

        PlayerStatus.save(status -> {
            playerLabelName.setText(status.playerName());
            hpLabelNumber.setText("" + status.hp());
            playerLvLabelNumber.setText("" + status.lv());
        });
    }

    public String getStatusPosition() {
        return statusPosition;
    }

    public String getDevilsPosition() {
        return devilsPosition;
    }
}