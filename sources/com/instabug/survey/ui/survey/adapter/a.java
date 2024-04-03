package com.instabug.survey.ui.survey.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;

public class a extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List f52546a;

    public a(@NonNull FragmentManager fragmentManager, @NonNull List list) {
        super(fragmentManager);
        this.f52546a = list;
    }

    /* renamed from: a */
    public com.instabug.survey.ui.survey.a getItem(int i11) {
        return (com.instabug.survey.ui.survey.a) this.f52546a.get(i11);
    }

    public int getCount() {
        return this.f52546a.size();
    }
}
