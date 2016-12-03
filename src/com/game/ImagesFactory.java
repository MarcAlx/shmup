/**
 *
 * ImagesFactory.java
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
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Crée par Marc-Alexandre Blanchard
 */
public class ImagesFactory
{

    /**
     * For singleton pattern
     */
    private static ImagesFactory IF_INSTANCE;

    //Images
    private ImageIcon MAIN_ICON;
    private ImageIcon TOAST_ICON;
    private BufferedImage SPACESHIP_UP;
    private BufferedImage SPACESHIP_DOWN;
    private BufferedImage SPACESHIP_LEFT;
    private BufferedImage SPACESHIP_RIGHT;
    private BufferedImage SPACESHIP_STABILIZE;
    private BufferedImage BULLET1;
    private BufferedImage BULLET2;
    private BufferedImage BULLET3;
    private BufferedImage ENEMY1;
    private BufferedImage ENEMY2;
    private BufferedImage ENEMY3;
    private BufferedImage ENEMY4;
    private BufferedImage ENEMY5;
    private BufferedImage ENEMY6;
    private BufferedImage ENEMY7;
    private BufferedImage ENEMY8;
    private BufferedImage ENEMY5_BROKEN;
    private BufferedImage ENEMY6_BROKEN;
    private BufferedImage ENEMY7_BROKEN;
    private BufferedImage ENEMY8_BROKEN;
    private BufferedImage SPACE;

    private ImagesFactory()
    {
        try
        {
            URL url = getClass().getResource(Parameters.IMAGE_PATH + "spshp.png");
            MAIN_ICON = new ImageIcon(ImageIO.read(url));
            url = getClass().getResource(Parameters.IMAGE_PATH + "toast_icon.png");
            TOAST_ICON = new ImageIcon(ImageIO.read(url));
            url = getClass().getResource(Parameters.IMAGE_PATH + "spshp.png");
            SPACESHIP_STABILIZE = ImageIO.read(url);
            url = getClass().getResource(Parameters.IMAGE_PATH + "spshp_up.png");
            SPACESHIP_UP = ImageIO.read(url);
            url = getClass().getResource(Parameters.IMAGE_PATH + "spshp_down.png");
            SPACESHIP_DOWN = ImageIO.read(url);
            url = getClass().getResource(Parameters.IMAGE_PATH + "spshp_left.png");
            SPACESHIP_LEFT = ImageIO.read(url);
            url = getClass().getResource(Parameters.IMAGE_PATH + "spshp_right.png");
            SPACESHIP_RIGHT = ImageIO.read(url);
            url = getClass().getResource(Parameters.IMAGE_PATH + "bullet1.png");
            BULLET1 = ImageIO.read(url);
            url = getClass().getResource(Parameters.IMAGE_PATH + "bullet2.png");
            BULLET2 = ImageIO.read(url);
            url = getClass().getResource(Parameters.IMAGE_PATH + "bullet3.png");
            BULLET3 = ImageIO.read(url);
            url = getClass().getResource(Parameters.IMAGE_PATH + "enemy1.png");
            ENEMY1 = ImageIO.read(url);
            url = getClass().getResource(Parameters.IMAGE_PATH + "enemy2.png");
            ENEMY2 = ImageIO.read(url);
            url = getClass().getResource(Parameters.IMAGE_PATH + "enemy3.png");
            ENEMY3 = ImageIO.read(url);
            url = getClass().getResource(Parameters.IMAGE_PATH + "enemy4.png");
            ENEMY4 = ImageIO.read(url);
            url = getClass().getResource(Parameters.IMAGE_PATH + "enemy5.png");
            ENEMY5 = ImageIO.read(url);
            url = getClass().getResource(Parameters.IMAGE_PATH + "enemy6.png");
            ENEMY6 = ImageIO.read(url);
            url = getClass().getResource(Parameters.IMAGE_PATH + "enemy7.png");
            ENEMY7 = ImageIO.read(url);
            url = getClass().getResource(Parameters.IMAGE_PATH + "enemy8.png");
            ENEMY8 = ImageIO.read(url);
            url = getClass().getResource(Parameters.IMAGE_PATH + "enemy5B.png");
            ENEMY5_BROKEN = ImageIO.read(url);
            url = getClass().getResource(Parameters.IMAGE_PATH + "enemy6B.png");
            ENEMY6_BROKEN = ImageIO.read(url);
            url = getClass().getResource(Parameters.IMAGE_PATH + "enemy7B.png");
            ENEMY7_BROKEN = ImageIO.read(url);
            url = getClass().getResource(Parameters.IMAGE_PATH + "enemy8B.png");
            ENEMY8_BROKEN = ImageIO.read(url);
            url = getClass().getResource(Parameters.IMAGE_PATH + "space.png");
            SPACE = ImageIO.read(url);
        }
        catch (IOException ex)
        {

        }
    }

    public static synchronized ImagesFactory getInstance()
    {
        if (IF_INSTANCE == null)
        {
            IF_INSTANCE = new ImagesFactory();
        }
        return IF_INSTANCE;
    }

    /**
     * @return the MAIN_ICON
     */
    public ImageIcon getMAIN_ICON()
    {
        return MAIN_ICON;
    }

    /**
     * @return the TOAST_ICON
     */
    public ImageIcon getTOAST_ICON()
    {
        return TOAST_ICON;
    }

    /**
     * @return the SPACESHIP_UP
     */
    public BufferedImage getSPACESHIP_UP()
    {
        return SPACESHIP_UP;
    }

    /**
     * @return the SPACESHIP_DOWN
     */
    public BufferedImage getSPACESHIP_DOWN()
    {
        return SPACESHIP_DOWN;
    }

    /**
     * @return the SPACESHIP_LEFT
     */
    public BufferedImage getSPACESHIP_LEFT()
    {
        return SPACESHIP_LEFT;
    }

    /**
     * @return the SPACESHIP_RIGHT
     */
    public BufferedImage getSPACESHIP_RIGHT()
    {
        return SPACESHIP_RIGHT;
    }

    /**
     * @return the SPACESHIP_STABILIZE
     */
    public BufferedImage getSPACESHIP_STABILIZE()
    {
        return SPACESHIP_STABILIZE;
    }

    /**
     * @return the BULLET1
     */
    public BufferedImage getBULLET1()
    {
        return BULLET1;
    }

    /**
     * @return the BULLET2
     */
    public BufferedImage getBULLET2()
    {
        return BULLET2;
    }

    /**
     * @return the BULLET3
     */
    public BufferedImage getBULLET3()
    {
        return BULLET3;
    }

    /**
     * @return the ENEMY1
     */
    public BufferedImage getENEMY1()
    {
        return ENEMY1;
    }

    /**
     * @return the ENEMY2
     */
    public BufferedImage getENEMY2()
    {
        return ENEMY2;
    }

    /**
     * @return the ENEMY3
     */
    public BufferedImage getENEMY3()
    {
        return ENEMY3;
    }

    /**
     * @return the ENEMY4
     */
    public BufferedImage getENEMY4()
    {
        return ENEMY4;
    }

    /**
     * @return the ENEMY5
     */
    public BufferedImage getENEMY5()
    {
        return ENEMY5;
    }

    /**
     * @return the ENEMY6
     */
    public BufferedImage getENEMY6()
    {
        return ENEMY6;
    }

    /**
     * @return the ENEMY7
     */
    public BufferedImage getENEMY7()
    {
        return ENEMY7;
    }

    /**
     * @return the ENEMY8
     */
    public BufferedImage getENEMY8()
    {
        return ENEMY8;
    }

    /**
     * @return the ENEMY5_BROKEN
     */
    public BufferedImage getENEMY5_BROKEN()
    {
        return ENEMY5_BROKEN;
    }

    /**
     * @return the ENEMY6_BROKEN
     */
    public BufferedImage getENEMY6_BROKEN()
    {
        return ENEMY6_BROKEN;
    }

    /**
     * @return the ENEMY7_BROKEN
     */
    public BufferedImage getENEMY7_BROKEN()
    {
        return ENEMY7_BROKEN;
    }

    /**
     * @return the ENEMY8_BROKEN
     */
    public BufferedImage getENEMY8_BROKEN()
    {
        return ENEMY8_BROKEN;
    }

    /**
     * @return the SPACE
     */
    public BufferedImage getSPACE()
    {
        return SPACE;
    }

}
