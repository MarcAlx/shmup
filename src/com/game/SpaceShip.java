/**
 *
 * SpaceShip.java
 *
 * Created by Marc-Alexandre Blanchard - all right reserved ©
 *
 * 2014
 *
 */
package com.game;

import com.app.Parameters;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;

/**
 * Represents the spaceship
 *
 * @author Crée par Marc-Alexandre Blanchard
 */
public class SpaceShip extends Element
{

    /**
     * Fire level of the space ship 0 -> 3
     */
    private int firelevel;

    /**
     * True hitbox of the spaceshit, cokpit
     */
    private final Point trueHitBox;

    /**
     * To load image
     */
    private final ImagesFactory IF;

    public SpaceShip() throws IOException
    {
        super(Parameters.DEFAULT_POS_X, Parameters.DEFAULT_POS_Y, "/com/ressources/images/spshp.png", ElementsEnum.SPACESHIP);
        this.trueHitBox = new Point(Parameters.DEFAULT_POS_X + 23, Parameters.DEFAULT_POS_Y + 30);
        this.firelevel = 1;
        IF = ImagesFactory.getInstance();
    }

    /**
     * Decrease fire level : -1
     */
    public void firelevelDown()
    {
        if (firelevel - 1 >= 0)
        {
            firelevel--;
        }
    }

    /**
     * Increase fire level : +1
     */
    public void firelevelUp()
    {
        if (firelevel + 1 <= 3)
        {
            firelevel++;
        }
    }

    /**
     * @return the firelevel
     */
    public int getFirelevel()
    {
        return firelevel;
    }

    /**
     * Move spaceship to the left
     */
    public void moveLeft()
    {
        this.moveRelative(-Parameters.DEFAULT_MOVE_SPACING, 0);
        this.setImage(IF.getSPACESHIP_LEFT());
    }

    /**
     * Move spaceship to the right
     */
    public void moveRight()
    {
        this.moveRelative(Parameters.DEFAULT_MOVE_SPACING, 0);
        this.setImage(IF.getSPACESHIP_RIGHT());
    }

    /**
     * Move spaceship up
     */
    @Override
    public void move()
    {
        this.moveRelative(0, -Parameters.DEFAULT_MOVE_SPACING);
        this.setImage(IF.getSPACESHIP_UP());
    }

    /**
     * Move spaceship down
     */
    public void moveDown()
    {
        this.moveRelative(0, Parameters.DEFAULT_MOVE_SPACING);
        this.setImage(IF.getSPACESHIP_DOWN());
    }

    /**
     * Re-init the img to his initial value, the spaceship seams to stabilize
     * itself
     */
    public void stabilize()
    {
        this.setImage(IF.getSPACESHIP_STABILIZE());
    }

    @Override
    public boolean colision(Rectangle r)
    {
        return r.contains(trueHitBox);
    }

    /**
     * Override as Truehitbox need to be move
     *
     * @param x
     * @param y
     */
    @Override
    public void moveRelative(int x, int y)
    {
        super.moveRelative(x, y);
        this.trueHitBox.x += x;
        this.trueHitBox.y += y;
    }

    /**
     * Override as Truehitbox need to be move
     *
     * @param x
     * @param y
     */
    @Override
    public void move(int x, int y)
    {
        super.moveRelative(x, y);
        this.trueHitBox.x = this.getPosition().x + x;
        this.trueHitBox.y = this.getPosition().y + y;
    }
}
