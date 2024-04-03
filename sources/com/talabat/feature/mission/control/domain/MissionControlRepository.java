package com.talabat.feature.mission.control.domain;

import com.talabat.feature.mission.control.domain.model.LifeStyleMissionControl;
import com.talabat.feature.mission.control.domain.model.MissionControlRequest;
import com.talabat.feature.mission.control.domain.model.PrimaryMissionControl;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/talabat/feature/mission/control/domain/MissionControlRepository;", "", "getLifeStyleMissionControls", "Lcom/talabat/feature/mission/control/domain/model/LifeStyleMissionControl;", "request", "Lcom/talabat/feature/mission/control/domain/model/MissionControlRequest;", "(Lcom/talabat/feature/mission/control/domain/model/MissionControlRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPrimaryMissionControls", "Lcom/talabat/feature/mission/control/domain/model/PrimaryMissionControl;", "com_talabat_feature_mission-control_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface MissionControlRepository {
    @Nullable
    Object getLifeStyleMissionControls(@NotNull MissionControlRequest missionControlRequest, @NotNull Continuation<? super LifeStyleMissionControl> continuation);

    @Nullable
    Object getPrimaryMissionControls(@NotNull MissionControlRequest missionControlRequest, @NotNull Continuation<? super PrimaryMissionControl> continuation);
}
