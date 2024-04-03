package com.talabat.core.safety.data.di;

import com.talabat.core.safety.data.interceptors.UserAgentInterceptor;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.Interceptor;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class PlayIntegrityNetworkModule_InterceptorFactory implements Factory<Interceptor> {
    private final PlayIntegrityNetworkModule module;
    private final Provider<UserAgentInterceptor> userAgentInterceptorProvider;

    public PlayIntegrityNetworkModule_InterceptorFactory(PlayIntegrityNetworkModule playIntegrityNetworkModule, Provider<UserAgentInterceptor> provider) {
        this.module = playIntegrityNetworkModule;
        this.userAgentInterceptorProvider = provider;
    }

    public static PlayIntegrityNetworkModule_InterceptorFactory create(PlayIntegrityNetworkModule playIntegrityNetworkModule, Provider<UserAgentInterceptor> provider) {
        return new PlayIntegrityNetworkModule_InterceptorFactory(playIntegrityNetworkModule, provider);
    }

    public static Interceptor interceptor(PlayIntegrityNetworkModule playIntegrityNetworkModule, UserAgentInterceptor userAgentInterceptor) {
        return (Interceptor) Preconditions.checkNotNullFromProvides(playIntegrityNetworkModule.interceptor(userAgentInterceptor));
    }

    public Interceptor get() {
        return interceptor(this.module, this.userAgentInterceptorProvider.get());
    }
}
