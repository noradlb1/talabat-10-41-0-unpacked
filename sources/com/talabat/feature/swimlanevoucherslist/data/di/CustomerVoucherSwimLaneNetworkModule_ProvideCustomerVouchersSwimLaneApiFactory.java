package com.talabat.feature.swimlanevoucherslist.data.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.swimlanevoucherslist.data.datasource.remote.VouchersBaseUrl;
import com.talabat.feature.swimlanevoucherslist.data.datasource.remote.VouchersSwimLaneApi;
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
public final class CustomerVoucherSwimLaneNetworkModule_ProvideCustomerVouchersSwimLaneApiFactory implements Factory<VouchersSwimLaneApi> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;
    private final Provider<VouchersBaseUrl> vouchersBaseUrlProvider;

    public CustomerVoucherSwimLaneNetworkModule_ProvideCustomerVouchersSwimLaneApiFactory(Provider<BaseUrlFactory> provider, Provider<VouchersBaseUrl> provider2, Provider<Retrofit.Builder> provider3) {
        this.baseUrlFactoryProvider = provider;
        this.vouchersBaseUrlProvider = provider2;
        this.retrofitBuilderProvider = provider3;
    }

    public static CustomerVoucherSwimLaneNetworkModule_ProvideCustomerVouchersSwimLaneApiFactory create(Provider<BaseUrlFactory> provider, Provider<VouchersBaseUrl> provider2, Provider<Retrofit.Builder> provider3) {
        return new CustomerVoucherSwimLaneNetworkModule_ProvideCustomerVouchersSwimLaneApiFactory(provider, provider2, provider3);
    }

    public static VouchersSwimLaneApi provideCustomerVouchersSwimLaneApi(BaseUrlFactory baseUrlFactory, VouchersBaseUrl vouchersBaseUrl, Retrofit.Builder builder) {
        return (VouchersSwimLaneApi) Preconditions.checkNotNullFromProvides(CustomerVoucherSwimLaneNetworkModule.INSTANCE.provideCustomerVouchersSwimLaneApi(baseUrlFactory, vouchersBaseUrl, builder));
    }

    public VouchersSwimLaneApi get() {
        return provideCustomerVouchersSwimLaneApi(this.baseUrlFactoryProvider.get(), this.vouchersBaseUrlProvider.get(), this.retrofitBuilderProvider.get());
    }
}
