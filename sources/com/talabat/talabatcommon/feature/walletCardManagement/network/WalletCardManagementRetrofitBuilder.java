package com.talabat.talabatcommon.feature.walletCardManagement.network;

import com.talabat.core.network.endpoint.MonolithEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.helpers.BASEURLS;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardManagement/network/WalletCardManagementRetrofitBuilder;", "", "()V", "getWalletCardAddCardAPIBuilder", "Lcom/talabat/talabatcommon/feature/walletCardManagement/network/WalletCardManagementApi;", "getWalletCardManagementAPIBuilder", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCardManagementRetrofitBuilder {
    @NotNull
    public static final WalletCardManagementRetrofitBuilder INSTANCE = new WalletCardManagementRetrofitBuilder();

    private WalletCardManagementRetrofitBuilder() {
    }

    @NotNull
    public final WalletCardManagementApi getWalletCardAddCardAPIBuilder() {
        TalabatAPIBuilder talabatAPIBuilder = new TalabatAPIBuilder();
        String buildSf = BASEURLS.buildSf("release");
        Intrinsics.checkNotNullExpressionValue(buildSf, "buildSf(BuildConfig.BUILD_TYPE)");
        return (WalletCardManagementApi) talabatAPIBuilder.createApi(buildSf, WalletCardManagementApi.class);
    }

    @NotNull
    public final WalletCardManagementApi getWalletCardManagementAPIBuilder() {
        return (WalletCardManagementApi) new TalabatAPIBuilder().createApi(MonolithEndPointProvider.INSTANCE.getBaseUrl(), WalletCardManagementApi.class);
    }
}
