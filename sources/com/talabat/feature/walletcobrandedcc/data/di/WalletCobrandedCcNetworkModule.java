package com.talabat.feature.walletcobrandedcc.data.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.feature.walletcobrandedcc.data.remote.WalletCobrandedCcApi;
import com.talabat.feature.walletcobrandedcc.data.remote.WalletCobrandedCcBaseUrl;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/feature/walletcobrandedcc/data/di/WalletCobrandedCcNetworkModule;", "", "()V", "BASE_URL", "", "provideBaseUrl", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "walletCobrandedCcBaseUrl", "Lcom/talabat/feature/walletcobrandedcc/data/remote/WalletCobrandedCcBaseUrl;", "provideWalletCobrandedCcApi", "Lcom/talabat/feature/walletcobrandedcc/data/remote/WalletCobrandedCcApi;", "baseUrl", "com_talabat_feature_wallet-cobranded-cc_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class WalletCobrandedCcNetworkModule {
    @NotNull
    private static final String BASE_URL = "baseUrl";
    @NotNull
    public static final WalletCobrandedCcNetworkModule INSTANCE = new WalletCobrandedCcNetworkModule();

    private WalletCobrandedCcNetworkModule() {
    }

    @NotNull
    @Provides
    @Named("baseUrl")
    public final String provideBaseUrl(@NotNull BaseUrlFactory baseUrlFactory, @NotNull WalletCobrandedCcBaseUrl walletCobrandedCcBaseUrl) {
        Intrinsics.checkNotNullParameter(baseUrlFactory, "baseUrlFactory");
        Intrinsics.checkNotNullParameter(walletCobrandedCcBaseUrl, "walletCobrandedCcBaseUrl");
        return baseUrlFactory.baseUrl(walletCobrandedCcBaseUrl);
    }

    @NotNull
    @Provides
    public final WalletCobrandedCcApi provideWalletCobrandedCcApi(@NotNull @Named("baseUrl") String str) {
        Intrinsics.checkNotNullParameter(str, BASE_URL);
        return (WalletCobrandedCcApi) new TalabatAPIBuilder().createApi(str, WalletCobrandedCcApi.class);
    }
}
