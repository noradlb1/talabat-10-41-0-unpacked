package com.talabat.wallet.network;

import JsonModels.OrderDetailsRM;
import JsonModels.Request.WalletCalculateCashBackRequest;
import JsonModels.Request.WalletCardTokenRequest;
import JsonModels.Request.WalletDeleteCreditCardRequest;
import JsonModels.Request.WalletSetDefaultCreditCardRequest;
import JsonModels.Request.WalletTopUpRequest;
import JsonModels.Response.WalletCalculateCashBackResponse;
import JsonModels.Response.WalletCashbackCampaignOfferMessageResponse;
import JsonModels.Response.WalletCashbackCampaignResponse;
import JsonModels.Response.WalletCreditBalanceResponse;
import JsonModels.Response.WalletCreditCardGetListResponse;
import JsonModels.Response.WalletCreditTransactionDetailResponse;
import JsonModels.Response.WalletDeleteCreditCardsResponse;
import JsonModels.Response.WalletSaveCreditCardResponse;
import JsonModels.Response.WalletSetDefaultCreditCardResponse;
import JsonModels.Response.WalletTopUpAmountSuggestionResponse;
import JsonModels.Response.WalletTopUpResponse;
import JsonModels.Response.WalletTransactionListResponse;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\nH'J\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u000eH'J,\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u0013\u001a\u00020\u0014H'J\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0017\u001a\u00020\u0018H'J\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0013\u001a\u00020\u0014H'J$\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0013\u001a\u00020\u0014H'J\u0018\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\"\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010)\u001a\u00020*H'¨\u0006+"}, d2 = {"Lcom/talabat/wallet/network/WalletApiService;", "", "fetchAllWalletCreditCards", "Lio/reactivex/Observable;", "LJsonModels/Response/WalletCreditCardGetListResponse;", "url", "", "fetchResponseOfDeleteRequest", "LJsonModels/Response/WalletDeleteCreditCardsResponse;", "walletDeleteCreditCardRequest", "LJsonModels/Request/WalletDeleteCreditCardRequest;", "fetchSetDefaultCreditCard", "LJsonModels/Response/WalletSetDefaultCreditCardResponse;", "walletSetDefaultCreditCardRequest", "LJsonModels/Request/WalletSetDefaultCreditCardRequest;", "fetchWalletCalculateCashBack", "LJsonModels/Response/WalletCalculateCashBackResponse;", "walletCalculateCashBackRequest", "LJsonModels/Request/WalletCalculateCashBackRequest;", "countryQueryId", "", "fetchWalletTopUp", "LJsonModels/Response/WalletTopUpResponse;", "walletTopUpRequest", "LJsonModels/Request/WalletTopUpRequest;", "fetchWalletTopUpAmountSuggestion", "LJsonModels/Response/WalletTopUpAmountSuggestionResponse;", "getCashBackCampaigns", "LJsonModels/Response/WalletCashbackCampaignResponse;", "getCashBackCampaignsForCard", "LJsonModels/Response/WalletCashbackCampaignOfferMessageResponse;", "getOrderDetail", "LJsonModels/OrderDetailsRM;", "getWalletCreditBalance", "LJsonModels/Response/WalletCreditBalanceResponse;", "getWalletTransactionDetail", "LJsonModels/Response/WalletCreditTransactionDetailResponse;", "getWalletTransactionList", "LJsonModels/Response/WalletTransactionListResponse;", "saveCreditCard", "LJsonModels/Response/WalletSaveCreditCardResponse;", "walletCardTokenRequest", "LJsonModels/Request/WalletCardTokenRequest;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletApiService {
    @NotNull
    @GET
    Observable<WalletCreditCardGetListResponse> fetchAllWalletCreditCards(@NotNull @Url String str);

    @NotNull
    @POST
    Observable<WalletDeleteCreditCardsResponse> fetchResponseOfDeleteRequest(@NotNull @Url String str, @NotNull @Body WalletDeleteCreditCardRequest walletDeleteCreditCardRequest);

    @NotNull
    @POST
    Observable<WalletSetDefaultCreditCardResponse> fetchSetDefaultCreditCard(@NotNull @Url String str, @NotNull @Body WalletSetDefaultCreditCardRequest walletSetDefaultCreditCardRequest);

    @NotNull
    @POST
    Observable<WalletCalculateCashBackResponse> fetchWalletCalculateCashBack(@NotNull @Url String str, @NotNull @Body WalletCalculateCashBackRequest walletCalculateCashBackRequest, @Query("country_id") int i11);

    @NotNull
    @POST
    Observable<WalletTopUpResponse> fetchWalletTopUp(@NotNull @Url String str, @NotNull @Body WalletTopUpRequest walletTopUpRequest);

    @NotNull
    @GET
    Observable<WalletTopUpAmountSuggestionResponse> fetchWalletTopUpAmountSuggestion(@NotNull @Url String str);

    @NotNull
    @GET
    Observable<WalletCashbackCampaignResponse> getCashBackCampaigns(@NotNull @Url String str, @Query("country_id") int i11);

    @NotNull
    @GET
    Observable<WalletCashbackCampaignOfferMessageResponse> getCashBackCampaignsForCard(@NotNull @Url String str, @Query("country_id") int i11);

    @NotNull
    @GET
    Observable<OrderDetailsRM> getOrderDetail(@NotNull @Url String str);

    @NotNull
    @GET
    Observable<WalletCreditBalanceResponse> getWalletCreditBalance(@NotNull @Url String str);

    @NotNull
    @GET
    Observable<WalletCreditTransactionDetailResponse> getWalletTransactionDetail(@NotNull @Url String str);

    @NotNull
    @GET
    Observable<WalletTransactionListResponse> getWalletTransactionList(@NotNull @Url String str);

    @NotNull
    @POST
    Observable<WalletSaveCreditCardResponse> saveCreditCard(@NotNull @Url String str, @NotNull @Body WalletCardTokenRequest walletCardTokenRequest);
}
