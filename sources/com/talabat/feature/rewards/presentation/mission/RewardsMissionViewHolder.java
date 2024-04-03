package com.talabat.feature.rewards.presentation.mission;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.feature.rewards.domain.model.Mission;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b¨\u0006\r"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/RewardsMissionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Lcom/talabat/feature/rewards/presentation/mission/RewardsMissionView;", "(Lcom/talabat/feature/rewards/presentation/mission/RewardsMissionView;)V", "setMission", "", "mission", "Lcom/talabat/feature/rewards/domain/model/Mission;", "setupListener", "onMissionUpdated", "Lcom/talabat/feature/rewards/presentation/mission/RewardsMissionViewHolder$OnMissionUpdated;", "OnMissionUpdated", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RewardsMissionViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/RewardsMissionViewHolder$OnMissionUpdated;", "", "onMissionUpdated", "", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnMissionUpdated {
        void onMissionUpdated();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RewardsMissionViewHolder(@NotNull RewardsMissionView rewardsMissionView) {
        super(rewardsMissionView);
        Intrinsics.checkNotNullParameter(rewardsMissionView, "itemView");
    }

    public final void setMission(@NotNull Mission mission) {
        Intrinsics.checkNotNullParameter(mission, "mission");
        ((RewardsMissionView) this.itemView).setMission(mission);
    }

    public final void setupListener(@Nullable OnMissionUpdated onMissionUpdated) {
        ((RewardsMissionView) this.itemView).setClaimedListener(new RewardsMissionViewHolder$setupListener$listener$1(onMissionUpdated));
    }
}
