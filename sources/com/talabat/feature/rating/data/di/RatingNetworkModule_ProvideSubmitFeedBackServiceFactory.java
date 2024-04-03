package com.talabat.feature.rating.data.di;

import com.talabat.feature.rating.data.remote.SubFeedBackApi;
import com.talabat.feature.rating.data.remote.SubmitFeedBackService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RatingNetworkModule_ProvideSubmitFeedBackServiceFactory implements Factory<SubmitFeedBackService> {
    private final Provider<SubFeedBackApi> subFeedBackApiProvider;

    public RatingNetworkModule_ProvideSubmitFeedBackServiceFactory(Provider<SubFeedBackApi> provider) {
        this.subFeedBackApiProvider = provider;
    }

    public static RatingNetworkModule_ProvideSubmitFeedBackServiceFactory create(Provider<SubFeedBackApi> provider) {
        return new RatingNetworkModule_ProvideSubmitFeedBackServiceFactory(provider);
    }

    public static SubmitFeedBackService provideSubmitFeedBackService(SubFeedBackApi subFeedBackApi) {
        return (SubmitFeedBackService) Preconditions.checkNotNullFromProvides(RatingNetworkModule.INSTANCE.provideSubmitFeedBackService(subFeedBackApi));
    }

    public SubmitFeedBackService get() {
        return provideSubmitFeedBackService(this.subFeedBackApiProvider.get());
    }
}
