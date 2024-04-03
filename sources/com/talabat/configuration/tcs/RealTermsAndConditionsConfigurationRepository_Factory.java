package com.talabat.configuration.tcs;

import com.talabat.configuration.AppInfoContainer;
import com.talabat.configuration.tcs.mapper.TermsAndConditionsConfigMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class RealTermsAndConditionsConfigurationRepository_Factory implements Factory<RealTermsAndConditionsConfigurationRepository> {
    private final Provider<AppInfoContainer> appInfoContainerProvider;
    private final Provider<TermsAndConditionsConfigMapper> mapperProvider;

    public RealTermsAndConditionsConfigurationRepository_Factory(Provider<AppInfoContainer> provider, Provider<TermsAndConditionsConfigMapper> provider2) {
        this.appInfoContainerProvider = provider;
        this.mapperProvider = provider2;
    }

    public static RealTermsAndConditionsConfigurationRepository_Factory create(Provider<AppInfoContainer> provider, Provider<TermsAndConditionsConfigMapper> provider2) {
        return new RealTermsAndConditionsConfigurationRepository_Factory(provider, provider2);
    }

    public static RealTermsAndConditionsConfigurationRepository newInstance(AppInfoContainer appInfoContainer, TermsAndConditionsConfigMapper termsAndConditionsConfigMapper) {
        return new RealTermsAndConditionsConfigurationRepository(appInfoContainer, termsAndConditionsConfigMapper);
    }

    public RealTermsAndConditionsConfigurationRepository get() {
        return newInstance(this.appInfoContainerProvider.get(), this.mapperProvider.get());
    }
}
