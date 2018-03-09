package ru.uj.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Blokhin Evgeny on 28.02.2018.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
