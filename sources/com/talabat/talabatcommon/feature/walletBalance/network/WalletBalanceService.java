package com.talabat.talabatcommon.feature.walletBalance.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatcommon.feature.walletBalance.model.response.WalletCreditBalanceResponse;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletBalance/network/WalletBalanceService;", "Lcom/talabat/talabatcommon/feature/walletBalance/network/WalletBalanceApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "walletBalanceApi", "getWalletBalanceApi", "()Lcom/talabat/talabatcommon/feature/walletBalance/network/WalletBalanceApi;", "walletBalanceApi$delegate", "Lkotlin/Lazy;", "getWalletBalance", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/walletBalance/model/response/WalletCreditBalanceResponse;", "countryId", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletBalanceService implements WalletBalanceApi {
    @NotNull
    private final Lazy walletBalanceApi$delegate;

    public WalletBalanceService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.walletBalanceApi$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new WalletBalanceService$walletBalanceApi$2(talabatAPIBuilder));
    }

    private final WalletBalanceApi getWalletBalanceApi() {
        return (WalletBalanceApi) this.walletBalanceApi$delegate.getValue();
    }

    @NotNull
    public Call<WalletCreditBalanceResponse> getWalletBalance(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "countryId");
        return getWalletBalanceApi().getWalletBalance(str);
    }
}
