package com.talabat.feature.mission.control.domain.usecases;

import com.talabat.feature.mission.control.domain.MissionControlRepository;
import com.talabat.feature.mission.control.domain.model.LifeStyleMissionControl;
import com.talabat.feature.mission.control.domain.model.MissionControlRequest;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/feature/mission/control/domain/usecases/LifeStyleMissionControlsUseCase;", "", "repository", "Lcom/talabat/feature/mission/control/domain/MissionControlRepository;", "(Lcom/talabat/feature/mission/control/domain/MissionControlRepository;)V", "getLifeStyleMissionControls", "Lcom/talabat/feature/mission/control/domain/model/LifeStyleMissionControl;", "request", "Lcom/talabat/feature/mission/control/domain/model/MissionControlRequest;", "(Lcom/talabat/feature/mission/control/domain/model/MissionControlRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_mission-control_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifeStyleMissionControlsUseCase {
    @NotNull
    private final MissionControlRepository repository;

    @Inject
    public LifeStyleMissionControlsUseCase(@NotNull MissionControlRepository missionControlRepository) {
        Intrinsics.checkNotNullParameter(missionControlRepository, "repository");
        this.repository = missionControlRepository;
    }

    @Nullable
    public final Object getLifeStyleMissionControls(@NotNull MissionControlRequest missionControlRequest, @NotNull Continuation<? super LifeStyleMissionControl> continuation) {
        return this.repository.getLifeStyleMissionControls(missionControlRequest, continuation);
    }
}
