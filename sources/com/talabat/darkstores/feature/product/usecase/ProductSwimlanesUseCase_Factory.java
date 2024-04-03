package com.talabat.darkstores.feature.product.usecase;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.feature.darkstores.swimlanes.domain.SwimlanesRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class ProductSwimlanesUseCase_Factory implements Factory<ProductSwimlanesUseCase> {
    private final Provider<ConfigurationParameters> configurationParametersProvider;
    private final Provider<DarkstoresRepo> darkstoresRepoProvider;
    private final Provider<DiscoveryRepo> discoveryRepoProvider;
    private final Provider<ITalabatFeatureFlag> featureFlagsProvider;
    private final Provider<SwimlanesRepository> swimlanesRepositoryProvider;

    public ProductSwimlanesUseCase_Factory(Provider<DarkstoresRepo> provider, Provider<DiscoveryRepo> provider2, Provider<SwimlanesRepository> provider3, Provider<ConfigurationParameters> provider4, Provider<ITalabatFeatureFlag> provider5) {
        this.darkstoresRepoProvider = provider;
        this.discoveryRepoProvider = provider2;
        this.swimlanesRepositoryProvider = provider3;
        this.configurationParametersProvider = provider4;
        this.featureFlagsProvider = provider5;
    }

    public static ProductSwimlanesUseCase_Factory create(Provider<DarkstoresRepo> provider, Provider<DiscoveryRepo> provider2, Provider<SwimlanesRepository> provider3, Provider<ConfigurationParameters> provider4, Provider<ITalabatFeatureFlag> provider5) {
        return new ProductSwimlanesUseCase_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ProductSwimlanesUseCase newInstance(DarkstoresRepo darkstoresRepo, DiscoveryRepo discoveryRepo, SwimlanesRepository swimlanesRepository, ConfigurationParameters configurationParameters, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new ProductSwimlanesUseCase(darkstoresRepo, discoveryRepo, swimlanesRepository, configurationParameters, iTalabatFeatureFlag);
    }

    public ProductSwimlanesUseCase get() {
        return newInstance(this.darkstoresRepoProvider.get(), this.discoveryRepoProvider.get(), this.swimlanesRepositoryProvider.get(), this.configurationParametersProvider.get(), this.featureFlagsProvider.get());
    }
}
