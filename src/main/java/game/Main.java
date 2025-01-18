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
        JPanel titleNamePanel = factory.createPanel();
        JPanel startButtonPanel = factory.createStartButtonPanel();
        JPanel mainTextPanel = factory.createMainTextPanel();
        JLabel titleNameLabel = factory.createLabel("TOWER BATTLE");
        JButton startButton = factory.createButton("スタート");
        JTextArea mainTextArea = factory.createTextArea("これはメインのテキストエリア");
        Font titleFont = factory.createFont();
        Font normalFont = factory.createNormalFont();

        GameWindow gameWindow = new GameWindow(factory, con,
                titleNamePanel, startButtonPanel, mainTextPanel,
                titleNameLabel, startButton, mainTextArea, titleFont,
                normalFont);

        gameWindow.frame();
    }
}