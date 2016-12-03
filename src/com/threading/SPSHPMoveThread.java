/**
 *
 * MovesThread.java
 *
 * Created by Marc-Alexandre Blanchard - all right reserved ©
 *
 * 2014
 *
 */
package com.threading;

import com.app.Parameters;
import com.game.Game;

/**
 * Makes the spaceship moves
 *
 * @author Crée par Marc-Alexandre Blanchard
 */
public class SPSHPMoveThread extends Thread
{

    private final Game currentGame;

    public SPSHPMoveThread(Game g)
    {
        this.currentGame = g;
    }

    @Override
    public void run()
    {
        while (currentGame.isOnPlay())
        {
            if (!this.currentGame.isOnPause())
            {
                //Move Spaceship
                if (this.currentGame.isGoingDown() && !this.currentGame.isGoingUp())
                {
                    this.currentGame.moveDown();
                }
                else if (!this.currentGame.isGoingDown() && this.currentGame.isGoingUp())
                {
                    this.currentGame.moveUp();
                }
                if (this.currentGame.isGoingLeft() && !this.currentGame.isGoingRight())
                {
                    this.currentGame.moveLeft();
                }
                else if (!this.currentGame.isGoingLeft() && this.currentGame.isGoingRight())
                {
                    this.currentGame.moveRight();
                }
            }

            try
            {
                Thread.sleep(Parameters.SPSHP_MOVE_CHECK_TIME);
            }
            catch (InterruptedException ex)
            {
            }
        }
    }
}
