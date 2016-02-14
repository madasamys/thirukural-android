package org.crunchersaspire.thirukural;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 * Author : Madasamy
 * Version : 0.0.1
 */
public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
        final Locale[] availableLocales = Locale.getAvailableLocales();
        for (final Locale locale : availableLocales) {
            Log.d("Applog", ":" + locale.getDisplayName() + ":" + locale.getLanguage() + ":"
                    + locale.getCountry() + ":values-" + locale.toString().replace("_", "-r"));
        }
        final TextView textView = (TextView) findViewById(R.id.hello_text);

        Button button = (Button) findViewById(R.id.changelanguage);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Locale systemLocale = getResources().getConfiguration().locale;
                Locale configureLocale;
                if (systemLocale.getLanguage().equalsIgnoreCase("ta")) {

                    configureLocale = new Locale("en");
                    Toast.makeText(MainActivity.this, "Locale in English !", Toast.LENGTH_LONG).show();
                } else {
                    configureLocale = new Locale("ta");
                }
               // Locale locale = new Locale("ta");
                Locale.setDefault(configureLocale);
                Configuration config = new Configuration();
                //Log.i(MainActivity.this.getClass().getSimpleName(), "System locale  " + " " + getResources().getConfiguration().locale.getLanguage());
                config.locale = configureLocale;
                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

                textView.setText(R.string.greet);
            }
        });

        Resources res = getResources();
        String[] planets = res.getStringArray(R.array.planets_array);
        TextView textView1 = (TextView)findViewById(R.id.array_text);
        textView1.setText(planets[0]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
