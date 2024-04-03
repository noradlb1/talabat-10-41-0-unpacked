package com.talabat.growth.ui.loyalty.dashboard;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.talabat.feature.rewards.domain.model.Mission;
import com.talabat.feature.rewards.presentation.mission.RewardsMissionView;
import com.talabat.growth.databinding.FragLoyaltyDashboardBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/talabat/growth/ui/loyalty/dashboard/LoyaltyDashboardFragment$setupMissionWidget$1", "Lcom/talabat/feature/rewards/presentation/mission/RewardsMissionView$Listener;", "onHasMission", "", "mission", "Lcom/talabat/feature/rewards/domain/model/Mission;", "onHasNoMission", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyDashboardFragment$setupMissionWidget$1 implements RewardsMissionView.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoyaltyDashboardFragment f60652a;

    public LoyaltyDashboardFragment$setupMissionWidget$1(LoyaltyDashboardFragment loyaltyDashboardFragment) {
        this.f60652a = loyaltyDashboardFragment;
    }

    public void onHasMission(@NotNull Mission mission) {
        Intrinsics.checkNotNullParameter(mission, "mission");
        this.f60652a.trackPointsCatalogueLoaded(mission);
        FragLoyaltyDashboardBinding access$getBinding$p = this.f60652a.binding;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        ConstraintLayout constraintLayout = access$getBinding$p.clMissionBlock;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clMissionBlock");
        constraintLayout.setVisibility(0);
    }

    public void onHasNoMission() {
        FragLoyaltyDashboardBinding fragLoyaltyDashboardBinding = null;
        LoyaltyDashboardFragment.f(this.f60652a, (Mission) null, 1, (Object) null);
        FragLoyaltyDashboardBinding access$getBinding$p = this.f60652a.binding;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragLoyaltyDashboardBinding = access$getBinding$p;
        }
        ConstraintLayout constraintLayout = fragLoyaltyDashboardBinding.clMissionBlock;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clMissionBlock");
        constraintLayout.setVisibility(8);
    }
}
