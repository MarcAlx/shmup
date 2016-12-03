/**
 *
 * shmup - GameWindow.java
 *
 * Created by Marc-Alexandre Blanchard - all right reserved ©
 *
 * 2014
 *
 */
package com.window;

import com.app.Parameters;
import com.game.Game;
import com.game.ImagesFactory;
import javax.swing.JFrame;

/**
 * Main window of the game
 *
 * @author Crée par Marc-Alexandre Blanchard
 */
public class GameWindow extends JFrame
{

    /**
     * Panel of the game window
     */
    private GamePanel gamePanel;

    /**
     * Game
     */
    private Game currentGame;

    /**
     * To load image
     */
    private final ImagesFactory IF;

    public GameWindow()
    {
        IF = ImagesFactory.getInstance();
    }

    /**
     * Build the visual aspect of the window
     */
    public void build()
    {
        this.setTitle(Parameters.APPNAME + " " + Parameters.VERSION_NUMBER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(Parameters.GAME_WINDOW_DIMENSION);
        this.setLocationRelativeTo(null);

        gamePanel = new GamePanel();
        this.setContentPane(gamePanel);

        this.setVisible(true);

    }

    /**
     * Init game
     */
    public void init()
    {
        this.currentGame = new Game(gamePanel);
        this.gamePanel.setGm(currentGame);
        this.addKeyListener(new GameKeyListenner(currentGame));
        this.currentGame.start();
        this.currentGame.instructions();
    }

}
