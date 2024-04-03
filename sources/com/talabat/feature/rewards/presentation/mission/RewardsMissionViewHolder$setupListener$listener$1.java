package com.talabat.feature.rewards.presentation.mission;

import com.talabat.feature.rewards.presentation.mission.RewardsMissionView;
import com.talabat.feature.rewards.presentation.mission.RewardsMissionViewHolder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/talabat/feature/rewards/presentation/mission/RewardsMissionViewHolder$setupListener$listener$1", "Lcom/talabat/feature/rewards/presentation/mission/RewardsMissionView$ClaimedListener;", "onRewardClaimed", "", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RewardsMissionViewHolder$setupListener$listener$1 implements RewardsMissionView.ClaimedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RewardsMissionViewHolder.OnMissionUpdated f58765a;

    public RewardsMissionViewHolder$setupListener$listener$1(RewardsMissionViewHolder.OnMissionUpdated onMissionUpdated) {
        this.f58765a = onMissionUpdated;
    }

    public void onRewardClaimed() {
        RewardsMissionViewHolder.OnMissionUpdated onMissionUpdated = this.f58765a;
        if (onMissionUpdated != null) {
            onMissionUpdated.onMissionUpdated();
        }
    }
}
