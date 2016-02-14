package org.crunchersaspire.thirukural.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.crunchersaspire.thirukural.R;
import org.crunchersaspire.thirukural.component.HomeViewerPageAdapter;
import org.crunchersaspire.thirukural.component.SlidingTabLayout;

import java.util.Arrays;
import java.util.List;

/**
 * Author: Madasamy
 * Version: 0.0.1
 */
public class HomeTabActivity extends AppCompatActivity
{
    private List<String> titles;
    private ViewPager pager;
    private HomeViewerPageAdapter adapter;
    private SlidingTabLayout tabs;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_tab_layout);
        titles = Arrays.asList("All", "Aruthupal");
        // Creating The HomeViewerPageAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.ome
        Log.i(this.getClass().getSimpleName(), "Preparing to load home view fragment");
        adapter = new HomeViewerPageAdapter(getSupportFragmentManager(), titles);
        adapter.notifyDataSetChanged();

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.viewer_pager);
        pager.setAdapter(adapter);
        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(false);
        // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width
        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer()
        {
            @Override
            public int getIndicatorColor(int position)
            {
                return getResources().getColor(R.color.bright_foreground_material_dark);
            }
        });
        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);
    }
}
