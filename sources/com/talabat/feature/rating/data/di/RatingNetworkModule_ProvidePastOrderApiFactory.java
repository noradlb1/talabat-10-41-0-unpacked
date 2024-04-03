package com.talabat.feature.rating.data.di;

import com.talabat.feature.rating.data.remote.GetPastOrderApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class RatingNetworkModule_ProvidePastOrderApiFactory implements Factory<GetPastOrderApi> {
    private final Provider<String> baseUrlProvider;

    public RatingNetworkModule_ProvidePastOrderApiFactory(Provider<String> provider) {
        this.baseUrlProvider = provider;
    }

    public static RatingNetworkModule_ProvidePastOrderApiFactory create(Provider<String> provider) {
        return new RatingNetworkModule_ProvidePastOrderApiFactory(provider);
    }

    public static GetPastOrderApi providePastOrderApi(String str) {
        return (GetPastOrderApi) Preconditions.checkNotNullFromProvides(RatingNetworkModule.INSTANCE.providePastOrderApi(str));
    }

    public GetPastOrderApi get() {
        return providePastOrderApi(this.baseUrlProvider.get());
    }
}
