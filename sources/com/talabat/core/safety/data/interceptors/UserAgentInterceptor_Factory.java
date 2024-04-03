package com.talabat.core.safety.data.interceptors;

import com.talabat.configuration.discovery.AppVersionProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class UserAgentInterceptor_Factory implements Factory<UserAgentInterceptor> {
    private final Provider<AppVersionProvider> appVersionProvider;

    public UserAgentInterceptor_Factory(Provider<AppVersionProvider> provider) {
        this.appVersionProvider = provider;
    }

    public static UserAgentInterceptor_Factory create(Provider<AppVersionProvider> provider) {
        return new UserAgentInterceptor_Factory(provider);
    }

    public static UserAgentInterceptor newInstance(AppVersionProvider appVersionProvider2) {
        return new UserAgentInterceptor(appVersionProvider2);
    }

    public UserAgentInterceptor get() {
        return newInstance(this.appVersionProvider.get());
    }
}
