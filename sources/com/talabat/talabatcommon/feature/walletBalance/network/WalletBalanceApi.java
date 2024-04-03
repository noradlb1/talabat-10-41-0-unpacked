package com.talabat.talabatcommon.feature.walletBalance.network;

import com.talabat.talabatcommon.feature.walletBalance.model.response.WalletCreditBalanceResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletBalance/network/WalletBalanceApi;", "", "getWalletBalance", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/walletBalance/model/response/WalletCreditBalanceResponse;", "countryId", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletBalanceApi {
    @NotNull
    @GET("/api/v1/wallet/balance/{countryId}")
    Call<WalletCreditBalanceResponse> getWalletBalance(@NotNull @Path("countryId") String str);
}
