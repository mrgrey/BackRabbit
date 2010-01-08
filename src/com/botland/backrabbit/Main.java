package com.botland.backrabbit;

import com.botland.backrabbit.model.*;
import com.botland.backrabbit.util.Directions;
import com.botland.backrabbit.util.Position;
import com.botland.backrabbit.view.Drawable.AnimatedGun;
import com.botland.backrabbit.view.Drawable.AnimatedRabbit;
import com.botland.backrabbit.view.Drawable.AnimatedTeleport;
import com.botland.backrabbit.view.Drawable.AnimatedWall;
import com.botland.backrabbit.view.GameScenePainter;
import com.botland.backrabbit.view.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Author: Vladimir Batygin
 * Date: 06.01.2010
 */
public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello, I am Back Rabbit!");
        AnimatedRabbit rabbit = new AnimatedRabbit(new Rabbit(new Position(200, 200)));
        final BufferedImage image = ImageIO.read(new File("images/wall.gif"));

        AnimatedWall wall = new AnimatedWall(new BoxWall(new Position(0, 300), 400, 100), image);
        AnimatedWall wall2 = new AnimatedWall(new BoxWall(new Position(200, 550), 500, 200), image);
        AnimatedWall wall3 = new AnimatedWall(new BoxWall(new Position(400, 10), 100, 200), image);

        AnimatedGun gun = new AnimatedGun(new Gun(new Position(100, 100), Directions.RIGHT));
        //AnimatedTeleport teleport = new AnimatedTeleport(new Teleport(new Position(100, 250), new Position(500,10)));
        AnimatedTeleport teleport = new AnimatedTeleport(new Teleport(new Position(200, 520), new Position(200,200)));
        GameScenePainter painter = new GameScenePainter(Arrays.<JComponent>asList(rabbit, wall, wall2, wall3, teleport, gun));
        final GameScene scene = new GameScene(Arrays.<GameObject>asList(wall.getWall(), wall2.getWall(), wall3.getWall(), teleport.getTeleport(), gun.getGun()), rabbit.getRabbit());
        View view = new View(scene, painter);
        view.setVisible(true);
        view.createBufferStrategy(3);
    }
}
