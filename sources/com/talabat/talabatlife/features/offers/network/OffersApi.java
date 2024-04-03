package com.talabat.talabatlife.features.offers.network;

import com.talabat.talabatlife.features.offers.model.redeem.RedeemOfferRequestModel;
import com.talabat.talabatlife.features.offers.model.redeem.RedeemOfferResponse;
import com.talabat.talabatlife.features.offers.model.transactionDetails.response.OfferTransactionRootResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH'J,\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\rH'¨\u0006\u000e"}, d2 = {"Lcom/talabat/talabatlife/features/offers/network/OffersApi;", "", "getOfferTransactionDetails", "Lretrofit2/Call;", "Lcom/talabat/talabatlife/features/offers/model/transactionDetails/response/OfferTransactionRootResponse;", "apiVersion", "", "offerId", "merchantTransactionId", "", "redeemOffer", "Lcom/talabat/talabatlife/features/offers/model/redeem/RedeemOfferResponse;", "redeemOfferRequestModel", "Lcom/talabat/talabatlife/features/offers/model/redeem/RedeemOfferRequestModel;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OffersApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Call getOfferTransactionDetails$default(OffersApi offersApi, int i11, int i12, String str, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 1) != 0) {
                    i11 = 3;
                }
                return offersApi.getOfferTransactionDetails(i11, i12, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOfferTransactionDetails");
        }

        public static /* synthetic */ Call redeemOffer$default(OffersApi offersApi, int i11, int i12, RedeemOfferRequestModel redeemOfferRequestModel, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 1) != 0) {
                    i11 = 3;
                }
                return offersApi.redeemOffer(i11, i12, redeemOfferRequestModel);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: redeemOffer");
        }
    }

    @NotNull
    @GET("/api/v{version}/offers/{id}/transaction/{merchantTransactionId}")
    Call<OfferTransactionRootResponse> getOfferTransactionDetails(@Path("version") int i11, @Path("id") int i12, @NotNull @Path("merchantTransactionId") String str);

    @NotNull
    @POST("/api/v{version}/offers/{id}/redeem")
    Call<RedeemOfferResponse> redeemOffer(@Path("version") int i11, @Path("id") int i12, @NotNull @Body RedeemOfferRequestModel redeemOfferRequestModel);
}
