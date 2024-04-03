package com.talabat.feature.rewards.data.tracking;

import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.rewards.data.tracking.events.MissionBottomSheetClickedTrackingEvent;
import com.talabat.feature.rewards.data.tracking.events.MissionClickedTrackingEvent;
import com.talabat.feature.rewards.data.tracking.events.MissionCompletedTrackingEvent;
import com.talabat.feature.rewards.data.tracking.events.MissionDetailLoadedTrackingEvent;
import com.talabat.feature.rewards.data.tracking.events.MissionSuccessLoadedTrackingEvent;
import com.talabat.feature.rewards.data.tracking.events.MissionsShopListLoadedTrackingEvent;
import com.talabat.feature.rewards.domain.MissionTracker;
import com.talabat.feature.rewards.domain.model.Mission;
import com.talabat.feature.rewards.domain.model.MissionButtonType;
import com.talabat.feature.rewards.domain.model.MissionClickType;
import com.talabat.feature.rewards.domain.model.MissionOrigin;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u0011\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u0012\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u0013\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/rewards/data/tracking/DefaultMissionTracker;", "Lcom/talabat/feature/rewards/domain/MissionTracker;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "onMissionButtonClicked", "", "buttonType", "Lcom/talabat/feature/rewards/domain/model/MissionButtonType;", "origin", "Lcom/talabat/feature/rewards/domain/model/MissionOrigin;", "onMissionClicked", "mission", "Lcom/talabat/feature/rewards/domain/model/Mission;", "clickType", "Lcom/talabat/feature/rewards/domain/model/MissionClickType;", "onMissionCompleted", "onMissionDetailLoaded", "onMissionSuccessLoaded", "onMissionsShopListLoaded", "missions", "", "com_talabat_feature_rewards_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultMissionTracker implements MissionTracker {
    @NotNull
    private final TalabatTracker talabatTracker;

    @Inject
    public DefaultMissionTracker(@NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        this.talabatTracker = talabatTracker2;
    }

    public void onMissionButtonClicked(@NotNull MissionButtonType missionButtonType, @Nullable MissionOrigin missionOrigin) {
        Intrinsics.checkNotNullParameter(missionButtonType, "buttonType");
        this.talabatTracker.track(new MissionBottomSheetClickedTrackingEvent(missionButtonType, missionOrigin, (List) null, 4, (DefaultConstructorMarker) null));
    }

    public void onMissionClicked(@Nullable MissionOrigin missionOrigin, @NotNull Mission mission, @NotNull MissionClickType missionClickType) {
        Intrinsics.checkNotNullParameter(mission, "mission");
        Intrinsics.checkNotNullParameter(missionClickType, "clickType");
        this.talabatTracker.track(new MissionClickedTrackingEvent(missionOrigin, mission, missionClickType, (List) null, 8, (DefaultConstructorMarker) null));
    }

    public void onMissionCompleted(@Nullable MissionOrigin missionOrigin, @NotNull Mission mission) {
        Intrinsics.checkNotNullParameter(mission, "mission");
        this.talabatTracker.track(new MissionCompletedTrackingEvent(missionOrigin, mission, (List) null, 4, (DefaultConstructorMarker) null));
    }

    public void onMissionDetailLoaded(@Nullable MissionOrigin missionOrigin, @NotNull Mission mission) {
        Intrinsics.checkNotNullParameter(mission, "mission");
        this.talabatTracker.track(new MissionDetailLoadedTrackingEvent(missionOrigin, mission, (List) null, 4, (DefaultConstructorMarker) null));
    }

    public void onMissionSuccessLoaded(@Nullable MissionOrigin missionOrigin, @NotNull Mission mission) {
        Intrinsics.checkNotNullParameter(mission, "mission");
        this.talabatTracker.track(new MissionSuccessLoadedTrackingEvent(missionOrigin, mission, (List) null, 4, (DefaultConstructorMarker) null));
    }

    public void onMissionsShopListLoaded(@Nullable MissionOrigin missionOrigin, @NotNull List<Mission> list) {
        Intrinsics.checkNotNullParameter(list, "missions");
        this.talabatTracker.track(new MissionsShopListLoadedTrackingEvent(missionOrigin, list, (List) null, 4, (DefaultConstructorMarker) null));
    }
}
