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
public final class GetDeviceDeepLinkUseCase_Factory implements Factory<GetDeviceDeepLinkUseCase> {
    private final Provider<SplashPreferences> splashPreferencesProvider;

    public GetDeviceDeepLinkUseCase_Factory(Provider<SplashPreferences> provider) {
        this.splashPreferencesProvider = provider;
    }

    public static GetDeviceDeepLinkUseCase_Factory create(Provider<SplashPreferences> provider) {
        return new GetDeviceDeepLinkUseCase_Factory(provider);
    }

    public static GetDeviceDeepLinkUseCase newInstance(SplashPreferences splashPreferences) {
        return new GetDeviceDeepLinkUseCase(splashPreferences);
    }

    public GetDeviceDeepLinkUseCase get() {
        return newInstance(this.splashPreferencesProvider.get());
    }
}
