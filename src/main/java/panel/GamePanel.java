package panel;

import javax.swing.*;

public abstract class GamePanel {

    public abstract JPanel createPanel();

    public abstract JPanel createStartButtonPanel();

    public abstract JPanel createMainTextPanel();

    public abstract JPanel createChoiceButtonPanel();

    public abstract JPanel createPlayerStatusPanel();
}