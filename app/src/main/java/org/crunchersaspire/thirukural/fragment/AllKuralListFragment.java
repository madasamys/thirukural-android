package org.crunchersaspire.thirukural.fragment;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.widget.Toast;

import org.crunchersaspire.thirukural.R;
import org.crunchersaspire.thirukural.service.KuralService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Author: Madasamy
 * Version: 0.0.1
 */
public class AllKuralListFragment extends ListFragment
{
    private KuralService kuralService = new KuralService();

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.i(this.getClass().getSimpleName(), "Preparing to load db..");
        setHasOptionsMenu(true);
        Locale systemLocale = getResources().getConfiguration().locale;
        if (!systemLocale.getLanguage().equalsIgnoreCase("ta")) {
            Locale configureLocale = new Locale("ta");
            Locale.setDefault(configureLocale);
            Configuration config = new Configuration();
            config.locale = configureLocale;
            getActivity().getBaseContext().getResources().updateConfiguration(config,
                    getActivity().getBaseContext().getResources().getDisplayMetrics());
        }

        Resources res = getResources();
        String[] planets = res.getStringArray(R.array.kaduvalvalthu);
        List<String> kurals = new ArrayList<>();
        for (String kural : planets) {
            kurals.add(kural);
        }
        setListAdapter(kuralService.getKuralAdapter(kurals, getFragmentManager()));
    }
}
