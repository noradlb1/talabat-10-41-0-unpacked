package com.instabug.featuresrequest.ui.featuresmain;

import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

class d implements TabLayout.BaseOnTabSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewPager f46782a;

    public d(f fVar, ViewPager viewPager) {
        this.f46782a = viewPager;
    }

    public void onTabReselected(TabLayout.Tab tab) {
    }

    public void onTabSelected(TabLayout.Tab tab) {
        this.f46782a.setCurrentItem(tab.getPosition());
    }

    public void onTabUnselected(TabLayout.Tab tab) {
    }
}
