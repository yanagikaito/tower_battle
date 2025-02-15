package label;

import javax.swing.*;

public abstract class GameLabel {

    public abstract JLabel createLabelText(String text);

    public abstract JLabel createPlayerLvLabelText(String text);

    public abstract JLabel createPlayerLvLabelNumber();

    public abstract JLabel createPlayerHPLabelText(String text);

    public abstract JLabel createPlayerHPLabelNumber();

    public abstract JLabel createWeaponLabelText(String text);

    public abstract JLabel createWeaponLabelTextName();
}