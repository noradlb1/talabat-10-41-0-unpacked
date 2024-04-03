package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.duolingo.open.rtlviewpager.RtlViewPager;
import com.google.android.material.tabs.TabLayout;
import com.talabat.darkstores.R;

public final class DarkstoresFragmentCategoriesBinding implements ViewBinding {
    @NonNull
    public final AppCompatImageView allCategories;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final RtlViewPager subcategoriesViewPager;
    @NonNull
    public final LinearLayout tabContainer;
    @NonNull
    public final TabLayout tabLayout;

    private DarkstoresFragmentCategoriesBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull ProgressBar progressBar2, @NonNull RtlViewPager rtlViewPager, @NonNull LinearLayout linearLayout, @NonNull TabLayout tabLayout2) {
        this.rootView = constraintLayout;
        this.allCategories = appCompatImageView;
        this.progressBar = progressBar2;
        this.subcategoriesViewPager = rtlViewPager;
        this.tabContainer = linearLayout;
        this.tabLayout = tabLayout2;
    }

    @NonNull
    public static DarkstoresFragmentCategoriesBinding bind(@NonNull View view) {
        int i11 = R.id.allCategories;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
        if (appCompatImageView != null) {
            i11 = R.id.progressBar;
            ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, i11);
            if (progressBar2 != null) {
                i11 = R.id.subcategoriesViewPager;
                RtlViewPager rtlViewPager = (RtlViewPager) ViewBindings.findChildViewById(view, i11);
                if (rtlViewPager != null) {
                    i11 = R.id.tabContainer;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                    if (linearLayout != null) {
                        i11 = R.id.tabLayout;
                        TabLayout tabLayout2 = (TabLayout) ViewBindings.findChildViewById(view, i11);
                        if (tabLayout2 != null) {
                            return new DarkstoresFragmentCategoriesBinding((ConstraintLayout) view, appCompatImageView, progressBar2, rtlViewPager, linearLayout, tabLayout2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresFragmentCategoriesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresFragmentCategoriesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_fragment_categories, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
