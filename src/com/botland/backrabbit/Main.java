package com.botland.backrabbit;

import com.botland.backrabbit.model.*;
import com.botland.backrabbit.util.Directions;
import com.botland.backrabbit.util.Position;
import com.botland.backrabbit.view.Drawable.*;
import com.botland.backrabbit.view.GameScenePainter;
import com.botland.backrabbit.view.View;

import javax.imageio.ImageIO;
import javax.swing.*;
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
        AnimatedRabbit rabbit = new AnimatedRabbit(new Rabbit(new Position(480, 330)));
        final BufferedImage image = ImageIO.read(new File("images/wall.gif"));

        AnimatedWall wall = new AnimatedWall(new BoxWall(new Position(0, 300), 400, 100), image);
        AnimatedWall wall2 = new AnimatedWall(new BoxWall(new Position(200, 550), 500, 200), image);
        AnimatedWall wall3 = new AnimatedWall(new BoxWall(new Position(400, 30), 100, 200), image);

        AnimatedGun gun = new AnimatedGun(new Gun(new Position(460, 500), Directions.UP));
        //AnimatedTeleport teleport = new AnimatedTeleport(new Teleport(new Position(100, 250), new Position(500,10)));
        AnimatedTeleport teleport = new AnimatedTeleport(new Teleport(new Position(200, 520), new Position(200, 200)));
//        GameScenePainter painter = new GameScenePainter(Arrays.<JComponent>asList(rabbit, wall, wall2, wall3, teleport, gun));
//        final GameScene scene = new GameScene(Arrays.<GameObject>asList(wall.getWall(), wall2.getWall(), wall3.getWall(), teleport.getTeleport(), gun.getGun()), rabbit.getRabbit());
//        View view = new View(scene, painter);
        View view = View.initialize(foo(), rabbit);
        view.setVisible(true);
        view.createBufferStrategy(3);
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
                new AnimatedWall(new BoxWall(new Position(30, 350), 60, 210), w1),
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
