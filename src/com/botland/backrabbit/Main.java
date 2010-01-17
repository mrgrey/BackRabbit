package com.botland.backrabbit;

import com.botland.backrabbit.model.*;
import com.botland.backrabbit.util.Directions;
import com.botland.backrabbit.util.Position;
import com.botland.backrabbit.view.Drawable.*;
import com.botland.backrabbit.view.GameScenePainter;
import com.botland.backrabbit.view.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Vladimir Batygin
 * Date: 06.01.2010
 */
public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello, I am Back Rabbit!");
        AnimatedRabbit rabbit = getRabbit();
        View view = View.initialize(foo(), rabbit);
        view.setVisible(true);
        view.createBufferStrategy(3);
        view.gameStart();


    }

    private static AnimatedRabbit getRabbit() throws IOException {
        return new AnimatedRabbit(new Rabbit(new Position(480, 330)), Arrays.<Image>asList(
                ImageIO.read(new File("images/rabbit/r01.gif")),
                ImageIO.read(new File("images/rabbit/r2.gif")),
                ImageIO.read(new File("images/rabbit/r3.gif")),
                ImageIO.read(new File("images/rabbit/r4.gif"))
        ));
    }


    static List<AbstractAnimatedObject> foo() throws IOException {
        final BufferedImage w1 = ImageIO.read(new File("images/sc1/wall1.gif"));
        final BufferedImage w2 = ImageIO.read(new File("images/sc1/wall2.gif"));
        final BufferedImage fl = ImageIO.read(new File("images/sc1/fl.gif"));
        final BufferedImage im1 = ImageIO.read(new File("images/sc1/im1.gif"));
        final BufferedImage im2 = ImageIO.read(new File("images/sc1/im2.gif"));
        final List<AbstractAnimatedObject> animatedObjects = Arrays.asList(
                new AnimatedWallImpl(new AbstractGameObject(new Position(510, 300), 30, 60), fl),
                new AnimatedWallImpl(new AbstractGameObject(new Position(180, 240), 180, 120), im1),
                new AnimatedWallImpl(new AbstractGameObject(new Position(240, 510), 240, 90), im2),
                new AnimatedWall(new BoxWall(new Position(150, 90), 120, 30), w1),
                new AnimatedWall(new BoxWall(new Position(450, 90), 150, 30), w1),
                new AnimatedWall(new BoxWall(new Position(0, 150), 180, 60), w2),
                new AnimatedWall(new BoxWall(new Position(300, 180), 240, 30), w2),
                new AnimatedWall(new BoxWall(new Position(240, 360), 300, 30), w1),
                new AnimatedWall(new BoxWall(new Position(90, 450), 270, 60), w1),
                new AnimatedWall(new BoxWall(new Position(450, 450), 90, 60), w2),
                new AnimatedWall(new BoxWall(new Position(0, 600), 600, 60), w2),
                new AnimatedTeleport(new Teleport(new Position(0, 540), new Position(570, 30))),
                new AnimatedTeleport(new Teleport(new Position(0, 120), new Position(480, 390))),
                new AnimatedGun(new Gun(new Position(0, 570), Directions.RIGHT)),
                new AnimatedGun(new Gun(new Position(570, 570), Directions.UP))
        );
        return animatedObjects;

    }
}
