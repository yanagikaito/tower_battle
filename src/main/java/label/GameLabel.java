package label;

import javax.swing.*;

public abstract class GameLabel {

    public abstract JLabel createLabelText(String text);

    public abstract JLabel createPlayerLvLabelText(String text);

    public abstract JLabel createPlayerLvLabelNumber();

    public abstract JLabel createPlayerLabelText(String text);

    public abstract JLabel createPlayerLabelName();

    public abstract JLabel createPlayerHPLabelText(String text);

    public abstract JLabel createPlayerHPLabelNumber();

    public abstract JLabel createMonsterHPLabelText(String text);

    public abstract JLabel createMonsterHPLabelNumber();

    public abstract JLabel createATKLabelText(String text);

    public abstract JLabel createATKLabelNumber();

    public abstract JLabel createDEFLabelText(String text);

    public abstract JLabel createDEFLabelNumber();

    public abstract JLabel createWeaponLabelText(String text);

    public abstract JLabel createWeaponLabelTextName();

    public abstract JLabel createDEFLabel(String text);

    public abstract JLabel createDEFLabelTextName();

    public abstract JLabel createMonsterLabelText(String text);

    public abstract JLabel createMonsterLabelName();

    public abstract JLabel createMonsterLvLabelText(String text);

    public abstract JLabel createMonsterLvLabelNumber();
}