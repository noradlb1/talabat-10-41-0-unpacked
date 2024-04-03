package com.talabat.darkstores.data.swimlanes;

import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.domain.mapper.MissionControlProductsResponseToDomainMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SwimlanesProductRepository_Factory implements Factory<SwimlanesProductRepository> {
    private final Provider<ConfigurationParameters> configurationParametersProvider;
    private final Provider<DarkstoresRepo> darkstoresRepoProvider;
    private final Provider<MissionControlProductsResponseToDomainMapper> mapMissionControlResponseProvider;
    private final Provider<RxSchedulersFactory> rxSchedulersFactoryProvider;
    private final Provider<SwimlanseProductApi> swimlanseProductApiProvider;

    public SwimlanesProductRepository_Factory(Provider<ConfigurationParameters> provider, Provider<DarkstoresRepo> provider2, Provider<SwimlanseProductApi> provider3, Provider<MissionControlProductsResponseToDomainMapper> provider4, Provider<RxSchedulersFactory> provider5) {
        this.configurationParametersProvider = provider;
        this.darkstoresRepoProvider = provider2;
        this.swimlanseProductApiProvider = provider3;
        this.mapMissionControlResponseProvider = provider4;
        this.rxSchedulersFactoryProvider = provider5;
    }

    public static SwimlanesProductRepository_Factory create(Provider<ConfigurationParameters> provider, Provider<DarkstoresRepo> provider2, Provider<SwimlanseProductApi> provider3, Provider<MissionControlProductsResponseToDomainMapper> provider4, Provider<RxSchedulersFactory> provider5) {
        return new SwimlanesProductRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SwimlanesProductRepository newInstance(ConfigurationParameters configurationParameters, DarkstoresRepo darkstoresRepo, SwimlanseProductApi swimlanseProductApi, MissionControlProductsResponseToDomainMapper missionControlProductsResponseToDomainMapper, RxSchedulersFactory rxSchedulersFactory) {
        return new SwimlanesProductRepository(configurationParameters, darkstoresRepo, swimlanseProductApi, missionControlProductsResponseToDomainMapper, rxSchedulersFactory);
    }

    public SwimlanesProductRepository get() {
        return newInstance(this.configurationParametersProvider.get(), this.darkstoresRepoProvider.get(), this.swimlanseProductApiProvider.get(), this.mapMissionControlResponseProvider.get(), this.rxSchedulersFactoryProvider.get());
    }
}
