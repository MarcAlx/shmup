/**
 *
 * Element.java
 *
 * Created by Marc-Alexandre Blanchard - all right reserved ©
 *
 * 2014
 *
 */
package com.game;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * Represents the super class of all graphics elements
 *
 * @author Crée par Marc-Alexandre Blanchard
 */
public abstract class Element
{

    /**
     * Position of the element on screen
     */
    private Point position;

    /**
     * HitBox of the element
     */
    private final Rectangle hitBox;

    /**
     * Represents the elements
     */
    private ElementsEnum type;

    /**
     * Actual image displayed by the game
     */
    private BufferedImage image;

    /**
     * Constructor of the element
     *
     * @param x pos x
     * @param y pos y
     * @param imagePath
     * @param tp
     * @throws java.io.IOException throws if image can't be load
     */
    public Element(int x, int y, String imagePath, ElementsEnum tp) throws IOException
    {
        URL url = getClass().getResource(imagePath);
        this.position = new Point(x, y);
        BufferedImage img;
        img = ImageIO.read(url);
        this.hitBox = new Rectangle(x, y, img.getWidth(), img.getHeight());
        this.image = img;
        this.type = tp;
    }

    /**
     * Constructor of the element
     *
     * @param x pos x
     * @param y pos y
     * @param img
     * @param tp
     */
    public Element(int x, int y, BufferedImage img, ElementsEnum tp)
    {
        this.position = new Point(x, y);
        this.image = img;
        this.hitBox = new Rectangle(x, y, img.getWidth(), img.getHeight());
        this.type = tp;
    }

    /**
     * Constructor of the elements
     *
     * @param imagePath
     * @param tp
     * @throws java.io.IOException throws if image can't be load
     */
    public Element(String imagePath, ElementsEnum tp) throws IOException
    {
        this(0, 0, imagePath, tp);
    }

    /**
     * Constructor of the elements
     *
     * @param img
     * @param tp
     */
    public Element(BufferedImage img, ElementsEnum tp)
    {
        this(0, 0, img, tp);
    }

    /**
     * Tells if component is in collision
     *
     * @param r object in collision
     * @return True collision else False
     */
    public boolean colision(Rectangle r)
    {
        return this.getHitBox().contains(r);
    }

    /**
     * Move element to position
     *
     * @param x new x position
     * @param y new y position
     */
    public void move(int x, int y)
    {
        this.position.x = x;
        this.position.y = y;
        this.hitBox.setLocation(x, y);
    }

    /**
     * Set a new position relative to the actual position
     *
     * @param xPadding
     * @param yPadding
     */
    public void moveRelative(int xPadding, int yPadding)
    {
        this.position.x += xPadding;
        this.position.y += yPadding;
        this.hitBox.setLocation(this.position.x, this.position.y);
    }

    /**
     * @return the position
     */
    public Point getPosition()
    {
        return position;
    }

    /**
     * @return the hitBox
     */
    public Rectangle getHitBox()
    {
        return hitBox;
    }

    /**
     * @return the image
     */
    public BufferedImage getImage()
    {
        return image;
    }

    /**
     * @return the type
     */
    public ElementsEnum getType()
    {
        return type;
    }

    /**
     * @param image the image to set
     */
    public void setImage(BufferedImage image)
    {
        this.image = image;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Point position)
    {
        this.position = position;
    }

    /**
     * Elements must be moveable
     */
    abstract public void move();

}
