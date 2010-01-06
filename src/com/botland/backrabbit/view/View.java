package com.botland.backrabbit.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

/**
 * Author: Vladimir Batygin
 * Date: 06.01.2010
 */
public class View extends JFrame {

    private int rabbitX = 100;
    private int rabbitY = 100;
    private RabbitComponent rabbitComponent = new RabbitComponent();


    boolean leftKey = false;
    boolean rightKey = false;
    boolean upKey = false;
    boolean downKey = false;
    boolean fireKey = false;
    private static final int STEP = 4;


    public View() throws HeadlessException {
        

        new Timer(20, new ActionListener() {

            public void actionPerformed(final ActionEvent e) {
                moveRabbit();
                repaint();
            }
        }).start();
        setSize(new Dimension(600, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        leftKey = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                        rightKey = true;
                        break;
                    case KeyEvent.VK_UP:
                        upKey = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        downKey = true;
                        break;
                    case KeyEvent.VK_SPACE:
                        fireKey = true;
                        break;
                }
            }

            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        leftKey = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        rightKey = false;
                        break;
                    case KeyEvent.VK_UP:
                        upKey = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        downKey = false;
                        break;
                }
                //ect...
            }
        });

    }

    private void moveRabbit() {
        rabbitX += rightKey ? STEP : (leftKey ? -STEP : 0);
        rabbitY += downKey ? STEP : (upKey ? -STEP : 0);
    }

    @Override
    public void paint(Graphics g) {
        final BufferStrategy bs = this.getBufferStrategy();
        if (bs.getDrawGraphics() != null) {
            g = bs.getDrawGraphics();
        }
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        rabbitComponent.paint(g, rabbitX, rabbitY);
        bs.show();
    }

    public enum DIRECTIONS {
        UP(0, -10), DOWN(0, 10), RIGHT(10, 0), LEFT(-10, 0);

        private final int x;
        private final int y;

        private DIRECTIONS(final int x, final int y) {
            this.x = x;
            this.y = y;
        }


        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
