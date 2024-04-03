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
public final class GetSplashPhaseOneUseCase_Factory implements Factory<GetSplashPhaseOneUseCase> {
    private final Provider<SplashPreferences> splashPreferencesProvider;

    public GetSplashPhaseOneUseCase_Factory(Provider<SplashPreferences> provider) {
        this.splashPreferencesProvider = provider;
    }

    public static GetSplashPhaseOneUseCase_Factory create(Provider<SplashPreferences> provider) {
        return new GetSplashPhaseOneUseCase_Factory(provider);
    }

    public static GetSplashPhaseOneUseCase newInstance(SplashPreferences splashPreferences) {
        return new GetSplashPhaseOneUseCase(splashPreferences);
    }

    public GetSplashPhaseOneUseCase get() {
        return newInstance(this.splashPreferencesProvider.get());
    }
}
