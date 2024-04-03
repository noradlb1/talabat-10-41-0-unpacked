package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;
import com.talabat.feature.rewards.presentation.mission.RewardsMissionView;

public final class DarkstoresItemHomeRewardMissionBinding implements ViewBinding {
    @NonNull
    public final RewardsMissionView rewardsMissionView;
    @NonNull
    private final LinearLayout rootView;

    private DarkstoresItemHomeRewardMissionBinding(@NonNull LinearLayout linearLayout, @NonNull RewardsMissionView rewardsMissionView2) {
        this.rootView = linearLayout;
        this.rewardsMissionView = rewardsMissionView2;
    }

    @NonNull
    public static DarkstoresItemHomeRewardMissionBinding bind(@NonNull View view) {
        int i11 = R.id.rewardsMissionView;
        RewardsMissionView rewardsMissionView2 = (RewardsMissionView) ViewBindings.findChildViewById(view, i11);
        if (rewardsMissionView2 != null) {
            return new DarkstoresItemHomeRewardMissionBinding((LinearLayout) view, rewardsMissionView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresItemHomeRewardMissionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemHomeRewardMissionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_home_reward_mission, viewGroup, false);
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
