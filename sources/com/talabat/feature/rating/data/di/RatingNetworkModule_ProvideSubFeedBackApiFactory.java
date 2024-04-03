package com.talabat.feature.rating.data.di;

import com.talabat.feature.rating.data.remote.SubFeedBackApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class RatingNetworkModule_ProvideSubFeedBackApiFactory implements Factory<SubFeedBackApi> {
    private final Provider<String> baseUrlProvider;

    public RatingNetworkModule_ProvideSubFeedBackApiFactory(Provider<String> provider) {
        this.baseUrlProvider = provider;
    }

    public static RatingNetworkModule_ProvideSubFeedBackApiFactory create(Provider<String> provider) {
        return new RatingNetworkModule_ProvideSubFeedBackApiFactory(provider);
    }

    public static SubFeedBackApi provideSubFeedBackApi(String str) {
        return (SubFeedBackApi) Preconditions.checkNotNullFromProvides(RatingNetworkModule.INSTANCE.provideSubFeedBackApi(str));
    }

    public SubFeedBackApi get() {
        return provideSubFeedBackApi(this.baseUrlProvider.get());
    }
}
