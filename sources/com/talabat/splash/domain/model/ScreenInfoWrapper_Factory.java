package com.talabat.splash.domain.model;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class ScreenInfoWrapper_Factory implements Factory<ScreenInfoWrapper> {
    private final Provider<String> forceUpdateMessageProvider;
    private final Provider<Boolean> isForceUpdateProvider;
    private final Provider<String> screenNameProvider;
    private final Provider<SplashRedirectionWrapper> screenTypeProvider;
    private final Provider<Boolean> shouldForceLocationSelectLocationInHomeProvider;

    public ScreenInfoWrapper_Factory(Provider<String> provider, Provider<String> provider2, Provider<SplashRedirectionWrapper> provider3, Provider<Boolean> provider4, Provider<Boolean> provider5) {
        this.screenNameProvider = provider;
        this.forceUpdateMessageProvider = provider2;
        this.screenTypeProvider = provider3;
        this.isForceUpdateProvider = provider4;
        this.shouldForceLocationSelectLocationInHomeProvider = provider5;
    }

    public static ScreenInfoWrapper_Factory create(Provider<String> provider, Provider<String> provider2, Provider<SplashRedirectionWrapper> provider3, Provider<Boolean> provider4, Provider<Boolean> provider5) {
        return new ScreenInfoWrapper_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ScreenInfoWrapper newInstance(String str, String str2, SplashRedirectionWrapper splashRedirectionWrapper, Boolean bool, Boolean bool2) {
        return new ScreenInfoWrapper(str, str2, splashRedirectionWrapper, bool, bool2);
    }

    public ScreenInfoWrapper get() {
        return newInstance(this.screenNameProvider.get(), this.forceUpdateMessageProvider.get(), this.screenTypeProvider.get(), this.isForceUpdateProvider.get(), this.shouldForceLocationSelectLocationInHomeProvider.get());
    }
}
