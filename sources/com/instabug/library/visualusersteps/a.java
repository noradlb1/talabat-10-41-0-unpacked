package com.instabug.library.visualusersteps;

import com.google.android.material.tabs.TabLayout;
import com.instabug.library.model.StepType;

public class a implements TabLayout.BaseOnTabSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    private final String f52137a;

    public a(String str) {
        this.f52137a = str;
    }

    public void onTabReselected(TabLayout.Tab tab) {
    }

    public void onTabSelected(TabLayout.Tab tab) {
        y d11 = y.d();
        d11.b(StepType.TAB_SELECT, this.f52137a + " - " + tab.getClass().getSimpleName() + " #" + (tab.getPosition() + 1), tab.getClass().getName(), (String) null);
    }

    public void onTabUnselected(TabLayout.Tab tab) {
    }
}
