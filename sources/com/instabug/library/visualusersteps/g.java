package com.instabug.library.visualusersteps;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.google.android.material.tabs.TabLayout;

class g implements TabLayout.BaseOnTabSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TabLayout f52153a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j f52154b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f52155c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ k f52156d;

    public g(k kVar, TabLayout tabLayout, j jVar, d dVar) {
        this.f52156d = kVar;
        this.f52153a = tabLayout;
        this.f52154b = jVar;
        this.f52155c = dVar;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private void a(TabLayout.Tab tab, TabLayout tabLayout) {
        if (tab == null) {
            this.f52154b.a(this.f52155c, this.f52156d.f52174f);
        } else if (!TextUtils.isEmpty(tab.getText())) {
            this.f52156d.f52174f.c(String.format("the button \"%s\"", new Object[]{tab.getText().toString()}));
            this.f52154b.a(this.f52155c, this.f52156d.f52174f);
        } else if (tab.getIcon() != null && !VisualUserStepsHelper.a(tabLayout)) {
            this.f52156d.a(tab.getIcon(), this.f52155c, this.f52154b);
        } else if (!TextUtils.isEmpty(tab.getContentDescription())) {
            this.f52156d.f52174f.c(String.format("the button \"%s\"", new Object[]{tab.getContentDescription()}));
            this.f52154b.a(this.f52155c, this.f52156d.f52174f);
        } else {
            this.f52156d.f52174f.c("a button");
            this.f52154b.a(this.f52155c, this.f52156d.f52174f);
        }
        tabLayout.removeOnTabSelectedListener((TabLayout.BaseOnTabSelectedListener) this);
    }

    public void onTabReselected(TabLayout.Tab tab) {
        a(tab, this.f52153a);
    }

    public void onTabSelected(TabLayout.Tab tab) {
        a(tab, this.f52153a);
    }

    public void onTabUnselected(TabLayout.Tab tab) {
    }
}
