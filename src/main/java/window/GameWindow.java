package window;

import factory.GameElementFactory;

import javax.swing.*;
import java.awt.*;

public record GameWindow(GameElementFactory factory, JFrame window, Container con) implements Window {

    @Override
    public void frame() {

    }
}
