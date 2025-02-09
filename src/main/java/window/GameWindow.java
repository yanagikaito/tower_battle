package window;

import button.GameButton;
import factory.*;
import font.GameFont;
import frame.GameFrame;
import handler.ChoiceHandler;
import handler.TitleScreenHandler;
import label.GameLabel;
import panel.GamePanel;
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

    // ウィンドウ作成
    private JFrame window;
    private Container con;
    private String position = "ステータス";
    private JPanel titleNamePanel = gamePanel.createPanel();
    private JPanel startButtonPanel = gamePanel.createStartButtonPanel();
    private JPanel mainTextPanel = gamePanel.createMainTextPanel();
    private JPanel choiceButtonPanel = gamePanel.createChoiceButtonPanel();
    private JPanel playerStatusPanel = gamePanel.createPlayerStatusPanel();
    private JLabel titleNameLabel = gameLabel.createLabel("");
    private JLabel lvLabel = gameLabel.createLvLabelText("");
    private JLabel lvLabelNumber = gameLabel.createLvLabelNumber();
    private JLabel hpLabel = gameLabel.createHPLabelText("");
    private JLabel hpLabelNumber = gameLabel.createHPLabelNumber();
    private JLabel atkLabel = gameLabel.createATKLabelText("");
    private JLabel atkLabelNumber = gameLabel.createATKLabelNumber();
    private JLabel defLabelText = gameLabel.createDEFLabelText("");
    private JLabel defLabelNumber = gameLabel.createDEFLabelNumber();
    private JLabel weaponLabel = gameLabel.createWeaponLabel("");
    private JLabel weaponLabelName = gameLabel.createWeaponLabelTextName();
    private JLabel defLabel = gameLabel.createDEFLabel("");
    private JLabel defLabelName = gameLabel.createDEFLabelTextName();
    private JButton startButton = gameButton.createButton("");
    private JButton weaponShopButton = gameButton.createWeaponShopButton("");
    private JButton armorShopButton = gameButton.createArmorShopButton("");
    private JButton statusButton = gameButton.createStatusButton("");
    private JButton devilsTowerButton = gameButton.createDevilsTowerButton("");
    private JTextArea mainTextArea = gameFont.createTextArea("");
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
        playerStatusPanel.setLayout(new GridLayout(6, 6));

        weaponLabel.setFont(normalFont);
        playerStatusPanel.add(weaponLabel);

        weaponLabelName.setFont(normalFont);
        playerStatusPanel.add(weaponLabelName);

        defLabel.setFont(normalFont);
        playerStatusPanel.add(defLabel);

        defLabelName.setFont(normalFont);
        playerStatusPanel.add(defLabelName);

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

        defLabelText.setFont(normalFont);
        playerStatusPanel.add(defLabelText);

        defLabelNumber.setFont(normalFont);
        playerStatusPanel.add(defLabelNumber);

        PlayerStatus.save(status -> {

            weaponLabelName.setText(status.weaponName());
            defLabelName.setText(status.armorName());
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