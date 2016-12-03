/**
 *
 * shmup - GameKeyListenner.java
 *
 * Created by Marc-Alexandre Blanchard - all right reserved ©
 *
 * 2014
 *
 */
package com.window;

import com.game.Game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Keylistenner of the game, manage key binding
 *
 * @author Crée par Marc-Alexandre Blanchard
 */
public class GameKeyListenner implements KeyListener
{

    private final Game gm;

    public GameKeyListenner(Game g)
    {
        this.gm = g;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_Z)
        {
            this.gm.setGoingUp(true);
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)
        {
            this.gm.setGoingDown(true);
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)
        {
            this.gm.setGoingRight(true);
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_Q)
        {
            this.gm.setGoingLeft(true);
        }
        else if (e.getKeyCode() == KeyEvent.VK_F)
        {
            this.gm.setShooting(true);
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            this.gm.setOnPause(!this.gm.isOnPause());
        }
        else if (e.getKeyCode() == KeyEvent.VK_R)
        {
            this.gm.restart();
        }
        else if (e.getKeyCode() == KeyEvent.VK_A)
        {
            this.gm.about();
        }
        else if (e.getKeyCode() == KeyEvent.VK_I)
        {
            this.gm.instructions();
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if (gm.isOnPlay())
        {
            this.gm.getSpshp().stabilize();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_Z)
        {
            this.gm.setGoingUp(false);
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)
        {
            this.gm.setGoingDown(false);
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)
        {
            this.gm.setGoingRight(false);
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_Q)
        {
            this.gm.setGoingLeft(false);
        }
        else if (e.getKeyCode() == KeyEvent.VK_F)
        {
            this.gm.setShooting(false);
        }
    }
}
