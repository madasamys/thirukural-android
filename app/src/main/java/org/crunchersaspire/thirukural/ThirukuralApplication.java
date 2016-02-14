package org.crunchersaspire.thirukural;

import android.app.Application;
import android.content.Context;

/**
 * Author: Madasamy
 * Version: 0.0.1
 */
public class ThirukuralApplication extends Application
{

    private static Context context;

    public static Context getContext()
    {
        return context;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        context = getApplicationContext();
    }
}
