package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.views.TalabatImageView;

public final class SidemenuRewardsBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout container;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final RelativeLayout sideMenuHeaderView;
    @NonNull
    public final TalabatImageView sideMenuRewardHeaderIcon;
    @NonNull
    public final TalabatTextView sideMenuRewardHeaderPoints;
    @NonNull
    public final TalabatTextView sideMenuRewardHeaderTitle;
    @NonNull
    public final LinearLayout sideMenuRewardPointsLinearLayout;
    @NonNull
    public final ProgressBar sideMenuRewardPointsProgressBar;

    private SidemenuRewardsBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull RelativeLayout relativeLayout3, @NonNull TalabatImageView talabatImageView, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull LinearLayout linearLayout, @NonNull ProgressBar progressBar) {
        this.rootView = relativeLayout;
        this.container = relativeLayout2;
        this.sideMenuHeaderView = relativeLayout3;
        this.sideMenuRewardHeaderIcon = talabatImageView;
        this.sideMenuRewardHeaderPoints = talabatTextView;
        this.sideMenuRewardHeaderTitle = talabatTextView2;
        this.sideMenuRewardPointsLinearLayout = linearLayout;
        this.sideMenuRewardPointsProgressBar = progressBar;
    }

    @NonNull
    public static SidemenuRewardsBinding bind(@NonNull View view) {
        int i11 = R.id.container;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.container);
        if (relativeLayout != null) {
            RelativeLayout relativeLayout2 = (RelativeLayout) view;
            i11 = R.id.side_menu_reward_header_icon;
            TalabatImageView talabatImageView = (TalabatImageView) ViewBindings.findChildViewById(view, R.id.side_menu_reward_header_icon);
            if (talabatImageView != null) {
                i11 = R.id.side_menu_reward_header_points;
                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.side_menu_reward_header_points);
                if (talabatTextView != null) {
                    i11 = R.id.side_menu_reward_header_title;
                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.side_menu_reward_header_title);
                    if (talabatTextView2 != null) {
                        i11 = R.id.side_menu_reward_points_LinearLayout;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.side_menu_reward_points_LinearLayout);
                        if (linearLayout != null) {
                            i11 = R.id.side_menu_reward_points_ProgressBar;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.side_menu_reward_points_ProgressBar);
                            if (progressBar != null) {
                                return new SidemenuRewardsBinding(relativeLayout2, relativeLayout, relativeLayout2, talabatImageView, talabatTextView, talabatTextView2, linearLayout, progressBar);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static SidemenuRewardsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static SidemenuRewardsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.sidemenu_rewards, viewGroup, false);
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
