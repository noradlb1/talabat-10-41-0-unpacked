package com.talabat.growth.ui.loyalty.dashboard;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.talabat.feature.rewards.presentation.mission.RewardsMissionView;
import com.talabat.growth.databinding.FragLoyaltyDashboardBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/talabat/growth/ui/loyalty/dashboard/LoyaltyDashboardFragment$setupMissionWidget$2", "Lcom/talabat/feature/rewards/presentation/mission/RewardsMissionView$ClaimedListener;", "onRewardClaimed", "", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyDashboardFragment$setupMissionWidget$2 implements RewardsMissionView.ClaimedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoyaltyDashboardFragment f60653a;

    public LoyaltyDashboardFragment$setupMissionWidget$2(LoyaltyDashboardFragment loyaltyDashboardFragment) {
        this.f60653a = loyaltyDashboardFragment;
    }

    public void onRewardClaimed() {
        FragLoyaltyDashboardBinding access$getBinding$p = this.f60653a.binding;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        ConstraintLayout constraintLayout = access$getBinding$p.clMissionBlock;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clMissionBlock");
        constraintLayout.setVisibility(8);
    }
}
