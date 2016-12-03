/**
 *
 * shmup - Parameters.java
 *
 * Created by Marc-Alexandre Blanchard - all right reserved ©
 *
 * 2014
 *
 */
package com.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;

/**
 * Static parameters of the project
 *
 * @author Crée par Marc-Alexandre Blanchard
 */
public class Parameters
{

    /**
     * Name of the app
     */
    public final static String APPNAME = "shmup";

    /**
     * Default width of the game window
     */
    public final static int GAME_WINDOW_WIDTH = 1024;

    /**
     * Default heigth of the game window
     */
    public final static int GAME_WINDOW_HEIGHT = 720;

    /**
     * Min width of the game window
     */
    public final static int GAME_WINDOW_MIN_WIDTH = 0;

    /**
     * Min heigth of the game window
     */
    public final static int GAME_WINDOW_MIN_HEIGHT = 0;

    /**
     * Rectangle wich has the size of the screen
     */
    public final static Rectangle SCREEN_RECTANGLE = new Rectangle(Parameters.GAME_WINDOW_MIN_WIDTH - 1, Parameters.GAME_WINDOW_MIN_HEIGHT - 1, Parameters.GAME_WINDOW_WIDTH + 1, Parameters.GAME_WINDOW_HEIGHT + 1);

    /**
     * Dimension of the game window
     */
    public final static Dimension GAME_WINDOW_DIMENSION = new Dimension(GAME_WINDOW_WIDTH, GAME_WINDOW_HEIGHT);

    /**
     * Default posX of the spaceShip
     */
    public final static int DEFAULT_POS_X = 475;

    /**
     * Default posY of the spaceShip
     */
    public final static int DEFAULT_POS_Y = 625;

    /**
     * X coord of the spshp point hitbox
     */
    public final static int SPSHP_HITBOX_X = 23;

    /**
     * Y coord of the spshp point hitbox
     */
    public final static int SPSHP_HITBOX_Y = 30;

    /**
     * Default posY of the spaceShip
     */
    public final static int DEFAULT_MOVE_SPACING = 20;

    /**
     * Default move spacing of bullets
     */
    public final static int DEFAULT_BULLET_MOVE_SPACING = 5;

    /**
     * Default move spacing of enemies
     */
    public final static int DEFAULT_ENEMY_MOVE_SPACING = 1;

    /**
     * Invulnerability time in ms
     */
    public final static int INVULNERABILITY_TIME = 750;

    /**
     * Default Interaction time
     */
    public final static int INTERACTION_CHECK_TIME = 10;

    /**
     * Default Spaceship move time
     */
    public final static int SPSHP_MOVE_CHECK_TIME = 50;

    /**
     * Default bullet move time
     */
    public final static int BULLET_MOVE_CHECK_TIME = 95;

    /**
     * Default Interaction time
     */
    public final static int DEFAULT_ENEMY_TIME = 1000;

    /**
     * Score gain with multiplicator
     */
    public final static int DEFAULT_COMBO_SCORE = 10;

    /**
     * Path to images
     */
    public final static String IMAGE_PATH = "/com/ressources/images/";
    /**
     * String wich explain the game
     */
    public final static String INSTRUCTION = "Make the highest score by destroying enemies.\nUse arrows and ZQSD to move.\nPress F to fire and <space> to pause.\nR to restart, I to show this window.\nA to get informations about the game.";

    /**
     * String wich show information about the game
     */
    public final static String ABOUT = "shmup is created, designed and developped by\nMarc-Alexandre Blanchard\n\nVersion : " + Parameters.VERSION_NUMBER + "\n\nFeedbacks at : marc-alx@outlook.com";

    /**
     * Default combo color, on edge touch : Gray
     */
    public final static Color DEFAULT_COMBO_COLOR = new Color(128, 128, 128);

    /**
     * Main font of the game
     */
    public final static Font GAME_FONT = new Font("Lucida", Font.PLAIN, 12);
    //Version informations
    private final static int MAJOR_RELEASE_NUMBER = 0;
    private final static int SUB_RELEASE_NUMBER = 9;
    private final static int MINOR_RELEASE_NUMBER = 0;
    private final static char RELEASE_TYPE = 'b';

    /**
     * Version number of the grame
     */
    public final static String VERSION_NUMBER = MAJOR_RELEASE_NUMBER + "." + SUB_RELEASE_NUMBER + "." + MINOR_RELEASE_NUMBER + RELEASE_TYPE;

    /**
     * Private constructor to avoid instanciation
     */
    private Parameters()
    {

    }
}
