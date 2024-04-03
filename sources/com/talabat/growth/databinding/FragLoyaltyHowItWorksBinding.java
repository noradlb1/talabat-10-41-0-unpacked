package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_navigation_bar.DSNavigationBarWithActionButton;
import com.talabat.growth.R;
import com.talabat.talabatcommon.views.titleViewMoreGridView.TitleViewMoreGridView;

public final class FragLoyaltyHowItWorksBinding implements ViewBinding {
    @NonNull
    public final ImageView howItWorksBackButton;
    @NonNull
    public final TitleViewMoreGridView howItWorksTitleViewMoreGridView;
    @NonNull
    public final DSNavigationBarWithActionButton navBarHowItWork;
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final ScrollView scroller;

    private FragLoyaltyHowItWorksBinding(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull TitleViewMoreGridView titleViewMoreGridView, @NonNull DSNavigationBarWithActionButton dSNavigationBarWithActionButton, @NonNull ScrollView scrollView) {
        this.rootView = frameLayout;
        this.howItWorksBackButton = imageView;
        this.howItWorksTitleViewMoreGridView = titleViewMoreGridView;
        this.navBarHowItWork = dSNavigationBarWithActionButton;
        this.scroller = scrollView;
    }

    @NonNull
    public static FragLoyaltyHowItWorksBinding bind(@NonNull View view) {
        int i11 = R.id.howItWorksBackButton;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.howItWorksTitleViewMoreGridView;
            TitleViewMoreGridView titleViewMoreGridView = (TitleViewMoreGridView) ViewBindings.findChildViewById(view, i11);
            if (titleViewMoreGridView != null) {
                i11 = R.id.navBarHowItWork;
                DSNavigationBarWithActionButton dSNavigationBarWithActionButton = (DSNavigationBarWithActionButton) ViewBindings.findChildViewById(view, i11);
                if (dSNavigationBarWithActionButton != null) {
                    i11 = R.id.scroller;
                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i11);
                    if (scrollView != null) {
                        return new FragLoyaltyHowItWorksBinding((FrameLayout) view, imageView, titleViewMoreGridView, dSNavigationBarWithActionButton, scrollView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragLoyaltyHowItWorksBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragLoyaltyHowItWorksBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.frag_loyalty_how_it_works, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
