package factory;

import label.GameLabel;

import javax.swing.*;
import java.awt.*;

public class LabelFactory extends GameLabel {

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
    public JLabel createWeaponLabel(String text) {
        JLabel weaponLabel = new JLabel("武器");
        weaponLabel.setForeground(Color.WHITE);
        return weaponLabel;
    }

    @Override
    public JLabel createWeaponLabelTextName(String text) {
        JLabel weaponLabelTextName = new JLabel("武器");
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
    public JLabel createDEFLabelTextName(String text) {
        JLabel defLabelTextName = new JLabel("防具");
        defLabelTextName.setForeground(Color.WHITE);
        return defLabelTextName;
    }
}