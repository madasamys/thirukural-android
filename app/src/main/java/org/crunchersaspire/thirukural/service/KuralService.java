package org.crunchersaspire.thirukural.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.crunchersaspire.thirukural.R;
import org.crunchersaspire.thirukural.ThirukuralApplication;
import org.crunchersaspire.thirukural.activity.KuralExplationActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Madasamy
 * Version: 0.0.1
 */
public class KuralService
{
    private ThirukuralApplication thirukuralApplication = new ThirukuralApplication();

    public ArrayAdapter<String> getKuralAdapter(final List<String> kurals, final FragmentManager fragmentManager)
    {
        return new ArrayAdapter<String>(thirukuralApplication.getContext(), R.layout.listview_adapter, kurals)
        {
            @Override
            public View getView(final int position, View convertView, final ViewGroup parent)
            {
                LayoutInflater inflater = (LayoutInflater) thirukuralApplication.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View rowView = inflater.inflate(R.layout.listview_adapter, parent, false);
                final TextView textView = (TextView) rowView.findViewById(R.id.kuralTextView);
                String kuralString = kurals.get(position);
                textView.setText(Html.fromHtml(kuralString));
                (rowView.findViewById(R.id.kuralTextView)).setOnClickListener(new View.OnClickListener()
                {
                    public void onClick(View arg0)
                    {
                        Intent intent = new Intent(thirukuralApplication.getContext(), KuralExplationActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("position", position);
                        thirukuralApplication.getContext().startActivity(intent);

                    }
                });
                return rowView;
            }
        };
    }
}
