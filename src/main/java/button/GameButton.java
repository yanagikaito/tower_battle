package button;

import javax.swing.*;

public abstract class GameButton {

    public abstract JButton createButton(String text);

    public abstract JButton createWeaponShopButton(String text);

    public abstract JButton createArmorShopButton(String text);

    public abstract JButton createStatusButton(String text);

    public abstract JButton createDevilsTowerButton(String text);

    public abstract JButton createAttackButton(String text);

    public abstract JButton createTownButton(String text);
}
