/**
 *
 * EnemyThreads.java
 *
 * Created by Marc-Alexandre Blanchard - all right reserved ©
 *
 * 2014
 *
 */
package com.threading;

import com.app.Parameters;
import com.game.DirectionEnum;
import com.game.ElementsFactory;
import com.game.Game;
import java.util.Random;

/**
 *
 * @author Crée par Marc-Alexandre Blanchard
 */
public class EnemyThread extends Thread
{

    /**
     * Factory for elements creation
     */
    private final ElementsFactory EF;

    private final Game currentGame;

    private final Random r;

    private int EnemyAddTime;

    public EnemyThread(Game g)
    {
        EF = ElementsFactory.getInstance();
        r = new Random();
        this.currentGame = g;
        EnemyAddTime = Parameters.DEFAULT_ENEMY_TIME;
    }

    @Override
    public void run()
    {
        while (currentGame.isOnPlay())
        {
            if (!this.currentGame.isOnPause())
            {
                for (int i = 0; i < this.currentGame.getEnemyList().size(); i++)
                {
                    this.currentGame.getEnemyList().get(i).toggle();
                }
                double enKind = Math.random();
                int level = 1;
                double bigEnemyRate = Math.random();
                if (bigEnemyRate > 0.90)
                {
                    level++;
                }
                int enemyHeightWidth = 50 * level;
                int posX = r.nextInt(Parameters.GAME_WINDOW_WIDTH - enemyHeightWidth);
                int posY = r.nextInt(Parameters.GAME_WINDOW_HEIGHT - enemyHeightWidth);
                int type = r.nextInt(4) + 1;
                int LR = r.nextInt(2);
                if (enKind >= 0 && enKind < 0.80)
                {
                    this.currentGame.getEnemyList().add(EF.createEnemy(posX, Parameters.GAME_WINDOW_MIN_HEIGHT, type, level, DirectionEnum.VERTICAL_NORTH_TO_SOUTH));
                }
                else if (enKind >= 0.80 && enKind < 0.90)
                {
                    if (LR == 0)
                    {
                        this.currentGame.getEnemyList().add(EF.createEnemy(Parameters.GAME_WINDOW_MIN_WIDTH, posY, type, level, DirectionEnum.HORIZONTAL_WEST_TO_EAST));
                    }
                    else
                    {
                        this.currentGame.getEnemyList().add(EF.createEnemy(Parameters.GAME_WINDOW_WIDTH - enemyHeightWidth, posY, type, level, DirectionEnum.HORIZONTAL_EAST_TO_WEST));
                    }
                }

                else if (enKind >= 0.90 && enKind < 0.95)
                {
                    this.currentGame.getEnemyList().add(EF.createEnemy(posX, Parameters.GAME_WINDOW_HEIGHT - enemyHeightWidth, type, level, DirectionEnum.VERTICAL_SOUTH_TO_NORTH));
                }
                this.currentGame.actualiseView();

            }
            if (this.currentGame.getNumberOfKIll() < 900)
            {
                EnemyAddTime = Parameters.DEFAULT_ENEMY_TIME - currentGame.getNumberOfKIll();
            }
            try
            {
                Thread.sleep(EnemyAddTime);
            }
            catch (InterruptedException ex)
            {
            }
        }
    }
}
