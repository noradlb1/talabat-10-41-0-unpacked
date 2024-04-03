package com.talabat.feature.rating.data.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.rating.data.remote.RatingFeedBackBaseUrl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class RatingNetworkModule_ProvideBaseUrlForFeedbackFactory implements Factory<String> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<RatingFeedBackBaseUrl> ratingFeedBackBaseUrlProvider;

    public RatingNetworkModule_ProvideBaseUrlForFeedbackFactory(Provider<BaseUrlFactory> provider, Provider<RatingFeedBackBaseUrl> provider2) {
        this.baseUrlFactoryProvider = provider;
        this.ratingFeedBackBaseUrlProvider = provider2;
    }

    public static RatingNetworkModule_ProvideBaseUrlForFeedbackFactory create(Provider<BaseUrlFactory> provider, Provider<RatingFeedBackBaseUrl> provider2) {
        return new RatingNetworkModule_ProvideBaseUrlForFeedbackFactory(provider, provider2);
    }

    public static String provideBaseUrlForFeedback(BaseUrlFactory baseUrlFactory, RatingFeedBackBaseUrl ratingFeedBackBaseUrl) {
        return (String) Preconditions.checkNotNullFromProvides(RatingNetworkModule.INSTANCE.provideBaseUrlForFeedback(baseUrlFactory, ratingFeedBackBaseUrl));
    }

    public String get() {
        return provideBaseUrlForFeedback(this.baseUrlFactoryProvider.get(), this.ratingFeedBackBaseUrlProvider.get());
    }
}
