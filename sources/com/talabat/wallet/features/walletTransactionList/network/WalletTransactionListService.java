package com.talabat.wallet.features.walletTransactionList.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.wallet.features.walletTransactionList.model.response.WalletTransactionListResponse;
import com.talabat.wallet.features.walletTransactionList.network.WalletTransactionListApi;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/wallet/features/walletTransactionList/network/WalletTransactionListService;", "Lcom/talabat/wallet/features/walletTransactionList/network/WalletTransactionListApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "walletTransactionListApi", "getWalletTransactionListApi", "()Lcom/talabat/wallet/features/walletTransactionList/network/WalletTransactionListApi;", "walletTransactionListApi$delegate", "Lkotlin/Lazy;", "getWalletTransactionList", "Lretrofit2/Call;", "Lcom/talabat/wallet/features/walletTransactionList/model/response/WalletTransactionListResponse;", "countryId", "", "version", "take", "skip", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionListService implements WalletTransactionListApi {
    @NotNull
    private final Lazy walletTransactionListApi$delegate;

    public WalletTransactionListService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.walletTransactionListApi$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new WalletTransactionListService$walletTransactionListApi$2(talabatAPIBuilder));
    }

    private final WalletTransactionListApi getWalletTransactionListApi() {
        return (WalletTransactionListApi) this.walletTransactionListApi$delegate.getValue();
    }

    @NotNull
    public Call<WalletTransactionListResponse> getWalletTransactionList(int i11, int i12, int i13, int i14) {
        return WalletTransactionListApi.DefaultImpls.getWalletTransactionList$default(getWalletTransactionListApi(), i11, 0, i13, i14, 2, (Object) null);
    }
}
