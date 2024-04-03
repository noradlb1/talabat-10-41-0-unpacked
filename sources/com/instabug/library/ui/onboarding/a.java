package com.instabug.library.ui.onboarding;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;

public class a extends FragmentPagerAdapter {

    /* renamed from: b  reason: collision with root package name */
    public List f51979b;

    public a(FragmentManager fragmentManager, List list) {
        super(fragmentManager);
        this.f51979b = list;
    }

    public int getCount() {
        return this.f51979b.size();
    }

    public Fragment getItem(int i11) {
        return (Fragment) this.f51979b.get(i11);
    }
}
