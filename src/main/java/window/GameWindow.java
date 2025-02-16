package window;

import button.GameButton;
import factory.*;
import font.GameFont;
import frame.GameFrame;
import handler.ChoiceHandler;
import handler.TitleScreenHandler;
import label.GameLabel;
import panel.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static frame.FrameApp.*;

public class GameWindow extends JPanel implements Window {

    // Factory
    private GameFrame gameFrame = FrameFactoryImpl.createFrame(baseDisplay());
    private GameFont gameFont = new FontFactory();
    private GamePanel gamePanel = new PanelFactory();
    private GameLabel gameLabel = new LabelFactory();
    private GameButton gameButton = new ButtonFactory();

    // ウィンドウ
    private JFrame window;
    private Container con;

    // ステータス
    private int playerHp;
    private int playerLv;
    private String weaponName;
    private int weaponKnife;
    private int monsterHp;
    private int monsterAttack;
    private String monsterName;
    private int weaponLongSword;

    private Random random = new Random();

    // Position
    private String position;

    // JPanel
    private JPanel titleNamePanel = gamePanel.createPanel();
    private JPanel startButtonPanel = gamePanel.createStartButtonPanel();
    private JPanel mainTextPanel = gamePanel.createMainTextPanel();
    private JPanel choiceButtonPanel = gamePanel.createChoiceButtonPanel();
    private JPanel playerStatusPanel = gamePanel.createPlayerStatusPanel();

    // JLabel
    private JLabel titleNameLabeltext = gameLabel.createLabelText("");
    private JLabel playerLvLabeltext = gameLabel.createPlayerLvLabelText("");
    private JLabel playerLvLabelNumber = gameLabel.createPlayerLvLabelNumber();
    private JLabel playerHPLabeltext = gameLabel.createPlayerHPLabelText("");
    private JLabel playerHPLabelNumber = gameLabel.createPlayerHPLabelNumber();
    private JLabel weaponLabeltext = gameLabel.createWeaponLabelText("");
    private JLabel weaponLabelName = gameLabel.createWeaponLabelTextName();

    // JButton
    private JButton startButton = gameButton.createButton("");
    private JButton choiceButton1 = gameButton.createChoiceButton1("");
    private JButton choiceButton2 = gameButton.createChoiceButton2("");
    private JButton choiceButton3 = gameButton.createChoiceButton3("");
    private JButton choiceButton4 = gameButton.createChoiceButton4("");

    private JTextArea mainTextArea = gameFont.createTextArea("");

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
        mainTextPanel.setBounds(createSize() + 2, (createSize() * 7) - 14,
                (createSize() * 10) - 30, (createSize() * 5) + 10);
        con.add(mainTextPanel);

        mainTextArea.setText("町の施設");
        mainTextArea.setBounds(createSize() + 2, (createSize() * 7) - 14,
                (createSize() * 10) - 30, (createSize() * 5) + 10);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        // 選択ボタン作成
        choiceButtonPanel.setBounds((createSize() * 10) + 20,
                (createSize() * 7) + 14,
                (createSize() * 5), (createSize() * 3));
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
        playerStatusPanel.setBounds(500, 100, 270, 80);
        playerStatusPanel.setLayout(new GridLayout(3, 3));

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

        playerSetUp();
    }

    public void playerSetUp() {

        playerHp = 15;
        playerLv = 1;
        weaponName = "ナイフ";
        weaponKnife = 3;

        playerHPLabelNumber.setText("" + playerHp);
        playerLvLabelNumber.setText("" + playerLv);
        weaponLabelName.setText(weaponName);

        town();
    }

    @Override
    public void town() {

        position = "町の施設";
        mainTextArea.setText("町の施設");

        choiceButton1.setText("門番");
        choiceButton2.setText("門番に攻撃");
        choiceButton3.setText("立ち去る");
        choiceButton4.setText("魔の塔");
    }

    @Override
    public void doorGuard() {

        position = "門番";
        mainTextArea.setText("門番 : ここを通すわけには,いかない");

        choiceButton1.setText(">");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    @Override
    public void attackGuard() {

        position = "門番に攻撃";
        mainTextArea.setText("門番 :　おい,バカなマネはよせ。\n門番は反撃し,プレイヤーを攻撃した。\n(あなたは3ダメージを受けた。)");

        playerHp = playerHp - 3;
        if (playerHp < 0) {
            playerHp = 0;
        }

        playerHPLabelNumber.setText("" + playerHp);
        choiceButton1.setText(">");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    @Override
    public void devilsTowerScreen() {

        position = "魔の塔";
        monsterHp = 20;
        monsterName = "スライム";

        mainTextArea.setText("1階 :" + monsterName + "に遭遇した");

        choiceButton1.setText("たたかう");
        choiceButton2.setText("逃げる");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    @Override
    public void fight() {

        position = "たたかう";
        monsterName = "スライム";
        mainTextArea.setText(monsterName + "HP :" + monsterHp + "\n\n 何をする?");

        choiceButton1.setText("攻撃");
        choiceButton2.setText("逃げる");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    @Override
    public void playerAttack() {

        position = "プレイヤーの攻撃";
        int playerDamage = 0;
        if (weaponName.equals("ナイフ")) {
            playerDamage = random.nextInt(weaponKnife) + 1;
        } else if (weaponName.equals("ロングソード")) {
            playerDamage = random.nextInt(weaponLongSword + 10) + 1;
        }
        mainTextArea.setText(monsterName + "を攻撃し,"
                + playerDamage + "ダメージを与えた。" + "HP" + monsterHp);
        monsterHp = monsterHp - playerDamage;
        if (monsterHp <= 0) {
            monsterHp = 0;
        }

        choiceButton1.setText(">");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    @Override
    public void monsterAttack() {

        position = "スライムの攻撃";
        int monsterDamage = 0;
        monsterAttack = 3;
        monsterDamage = random.nextInt(monsterAttack) + 1;
        mainTextArea.setText("スライム" + "はプレイヤーに" + monsterDamage + "ダメージ与えた。");
        playerHp = playerHp - monsterDamage;
        if (playerHp <= 0) {
            playerHp = 0;
        }

        playerHPLabelNumber.setText("" + playerHp);

        choiceButton1.setText(">");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    @Override
    public void crossRoad() {

        position = "分かれ道";
        mainTextArea.setText("ここからは分かれ道になっている。\n 南にいけば,町に戻れる。");

        choiceButton1.setText("北へ進む");
        choiceButton2.setText("東へ進む");
        choiceButton3.setText("南へ進む");
        choiceButton4.setText("西へ進む");
    }

    @Override
    public void north() {

        int recovery = random.nextInt(5) + 1;
        position = "北";
        mainTextArea.setText("川がある。\n水を飲み,川辺で休んだ。\n\nプレイヤーのHPが" + recovery + "回復した。");
        playerHp = playerHp + recovery;
        if (playerHp >= 15) {
            playerHp = 15;
        }

        playerHPLabelNumber.setText("" + playerHp);
        choiceButton1.setText(">");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    @Override
    public void east() {

        position = "東";
        int weaponDrop = random.nextInt(3) + 1;
        if (weaponDrop == 3) {
            mainTextArea.setText("森に入り,ロングソードを見つける。 \n\nロングソードを手に入れた。");
            weaponName = "ロングソード";
            weaponLabelName.setText(weaponName);
        } else {
            mainTextArea.setText("森に入り,何も見つからなかった。");
        }

        choiceButton1.setText(">");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    @Override
    public void west() {

        position = "西";
        mainTextArea.setText("砂漠に入り,何も見つからなかった。");

        choiceButton1.setText(">");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    @Override
    public void win() {

        position = "勝ち";
        playerLvLabelNumber.setText("" + playerLv);
        playerHPLabelNumber.setText("" + playerHp);
        mainTextArea.setText("モンスターを倒しました");

        choiceButton1.setText("分かれ道");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }

    @Override
    public void lose() {

        playerHPLabelNumber.setText("" + playerHp);
        position = "負け";
        mainTextArea.setText("ゲームオーバー");

        choiceButton1.setText(">");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
    }


    public String getPosition() {
        return position;
    }

    public int getPlayerHp() {
        return playerHp;
    }

    public int getMonsterHp() {
        return monsterHp;
    }
}