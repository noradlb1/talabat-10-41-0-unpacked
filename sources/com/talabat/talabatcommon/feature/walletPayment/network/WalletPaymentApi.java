package com.talabat.talabatcommon.feature.walletPayment.network;

import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletDebitRequestModel;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletTopUpRequestModel;
import com.talabat.talabatcommon.feature.walletPayment.model.response.VerifyWalletTransactionResponse;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletPaymentResponse;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletTopUpSuggestionsAndLimitsResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\t\u001a\u00020\nH'J\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0003\u0010\u000f\u001a\u00020\u000eH'J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u0012H'¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPayment/network/WalletPaymentApi;", "", "debitWallet", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletPaymentResponse;", "walletDebitRequestModel", "Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletDebitRequestModel;", "getVerifyWalletTransaction", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/VerifyWalletTransactionResponse;", "transactionId", "", "getWalletTopUpSuggestionAmount", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletTopUpSuggestionsAndLimitsResponse;", "countryId", "", "version", "topUpWallet", "walletTopUpRequestModel", "Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletTopUpRequestModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletPaymentApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Call getWalletTopUpSuggestionAmount$default(WalletPaymentApi walletPaymentApi, int i11, int i12, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 2) != 0) {
                    i12 = 1;
                }
                return walletPaymentApi.getWalletTopUpSuggestionAmount(i11, i12);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWalletTopUpSuggestionAmount");
        }
    }

    @NotNull
    @POST("/api/v2/wallet/debit")
    Call<WalletPaymentResponse> debitWallet(@NotNull @Body WalletDebitRequestModel walletDebitRequestModel);

    @NotNull
    @GET("/api/v1/wallet/verify-transaction/{transactionId}")
    Call<VerifyWalletTransactionResponse> getVerifyWalletTransaction(@NotNull @Path("transactionId") String str);

    @NotNull
    @GET("/api/v{version}/wallet/topupSuggestions/{countryId}")
    Call<WalletTopUpSuggestionsAndLimitsResponse> getWalletTopUpSuggestionAmount(@Path("countryId") int i11, @Path("version") int i12);

    @NotNull
    @POST("/api/v2/wallet/topUp")
    Call<WalletPaymentResponse> topUpWallet(@NotNull @Body WalletTopUpRequestModel walletTopUpRequestModel);
}
