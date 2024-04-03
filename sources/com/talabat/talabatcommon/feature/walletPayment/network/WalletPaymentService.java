package com.talabat.talabatcommon.feature.walletPayment.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletDebitRequestModel;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletTopUpRequestModel;
import com.talabat.talabatcommon.feature.walletPayment.model.response.VerifyWalletTransactionResponse;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletPaymentResponse;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletTopUpSuggestionsAndLimitsResponse;
import com.talabat.talabatcommon.feature.walletPayment.network.WalletPaymentApi;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPayment/network/WalletPaymentService;", "Lcom/talabat/talabatcommon/feature/walletPayment/network/WalletPaymentApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "walletPaymentApi", "getWalletPaymentApi", "()Lcom/talabat/talabatcommon/feature/walletPayment/network/WalletPaymentApi;", "walletPaymentApi$delegate", "Lkotlin/Lazy;", "debitWallet", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletPaymentResponse;", "walletDebitRequestModel", "Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletDebitRequestModel;", "getVerifyWalletTransaction", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/VerifyWalletTransactionResponse;", "transactionId", "", "getWalletTopUpSuggestionAmount", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletTopUpSuggestionsAndLimitsResponse;", "countryId", "", "version", "topUpWallet", "walletTopUpRequestModel", "Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletTopUpRequestModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentService implements WalletPaymentApi {
    @NotNull
    private final Lazy walletPaymentApi$delegate;

    public WalletPaymentService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.walletPaymentApi$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new WalletPaymentService$walletPaymentApi$2(talabatAPIBuilder));
    }

    private final WalletPaymentApi getWalletPaymentApi() {
        return (WalletPaymentApi) this.walletPaymentApi$delegate.getValue();
    }

    @NotNull
    public Call<WalletPaymentResponse> debitWallet(@NotNull WalletDebitRequestModel walletDebitRequestModel) {
        Intrinsics.checkNotNullParameter(walletDebitRequestModel, "walletDebitRequestModel");
        return getWalletPaymentApi().debitWallet(walletDebitRequestModel);
    }

    @NotNull
    public Call<VerifyWalletTransactionResponse> getVerifyWalletTransaction(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "transactionId");
        return getWalletPaymentApi().getVerifyWalletTransaction(str);
    }

    @NotNull
    public Call<WalletTopUpSuggestionsAndLimitsResponse> getWalletTopUpSuggestionAmount(int i11, int i12) {
        return WalletPaymentApi.DefaultImpls.getWalletTopUpSuggestionAmount$default(getWalletPaymentApi(), i11, 0, 2, (Object) null);
    }

    @NotNull
    public Call<WalletPaymentResponse> topUpWallet(@NotNull WalletTopUpRequestModel walletTopUpRequestModel) {
        Intrinsics.checkNotNullParameter(walletTopUpRequestModel, "walletTopUpRequestModel");
        return getWalletPaymentApi().topUpWallet(walletTopUpRequestModel);
    }
}
