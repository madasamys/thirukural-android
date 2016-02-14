package org.crunchersaspire.thirukural;

import android.os.Build;

import android.view.View;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

/**
 * Author : Madasamy
 * Version : 0.0.1
 */

@RunWith(CustomRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.KITKAT)
public class MainActivityTest
{


    private MainActivity mainActivity;

    @Before
    public void setUp()
    {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void testTextView()
    {
        System.out.println("--textView--");
        TextView textView = (TextView) mainActivity.findViewById(R.id.hello_text);
        assertEquals(-2, textView.getLayoutParams().height);
        assertEquals(-1, textView.getLayoutParams().width);
    }
}