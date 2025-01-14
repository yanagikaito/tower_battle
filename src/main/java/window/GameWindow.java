package window;

import factory.ConcreteGameElementFactory;
import factory.GameElementFactory;

import javax.swing.*;
import java.awt.*;

public class GameWindow implements Window {
    private GameElementFactory factory = new ConcreteGameElementFactory();
    private JFrame window;
    private Container con;

    @Override
    public void frame() {
        // ウィンドウ作成
        window = factory.createFrame();
        con = window.getContentPane();
    }
}
