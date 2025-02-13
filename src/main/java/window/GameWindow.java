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
            "ロングソード",
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
    private String statusPosition = "ステータス";
    private String devilsPosition = "魔の塔";
    private String attackPosition = "プレイヤーの攻撃";
    private String townPosition = "町の施設";

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
    private JButton weaponShopButton = gameButton.createWeaponShopButton("");
    private JButton armorShopButton = gameButton.createArmorShopButton("");
    private JButton statusButton = gameButton.createStatusButton("");
    private JButton devilsTowerButton = gameButton.createDevilsTowerButton("");
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

        weaponLabeltext.setFont(normalFont);
        playerStatusPanel.add(weaponLabeltext);

        weaponLabelName.setFont(normalFont);
        playerStatusPanel.add(weaponLabelName);

        defLabel.setFont(normalFont);
        playerStatusPanel.add(defLabel);

        defLabelName.setFont(normalFont);
        playerStatusPanel.add(defLabelName);

        playerLvLabeltext.setFont(normalFont);
        playerStatusPanel.add(playerLvLabeltext);

        playerLvLabelNumber.setFont(normalFont);
        playerStatusPanel.add(playerLvLabelNumber);

        playerHPLabeltext.setFont(normalFont);
        playerStatusPanel.add(playerHPLabeltext);

        playerHPLabelNumber.setFont(normalFont);
        playerStatusPanel.add(playerHPLabelNumber);

        atkLabeltext.setFont(normalFont);
        playerStatusPanel.add(atkLabeltext);

        atkLabelNumber.setFont(normalFont);
        playerStatusPanel.add(atkLabelNumber);

        defLabelText.setFont(normalFont);
        playerStatusPanel.add(defLabelText);

        defLabelNumber.setFont(normalFont);
        playerStatusPanel.add(defLabelNumber);

        PlayerStatus.save(status -> {

            weaponLabelName.setText(status.weaponName());
            defLabelName.setText(status.armorName());
            playerHPLabelNumber.setText("" + status.hp());
            playerLvLabelNumber.setText("" + status.lv());
            atkLabelNumber.setText("" + status.atk());
            defLabelNumber.setText("" + status.def());
        });
    }

    @Override
    public void devilsTowerScreen() {

        showBattleScreenScroll();

        // 2つのパネルを無効にする。
        mainTextPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);

        con.add(battlePanel);

        // devilsTowerPanelにプレイヤーのLVとHPのラベルを貼り付けている
        playerLabelName.setFont(normalFont);
        devilsTowerPanel.add(playerLabelName);

        playerLvLabeltext.setFont(normalFont);
        devilsTowerPanel.add(playerLvLabeltext);

        playerLvLabelNumber.setFont(normalFont);
        devilsTowerPanel.add(playerLvLabelNumber);

        playerHPLabeltext.setFont(normalFont);
        devilsTowerPanel.add(playerHPLabeltext);

        playerHPLabelNumber.setFont(normalFont);
        devilsTowerPanel.add(playerHPLabelNumber);

        PlayerStatus.save(status -> {
            playerLabelName.setText(status.name());
            playerHPLabelNumber.setText("" + status.hp());
            playerLvLabelNumber.setText("" + status.lv());
        });

        // モンスターの情報を表示するラベルを追加
        monsterLabelName.setFont(normalFont);
        monsterDisplayPanel.add(monsterLabelName);

        monsterHPLabeltext.setFont(normalFont);
        monsterDisplayPanel.add(monsterHPLabeltext);

        monsterHPLabelNumber.setFont(normalFont);
        monsterDisplayPanel.add(monsterHPLabelNumber);

        MonsterStatus.save(status -> {
            monsterLabelName.setText(status.name() + "が現れた");
            monsterHPLabelNumber.setText(" " + status.hp());
        });

        // JScrollPaneにdevilsTowerPanelを設定
        battleScreenScroll.setViewportView(battlePanel);
        battlePanel.add(devilsTowerPanel);
        battlePanel.add(monsterDisplayPanel);

        attackButton.setFont(normalFont);
        attackButton.addActionListener(csHandler);
        attackButton.setActionCommand("c1");
        battlePanel.add(attackButton);

        townButton.setFont(normalFont);
        townButton.addActionListener(csHandler);
        townButton.setActionCommand("c2");
        battlePanel.add(townButton);

        devilsTowerPanel.setBounds(100, 30, 560, 50);
        devilsTowerPanel.setLayout(new GridLayout(1, 4));
        con.add(battleScreenScroll);
    }

    public void playerAttack() {

        monsterLabelName.setVisible(false);
        monsterHPLabelNumber.setVisible(false);

        attackPosition = "プレイヤーの攻撃";
        int playerDamage = 0;
        playerDamage = random.nextInt(playerStatus.atk()) + 1;
        monsterHPLabeltext.setText(monsterStatus.name() + "攻撃し,"
                + playerDamage + "ダメージを与えた。" + "HP" + monsterStatus.hp());
        int monsterResult = monsterStatus.hp() - playerDamage;
        if (monsterResult <= 1) {
            win();
        }
        monsterStatus = new MonsterStatus("スライム ",
                1,
                monsterResult,
                5,
                3);
    }

    public void win() {
        monsterHPLabeltext.setText("モンスターを倒しました");
    }

    public void town() {

        hideTownComponents();
        showBattleScreenScroll();

        battleScreenScroll.setVisible(false);
        townPosition = "町の施設";

        mainTextPanel = gamePanel.createMainTextPanel();
        mainTextArea = gameFont.createTextArea("");
        choiceButtonPanel = gamePanel.createChoiceButtonPanel();
        weaponShopButton = gameButton.createWeaponShopButton("");
        armorShopButton = gameButton.createArmorShopButton("");
        statusButton = gameButton.createStatusButton("");
        devilsTowerButton = gameButton.createDevilsTowerButton("");

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

    // 町のコンポーネントを隠すメソッドを追加
    public void hideTownComponents() {
        if (mainTextPanel != null) {
            mainTextPanel.setVisible(false);
        }
        if (choiceButtonPanel != null) {
            choiceButtonPanel.setVisible(false);
        }
    }

    public void showBattleScreenScroll() {
        battleScreenScroll.setVisible(true);
    }

    public String getAttackPosition() {
        return attackPosition;
    }

    public String getTownPosition() {
        return townPosition;
    }
}