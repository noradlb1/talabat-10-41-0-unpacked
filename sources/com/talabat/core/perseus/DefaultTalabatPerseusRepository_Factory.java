package com.talabat.core.perseus;

import android.content.Context;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DefaultTalabatPerseusRepository_Factory implements Factory<DefaultTalabatPerseusRepository> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<Context> contextProvider;
    private final Provider<CoroutineDispatchersFactory> dispatchersFactoryProvider;

    public DefaultTalabatPerseusRepository_Factory(Provider<Context> provider, Provider<AppVersionProvider> provider2, Provider<CoroutineDispatchersFactory> provider3) {
        this.contextProvider = provider;
        this.appVersionProvider = provider2;
        this.dispatchersFactoryProvider = provider3;
    }

    public static DefaultTalabatPerseusRepository_Factory create(Provider<Context> provider, Provider<AppVersionProvider> provider2, Provider<CoroutineDispatchersFactory> provider3) {
        return new DefaultTalabatPerseusRepository_Factory(provider, provider2, provider3);
    }

    public static DefaultTalabatPerseusRepository newInstance(Context context, AppVersionProvider appVersionProvider2, CoroutineDispatchersFactory coroutineDispatchersFactory) {
        return new DefaultTalabatPerseusRepository(context, appVersionProvider2, coroutineDispatchersFactory);
    }

    public DefaultTalabatPerseusRepository get() {
        return newInstance(this.contextProvider.get(), this.appVersionProvider.get(), this.dispatchersFactoryProvider.get());
    }
}
