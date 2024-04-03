package com.talabat.feature.mission.control.domain.usecases;

import com.talabat.feature.mission.control.domain.MissionControlRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class LifeStyleMissionControlsUseCase_Factory implements Factory<LifeStyleMissionControlsUseCase> {
    private final Provider<MissionControlRepository> repositoryProvider;

    public LifeStyleMissionControlsUseCase_Factory(Provider<MissionControlRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static LifeStyleMissionControlsUseCase_Factory create(Provider<MissionControlRepository> provider) {
        return new LifeStyleMissionControlsUseCase_Factory(provider);
    }

    public static LifeStyleMissionControlsUseCase newInstance(MissionControlRepository missionControlRepository) {
        return new LifeStyleMissionControlsUseCase(missionControlRepository);
    }

    public LifeStyleMissionControlsUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
