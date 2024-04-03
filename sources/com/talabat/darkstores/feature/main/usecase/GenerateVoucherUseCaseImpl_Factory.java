package com.talabat.darkstores.feature.main.usecase;

import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GenerateVoucherUseCaseImpl_Factory implements Factory<GenerateVoucherUseCaseImpl> {
    private final Provider<ConfigurationParameters> configurationParametersProvider;
    private final Provider<DarkstoresRepo> darkstoresRepoProvider;

    public GenerateVoucherUseCaseImpl_Factory(Provider<DarkstoresRepo> provider, Provider<ConfigurationParameters> provider2) {
        this.darkstoresRepoProvider = provider;
        this.configurationParametersProvider = provider2;
    }

    public static GenerateVoucherUseCaseImpl_Factory create(Provider<DarkstoresRepo> provider, Provider<ConfigurationParameters> provider2) {
        return new GenerateVoucherUseCaseImpl_Factory(provider, provider2);
    }

    public static GenerateVoucherUseCaseImpl newInstance(DarkstoresRepo darkstoresRepo, ConfigurationParameters configurationParameters) {
        return new GenerateVoucherUseCaseImpl(darkstoresRepo, configurationParameters);
    }

    public GenerateVoucherUseCaseImpl get() {
        return newInstance(this.darkstoresRepoProvider.get(), this.configurationParametersProvider.get());
    }
}
