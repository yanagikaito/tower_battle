package factory;

import javax.swing.*;
import java.awt.*;

public class ConcreteGameElementFactory extends GameElementFactory {

    @Override
    public JFrame createFrame() {

        // 横
        int maxScreenRow = 16;
        // 縦
        int maxScreenCol = 12;
        int tileSize = createSize();
        int screenWidth = tileSize * maxScreenRow;
        int screenHeight = tileSize * maxScreenCol;

        // ウィンドウ作成
        JFrame frame = new JFrame();
        frame.setSize(screenWidth, screenHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);

        // JFrameのデフォルトのレイアウトを無効
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return frame;
    }

    @Override
    public JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        return panel;
    }

    @Override
    public JPanel createStartButtonPanel() {
        JPanel startButtonPanel = new JPanel();
        startButtonPanel.setBackground(Color.BLACK);
        return startButtonPanel;
    }

    @Override
    public JPanel createMainTextPanel() {
        JPanel mainTextPanel = new JPanel();
        mainTextPanel.setBackground(Color.BLACK);
        return mainTextPanel;
    }

    @Override
    public JPanel createChoiceButtonPanel() {
        JPanel choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBackground(Color.BLACK);
        return choiceButtonPanel;
    }

    @Override
    public JPanel createPlayerStatusPanel() {
        JPanel playerStatusPanel = new JPanel();
        playerStatusPanel.setBackground(Color.BLACK);
        return playerStatusPanel;
    }

    @Override
    public int createSize() {
        int originalTileSize = 16;
        int scale = 3;
        return originalTileSize * scale;
    }

    @Override
    public Font createFont() {
        return new Font("アリアル", Font.PLAIN, 65);
    }

    @Override
    public Font createNormalFont() {
        return new Font("アリアル", Font.PLAIN, 25);
    }

    @Override
    public JLabel createLabel(String text) {
        JLabel label = new JLabel("TOWER BATTLE");
        label.setForeground(Color.WHITE);
        return label;
    }

    @Override
    public JLabel createLvLabelText(String text) {
        JLabel lvLabel = new JLabel("LV");
        lvLabel.setForeground(Color.WHITE);
        return lvLabel;
    }

    @Override
    public JLabel createLvLabelNumber() {
        JLabel lvLabelNumber = new JLabel();
        lvLabelNumber.setForeground(Color.WHITE);
        return lvLabelNumber;
    }

    @Override
    public JLabel createHPLabelText(String text) {
        JLabel hpLabelText = new JLabel("HP");
        hpLabelText.setForeground(Color.WHITE);
        return hpLabelText;
    }

    @Override
    public JLabel createHPLabelNumber() {
        JLabel hpLabelNumber = new JLabel();
        hpLabelNumber.setForeground(Color.WHITE);
        return hpLabelNumber;
    }

    @Override
    public JLabel createATKLabelText(String text) {
        JLabel atkLabelText = new JLabel("攻撃力");
        atkLabelText.setForeground(Color.WHITE);
        return atkLabelText;
    }

    @Override
    public JLabel createATKLabelNumber() {
        JLabel atkLabelNumber = new JLabel();
        atkLabelNumber.setForeground(Color.WHITE);
        return atkLabelNumber;
    }

    @Override
    public JLabel createDEFLabelText(String text) {
        JLabel defLabelText = new JLabel("防御力");
        defLabelText.setForeground(Color.WHITE);
        return defLabelText;
    }

    @Override
    public JLabel createDEFLabelNumber() {
        JLabel defLabelNumber = new JLabel();
        defLabelNumber.setForeground(Color.WHITE);
        return defLabelNumber;
    }

    @Override
    public JButton createButton(String text) {
        JButton button = new JButton("スタート");
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        return button;
    }

    @Override
    public JButton createWeaponShopButton(String text) {
        JButton weaponShopButton = new JButton("武器屋");
        weaponShopButton.setBackground(Color.BLACK);
        weaponShopButton.setForeground(Color.WHITE);
        weaponShopButton.setFocusPainted(false);
        return weaponShopButton;
    }

    @Override
    public JButton createArmorShopButton(String text) {
        JButton armorShopButton = new JButton("防具屋");
        armorShopButton.setBackground(Color.BLACK);
        armorShopButton.setForeground(Color.WHITE);
        armorShopButton.setFocusPainted(false);
        return armorShopButton;
    }

    @Override
    public JButton createStatusButton(String text) {
        JButton statusButton = new JButton("ステータス");
        statusButton.setBackground(Color.BLACK);
        statusButton.setForeground(Color.WHITE);
        statusButton.setFocusPainted(false);
        return statusButton;
    }

    @Override
    public JButton createDevilsTowerButton(String text) {
        JButton devilsTowerButton = new JButton("魔の塔");
        devilsTowerButton.setBackground(Color.BLACK);
        devilsTowerButton.setForeground(Color.WHITE);
        devilsTowerButton.setFocusPainted(false);
        return devilsTowerButton;
    }

    @Override
    public JTextArea createTextArea(String text) {
        JTextArea textArea = new JTextArea("町の施設");
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setLineWrap(true);
        return textArea;
    }
}