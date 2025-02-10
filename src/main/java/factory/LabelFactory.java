package factory;

import label.GameLabel;

import javax.swing.*;
import java.awt.*;

public class LabelFactory extends GameLabel {

    @Override
    public JLabel createLabelText(String text) {
        JLabel label = new JLabel("TOWER BATTLE");
        label.setForeground(Color.WHITE);
        return label;
    }

    @Override
    public JLabel createPlayerLvLabelText(String text) {
        JLabel playerLvLabelText = new JLabel("LV");
        playerLvLabelText.setForeground(Color.WHITE);
        return playerLvLabelText;
    }

    @Override
    public JLabel createPlayerLvLabelNumber() {
        JLabel playerLvLabelNumber = new JLabel();
        playerLvLabelNumber.setForeground(Color.WHITE);
        return playerLvLabelNumber;
    }

    @Override
    public JLabel createPlayerHPLabelText(String text) {
        JLabel playerHPLabelText = new JLabel(" HP");
        playerHPLabelText.setForeground(Color.WHITE);
        return playerHPLabelText;
    }

    @Override
    public JLabel createPlayerHPLabelNumber() {
        JLabel playerHPLabelNumber = new JLabel();
        playerHPLabelNumber.setForeground(Color.WHITE);
        return playerHPLabelNumber;
    }

    @Override
    public JLabel createMonsterHPLabelText(String text) {
        JLabel monsterHPLabelText = new JLabel(" HP");
        monsterHPLabelText.setForeground(Color.WHITE);
        return monsterHPLabelText;
    }

    @Override
    public JLabel createMonsterHPLabelNumber() {
        JLabel monsterHPLabelNumber = new JLabel();
        monsterHPLabelNumber.setForeground(Color.WHITE);
        return monsterHPLabelNumber;
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
    public JLabel createWeaponLabelText(String text) {
        JLabel weaponLabel = new JLabel("武器");
        weaponLabel.setForeground(Color.WHITE);
        return weaponLabel;
    }

    @Override
    public JLabel createWeaponLabelTextName() {
        JLabel weaponLabelTextName = new JLabel();
        weaponLabelTextName.setForeground(Color.WHITE);
        return weaponLabelTextName;
    }

    @Override
    public JLabel createDEFLabel(String text) {
        JLabel defLabel = new JLabel("防具");
        defLabel.setForeground(Color.WHITE);
        return defLabel;
    }

    @Override
    public JLabel createDEFLabelTextName() {
        JLabel defLabelTextName = new JLabel();
        defLabelTextName.setForeground(Color.WHITE);
        return defLabelTextName;
    }

    @Override
    public JLabel createMonsterLabelText(String text) {
        JLabel monsterLabel = new JLabel("モンスター ");
        monsterLabel.setForeground(Color.WHITE);
        return monsterLabel;
    }

    @Override
    public JLabel createMonsterLabelName() {
        JLabel monsterLabelName = new JLabel();
        monsterLabelName.setForeground(Color.WHITE);
        return monsterLabelName;
    }

    @Override
    public JLabel createMonsterLvLabelText(String text) {
        JLabel monsterLVLabel = new JLabel("LV");
        monsterLVLabel.setForeground(Color.WHITE);
        return monsterLVLabel;
    }

    @Override
    public JLabel createMonsterLvLabelNumber() {
        JLabel monsterLvLabelNumber = new JLabel();
        monsterLvLabelNumber.setForeground(Color.WHITE);
        return monsterLvLabelNumber;
    }

    @Override
    public JLabel createPlayerLabelText(String text) {
        JLabel playerLabel = new JLabel("プレイヤー");
        playerLabel.setForeground(Color.WHITE);
        return playerLabel;
    }

    @Override
    public JLabel createPlayerLabelName() {
        JLabel playerLabelName = new JLabel();
        playerLabelName.setForeground(Color.WHITE);
        return playerLabelName;
    }
}