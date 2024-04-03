package com.talabat.darkstores.di;

import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.darkstores.data.darkstores.DarkstoresHeaderInterceptor;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("com.talabat.darkstores.di.LibScope")
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresNetworkModule_ProvideDarkstoresHeaderInterceptorFactory implements Factory<DarkstoresHeaderInterceptor> {
    private final Provider<AppVersionProvider> appVersionProvider;

    public DarkstoresNetworkModule_ProvideDarkstoresHeaderInterceptorFactory(Provider<AppVersionProvider> provider) {
        this.appVersionProvider = provider;
    }

    public static DarkstoresNetworkModule_ProvideDarkstoresHeaderInterceptorFactory create(Provider<AppVersionProvider> provider) {
        return new DarkstoresNetworkModule_ProvideDarkstoresHeaderInterceptorFactory(provider);
    }

    public static DarkstoresHeaderInterceptor provideDarkstoresHeaderInterceptor(AppVersionProvider appVersionProvider2) {
        return (DarkstoresHeaderInterceptor) Preconditions.checkNotNullFromProvides(DarkstoresNetworkModule.INSTANCE.provideDarkstoresHeaderInterceptor(appVersionProvider2));
    }

    public DarkstoresHeaderInterceptor get() {
        return provideDarkstoresHeaderInterceptor(this.appVersionProvider.get());
    }
}
