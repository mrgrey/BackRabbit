package com.botland.backrabbit.view.Drawable;

import com.botland.backrabbit.model.GameObject;
import com.botland.backrabbit.model.Wall;
import com.botland.backrabbit.util.Position;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

/**
 * Author: Vladimir Batygin
 * Date: 07.01.2010
 */
public class AnimatedWall extends AbstractAnimatedObject {
    private final Wall wall;

    @Override
    public GameObject getGameObject() {
        return wall;
    }

    private final Image image;

    public AnimatedWall(Wall wall, Image image) {
        super(1);

        this.wall = wall;
        this.image = image;
    }


    @Override
    public void paint(final Graphics g) {
        //  g.drawImage(image, wall.getPosition().getX(), wall.getPosition().getY(), this);
        //drawImagesInRect(g, image);
        //  g.setColor(Color.BLACK);
        //  final BufferedImage bufferedImage = new BufferedImage(10, 10, BufferedImage.TRANSLUCENT);
//        bufferedImage.
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(this), image.getHeight(this), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(image, 0, 0, this);


        final TexturePaint paint = new TexturePaint(bufferedImage, new Rectangle(0, 0, image.getWidth(this), image.getHeight(this)));
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(paint);
        final Rectangle s = new Rectangle(wall.getPosition().getX(), wall.getPosition().getY(), wall.getWidth(), wall.getHeight());
        g2.fill(s);

        g2d.setPaint(Color.blue);
        g2d.setStroke(new BasicStroke(5));
        g2d.draw(s);

        g.setColor(Color.GREEN);
        g.drawRect(wall.getPosition().getX(), wall.getPosition().getY(), wall.getWidth(), wall.getHeight());
    }

    public Wall getWall() {
        return wall;
    }

    public void drawImagesInRect(Graphics g, Image image) {
        final Position pos = wall.getPosition();
        for (int i = pos.getX(); i < pos.getX() + wall.getWidth(); i += image.getWidth(this)) {
            for (int j = pos.getY(); j < pos.getY() + wall.getHeight(); j += image.getHeight(this)) {
                g.drawImage(image, i, j, this);
            }
        }

    }


}
