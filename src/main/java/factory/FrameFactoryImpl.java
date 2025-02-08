package factory;

import frame.FrameSize;
import frame.GameFrame;

import javax.swing.*;
import java.awt.*;

public class FrameFactoryImpl {

    public static GameFrame createFrame(FrameSize size) {
        return () -> {
            JFrame frame = new JFrame();
            frame.setSize(size.width(), size.height());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setBackground(Color.BLACK);

            // JFrameのデフォルトのレイアウトを無効
            frame.setLayout(null);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            return frame;
        };
    }
}