package com.talabat.feature.mission.control.data.di;

import com.talabat.feature.mission.control.data.RealMissionControlRepository;
import com.talabat.feature.mission.control.data.remote.mapper.LifeStyleMissionControlMapper;
import com.talabat.feature.mission.control.data.remote.mapper.PrimaryMissionControlMapper;
import com.talabat.feature.mission.control.data.remote.model.LifeStyleMissionControlResponse;
import com.talabat.feature.mission.control.data.remote.model.PrimaryMissionControlResponse;
import com.talabat.feature.mission.control.domain.MissionControlRepository;
import com.talabat.feature.mission.control.domain.model.LifeStyleMissionControl;
import com.talabat.feature.mission.control.domain.model.PrimaryMissionControl;
import com.talabat.mapper.ModelMapper;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'J\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u0006\u001a\u00020\u000fH'¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/mission/control/data/di/MissionControlFeatureModule;", "", "lifeStyleMissionControlMapper", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/mission/control/data/remote/model/LifeStyleMissionControlResponse;", "Lcom/talabat/feature/mission/control/domain/model/LifeStyleMissionControl;", "impl", "Lcom/talabat/feature/mission/control/data/remote/mapper/LifeStyleMissionControlMapper;", "missionControlRepository", "Lcom/talabat/feature/mission/control/domain/MissionControlRepository;", "repository", "Lcom/talabat/feature/mission/control/data/RealMissionControlRepository;", "primaryMissionControlMapper", "Lcom/talabat/feature/mission/control/data/remote/model/PrimaryMissionControlResponse;", "Lcom/talabat/feature/mission/control/domain/model/PrimaryMissionControl;", "Lcom/talabat/feature/mission/control/data/remote/mapper/PrimaryMissionControlMapper;", "com_talabat_feature_mission-control_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {MissionControlNetworkModule.class})
public interface MissionControlFeatureModule {
    @NotNull
    @Binds
    ModelMapper<LifeStyleMissionControlResponse, LifeStyleMissionControl> lifeStyleMissionControlMapper(@NotNull LifeStyleMissionControlMapper lifeStyleMissionControlMapper);

    @NotNull
    @Binds
    @Reusable
    MissionControlRepository missionControlRepository(@NotNull RealMissionControlRepository realMissionControlRepository);

    @NotNull
    @Binds
    ModelMapper<PrimaryMissionControlResponse, PrimaryMissionControl> primaryMissionControlMapper(@NotNull PrimaryMissionControlMapper primaryMissionControlMapper);
}
