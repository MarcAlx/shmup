/**
 *
 * ElementsFactory.java
 *
 * Created by Marc-Alexandre Blanchard - all right reserved ©
 *
 * 2014
 *
 */
package com.game;

import java.awt.Color;

/**
 * Factory to ease elements creation
 *
 * @author Crée par Marc-Alexandre Blanchard
 */
public class ElementsFactory
{

    private static ElementsFactory EF_INSTANCE = null;

    /**
     * To load image
     */
    private final ImagesFactory IF;

    private ElementsFactory()
    {
        IF = ImagesFactory.getInstance();
    }

    public static synchronized ElementsFactory getInstance()
    {
        if (EF_INSTANCE == null)
        {
            EF_INSTANCE = new ElementsFactory();
        }
        return EF_INSTANCE;
    }

    /**
     * Create bullet of type t at position posX posY
     *
     * @param posX
     * @param posY
     * @param t type of bullet 1,2,3
     * @return
     */
    public Bullet createBullet(int posX, int posY, int t)
    {
        Bullet b;
        switch (t)
        {
            case 1:
                b = new Bullet(posX, posY, IF.getBULLET1(), ElementsEnum.BULLET);
                return b;
            case 2:

                b = new Bullet(posX, posY, IF.getBULLET2(), ElementsEnum.BULLET);
                return b;
            case 3:

                b = new Bullet(posX, posY, IF.getBULLET3(), ElementsEnum.BULLET);
                return b;
            default:
                break;

        }
        return null;
    }

    /**
     * Create Enemy of type 1 at position posX posY
     *
     * @param posX
     * @param posY
     * @param t
     * @param lvl
     * @param dir
     * @return
     */
    public Enemy createEnemy(int posX, int posY, int t, int lvl, DirectionEnum dir)
    {
        Enemy e;
        if (lvl == 1)
        {
            switch (t)
            {
                case 1:
                    e = new Enemy(posX, posY, lvl, IF.getENEMY1(), ElementsEnum.ENEMY_SQUARE_SIZE_1, 5, Color.blue, dir);
                    return e;
                case 2:
                    e = new Enemy(posX, posY, lvl, IF.getENEMY2(), ElementsEnum.ENEMY_SQUARE_SIZE_1, 5, Color.green, dir);
                    return e;
                case 3:
                    e = new Enemy(posX, posY, lvl, IF.getENEMY3(), ElementsEnum.ENEMY_SQUARE_SIZE_1, 5, Color.red, dir);
                    return e;
                case 4:
                    e = new Enemy(posX, posY, lvl, IF.getENEMY4(), ElementsEnum.ENEMY_SQUARE_SIZE_1, 5, Color.yellow, dir);
                    return e;
                default:
                    break;
            }
        }
        else if (lvl == 2)
        {
            switch (t)
            {
                case 1:
                    e = new Enemy(posX, posY, lvl, IF.getENEMY5(), ElementsEnum.ENEMY_SQUARE_SIZE_2, 15, Color.blue, dir);
                    return e;
                case 2:
                    e = new Enemy(posX, posY, lvl, IF.getENEMY6(), ElementsEnum.ENEMY_SQUARE_SIZE_2, 15, Color.green, dir);
                    return e;
                case 3:
                    e = new Enemy(posX, posY, lvl, IF.getENEMY7(), ElementsEnum.ENEMY_SQUARE_SIZE_2, 15, Color.red, dir);
                    return e;
                case 4:
                    e = new Enemy(posX, posY, lvl, IF.getENEMY8(), ElementsEnum.ENEMY_SQUARE_SIZE_2, 15, Color.yellow, dir);
                    return e;
                default:
                    break;
            }
        }
        return null;
    }
}
