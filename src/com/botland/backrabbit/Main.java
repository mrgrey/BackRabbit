package com.botland.backrabbit;

import com.botland.backrabbit.model.BoxWall;
import com.botland.backrabbit.model.GameObject;
import com.botland.backrabbit.model.GameScene;
import com.botland.backrabbit.model.Rabbit;
import com.botland.backrabbit.util.Position;
import com.botland.backrabbit.view.Drawable.AnimatedRabbit;
import com.botland.backrabbit.view.Drawable.AnimatedWall;
import com.botland.backrabbit.view.GameScenePainter;
import com.botland.backrabbit.view.View;

import javax.swing.*;
import java.util.Arrays;

/**
 * Author: Vladimir Batygin
 * Date: 06.01.2010
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, I am Back Rabbit!");
        AnimatedRabbit rabbit = new AnimatedRabbit(new Rabbit(new Position(200, 200)));
        AnimatedWall wall = new AnimatedWall(new BoxWall(new Position(0, 300), 400, 100));
        AnimatedWall wall2 = new AnimatedWall(new BoxWall(new Position(200, 550), 500, 200));
        AnimatedWall wall3 = new AnimatedWall(new BoxWall(new Position(400, 150), 100, 100));
        GameScenePainter painter = new GameScenePainter(Arrays.<JComponent>asList(rabbit, wall, wall2, wall3));
        final GameScene scene = new GameScene(Arrays.<GameObject>asList(wall.getWall(), wall2.getWall(), wall3.getWall()), rabbit.getRabbit());
        View view = new View(scene, painter);
        view.setVisible(true);
        view.createBufferStrategy(3);
    }
}
