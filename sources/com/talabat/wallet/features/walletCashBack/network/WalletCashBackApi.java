package com.talabat.wallet.features.walletCashBack.network;

import com.talabat.wallet.features.walletCashBack.model.request.WalletCalculateCashBackRequestModel;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCalculateCashBackResponse;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignOfferResponse;
import com.talabat.wallet.features.walletCashBack.model.response.WalletCashBackCampaignResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u0006H'J,\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u0006H'J\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\t\u001a\u00020\u0006H'¨\u0006\u0011"}, d2 = {"Lcom/talabat/wallet/features/walletCashBack/network/WalletCashBackApi;", "", "getCashBackCampaignOffer", "Lretrofit2/Call;", "Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCashBackCampaignOfferResponse;", "countryId", "", "binNumber", "", "countryQueryId", "getCashBackCampaigns", "Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCashBackCampaignResponse;", "eventId", "getEstimatedCashBack", "Lcom/talabat/wallet/features/walletCashBack/model/response/WalletCalculateCashBackResponse;", "requestModel", "Lcom/talabat/wallet/features/walletCashBack/model/request/WalletCalculateCashBackRequestModel;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletCashBackApi {
    @NotNull
    @GET("/api/Cashback/campaignOffer/{countryId}/{binNumber}")
    Call<WalletCashBackCampaignOfferResponse> getCashBackCampaignOffer(@Path("countryId") int i11, @NotNull @Path("binNumber") String str, @Query("country_id") int i12);

    @NotNull
    @GET("/api/Cashback/campaigns/{countryId}/{eventId}")
    Call<WalletCashBackCampaignResponse> getCashBackCampaigns(@Path("countryId") int i11, @Path("eventId") int i12, @Query("country_id") int i13);

    @NotNull
    @POST("/api/Cashback/CalculateEstimatedCashback")
    Call<WalletCalculateCashBackResponse> getEstimatedCashBack(@NotNull @Body WalletCalculateCashBackRequestModel walletCalculateCashBackRequestModel, @Query("country_id") int i11);
}
