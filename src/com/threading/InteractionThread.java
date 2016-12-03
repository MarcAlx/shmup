/**
 *
 * InteractionThread.java
 *
 * Created by Marc-Alexandre Blanchard - all right reserved ©
 *
 * 2014
 *
 */
package com.threading;

import com.app.Parameters;
import com.game.Bullet;
import com.game.Game;
import java.util.ArrayList;
import java.util.Timer;

/**
 * Thread in charge of the interaction of the game
 *
 * @author Crée par Marc-Alexandre Blanchard
 */
public class InteractionThread extends Thread
{

    private final Game currentGame;
    private final ArrayList<Bullet> toRemove;
    private Timer myTimer;

    public InteractionThread(Game g)
    {
        this.currentGame = g;
        toRemove = new ArrayList<>();
    }

    @Override
    public void run()
    {
        while (currentGame.isOnPlay())
        {
            if (!this.currentGame.isOnPause())
            {

                //Move bullets
                for (int i = 0; i < this.currentGame.getBulletList().size(); i++)
                {
                    //if bullet can moves it moves inside screen
                    if (this.currentGame.getBulletList().get(i).getPosition().y - Parameters.DEFAULT_BULLET_MOVE_SPACING > Parameters.GAME_WINDOW_MIN_HEIGHT)
                    {
                        //Move
                        this.currentGame.getBulletList().get(i).move();
                        //Check Bullet / Enemy colision
                        for (int j = 0; j < this.currentGame.getEnemyList().size(); j++)
                        {
                            //Si collision
                            if (this.currentGame.getEnemyList().get(j).colision(this.currentGame.getBulletList().get(i).getHitBox()))
                            {
                                //Couleurs egales ou multiplicator = 1 : combo++
                                if (this.currentGame.getMultiplicator() == 1 || this.currentGame.getEnemyList().get(j).getColor().equals(this.currentGame.getCurrentComboColor()))
                                {
                                    this.currentGame.MultiplicatorUp();
                                    this.currentGame.setCurrentComboColor(this.currentGame.getEnemyList().get(j).getColor());
                                }
                                else
                                {
                                    this.currentGame.resetMultiplicator();
                                    this.currentGame.setCurrentComboColor(this.currentGame.getEnemyList().get(j).getColor());
                                }

                                //Enemy loose life equal to power level
                                for (int k = 0; k < this.currentGame.getSpshp().getFirelevel(); k++)
                                {
                                    this.currentGame.getEnemyList().get(j).decreaseLevel();
                                }

                                //Add bullet to removelist to avoid dirty read
                                toRemove.add(this.currentGame.getBulletList().get(i));

                                //Remove enemy if level == 0
                                if (this.currentGame.getEnemyList().get(j).getLevel() == 0)
                                {
                                    this.currentGame.increaseNumberOfKill();
                                    this.currentGame.increaseScore(this.currentGame.getEnemyList().get(j).getPointValue());
                                    this.currentGame.getEnemyList().remove(this.currentGame.getEnemyList().get(j));
                                }
                            }
                        }

                    }
                    //else it removes
                    else
                    {
                        this.currentGame.getBulletList().remove(this.currentGame.getBulletList().get(i));
                        //If bullet out of screen color combo reset
                        this.currentGame.resetMultiplicator();
                    }
                }

                //Remove elements from to read list
                for (int i = 0; i < toRemove.size(); i++)
                {
                    this.currentGame.getBulletList().remove(toRemove.get(i));
                }
                this.currentGame.actualiseView();

                //Move enemies
                for (int i = 0; i < this.currentGame.getEnemyList().size(); i++)
                {
                    //if enemy can moves it moves
                    if (Parameters.SCREEN_RECTANGLE.contains(this.currentGame.getEnemyList().get(i).getPosition()))
                    {
                        this.currentGame.getEnemyList().get(i).move();
                        //Check enemy colision with spaceship
                        if (!this.currentGame.isInvulnerable() && this.currentGame.getSpshp().colision(this.currentGame.getEnemyList().get(i).getHitBox()))
                        {
                            this.currentGame.showNotificationForLevelDown();
                            this.currentGame.getSpshp().firelevelDown();
                            if (this.currentGame.getSpshp().getFirelevel() > 0)
                            {
                                this.currentGame.beInvulnerable();
                                myTimer = new Timer();
                                myTimer.schedule(new InvulnerabilityTask(this.currentGame), Parameters.INVULNERABILITY_TIME);
                            }
                            else
                            {
                                this.currentGame.setOnPlay(false);
                            }
                        }
                    }
                    //else it removes
                    else
                    {
                        this.currentGame.getEnemyList().remove(this.currentGame.getEnemyList().get(i));
                    }
                }
            }
            this.currentGame.actualiseView();
            try
            {
                Thread.sleep(Parameters.INTERACTION_CHECK_TIME);
            }
            catch (InterruptedException ex)
            {
            }
        }
        //If we go out of the thread loop and fire level == 0, this mean we had to restart
        if (this.currentGame.getSpshp().getFirelevel() == 0)
        {
            this.currentGame.end();
        }
    }
}
