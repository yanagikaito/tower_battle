package factory;

import javax.swing.*;
import java.awt.*;

public class ConcreteGameElementFactory extends GameElementFactory {
    @Override
    public JFrame createFrame() {
        // ウィンドウ作成
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);

        // JFrameのデフォルトのレイアウトを無効
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return frame;
    }

    @Override
    public JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        return panel;
    }

    @Override
    public JLabel createLabel(String text) {
        JLabel label = new JLabel();
        label.setForeground(Color.WHITE);
        return label;
    }

    @Override
    public JButton createButton(String text) {
        JButton button = new JButton();
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        return button;
    }

    @Override
    public JTextArea createTextArea(String text) {
        JTextArea textArea = new JTextArea();
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setLineWrap(true);
        return textArea;
    }
}
