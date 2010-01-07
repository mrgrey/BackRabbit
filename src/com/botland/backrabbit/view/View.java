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
    private Timer timer;
    private boolean jump = false;
    private int alreadyJumped = 0;
    private boolean falldown = false;


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
            public void keyPressed(KeyEvent e) {
                keyActions(e, true);
            }

            public void keyReleased(KeyEvent e) {
                keyActions(e, false);
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
                if (!falldown)jump = b;
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
        if (!flag() && !jump && isWallDown()) {
            falldown = false;
            return false;
        }
        if (rightKey && allowedRight()) {
            rabbitX += STEP;
        }
        if (leftKey && allowedLeft()) {
           rabbitX -=STEP;
        }
    //    rabbitX += rightKey ? STEP : (leftKey ? -STEP : 0);
     //   rabbitY += downKey ? STEP : 0;
        if (jump && alreadyJumped < rabbitComponent.MAX_JUMP_HEIGHT) {
            rabbitY -= 4 * STEP;
            alreadyJumped += 4 * STEP;
        } else {
            alreadyJumped = 0;
            jump = false;
        }
        if (!isWallDown()) {
            rabbitY += STEP;
            falldown = true;
        } else {
            falldown = false;
        }

        return true;
    }

    private boolean allowedLeft() {
        if (rabbitX <= 30) {
            return false;
        }
        if (rabbitX <= 500 && rabbitY > 370) {
            return false;
        }
        return true;
    }

    private boolean allowedRight() {
        return rabbitX <= 565;
    }

    private boolean isWallDown() {
        return (rabbitX < 465 && rabbitY >= 370) || (rabbitY >= 570);
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
        g.setColor(Color.BLACK);
        g.drawLine(0, 400, 500, 400);
        g.drawLine(500, 400, 500, 600);
        if (bs != null) {
            bs.show();
        }
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
