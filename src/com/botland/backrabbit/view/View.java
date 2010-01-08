package com.botland.backrabbit.view;

import com.botland.backrabbit.model.GameScene;
import com.botland.backrabbit.util.Directions;

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

    private GameScene scene;
    private GameScenePainter gameScenePainter;

    private boolean leftKey = false;
    private boolean rightKey = false;
    private boolean upKey = false;
    private boolean downKey = false;
    private boolean fireKey = false;
    private final Timer timer;


    public View(final GameScene scene, final GameScenePainter gameScenePainter) throws HeadlessException {
        this.scene = scene;
        this.gameScenePainter = gameScenePainter;

        timer = new Timer(10, new ActionListener() {

            public void actionPerformed(final ActionEvent e) {
                moveRabbit();
                repaint();
            }
        });
        timer.start();

        setSize(new Dimension(600, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                keyActions(e, true);
            }

            @Override
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
                if (b) {
                    scene.setRabbitJump();
                }
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
        scene.doActions();
        if (!flag()) {
            return false;
        }
        if (rightKey) {
            scene.moveRabbit(Directions.RIGHT);
        }
        if (leftKey) {
            scene.moveRabbit(Directions.LEFT);
        }
        return true;
    }

    @Override
    public void paint(Graphics g) {
        final BufferStrategy bs = this.getBufferStrategy();
        if (bs != null && bs.getDrawGraphics() != null) {
            g = bs.getDrawGraphics();
        }
        gameScenePainter.paint(g);
        if (bs != null) {
            bs.show();
        }
    }

}
