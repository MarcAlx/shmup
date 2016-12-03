/**
 *
 * Enemy.java
 *
 * Created by Marc-Alexandre Blanchard - all right reserved ©
 *
 * 2014
 *
 */
package com.game;

import com.app.Parameters;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Represents the enemies of the game
 *
 * @author Crée par Marc-Alexandre Blanchard
 */
public class Enemy extends Element
{

    private int level;
    private final int pointValue;
    private Color color;
    private final DirectionEnum direction;
    private final ImagesFactory IF;

    /**
     *
     * @param x
     * @param y
     * @param lvl
     * @param path
     * @param type
     * @param pv point value of the enemy
     * @param c color of the enemy
     * @param dir
     * @throws IOException
     */
    public Enemy(int x, int y, int lvl, String path, ElementsEnum type, int pv, Color c, DirectionEnum dir) throws IOException
    {
        super(x, y, path, type);
        this.level = lvl;
        this.pointValue = pv;
        this.color = c;
        this.direction = dir;
        this.IF = ImagesFactory.getInstance();
    }

    public Enemy(int lvl, String path, ElementsEnum type, int pv, Color c, DirectionEnum dir) throws IOException
    {
        super(Parameters.DEFAULT_POS_X, Parameters.DEFAULT_POS_Y, path, type);
        this.level = lvl;
        this.pointValue = pv;
        this.color = c;
        this.direction = dir;
        this.IF = ImagesFactory.getInstance();
    }

    public Enemy(int x, int y, int lvl, BufferedImage img, ElementsEnum type, int pv, Color c, DirectionEnum dir)
    {
        super(x, y, img, type);
        this.level = lvl;
        this.pointValue = pv;
        this.color = c;
        this.direction = dir;
        this.IF = ImagesFactory.getInstance();
    }

    public Enemy(int lvl, BufferedImage img, ElementsEnum type, int pv, Color c, DirectionEnum dir)
    {
        super(Parameters.DEFAULT_POS_X, Parameters.DEFAULT_POS_Y, img, type);
        this.level = lvl;
        this.pointValue = pv;
        this.color = c;
        this.direction = dir;
        this.IF = ImagesFactory.getInstance();
    }

    /**
     * @return the level
     */
    public int getLevel()
    {
        return level;
    }

    /**
     * Decrease level by 1
     */
    public void decreaseLevel()
    {
        if (level - 1 >= 0)
        {
            level--;
            this.actualiseAppearance();
        }
    }

    private void actualiseAppearance()
    {
        if (this.getType() == ElementsEnum.ENEMY_SQUARE_SIZE_1)
        {
            if (this.color.equals(Color.blue))
            {
                this.setImage(IF.getENEMY1());
            }
            else if (this.color.equals(Color.green))
            {
                this.setImage(IF.getENEMY2());
            }
            else if (this.color.equals(Color.red))
            {
                this.setImage(IF.getENEMY3());
            }
            else if (this.color.equals(Color.yellow))
            {
                this.setImage(IF.getENEMY4());
            }
        }
        else if (this.getType() == ElementsEnum.ENEMY_SQUARE_SIZE_2 && level == 2)
        {
            if (this.color.equals(Color.blue))
            {
                this.setImage(IF.getENEMY5());
            }
            else if (this.color.equals(Color.green))
            {
                this.setImage(IF.getENEMY6());
            }
            else if (this.color.equals(Color.red))
            {
                this.setImage(IF.getENEMY7());
            }
            else if (this.color.equals(Color.yellow))
            {
                this.setImage(IF.getENEMY8());
            }
        }
        else if (this.getType() == ElementsEnum.ENEMY_SQUARE_SIZE_2 && level == 1)
        {
            if (this.color.equals(Color.blue))
            {
                this.setImage(IF.getENEMY5_BROKEN());
            }
            else if (this.color.equals(Color.green))
            {
                this.setImage(IF.getENEMY6_BROKEN());
            }
            else if (this.color.equals(Color.red))
            {
                this.setImage(IF.getENEMY7_BROKEN());
            }
            else if (this.color.equals(Color.yellow))
            {
                this.setImage(IF.getENEMY8_BROKEN());
            }
        }
    }

    public void toggle()
    {
        if (this.color.equals(Color.blue))
        {
            this.color = Color.red;
        }
        else if (this.color.equals(Color.green))
        {
            this.color = Color.yellow;
        }
        else if (this.color.equals(Color.red))
        {
            this.color = Color.green;
        }
        else if (this.color.equals(Color.yellow))
        {
            this.color = Color.blue;
        }
        this.actualiseAppearance();
    }

    /**
     * @return the pointValue
     */
    public int getPointValue()
    {
        return pointValue;
    }

    /**
     * @return the color
     */
    public Color getColor()
    {
        return color;
    }

    @Override
    public void move()
    {
        switch (direction)
        {
            case VERTICAL_NORTH_TO_SOUTH:
                this.moveRelative(0, Parameters.DEFAULT_ENEMY_MOVE_SPACING);
                break;
            case VERTICAL_SOUTH_TO_NORTH:
                this.moveRelative(0, -Parameters.DEFAULT_ENEMY_MOVE_SPACING);
                break;
            case HORIZONTAL_WEST_TO_EAST:
                this.moveRelative(Parameters.DEFAULT_BULLET_MOVE_SPACING, 0);
                break;
            case HORIZONTAL_EAST_TO_WEST:
                this.moveRelative(-Parameters.DEFAULT_BULLET_MOVE_SPACING, 0);
                break;
        }
    }
}
