package com.talabat.feature.rewards.data.tracking;

import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.rewards.data.tracking.events.PointsCatalogueLoadedTrackingEvent;
import com.talabat.feature.rewards.data.tracking.events.PointsSuccessLoadedTrackingEvent;
import com.talabat.feature.rewards.domain.RewardsTracker;
import com.talabat.feature.rewards.domain.model.ButtonType;
import com.talabat.feature.rewards.domain.model.Mission;
import com.talabat.feature.rewards.domain.model.MissionOrigin;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/rewards/data/tracking/DefaultRewardsTracker;", "Lcom/talabat/feature/rewards/domain/RewardsTracker;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "onPointsCatalogueLoaded", "", "missionOrigin", "Lcom/talabat/feature/rewards/domain/model/MissionOrigin;", "missions", "", "Lcom/talabat/feature/rewards/domain/model/Mission;", "rewardsCatalogueOrigin", "", "onPointsSuccessLoaded", "offerVoucherId", "buttonType", "Lcom/talabat/feature/rewards/domain/model/ButtonType;", "com_talabat_feature_rewards_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultRewardsTracker implements RewardsTracker {
    @NotNull
    private final TalabatTracker talabatTracker;

    @Inject
    public DefaultRewardsTracker(@NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        this.talabatTracker = talabatTracker2;
    }

    public void onPointsCatalogueLoaded(@Nullable MissionOrigin missionOrigin, @NotNull List<Mission> list, @Nullable String str) {
        Intrinsics.checkNotNullParameter(list, "missions");
        this.talabatTracker.track(new PointsCatalogueLoadedTrackingEvent(missionOrigin, list, str, (List) null, 8, (DefaultConstructorMarker) null));
    }

    public void onPointsSuccessLoaded(@Nullable String str, @NotNull ButtonType buttonType) {
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        this.talabatTracker.track(new PointsSuccessLoadedTrackingEvent(str, buttonType, (List) null, 4, (DefaultConstructorMarker) null));
    }
}
