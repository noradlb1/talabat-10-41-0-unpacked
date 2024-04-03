package com.talabat.talabatcommon.views.wallet.walletCardManagement.view.di;

import com.talabat.core.network.domain.MoshiRetrofit;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.talabatcommon.feature.walletCardManagement.network.WalletCardManagementApi;
import com.talabat.talabatcommon.feature.walletCardManagement.network.WalletCardManagementBaseUrl;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/di/AddCardCustomViewModule;", "", "()V", "provideWalletCardManagementApi", "Lcom/talabat/talabatcommon/feature/walletCardManagement/network/WalletCardManagementApi;", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "walletCardManagementBaseUrl", "Lcom/talabat/talabatcommon/feature/walletCardManagement/network/WalletCardManagementBaseUrl;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class AddCardCustomViewModule {
    @NotNull
    public static final AddCardCustomViewModule INSTANCE = new AddCardCustomViewModule();

    private AddCardCustomViewModule() {
    }

    @NotNull
    @Reusable
    @Provides
    public final WalletCardManagementApi provideWalletCardManagementApi(@NotNull @MoshiRetrofit Retrofit.Builder builder, @NotNull BaseUrlFactory baseUrlFactory, @NotNull WalletCardManagementBaseUrl walletCardManagementBaseUrl) {
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Intrinsics.checkNotNullParameter(baseUrlFactory, "baseUrlFactory");
        Intrinsics.checkNotNullParameter(walletCardManagementBaseUrl, "walletCardManagementBaseUrl");
        Retrofit build = builder.baseUrl(baseUrlFactory.baseUrl(walletCardManagementBaseUrl)).build();
        Intrinsics.checkNotNullExpressionValue(build, "retrofitBuilder.baseUrl(…aseUrl)\n        ).build()");
        return (WalletCardManagementApi) build.create(WalletCardManagementApi.class);
    }
}
