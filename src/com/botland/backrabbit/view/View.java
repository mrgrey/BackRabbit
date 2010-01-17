package com.botland.backrabbit.view;

import com.botland.backrabbit.model.GameObject;
import com.botland.backrabbit.model.GameScene;
import com.botland.backrabbit.model.Rabbit;
import com.botland.backrabbit.model.Wall;
import com.botland.backrabbit.util.Directions;
import com.botland.backrabbit.view.Drawable.AbstractAnimatedObject;
import com.botland.backrabbit.view.Drawable.AnimatedRabbit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Vladimir Batygin
 * Date: 06.01.2010
 */
public class View extends JFrame {

    private GameScene scene;
    private GameScenePainter gameScenePainter;

    private final Timer timer;

    public static View initialize(final List<AbstractAnimatedObject> gameObjects, final AnimatedRabbit rabbit) {
        List<GameObject> innerObjects = new ArrayList<GameObject>(gameObjects.size());
        for (final AbstractAnimatedObject obj : gameObjects) {
            innerObjects.add(obj.getGameObject());
        }
        final List<AbstractAnimatedObject> paintableObjects = new ArrayList<AbstractAnimatedObject>(gameObjects);
        paintableObjects.add(rabbit);
        AbstractAnimatedObject.timer.start();
        return new View(new GameScene(innerObjects, rabbit.getRabbit()), new GameScenePainter(paintableObjects));
    }

    public void gameStart() {
        timer.start();
    }

    public View(final GameScene scene, final GameScenePainter gameScenePainter) throws HeadlessException {
        this.scene = scene;
        this.gameScenePainter = gameScenePainter;

        timer = new Timer(10, new ActionListener() {

            public void actionPerformed(final ActionEvent e) {
                scene.doActions();
                repaint();
            }
        });


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

    private void keyActions(final KeyEvent e, final boolean b) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                scene.moveRabbit(Directions.LEFT, b);
                break;
            case KeyEvent.VK_RIGHT:
                scene.moveRabbit(Directions.RIGHT, b);
                break;
            case KeyEvent.VK_UP:
                if (b) {
                    scene.setRabbitJump();
                }
                break;
        }
    }

    @Override
    public void paint(Graphics g) {
        if (gameScenePainter.needRepaint()) {
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

}
