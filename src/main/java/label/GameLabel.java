package label;

import javax.swing.*;

public abstract class GameLabel {

    public abstract JLabel createLabel(String text);

    public abstract JLabel createLvLabelText(String text);

    public abstract JLabel createLvLabelNumber();

    public abstract JLabel createHPLabelText(String text);

    public abstract JLabel createHPLabelNumber();

    public abstract JLabel createATKLabelText(String text);

    public abstract JLabel createATKLabelNumber();

    public abstract JLabel createDEFLabelText(String text);

    public abstract JLabel createDEFLabelNumber();

    public abstract JLabel createWeaponLabel(String text);

    public abstract JLabel createWeaponLabelTextName();

    public abstract JLabel createDEFLabel(String text);

    public abstract JLabel createDEFLabelTextName();
}