/**
 *
 * App.java
 *
 * Created by Marc-Alexandre Blanchard - all right reserved ©
 *
 * 2014
 *
 */
package com.app;

import com.window.GameWindow;

/**
 * Represents the app
 *
 * @author Crée par Marc-Alexandre Blanchard
 */
public class App implements Runnable
{

    private final GameWindow gw;

    public App()
    {
        gw = new GameWindow();
    }

    @Override
    public void run()
    {
        gw.build();
        gw.init();
    }
}
