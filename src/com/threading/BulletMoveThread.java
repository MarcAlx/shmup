/**
 *
 * ShootThread.java
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
public class BulletMoveThread extends Thread
{

    private final Game currentGame;

    public BulletMoveThread(Game g)
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
                //Shoot
                if (this.currentGame.isShooting())
                {
                    this.currentGame.shoot();
                }
            }
            try
            {
                Thread.sleep(Parameters.BULLET_MOVE_CHECK_TIME);
            }
            catch (InterruptedException ex)
            {
            }
        }
    }
}
