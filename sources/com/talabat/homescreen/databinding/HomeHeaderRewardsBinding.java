package com.talabat.homescreen.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.homescreen.R;
import com.talabat.talabatcommon.views.TalabatImageView;

public final class HomeHeaderRewardsBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout container;
    @NonNull
    public final TalabatImageView rewardHeaderIcon;
    @NonNull
    public final AppCompatTextView rewardHeaderTitle;
    @NonNull
    public final RelativeLayout rewardsContainer;
    @NonNull
    private final RelativeLayout rootView;

    private HomeHeaderRewardsBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatImageView talabatImageView, @NonNull AppCompatTextView appCompatTextView, @NonNull RelativeLayout relativeLayout3) {
        this.rootView = relativeLayout;
        this.container = relativeLayout2;
        this.rewardHeaderIcon = talabatImageView;
        this.rewardHeaderTitle = appCompatTextView;
        this.rewardsContainer = relativeLayout3;
    }

    @NonNull
    public static HomeHeaderRewardsBinding bind(@NonNull View view) {
        int i11 = R.id.container;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i11);
        if (relativeLayout != null) {
            i11 = R.id.reward_header_icon;
            TalabatImageView talabatImageView = (TalabatImageView) ViewBindings.findChildViewById(view, i11);
            if (talabatImageView != null) {
                i11 = R.id.reward_header_title;
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
                if (appCompatTextView != null) {
                    RelativeLayout relativeLayout2 = (RelativeLayout) view;
                    return new HomeHeaderRewardsBinding(relativeLayout2, relativeLayout, talabatImageView, appCompatTextView, relativeLayout2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static HomeHeaderRewardsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static HomeHeaderRewardsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.home_header_rewards, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
