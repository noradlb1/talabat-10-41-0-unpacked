package com.talabat.wallet.features.refund.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.wallet.features.UrlConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/wallet/features/refund/network/WalletRefundToBankRetrofitBuilder;", "", "()V", "getWalletRefundToBankApi", "Lcom/talabat/wallet/features/refund/network/WalletRefundToBankApi;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletRefundToBankRetrofitBuilder {
    @NotNull
    public static final WalletRefundToBankRetrofitBuilder INSTANCE = new WalletRefundToBankRetrofitBuilder();

    private WalletRefundToBankRetrofitBuilder() {
    }

    @NotNull
    public final WalletRefundToBankApi getWalletRefundToBankApi() {
        return (WalletRefundToBankApi) new TalabatAPIBuilder().createApi(UrlConstants.Companion.getBaseUrl(), WalletRefundToBankApi.class);
    }
}
