package com.talabat.talabatcommon.feature.walletCardList.network;

import com.talabat.talabatcommon.feature.walletCardList.model.response.WalletCreditCardGetListResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H'¨\u0006\b"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardList/network/WalletCardListApi;", "", "getWalletCardList", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/walletCardList/model/response/WalletCreditCardGetListResponse;", "paymentProvider", "", "countryId", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletCardListApi {
    @NotNull
    @GET("v1/customer/tokens/{paymentProvider}/{countryCode}")
    Call<WalletCreditCardGetListResponse> getWalletCardList(@NotNull @Path("paymentProvider") String str, @NotNull @Path("countryCode") String str2);
}
