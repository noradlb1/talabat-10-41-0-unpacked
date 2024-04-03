package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.views.TalabatImageView;
import com.wang.avi.AVLoadingIndicatorView;

public final class UserAccountRewardsBinding implements ViewBinding {
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final ConstraintLayout sideMenuHeaderView;
    @NonNull
    public final TalabatImageView sideMenuRewardHeaderIcon;
    @NonNull
    public final TalabatTextView sideMenuRewardHeaderPoints;
    @NonNull
    public final TalabatTextView sideMenuRewardHeaderTitle;
    @NonNull
    public final LinearLayout sideMenuRewardPointsLinearLayout;
    @NonNull
    public final AVLoadingIndicatorView sideMenuRewardPointsProgressBar;

    private UserAccountRewardsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull TalabatImageView talabatImageView, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull LinearLayout linearLayout, @NonNull AVLoadingIndicatorView aVLoadingIndicatorView) {
        this.rootView = constraintLayout;
        this.sideMenuHeaderView = constraintLayout2;
        this.sideMenuRewardHeaderIcon = talabatImageView;
        this.sideMenuRewardHeaderPoints = talabatTextView;
        this.sideMenuRewardHeaderTitle = talabatTextView2;
        this.sideMenuRewardPointsLinearLayout = linearLayout;
        this.sideMenuRewardPointsProgressBar = aVLoadingIndicatorView;
    }

    @NonNull
    public static UserAccountRewardsBinding bind(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i11 = R.id.side_menu_reward_header_icon;
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
                        AVLoadingIndicatorView aVLoadingIndicatorView = (AVLoadingIndicatorView) ViewBindings.findChildViewById(view, R.id.side_menu_reward_points_ProgressBar);
                        if (aVLoadingIndicatorView != null) {
                            return new UserAccountRewardsBinding(constraintLayout, constraintLayout, talabatImageView, talabatTextView, talabatTextView2, linearLayout, aVLoadingIndicatorView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static UserAccountRewardsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static UserAccountRewardsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.user_account_rewards, viewGroup, false);
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
