package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.tabs.TabLayout;
import com.talabat.talabatcommon.R;

public final class TabBarWithTagBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final LinearLayout tabsContainer;
    @NonNull
    public final TabLayout tabsLayout;

    private TabBarWithTagBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TabLayout tabLayout) {
        this.rootView = linearLayout;
        this.tabsContainer = linearLayout2;
        this.tabsLayout = tabLayout;
    }

    @NonNull
    public static TabBarWithTagBinding bind(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i11 = R.id.tabsLayout;
        TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, i11);
        if (tabLayout != null) {
            return new TabBarWithTagBinding(linearLayout, linearLayout, tabLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static TabBarWithTagBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static TabBarWithTagBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.tab_bar_with_tag, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
