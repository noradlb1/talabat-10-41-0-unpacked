package com.talabat.talabatcommon.feature.walletCardList.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatcommon.feature.walletCardList.model.response.WalletCreditCardGetListResponse;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardList/network/WalletCardListService;", "Lcom/talabat/talabatcommon/feature/walletCardList/network/WalletCardListApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "walletCardListApi", "getWalletCardListApi", "()Lcom/talabat/talabatcommon/feature/walletCardList/network/WalletCardListApi;", "walletCardListApi$delegate", "Lkotlin/Lazy;", "getWalletCardList", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/walletCardList/model/response/WalletCreditCardGetListResponse;", "paymentProvider", "", "countryId", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCardListService implements WalletCardListApi {
    @NotNull
    private final Lazy walletCardListApi$delegate;

    public WalletCardListService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.walletCardListApi$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new WalletCardListService$walletCardListApi$2(talabatAPIBuilder));
    }

    private final WalletCardListApi getWalletCardListApi() {
        return (WalletCardListApi) this.walletCardListApi$delegate.getValue();
    }

    @NotNull
    public Call<WalletCreditCardGetListResponse> getWalletCardList(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "paymentProvider");
        Intrinsics.checkNotNullParameter(str2, "countryId");
        return getWalletCardListApi().getWalletCardList(str, str2);
    }
}
