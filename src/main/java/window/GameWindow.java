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
import status.Status;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static frame.FrameApp.*;

public class GameWindow implements Window {

    // Factory
    private GameFrame gameFrame = FrameFactoryImpl.createFrame(baseDisplay());
    private GameFont gameFont = new FontFactory();
    private GamePanel gamePanel = new PanelFactory();
    private GameLabel gameLabel = new LabelFactory();
    private GameButton gameButton = new ButtonFactory();
    private GameScroll gameScroll = new BattleScreenFactory();

    private Status playerStatus = new PlayerStatus("勇者",
            "ナイフ",
            "戦士の盾",
            1,
            10,
            5,
            3);

    private Status monsterStatus = new MonsterStatus("スライム ",
            1,
            10,
            5,
            3);

    // ウィンドウ
    private JFrame window;
    private Container con;

    private Random random = new Random();

    // Position
    private String position;

    // JPanel
    private JPanel titleNamePanel = gamePanel.createPanel();
    private JPanel startButtonPanel = gamePanel.createStartButtonPanel();
    private JPanel mainTextPanel = gamePanel.createMainTextPanel();
    private JPanel choiceButtonPanel = gamePanel.createChoiceButtonPanel();
    private JPanel playerStatusPanel = gamePanel.createPlayerStatusPanel();
    private JPanel devilsTowerPanel = gamePanel.createDevilsTowerPanel();
    private JPanel battlePanel = gamePanel.createBattlePanel();
    private JPanel monsterDisplayPanel = gamePanel.createMonsterDisplayPanel();

    // JLabel
    private JLabel titleNameLabeltext = gameLabel.createLabelText("");
    private JLabel playerLvLabeltext = gameLabel.createPlayerLvLabelText("");
    private JLabel playerLvLabelNumber = gameLabel.createPlayerLvLabelNumber();
    private JLabel playerLabeltext = gameLabel.createPlayerLabelText("");
    private JLabel playerLabelName = gameLabel.createPlayerLabelName();
    private JLabel playerHPLabeltext = gameLabel.createPlayerHPLabelText("");
    private JLabel playerHPLabelNumber = gameLabel.createPlayerHPLabelNumber();
    private JLabel defLabelName = gameLabel.createDEFLabelTextName();
    private JLabel atkLabeltext = gameLabel.createATKLabelText("");
    private JLabel atkLabelNumber = gameLabel.createATKLabelNumber();
    private JLabel defLabelText = gameLabel.createDEFLabelText("");
    private JLabel defLabelNumber = gameLabel.createDEFLabelNumber();
    private JLabel weaponLabeltext = gameLabel.createWeaponLabelText("");
    private JLabel weaponLabelName = gameLabel.createWeaponLabelTextName();
    private JLabel defLabel = gameLabel.createDEFLabel("");
    private JLabel monsterLabeltext = gameLabel.createMonsterLabelText("");
    private JLabel monsterLabelName = gameLabel.createMonsterLabelName();
    private JLabel monsterLvLabeltext = gameLabel.createMonsterLvLabelText("");
    private JLabel monsterLvLabelNumber = gameLabel.createMonsterLvLabelNumber();
    private JLabel monsterHPLabeltext = gameLabel.createMonsterHPLabelText("");
    private JLabel monsterHPLabelNumber = gameLabel.createMonsterHPLabelNumber();

    // JButton
    private JButton startButton = gameButton.createButton("");
    private JButton choiceButton1 = gameButton.createWeaponShopButton("");
    private JButton choiceButton2 = gameButton.createArmorShopButton("");
    private JButton choiceButton3 = gameButton.createStatusButton("");
    private JButton choiceButton4 = gameButton.createDevilsTowerButton("");
    private JButton attackButton = gameButton.createAttackButton("");
    private JButton townButton = gameButton.createTownButton("");

    private JTextArea mainTextArea = gameFont.createTextArea("");
    private JScrollPane battleScreenScroll = gameScroll.createBattleScreenScroll();

    // Font
    private Font titleFont = gameFont.createFont();
    private Font normalFont = gameFont.createNormalFont();

    // Handler
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
        titleNameLabeltext.setForeground(Color.WHITE);
        titleNameLabeltext.setFont(titleFont);

        // スタートボタンパネル作成
        startButtonPanel.setBounds((createSize() * 5) + 40, (createSize() * 7) +
                (createSize() - 32), (createSize() * 3) + 36, createSize() + 32);

        // スタートボタン作成
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);

        // ウィンドウに貼り付け
        titleNamePanel.add(titleNameLabeltext);
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
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        con.add(choiceButtonPanel);

        choiceButton1.setFont(normalFont);
        choiceButton1.addActionListener(csHandler);
        choiceButton1.setActionCommand("c1");
        choiceButtonPanel.add(choiceButton1);

        choiceButton2.setFont(normalFont);
        choiceButton2.addActionListener(csHandler);
        choiceButton2.setActionCommand("c2");
        choiceButtonPanel.add(choiceButton2);

        choiceButton3.setFont(normalFont);
        choiceButton3.addActionListener(csHandler);
        choiceButton3.setActionCommand("c3");
        choiceButtonPanel.add(choiceButton3);

        choiceButton4.setFont(normalFont);
        choiceButton4.addActionListener(csHandler);
        choiceButton4.setActionCommand("c4");
        choiceButtonPanel.add(choiceButton4);

        statusScreen();
    }

    @Override
    public void statusScreen() {

        con.add(playerStatusPanel);
        playerStatusPanel.setBounds(80, 20, 600, 50);
        playerStatusPanel.setLayout(new GridLayout(1, 4));

        weaponLabeltext.setFont(normalFont);
        playerStatusPanel.add(weaponLabeltext);

        weaponLabelName.setFont(normalFont);
        playerStatusPanel.add(weaponLabelName);

        playerLvLabeltext.setFont(normalFont);
        playerStatusPanel.add(playerLvLabeltext);

        playerLvLabelNumber.setFont(normalFont);
        playerStatusPanel.add(playerLvLabelNumber);

        playerHPLabeltext.setFont(normalFont);
        playerStatusPanel.add(playerHPLabeltext);

        playerHPLabelNumber.setFont(normalFont);
        playerStatusPanel.add(playerHPLabelNumber);

        PlayerStatus.save(status -> {

            weaponLabelName.setText(status.weaponName());
            playerHPLabelNumber.setText("" + status.hp());
            playerLvLabelNumber.setText("" + status.lv());
        });

        town();
    }

    public void doorGuard() {

        position = "門番";
        mainTextArea.setText("門番 : ここを通すわけには,いかない");

        choiceButton1.setText(">");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void attackGuard() {

        position = "門番に攻撃";
        mainTextArea.setText("門番 :　おい,バカなマネはよせ。\n門番は反撃し,プレイヤーを攻撃した。\n(あなたは3ダメージを受けた。)");

        int valueHP = playerStatus.hp() - 3;
        if (valueHP < 0) {
            valueHP = 1;
        }
        playerStatus = new PlayerStatus("勇者",
                "ナイフ",
                "戦士の盾",
                1,
                valueHP,
                5,
                3);
        playerHPLabelNumber.setText("" + playerStatus.hp());
        choiceButton1.setText(">");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void town() {

        position = "町の施設";
        mainTextArea.setText("町の施設");

        choiceButton1.setText("門番");
        choiceButton2.setText("門番に攻撃");
        choiceButton3.setText("立ち去る");
        choiceButton4.setText("魔の塔");
    }

    @Override
    public void devilsTowerScreen() {

        position = "魔の塔";
        monsterStatus.hp();
        mainTextArea.setText(monsterStatus.name() + "に遭遇した");

        choiceButton1.setText("たたかう");
        choiceButton2.setText("逃げる");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void fight() {

    }

    public void playerAttack() {

        monsterLabelName.setVisible(false);
        monsterHPLabelNumber.setVisible(false);

        position = "プレイヤーの攻撃";
        int playerDamage = 0;
        playerDamage = random.nextInt(playerStatus.atk()) + 1;
        monsterHPLabeltext.setText(monsterStatus.name() + "攻撃し,"
                + playerDamage + "ダメージを与えた。" + "HP" + monsterStatus.hp());
        int monsterResult = monsterStatus.hp() - playerDamage;
        if (monsterResult <= 1) {
            win();
        } else {
            monsterHPLabeltext.setVisible(true);
        }
        monsterStatus = new MonsterStatus("スライム ",
                1,
                monsterResult,
                5,
                3);
    }

    public void crossRoad() {

        position = "分かれ道";
        mainTextArea.setText("ここからは分かれ道になっている。\n 南にいけば,町に戻れる。");

        choiceButton1.setText("北へ進む");
        choiceButton2.setText("東へ進む");
        choiceButton3.setText("南へ進む");
        choiceButton4.setText("西へ進む");
    }

    public void north() {

        int recovery = random.nextInt(5) + 1;
        position = "北";
        mainTextArea.setText("川がある。\n水を飲み,川辺で休んだ。\n\nプレイヤーのHPが" + recovery + "回復した。");
        int valueHP = playerStatus.hp() + recovery;
        if (valueHP >= 10) {
            valueHP = 10;
        }
        playerStatus = new PlayerStatus("勇者",
                "ナイフ",
                "戦士の盾",
                1,
                valueHP,
                5,
                3);

        playerHPLabelNumber.setText("" + playerStatus.hp());
        choiceButton1.setText(">");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    public void east() {

    }

    public void west() {

    }

    public void win() {
        monsterHPLabeltext.setText("モンスターを倒しました");
    }

    public void lose() {
        mainTextArea.setText("ゲームオーバー");
    }


    public String getPosition() {
        return position;
    }
}