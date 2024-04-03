package com.talabat.feature.incentiveautoapplydiscounts.data.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote.IncentiveAutoApplyDiscountsApi;
import com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote.LoyaltyBaseUrl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.core.network.domain.MoshiRetrofit"})
public final class IncentiveAutoApplyDiscountsNetworkModule_ProvideIncentiveAutoApplyDiscountsApiFactory implements Factory<IncentiveAutoApplyDiscountsApi> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<LoyaltyBaseUrl> loyaltyBaseUrlProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;

    public IncentiveAutoApplyDiscountsNetworkModule_ProvideIncentiveAutoApplyDiscountsApiFactory(Provider<BaseUrlFactory> provider, Provider<LoyaltyBaseUrl> provider2, Provider<Retrofit.Builder> provider3) {
        this.baseUrlFactoryProvider = provider;
        this.loyaltyBaseUrlProvider = provider2;
        this.retrofitBuilderProvider = provider3;
    }

    public static IncentiveAutoApplyDiscountsNetworkModule_ProvideIncentiveAutoApplyDiscountsApiFactory create(Provider<BaseUrlFactory> provider, Provider<LoyaltyBaseUrl> provider2, Provider<Retrofit.Builder> provider3) {
        return new IncentiveAutoApplyDiscountsNetworkModule_ProvideIncentiveAutoApplyDiscountsApiFactory(provider, provider2, provider3);
    }

    public static IncentiveAutoApplyDiscountsApi provideIncentiveAutoApplyDiscountsApi(BaseUrlFactory baseUrlFactory, LoyaltyBaseUrl loyaltyBaseUrl, Retrofit.Builder builder) {
        return (IncentiveAutoApplyDiscountsApi) Preconditions.checkNotNullFromProvides(IncentiveAutoApplyDiscountsNetworkModule.INSTANCE.provideIncentiveAutoApplyDiscountsApi(baseUrlFactory, loyaltyBaseUrl, builder));
    }

    public IncentiveAutoApplyDiscountsApi get() {
        return provideIncentiveAutoApplyDiscountsApi(this.baseUrlFactoryProvider.get(), this.loyaltyBaseUrlProvider.get(), this.retrofitBuilderProvider.get());
    }
}
