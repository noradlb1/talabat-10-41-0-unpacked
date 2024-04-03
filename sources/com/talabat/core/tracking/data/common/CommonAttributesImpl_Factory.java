package com.talabat.core.tracking.data.common;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CommonAttributesImpl_Factory implements Factory<CommonAttributesImpl> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;

    public CommonAttributesImpl_Factory(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2) {
        this.appVersionProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
    }

    public static CommonAttributesImpl_Factory create(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2) {
        return new CommonAttributesImpl_Factory(provider, provider2);
    }

    public static CommonAttributesImpl newInstance(AppVersionProvider appVersionProvider2, ConfigurationLocalRepository configurationLocalRepository) {
        return new CommonAttributesImpl(appVersionProvider2, configurationLocalRepository);
    }

    public CommonAttributesImpl get() {
        return newInstance(this.appVersionProvider.get(), this.configurationLocalRepositoryProvider.get());
    }
}
