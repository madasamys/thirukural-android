package org.crunchersaspire.thirukural.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import org.crunchersaspire.thirukural.R;
import org.w3c.dom.Text;

/**
 * Author: Madasamy
 * Version: 1.0.0
 */
public class KuralExplationActivity extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kural_explanation);
        TextView explantationTextView = (TextView) findViewById(R.id.explanationTextView);
        Resources res = getResources();
        String[] planets = res.getStringArray(R.array.explanation);
        explantationTextView.setText(Html.fromHtml(planets[0]));
    }
}
