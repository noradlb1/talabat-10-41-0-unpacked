package com.talabat.talabatcommon.views.wallet.walletCardManagement.view.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.talabatcommon.feature.walletCardManagement.network.WalletCardManagementApi;
import com.talabat.talabatcommon.feature.walletCardManagement.network.WalletCardManagementBaseUrl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.core.network.domain.MoshiRetrofit"})
public final class AddCardCustomViewModule_ProvideWalletCardManagementApiFactory implements Factory<WalletCardManagementApi> {
    private final Provider<BaseUrlFactory> baseUrlFactoryProvider;
    private final Provider<Retrofit.Builder> retrofitBuilderProvider;
    private final Provider<WalletCardManagementBaseUrl> walletCardManagementBaseUrlProvider;

    public AddCardCustomViewModule_ProvideWalletCardManagementApiFactory(Provider<Retrofit.Builder> provider, Provider<BaseUrlFactory> provider2, Provider<WalletCardManagementBaseUrl> provider3) {
        this.retrofitBuilderProvider = provider;
        this.baseUrlFactoryProvider = provider2;
        this.walletCardManagementBaseUrlProvider = provider3;
    }

    public static AddCardCustomViewModule_ProvideWalletCardManagementApiFactory create(Provider<Retrofit.Builder> provider, Provider<BaseUrlFactory> provider2, Provider<WalletCardManagementBaseUrl> provider3) {
        return new AddCardCustomViewModule_ProvideWalletCardManagementApiFactory(provider, provider2, provider3);
    }

    public static WalletCardManagementApi provideWalletCardManagementApi(Retrofit.Builder builder, BaseUrlFactory baseUrlFactory, WalletCardManagementBaseUrl walletCardManagementBaseUrl) {
        return (WalletCardManagementApi) Preconditions.checkNotNullFromProvides(AddCardCustomViewModule.INSTANCE.provideWalletCardManagementApi(builder, baseUrlFactory, walletCardManagementBaseUrl));
    }

    public WalletCardManagementApi get() {
        return provideWalletCardManagementApi(this.retrofitBuilderProvider.get(), this.baseUrlFactoryProvider.get(), this.walletCardManagementBaseUrlProvider.get());
    }
}
