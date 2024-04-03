package com.talabat.growth.ui.util;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.helpers.GlobalDataModel;
import datamodels.Restaurant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/growth/ui/util/UnexpectedBehaviorObservability;", "", "observability", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "checkIsPickupInGlobalDataModel", "", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnexpectedBehaviorObservability {
    @NotNull
    private final IObservabilityManager observability;

    public UnexpectedBehaviorObservability(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observability");
        this.observability = iObservabilityManager;
    }

    public final void checkIsPickupInGlobalDataModel() {
        boolean z11;
        Restaurant restaurant = GlobalDataModel.SELECTED.getRestaurant();
        if (restaurant != null) {
            z11 = Intrinsics.areEqual((Object) restaurant.isPickup(), (Object) Boolean.TRUE);
        } else {
            z11 = false;
        }
        if (z11) {
            IObservabilityManager.DefaultImpls.trackUnExpectedScenario$default(this.observability, "RewardsIsPickupError", (Map) null, 2, (Object) null);
            restaurant.setPickup(Boolean.FALSE);
            GlobalDataModel.SELECTED.updateRestaurant(restaurant);
        }
    }
}
