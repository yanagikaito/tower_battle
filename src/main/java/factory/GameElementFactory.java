package factory;

import javax.swing.*;
import java.awt.*;

public abstract class GameElementFactory {

    public abstract JFrame createFrame();

    public abstract JPanel createPanel();

    public abstract JPanel createStartButtonPanel();

    public abstract JPanel createMainTextPanel();

    public abstract JPanel createChoiceButtonPanel();

    public abstract JPanel createPlayerStatusPanel();

    public abstract int createSize();

    public abstract Font createFont();

    public abstract Font createNormalFont();

    public abstract JLabel createLabel(String text);

    public abstract JLabel createLvLabelText(String text);

    public abstract JLabel createLvLabelNumber();

    public abstract JLabel createHPLabelText(String text);

    public abstract JLabel createHPLabelNumber();

    public abstract JLabel createATKLabelText(String text);

    public abstract JLabel createATKLabelNumber();

    public abstract JLabel createDEFLabelText(String text);

    public abstract JLabel createDEFLabelNumber();

    public abstract JButton createButton(String text);

    public abstract JButton createWeaponShopButton(String text);

    public abstract JButton createArmorShopButton(String text);

    public abstract JButton createStatusButton(String text);

    public abstract JButton createDevilsTowerButton(String text);

    public abstract JTextArea createTextArea(String text);
}
