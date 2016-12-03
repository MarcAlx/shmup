/**
 *
 * Bullet.java
 *
 * Created by Marc-Alexandre Blanchard - all right reserved ©
 *
 * 2014
 *
 */
package com.game;

import com.app.Parameters;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author Crée par Marc-Alexandre Blanchard
 */
public class Bullet extends Element
{

    public Bullet(String imagePath, ElementsEnum tp) throws IOException
    {
        super(imagePath, tp);
    }

    public Bullet(BufferedImage img, ElementsEnum tp)
    {
        super(img, tp);
    }

    public Bullet(int x, int y, String imagePath, ElementsEnum tp) throws IOException
    {
        super(x, y, imagePath, tp);
    }

    public Bullet(int x, int y, BufferedImage img, ElementsEnum tp)
    {
        super(x, y, img, tp);
    }

    @Override
    public void move()
    {
        this.moveRelative(0, -Parameters.DEFAULT_BULLET_MOVE_SPACING);
    }
}
