package com.talabat.feature.darkstores.presentation.viewmodel;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.feature.darkstores.domain.repository.DarkstoresRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkStoresDeepLinkViewModel_Factory implements Factory<DarkStoresDeepLinkViewModel> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<DarkstoresRepository> darkStoresRepositoryProvider;

    public DarkStoresDeepLinkViewModel_Factory(Provider<DarkstoresRepository> provider, Provider<ConfigurationLocalRepository> provider2) {
        this.darkStoresRepositoryProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
    }

    public static DarkStoresDeepLinkViewModel_Factory create(Provider<DarkstoresRepository> provider, Provider<ConfigurationLocalRepository> provider2) {
        return new DarkStoresDeepLinkViewModel_Factory(provider, provider2);
    }

    public static DarkStoresDeepLinkViewModel newInstance(DarkstoresRepository darkstoresRepository, ConfigurationLocalRepository configurationLocalRepository) {
        return new DarkStoresDeepLinkViewModel(darkstoresRepository, configurationLocalRepository);
    }

    public DarkStoresDeepLinkViewModel get() {
        return newInstance(this.darkStoresRepositoryProvider.get(), this.configurationLocalRepositoryProvider.get());
    }
}
