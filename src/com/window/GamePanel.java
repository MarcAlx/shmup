/**
 *
 * shmup - GamePanel.java
 *
 * Created by Marc-Alexandre Blanchard - all right reserved ©
 *
 * 2014
 *
 */
package com.window;

import com.app.Parameters;
import com.game.Bullet;
import com.game.Enemy;
import com.game.Game;
import com.game.ImagesFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Meant to be contained inside a GameWindow, this is where things are drawn
 *
 * @author Crée par Marc-Alexandre Blanchard
 */
public class GamePanel extends JPanel
{

    private Game gm;
    private String info;
    private String kill;
    private Bullet b;
    private Enemy e;
    private ImagesFactory IF;

    public GamePanel()
    {
        this.setLayout(new BorderLayout());
        IF = ImagesFactory.getInstance();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (gm != null)
        {
            g.drawImage(IF.getSPACE(), 0, 0, null);
            //Print Score and highcore
            g.setColor(Color.white);
            g.setFont(Parameters.GAME_FONT);

            info = "Score " + gm.getScore() + " Highscrore " + gm.getHighscore();
            if (gm.isOnPause())
            {
                info += " - Pause";

            }

            kill = "x " + gm.getMultiplicator() + " kill " + gm.getComboKill();

            //Draw rectangle combo
            g.drawString(info, 5, 15);
            g.drawString(kill, 23, 35);
            g.setColor(this.gm.getCurrentComboColor());
            g.fillRect(5, 25, 10, 10);

            //Draw spaceship
            if (getGm().getSpshp() != null)
            {
                g.drawImage(getGm().getSpshp().getImage(), getGm().getSpshp().getPosition().x, getGm().getSpshp().getPosition().y, null);
                //Draw bullets
                for (int i = 0; i < getGm().getBulletList().size(); i++)
                {
                    b = getGm().getBulletList().get(i);
                    g.drawImage(b.getImage(), b.getPosition().x, b.getPosition().y, null);
                }
                //Draw enemies
                for (int i = 0; i < getGm().getEnemyList().size(); i++)
                {
                    e = getGm().getEnemyList().get(i);
                    g.drawImage(e.getImage(), e.getPosition().x, e.getPosition().y, null);
                }
            }
        }
    }

    /**
     * @return the gm
     */
    public Game getGm()
    {
        return gm;
    }

    /**
     * @param gm the gm to set
     */
    public void setGm(Game gm)
    {
        this.gm = gm;
    }
}
