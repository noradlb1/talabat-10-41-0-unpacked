package com.talabat.flutter.groceryhome.domain.usecase;

import com.talabat.configuration.ConfigurationLocalRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetUserLocationUseCaseImpl_Factory implements Factory<GetUserLocationUseCaseImpl> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;

    public GetUserLocationUseCaseImpl_Factory(Provider<ConfigurationLocalRepository> provider) {
        this.configurationLocalRepositoryProvider = provider;
    }

    public static GetUserLocationUseCaseImpl_Factory create(Provider<ConfigurationLocalRepository> provider) {
        return new GetUserLocationUseCaseImpl_Factory(provider);
    }

    public static GetUserLocationUseCaseImpl newInstance(ConfigurationLocalRepository configurationLocalRepository) {
        return new GetUserLocationUseCaseImpl(configurationLocalRepository);
    }

    public GetUserLocationUseCaseImpl get() {
        return newInstance(this.configurationLocalRepositoryProvider.get());
    }
}
