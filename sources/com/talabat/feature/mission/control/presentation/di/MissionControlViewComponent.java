package com.talabat.feature.mission.control.presentation.di;

import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.mission.control.domain.MissionControlFeatureApi;
import com.talabat.feature.mission.control.presentation.LifeStyleMissionV2View;
import com.talabat.feature.mission.control.presentation.LifeStyleMissionView;
import com.talabat.feature.mission.control.presentation.PrimaryMissionView;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/talabat/feature/mission/control/presentation/di/MissionControlViewComponent;", "", "inject", "", "target", "Lcom/talabat/feature/mission/control/presentation/LifeStyleMissionV2View;", "Lcom/talabat/feature/mission/control/presentation/LifeStyleMissionView;", "Lcom/talabat/feature/mission/control/presentation/PrimaryMissionView;", "Factory", "com_talabat_feature_mission-control_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ExperimentCoreLibApi.class, MissionControlFeatureApi.class, TrackingCoreLibApi.class})
public interface MissionControlViewComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/talabat/feature/mission/control/presentation/di/MissionControlViewComponent$Factory;", "", "create", "Lcom/talabat/feature/mission/control/presentation/di/MissionControlViewComponent;", "experimentCoreLibApi", "Lcom/talabat/core/experiment/domain/ExperimentCoreLibApi;", "missionControlFeatureApi", "Lcom/talabat/feature/mission/control/domain/MissionControlFeatureApi;", "trackingCoreLibApi", "Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "com_talabat_feature_mission-control_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        MissionControlViewComponent create(@NotNull ExperimentCoreLibApi experimentCoreLibApi, @NotNull MissionControlFeatureApi missionControlFeatureApi, @NotNull TrackingCoreLibApi trackingCoreLibApi);
    }

    void inject(@NotNull LifeStyleMissionV2View lifeStyleMissionV2View);

    void inject(@NotNull LifeStyleMissionView lifeStyleMissionView);

    void inject(@NotNull PrimaryMissionView primaryMissionView);
}
