package com.talabat.splash.presentation.infrastructure.thirdparty;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.splash.data.preferences.SplashPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SplashConfig_Factory implements Factory<SplashConfig> {
    private final Provider<SplashPreferences> splashPreferencesProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public SplashConfig_Factory(Provider<SplashPreferences> provider, Provider<ITalabatFeatureFlag> provider2) {
        this.splashPreferencesProvider = provider;
        this.talabatFeatureFlagProvider = provider2;
    }

    public static SplashConfig_Factory create(Provider<SplashPreferences> provider, Provider<ITalabatFeatureFlag> provider2) {
        return new SplashConfig_Factory(provider, provider2);
    }

    public static SplashConfig newInstance(SplashPreferences splashPreferences, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new SplashConfig(splashPreferences, iTalabatFeatureFlag);
    }

    public SplashConfig get() {
        return newInstance(this.splashPreferencesProvider.get(), this.talabatFeatureFlagProvider.get());
    }
}
