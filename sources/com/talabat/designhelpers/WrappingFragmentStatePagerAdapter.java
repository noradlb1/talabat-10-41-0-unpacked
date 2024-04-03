package com.talabat.designhelpers;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public abstract class WrappingFragmentStatePagerAdapter extends FragmentPagerAdapter {
    private int mCurrentPosition = -1;

    public WrappingFragmentStatePagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i11, Object obj) {
        super.setPrimaryItem(viewGroup, i11, obj);
        if (viewGroup instanceof WrappingViewPager) {
            Fragment fragment = (Fragment) obj;
            WrappingViewPager wrappingViewPager = (WrappingViewPager) viewGroup;
            if (fragment != null && fragment.getView() != null) {
                if (i11 != this.mCurrentPosition) {
                    this.mCurrentPosition = i11;
                }
                wrappingViewPager.onPageChanged(fragment.getView());
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("ViewPager is not a WrappingViewPager");
    }
}
