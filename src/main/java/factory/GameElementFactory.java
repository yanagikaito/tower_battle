package factory;

import javax.swing.*;
import java.awt.*;

public abstract class GameElementFactory {

    public abstract Font createFont();

    public abstract Font createNormalFont();

    public abstract JButton createButton(String text);

    public abstract JButton createWeaponShopButton(String text);

    public abstract JButton createArmorShopButton(String text);

    public abstract JButton createStatusButton(String text);

    public abstract JButton createDevilsTowerButton(String text);

    public abstract JTextArea createTextArea(String text);
}