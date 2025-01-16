package game;

import factory.ConcreteGameElementFactory;
import factory.GameElementFactory;
import window.GameWindow;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GameElementFactory factory = new ConcreteGameElementFactory();
        // ウィンドウ作成
        JFrame window = factory.createFrame();
        Container con = window.getContentPane();
        GameWindow gameWindow = new GameWindow(factory, window, con);
        gameWindow.frame();
    }
}