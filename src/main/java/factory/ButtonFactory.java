package factory;

import button.GameButton;

import javax.swing.*;
import java.awt.*;

public class ButtonFactory extends GameButton {

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
}
