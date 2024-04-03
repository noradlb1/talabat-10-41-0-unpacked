package com.talabat.feature.mission.control.data;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.feature.mission.control.data.remote.LifeStyleMissionControlApi;
import com.talabat.feature.mission.control.data.remote.PrimaryMissionControlApi;
import com.talabat.feature.mission.control.data.remote.mapper.LifeStyleMissionControlMapper;
import com.talabat.feature.mission.control.data.remote.mapper.PrimaryMissionControlMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RealMissionControlRepository_Factory implements Factory<RealMissionControlRepository> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagProvider;
    private final Provider<LifeStyleMissionControlApi> lifeStyleMissionControlApiProvider;
    private final Provider<LifeStyleMissionControlMapper> lifeStyleMissionControlMapperProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<PrimaryMissionControlApi> primaryMissionControlApiProvider;
    private final Provider<PrimaryMissionControlMapper> primaryMissionControlMapperProvider;
    private final Provider<ITalabatExperiment> talabatExperimentProvider;

    public RealMissionControlRepository_Factory(Provider<ConfigurationLocalRepository> provider, Provider<ITalabatFeatureFlag> provider2, Provider<ITalabatExperiment> provider3, Provider<LifeStyleMissionControlMapper> provider4, Provider<LifeStyleMissionControlApi> provider5, Provider<PrimaryMissionControlApi> provider6, Provider<IObservabilityManager> provider7, Provider<PrimaryMissionControlMapper> provider8) {
        this.configurationLocalRepositoryProvider = provider;
        this.featureFlagProvider = provider2;
        this.talabatExperimentProvider = provider3;
        this.lifeStyleMissionControlMapperProvider = provider4;
        this.lifeStyleMissionControlApiProvider = provider5;
        this.primaryMissionControlApiProvider = provider6;
        this.observabilityManagerProvider = provider7;
        this.primaryMissionControlMapperProvider = provider8;
    }

    public static RealMissionControlRepository_Factory create(Provider<ConfigurationLocalRepository> provider, Provider<ITalabatFeatureFlag> provider2, Provider<ITalabatExperiment> provider3, Provider<LifeStyleMissionControlMapper> provider4, Provider<LifeStyleMissionControlApi> provider5, Provider<PrimaryMissionControlApi> provider6, Provider<IObservabilityManager> provider7, Provider<PrimaryMissionControlMapper> provider8) {
        return new RealMissionControlRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static RealMissionControlRepository newInstance(ConfigurationLocalRepository configurationLocalRepository, ITalabatFeatureFlag iTalabatFeatureFlag, ITalabatExperiment iTalabatExperiment, LifeStyleMissionControlMapper lifeStyleMissionControlMapper, LifeStyleMissionControlApi lifeStyleMissionControlApi, PrimaryMissionControlApi primaryMissionControlApi, IObservabilityManager iObservabilityManager, PrimaryMissionControlMapper primaryMissionControlMapper) {
        return new RealMissionControlRepository(configurationLocalRepository, iTalabatFeatureFlag, iTalabatExperiment, lifeStyleMissionControlMapper, lifeStyleMissionControlApi, primaryMissionControlApi, iObservabilityManager, primaryMissionControlMapper);
    }

    public RealMissionControlRepository get() {
        return newInstance(this.configurationLocalRepositoryProvider.get(), this.featureFlagProvider.get(), this.talabatExperimentProvider.get(), this.lifeStyleMissionControlMapperProvider.get(), this.lifeStyleMissionControlApiProvider.get(), this.primaryMissionControlApiProvider.get(), this.observabilityManagerProvider.get(), this.primaryMissionControlMapperProvider.get());
    }
}
