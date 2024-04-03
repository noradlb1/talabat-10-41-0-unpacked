package com.talabat.feature.rating.data.di;

import com.talabat.feature.rating.data.remote.GetPastOrderApi;
import com.talabat.feature.rating.data.remote.GetPastOrdersService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RatingNetworkModule_ProvideGetPastOrderServiceFactory implements Factory<GetPastOrdersService> {
    private final Provider<GetPastOrderApi> getPastOrderApiProvider;

    public RatingNetworkModule_ProvideGetPastOrderServiceFactory(Provider<GetPastOrderApi> provider) {
        this.getPastOrderApiProvider = provider;
    }

    public static RatingNetworkModule_ProvideGetPastOrderServiceFactory create(Provider<GetPastOrderApi> provider) {
        return new RatingNetworkModule_ProvideGetPastOrderServiceFactory(provider);
    }

    public static GetPastOrdersService provideGetPastOrderService(GetPastOrderApi getPastOrderApi) {
        return (GetPastOrdersService) Preconditions.checkNotNullFromProvides(RatingNetworkModule.INSTANCE.provideGetPastOrderService(getPastOrderApi));
    }

    public GetPastOrdersService get() {
        return provideGetPastOrderService(this.getPastOrderApiProvider.get());
    }
}
