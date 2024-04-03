package com.talabat.feature.rating.data;

import com.talabat.feature.rating.data.remote.GetPastOrdersService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetPastOrdersRepositoryImpl_Factory implements Factory<GetPastOrdersRepositoryImpl> {
    private final Provider<GetPastOrdersService> getPastOrdersServiceProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;

    public GetPastOrdersRepositoryImpl_Factory(Provider<GetPastOrdersService> provider, Provider<CoroutineDispatcher> provider2) {
        this.getPastOrdersServiceProvider = provider;
        this.ioDispatcherProvider = provider2;
    }

    public static GetPastOrdersRepositoryImpl_Factory create(Provider<GetPastOrdersService> provider, Provider<CoroutineDispatcher> provider2) {
        return new GetPastOrdersRepositoryImpl_Factory(provider, provider2);
    }

    public static GetPastOrdersRepositoryImpl newInstance(GetPastOrdersService getPastOrdersService, CoroutineDispatcher coroutineDispatcher) {
        return new GetPastOrdersRepositoryImpl(getPastOrdersService, coroutineDispatcher);
    }

    public GetPastOrdersRepositoryImpl get() {
        return newInstance(this.getPastOrdersServiceProvider.get(), this.ioDispatcherProvider.get());
    }
}
