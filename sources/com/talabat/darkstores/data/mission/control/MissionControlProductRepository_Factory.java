package com.talabat.darkstores.data.mission.control;

import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.domain.mapper.MissionControlProductsResponseToDomainMapper;
import com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.Scheduler;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.IoScheduler"})
public final class MissionControlProductRepository_Factory implements Factory<MissionControlProductRepository> {
    private final Provider<ConfigurationParameters> configurationParametersProvider;
    private final Provider<DarkstoresRepo> darkstoresRepoProvider;
    private final Provider<Scheduler> ioSchedulerProvider;
    private final Provider<MissionControlProductsResponseToDomainMapper> mapMissionControlResponseProvider;
    private final Provider<MissionControlProductApi> missionControlProductApiProvider;
    private final Provider<IRemoteConfigurationDataSource> remoteConfigDataSourceProvider;

    public MissionControlProductRepository_Factory(Provider<ConfigurationParameters> provider, Provider<IRemoteConfigurationDataSource> provider2, Provider<DarkstoresRepo> provider3, Provider<MissionControlProductApi> provider4, Provider<MissionControlProductsResponseToDomainMapper> provider5, Provider<Scheduler> provider6) {
        this.configurationParametersProvider = provider;
        this.remoteConfigDataSourceProvider = provider2;
        this.darkstoresRepoProvider = provider3;
        this.missionControlProductApiProvider = provider4;
        this.mapMissionControlResponseProvider = provider5;
        this.ioSchedulerProvider = provider6;
    }

    public static MissionControlProductRepository_Factory create(Provider<ConfigurationParameters> provider, Provider<IRemoteConfigurationDataSource> provider2, Provider<DarkstoresRepo> provider3, Provider<MissionControlProductApi> provider4, Provider<MissionControlProductsResponseToDomainMapper> provider5, Provider<Scheduler> provider6) {
        return new MissionControlProductRepository_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static MissionControlProductRepository newInstance(ConfigurationParameters configurationParameters, IRemoteConfigurationDataSource iRemoteConfigurationDataSource, DarkstoresRepo darkstoresRepo, MissionControlProductApi missionControlProductApi, MissionControlProductsResponseToDomainMapper missionControlProductsResponseToDomainMapper, Scheduler scheduler) {
        return new MissionControlProductRepository(configurationParameters, iRemoteConfigurationDataSource, darkstoresRepo, missionControlProductApi, missionControlProductsResponseToDomainMapper, scheduler);
    }

    public MissionControlProductRepository get() {
        return newInstance(this.configurationParametersProvider.get(), this.remoteConfigDataSourceProvider.get(), this.darkstoresRepoProvider.get(), this.missionControlProductApiProvider.get(), this.mapMissionControlResponseProvider.get(), this.ioSchedulerProvider.get());
    }
}
