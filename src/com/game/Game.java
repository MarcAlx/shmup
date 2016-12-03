/**
 *
 * shmup - Game.java
 *
 * Created by Marc-Alexandre Blanchard - all right reserved ©
 *
 * 2014
 *
 */
package com.game;

import com.app.Parameters;
import com.threading.BulletMoveThread;
import com.window.GamePanel;
import java.io.IOException;
import java.util.ArrayList;
import com.threading.EnemyThread;
import com.threading.InteractionThread;
import com.threading.SPSHPMoveThread;
import com.toaster.engine.Toaster;
import com.toaster.exceptions.TooManyToastException;
import java.awt.Color;
import java.util.Timer;
import javax.swing.JOptionPane;

/**
 * Represents the current play
 *
 * @author Crée par Marc-Alexandre Blanchard
 */
public class Game
{

    /**
     * Factory for elements creation
     */
    private final ElementsFactory EF;

    /**
     * To create toastmessages
     */
    private final Toaster T;

    /**
     * score of the current play
     */
    private int score;

    /**
     * highscore of the current play
     */
    private int highscore;

    /**
     * Bullets displayed on screen
     */
    private ArrayList<Bullet> BulletList;

    /**
     * Enemies displayed on screen
     */
    private ArrayList<Enemy> EnemyList;

    /**
     * Spaceship displayed on screen
     */
    private SpaceShip spshp;

    /**
     * Tells if game is on play
     */
    private boolean onPlay;

    /**
     * Actual game panel
     */
    private final GamePanel gamep;

    /**
     * Tells if player is invulnerable
     */
    private boolean invulnerability;

    /**
     * Multiplicator of the current play
     */
    private float multiplicator;

    /**
     * Tells if game is on pause
     */
    private boolean onPause;

    /**
     * Timer to manage invulnerability
     */
    private Timer myTimer;

    /**
     * Current comboColor
     */
    private Color currentComboColor;

    /**
     * Number of kill of the current play
     */
    private int numberOfKIll;

    /**
     * Number of kill of the actual combo
     */
    private int comboKill;

    /**
     * If spaceship is currently shooting
     */
    private boolean shooting;

    /**
     * If spaceship is currently going to the left
     */
    private boolean goingLeft;

    /**
     * If spaceship is currently going down
     */
    private boolean goingDown;

    /**
     * If spaceship is currently going to the right
     */
    private boolean goingRight;

    /**
     * If spaceship is currently going up
     */
    private boolean goingUp;

    /**
     * To load image
     */
    private final ImagesFactory IF;

    /**
     * init a game
     *
     * @param gp game panel to ease drawing
     */
    public Game(GamePanel gp)
    {
        EF = ElementsFactory.getInstance();
        IF = ImagesFactory.getInstance();
        T = Toaster.getInstance();
        this.gamep = gp;
        this.score = 0;
        this.highscore = 0;
        this.onPlay = false;
        this.currentComboColor = Parameters.DEFAULT_COMBO_COLOR;
    }

    /**
     * Start the game
     */
    public void start()
    {
        this.setOnPlay(true);
        this.invulnerability = false;
        this.setOnPause(false);
        this.shooting = false;
        this.goingDown = false;
        this.goingUp = false;
        this.goingLeft = false;
        this.goingRight = false;
        this.score = 0;
        this.numberOfKIll = 0;
        this.comboKill = 0;
        this.multiplicator = 1;
        BulletList = new ArrayList<>();
        EnemyList = new ArrayList<>();
        try
        {
            spshp = new SpaceShip();
        }
        catch (IOException ex)
        {
        }

        InteractionThread IT = new InteractionThread(this);
        IT.start();
        EnemyThread ET = new EnemyThread(this);
        ET.start();
        SPSHPMoveThread SMT = new SPSHPMoveThread(this);
        SMT.start();
        BulletMoveThread BMT = new BulletMoveThread(this);
        BMT.start();
    }

    /**
     * Actualise UI
     */
    public void actualiseView()
    {
        this.gamep.repaint();
    }

    /**
     * @return the score
     */
    public int getScore()
    {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score)
    {
        this.score = score;
    }

    /**
     * @return the highscore
     */
    public int getHighscore()
    {
        return highscore;
    }

    /**
     * @param highscore the highscore to set
     */
    public void setHighscore(int highscore)
    {
        this.highscore = highscore;
    }

    /**
     * Actualise highscore if it has to be updated
     */
    public void updateHighscore()
    {
        if (score > highscore)
        {
            this.highscore = score;
        }
    }

    /**
     * Move spaceship left and actualise UI
     */
    public void moveLeft()
    {
        if (!onPause && onPlay)
        {
            if ((this.getSpshp().getPosition().x - Parameters.DEFAULT_MOVE_SPACING) > Parameters.GAME_WINDOW_MIN_WIDTH)
            {
                this.getSpshp().moveLeft();
                this.actualiseView();
            }
        }
    }

    /**
     * Move spaceship right and actualise UI
     */
    public void moveRight()
    {
        if (!onPause && onPlay)
        {
            if ((this.getSpshp().getPosition().x + Parameters.DEFAULT_MOVE_SPACING + this.getSpshp().getHitBox().width) < Parameters.GAME_WINDOW_WIDTH)
            {
                this.getSpshp().moveRight();
                this.actualiseView();
            }
        }
    }

    /**
     * Move spaceship up and actualise UI
     */
    public void moveUp()
    {
        if (!onPause && onPlay)
        {
            if ((this.getSpshp().getPosition().y - Parameters.DEFAULT_MOVE_SPACING) > Parameters.GAME_WINDOW_MIN_HEIGHT)
            {
                this.getSpshp().move();
                this.actualiseView();
            }
        }
    }

    /**
     * Move spaceship down and actualise UI
     */
    public void moveDown()
    {
        if (!onPause && onPlay)
        {
            if ((this.getSpshp().getPosition().y + Parameters.DEFAULT_MOVE_SPACING + this.getSpshp().getHitBox().height + 15) < Parameters.GAME_WINDOW_HEIGHT)
            {
                this.getSpshp().moveDown();
                this.actualiseView();
            }
        }
    }

    /**
     * @return the onPlay
     */
    public boolean isOnPlay()
    {
        return onPlay;
    }

    /**
     * @return the BulletList
     */
    public ArrayList<Bullet> getBulletList()
    {
        return BulletList;
    }

    /**
     * @return the EnemyList
     */
    public ArrayList<Enemy> getEnemyList()
    {
        return EnemyList;
    }

    /**
     * @return the spshp
     */
    public SpaceShip getSpshp()
    {
        return spshp;
    }

    /**
     * @return the gamep
     */
    public GamePanel getGamep()
    {
        return gamep;
    }

    /**
     * Add bullets on screen
     */
    public void shoot()
    {
        if (!onPause && onPlay)
        {
            //x +10 -10 && Y +15 to get side bullets
            this.BulletList.add(EF.createBullet(this.spshp.getPosition().x + (this.spshp.getHitBox().width / 2) - 2, this.spshp.getPosition().y - 20, spshp.getFirelevel()));
        }
    }

    /**
     * Become invulnerable
     */
    public void beInvulnerable()
    {
        this.invulnerability = true;
    }

    public void looseInvulnerability()
    {
        this.invulnerability = false;
    }

    /**
     * @return the multiplicator
     */
    public float getMultiplicator()
    {
        return multiplicator;
    }

    /**
     * Increase multiplicator +0.1
     */
    public void MultiplicatorUp()
    {
        multiplicator = multiplicator + 0.1f;
        comboKill += 1;
    }

    /**
     * Reset multiplicator
     */
    public void resetMultiplicator()
    {
        multiplicator = 1;
        comboKill = 0;
        this.currentComboColor = Parameters.DEFAULT_COMBO_COLOR;
    }

    /**
     * Increase score and actualise firelevel
     *
     * @param enemyPointValue
     */
    public void increaseScore(int enemyPointValue)
    {
        this.score += enemyPointValue + Parameters.DEFAULT_COMBO_SCORE * this.multiplicator;
        this.updateHighscore();
        if (multiplicator > 10 && this.getSpshp().getFirelevel() == 1)
        {
            this.getSpshp().firelevelUp();
            try
            {
                T.Toast("Level up !\n1 → 2", IF.getTOAST_ICON(), Color.red);
            }
            catch (TooManyToastException ex)
            {
            }
        }
        if (multiplicator > 20 && this.getSpshp().getFirelevel() == 2)
        {
            this.getSpshp().firelevelUp();
            try
            {
                T.Toast("Level up !\n2 → 3", IF.getTOAST_ICON(), Color.green);
            }
            catch (TooManyToastException ex)
            {
            }
        }
    }

    /**
     * @return the invulnerability
     */
    public boolean isInvulnerable()
    {
        return invulnerability;
    }

    /**
     * @return the onPause
     */
    public boolean isOnPause()
    {
        return onPause;
    }

    /**
     * @param onPause the onPause to set
     */
    public void setOnPause(boolean onPause)
    {
        this.onPause = onPause;
    }

    /**
     * Quit the game
     */
    public void quit()
    {
        System.exit(0);
    }

    /**
     * Restart game
     */
    public void restart()
    {
        this.setOnPause(true);
        int i = JOptionPane.showConfirmDialog(null, "Restart ?", "Restart", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, IF.getMAIN_ICON());
        if (i == JOptionPane.YES_OPTION)
        {
            //Wait for end of threads
            this.setOnPlay(false);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
            }
            this.start();
        }
        else
        {
            setOnPause(false);
        }
    }

    /**
     * End game
     */
    public void end()
    {
        this.setOnPause(true);
        this.updateHighscore();
        int i = JOptionPane.showConfirmDialog(null, "Replay ?", "End game", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, IF.getMAIN_ICON());
        if (i == JOptionPane.YES_OPTION)
        {
            this.setOnPlay(false);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
            }
            this.start();
        }
        else
        {
            this.quit();
        }
    }

    /**
     * Print window about
     */
    public void about()
    {
        this.setOnPause(true);
        JOptionPane.showMessageDialog(null, Parameters.ABOUT, "About", JOptionPane.INFORMATION_MESSAGE, IF.getMAIN_ICON());
        this.setOnPause(false);
    }

    /**
     * Print window about
     */
    public void instructions()
    {
        this.setOnPause(true);
        JOptionPane.showMessageDialog(null, Parameters.INSTRUCTION, "Information", JOptionPane.INFORMATION_MESSAGE, IF.getMAIN_ICON());
        this.setOnPause(false);
    }

    /**
     * @param onPlay the onPlay to set
     */
    public void setOnPlay(boolean onPlay)
    {
        this.onPlay = onPlay;
    }

    /**
     * @return the currentComboColor
     */
    public Color getCurrentComboColor()
    {
        return currentComboColor;
    }

    /**
     * @param currentComboColor the currentComboColor to set
     */
    public void setCurrentComboColor(Color currentComboColor)
    {
        this.currentComboColor = currentComboColor;
    }

    /**
     * Show an appropriate notification for level down
     */
    public void showNotificationForLevelDown()
    {
        if (this.spshp.getFirelevel() == 3)
        {
            try
            {
                T.Toast("Fire level down !\n3 → 2", IF.getTOAST_ICON(), Color.red, Color.black, 1000);
            }
            catch (TooManyToastException ex)
            {
            }
        }
        else if (this.spshp.getFirelevel() == 2)
        {
            try
            {
                T.Toast("Fire level down !\n2 → 1", IF.getTOAST_ICON(), Color.blue, Color.black,1000);
            }
            catch (TooManyToastException ex)
            {
            }
        }
    }

    public void increaseNumberOfKill()
    {
        numberOfKIll++;
    }

    /**
     * @return the numberOfKIll
     */
    public int getNumberOfKIll()
    {
        return numberOfKIll;
    }

    /**
     * @return the comboKill
     */
    public int getComboKill()
    {
        return comboKill;
    }

    /**
     * @return the shooting
     */
    public boolean isShooting()
    {
        return shooting;
    }

    /**
     * @param shooting the shooting to set
     */
    public void setShooting(boolean shooting)
    {
        this.shooting = shooting;
    }

    /**
     * @return the goingLeft
     */
    public boolean isGoingLeft()
    {
        return goingLeft;
    }

    /**
     * @param goingLeft the goingLeft to set
     */
    public void setGoingLeft(boolean goingLeft)
    {
        this.goingLeft = goingLeft;
    }

    /**
     * @return the goingDown
     */
    public boolean isGoingDown()
    {
        return goingDown;
    }

    /**
     * @param goingDown the goingDown to set
     */
    public void setGoingDown(boolean goingDown)
    {
        this.goingDown = goingDown;
    }

    /**
     * @return the goingRight
     */
    public boolean isGoingRight()
    {
        return goingRight;
    }

    /**
     * @param goingRight the goingRight to set
     */
    public void setGoingRight(boolean goingRight)
    {
        this.goingRight = goingRight;
    }

    /**
     * @return the goingUp
     */
    public boolean isGoingUp()
    {
        return goingUp;
    }

    /**
     * @param goingUp the goingUp to set
     */
    public void setGoingUp(boolean goingUp)
    {
        this.goingUp = goingUp;
    }
}
