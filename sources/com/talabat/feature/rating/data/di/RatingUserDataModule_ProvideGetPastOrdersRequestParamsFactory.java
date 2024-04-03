package com.talabat.feature.rating.data.di;

import com.talabat.feature.rating.domain.model.GetPastOrdersRequestParamsProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class RatingUserDataModule_ProvideGetPastOrdersRequestParamsFactory implements Factory<GetPastOrdersRequestParamsProvider> {
    private final Provider<Integer> countryIdProvider;

    public RatingUserDataModule_ProvideGetPastOrdersRequestParamsFactory(Provider<Integer> provider) {
        this.countryIdProvider = provider;
    }

    public static RatingUserDataModule_ProvideGetPastOrdersRequestParamsFactory create(Provider<Integer> provider) {
        return new RatingUserDataModule_ProvideGetPastOrdersRequestParamsFactory(provider);
    }

    public static GetPastOrdersRequestParamsProvider provideGetPastOrdersRequestParams(int i11) {
        return (GetPastOrdersRequestParamsProvider) Preconditions.checkNotNullFromProvides(RatingUserDataModule.INSTANCE.provideGetPastOrdersRequestParams(i11));
    }

    public GetPastOrdersRequestParamsProvider get() {
        return provideGetPastOrdersRequestParams(this.countryIdProvider.get().intValue());
    }
}
