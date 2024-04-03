package com.talabat.splash.presentation.infrastructure.thirdparty;

import android.content.Context;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.splash.domain.model.AppInfoGlobalCountryWrapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ThirdPartyLibraryInfrastructureImpl_Factory implements Factory<ThirdPartyLibraryInfrastructureImpl> {
    private final Provider<AppInfoGlobalCountryWrapper> appInfoGlobalCountryWrapperProvider;
    private final Provider<Context> contextProvider;
    private final Provider<CoroutineDispatchersFactory> dispatchersFactoryProvider;

    public ThirdPartyLibraryInfrastructureImpl_Factory(Provider<Context> provider, Provider<AppInfoGlobalCountryWrapper> provider2, Provider<CoroutineDispatchersFactory> provider3) {
        this.contextProvider = provider;
        this.appInfoGlobalCountryWrapperProvider = provider2;
        this.dispatchersFactoryProvider = provider3;
    }

    public static ThirdPartyLibraryInfrastructureImpl_Factory create(Provider<Context> provider, Provider<AppInfoGlobalCountryWrapper> provider2, Provider<CoroutineDispatchersFactory> provider3) {
        return new ThirdPartyLibraryInfrastructureImpl_Factory(provider, provider2, provider3);
    }

    public static ThirdPartyLibraryInfrastructureImpl newInstance(Context context, AppInfoGlobalCountryWrapper appInfoGlobalCountryWrapper, CoroutineDispatchersFactory coroutineDispatchersFactory) {
        return new ThirdPartyLibraryInfrastructureImpl(context, appInfoGlobalCountryWrapper, coroutineDispatchersFactory);
    }

    public ThirdPartyLibraryInfrastructureImpl get() {
        return newInstance(this.contextProvider.get(), this.appInfoGlobalCountryWrapperProvider.get(), this.dispatchersFactoryProvider.get());
    }
}
