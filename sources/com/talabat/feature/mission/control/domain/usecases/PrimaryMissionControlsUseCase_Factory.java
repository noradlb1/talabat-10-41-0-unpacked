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
public final class PrimaryMissionControlsUseCase_Factory implements Factory<PrimaryMissionControlsUseCase> {
    private final Provider<MissionControlRepository> repositoryProvider;

    public PrimaryMissionControlsUseCase_Factory(Provider<MissionControlRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static PrimaryMissionControlsUseCase_Factory create(Provider<MissionControlRepository> provider) {
        return new PrimaryMissionControlsUseCase_Factory(provider);
    }

    public static PrimaryMissionControlsUseCase newInstance(MissionControlRepository missionControlRepository) {
        return new PrimaryMissionControlsUseCase(missionControlRepository);
    }

    public PrimaryMissionControlsUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
