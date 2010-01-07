package com.botland.backrabbit.view;

import com.botland.backrabbit.view.Drawable.AnimatedRabbit;
import com.botland.backrabbit.view.Drawable.AnimatedTeleport;
import com.botland.backrabbit.view.Drawable.InteractableAction;

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
    //private RabbitComponent rabbitComponent = new RabbitComponent();
    private AnimatedRabbit rabbitComponent = new AnimatedRabbit();

    private AnimatedTeleport teleport = new AnimatedTeleport();
    private final int teleportX = 60;
    private final int teleportY = 60;


    boolean leftKey = false;
    boolean rightKey = false;
    boolean upKey = false;
    boolean downKey = false;
    boolean fireKey = false;
    private static final int STEP = 4;
    private Timer timer;


    public View() throws HeadlessException {


        timer = new Timer(10, new ActionListener() {

            public void actionPerformed(final ActionEvent e) {
                if (moveRabbit()) {
                    repaint();
                }
            }
        });
        timer.start();


        setSize(new Dimension(600, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                final boolean b = true;
                keyActions(e, b);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                final boolean b = false;
                keyActions(e, b);
            }
        });

    }

    private boolean flag() {
        return leftKey || fireKey || rightKey || upKey || downKey;
    }

    private void keyActions(final KeyEvent e, final boolean b) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                leftKey = b;
                break;
            case KeyEvent.VK_RIGHT:
                rightKey = b;
                break;
            case KeyEvent.VK_UP:
                upKey = b;
                break;
            case KeyEvent.VK_DOWN:
                downKey = b;
                break;
            case KeyEvent.VK_SPACE:
                fireKey = b;
                break;
        }
    }

    private boolean moveRabbit() {
        if (!flag()) {
            return false;
        }
        rabbitX += rightKey ? STEP : (leftKey ? -STEP : 0);
        rabbitY += downKey ? STEP : (upKey ? -STEP : 0);
        if(rabbitX == teleportX && rabbitY == teleportY) {
            teleport.interact(new InteractableAction() {
                public void perform() {
                    rabbitX = rabbitY = 240;
                }
            });
        }
        return true;
    }

    @Override
    public void paint(Graphics g) {
        final BufferStrategy bs = this.getBufferStrategy();
        if (bs != null && bs.getDrawGraphics() != null) {
            g = bs.getDrawGraphics();
        }
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        rabbitComponent.paint(g, rabbitX, rabbitY);
        teleport.paint(g, teleportX, teleportY);
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
