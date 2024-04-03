package com.instabug.featuresrequest.ui.featuresmain;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.instabug.featuresrequest.listeners.c;

public class h extends FragmentPagerAdapter {

    /* renamed from: b  reason: collision with root package name */
    public c f46793b;

    public h(FragmentManager fragmentManager, c cVar) {
        super(fragmentManager);
        this.f46793b = cVar;
    }

    public int getCount() {
        return 2;
    }

    public Fragment getItem(int i11) {
        return this.f46793b.c(i11);
    }

    @Nullable
    public CharSequence getPageTitle(int i11) {
        return i11 != 0 ? i11 != 1 ? "" : "My features" : "Features";
    }
}
