package org.crunchersaspire.thirukural.component;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import org.crunchersaspire.thirukural.fragment.AllKuralListFragment;
import org.crunchersaspire.thirukural.fragment.AruthpalKuralListFragment;

import java.util.List;

/**
 * Author: Madasamy
 * Version: 0.0.1
 */
public class HomeViewerPageAdapter extends FragmentPagerAdapter
{
    private List<String> titles;


    public HomeViewerPageAdapter(FragmentManager fragmentManager, List<String> titles)
    {
        super(fragmentManager);
        this.titles = titles;
    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position)
    {

        switch (position) {
            case 0:
                return new AllKuralListFragment();
            case 1:
                return new AruthpalKuralListFragment();

        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return titles.get(position);
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount()
    {
        return titles.size();
    }

}
