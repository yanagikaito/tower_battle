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
}