package font;

import javax.swing.*;
import java.awt.*;

public abstract class GameFont {

    public abstract Font createFont();

    public abstract Font createNormalFont();

    public abstract JTextArea createTextArea(String text);
}