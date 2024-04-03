package com.talabat.feature.tpro.presentation.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class TproPresentationModule_ProvideCountryIdFactory implements Factory<Integer> {
    private final Provider<ConfigurationLocalRepository> customerLocalRepositoryProvider;

    public TproPresentationModule_ProvideCountryIdFactory(Provider<ConfigurationLocalRepository> provider) {
        this.customerLocalRepositoryProvider = provider;
    }

    public static TproPresentationModule_ProvideCountryIdFactory create(Provider<ConfigurationLocalRepository> provider) {
        return new TproPresentationModule_ProvideCountryIdFactory(provider);
    }

    public static int provideCountryId(ConfigurationLocalRepository configurationLocalRepository) {
        return TproPresentationModule.INSTANCE.provideCountryId(configurationLocalRepository);
    }

    public Integer get() {
        return Integer.valueOf(provideCountryId(this.customerLocalRepositoryProvider.get()));
    }
}
