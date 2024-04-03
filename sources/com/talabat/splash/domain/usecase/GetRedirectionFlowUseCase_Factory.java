package com.talabat.splash.domain.usecase;

import com.talabat.splash.data.preferences.SplashPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetRedirectionFlowUseCase_Factory implements Factory<GetRedirectionFlowUseCase> {
    private final Provider<SplashPreferences> splashPreferencesProvider;

    public GetRedirectionFlowUseCase_Factory(Provider<SplashPreferences> provider) {
        this.splashPreferencesProvider = provider;
    }

    public static GetRedirectionFlowUseCase_Factory create(Provider<SplashPreferences> provider) {
        return new GetRedirectionFlowUseCase_Factory(provider);
    }

    public static GetRedirectionFlowUseCase newInstance(SplashPreferences splashPreferences) {
        return new GetRedirectionFlowUseCase(splashPreferences);
    }

    public GetRedirectionFlowUseCase get() {
        return newInstance(this.splashPreferencesProvider.get());
    }
}
