package com.talabat.talabatlife.features.subscription.network;

import com.talabat.talabatlife.features.subscription.model.request.SubscriptionPaymentRequestModel;
import com.talabat.talabatlife.features.subscription.model.response.AutoRenewSubscriptionResponse;
import com.talabat.talabatlife.features.subscription.model.response.SubscriptionPaymentResponse;
import com.talabat.talabatlife.features.subscription.model.response.TLifePlansRootResponse;
import com.talabat.talabatlife.features.subscription.model.response.TLifeSubscriptionDetailResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\f\u001a\u00020\u00062\b\b\u0003\u0010\u0005\u001a\u00020\u0006H'J\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\f\u001a\u00020\u00062\b\b\u0003\u0010\u0005\u001a\u00020\u0006H'J\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u0012H'¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatlife/features/subscription/network/SubscriptionApi;", "", "disableSubscriptionAutoRenew", "Lretrofit2/Call;", "Lcom/talabat/talabatlife/features/subscription/model/response/AutoRenewSubscriptionResponse;", "version", "", "membershipId", "", "enableSubscriptionAutoRenew", "getTLifeSubscriptionDetail", "Lcom/talabat/talabatlife/features/subscription/model/response/TLifeSubscriptionDetailResponse;", "country", "getUserPlans", "Lcom/talabat/talabatlife/features/subscription/model/response/TLifePlansRootResponse;", "paySubscription", "Lcom/talabat/talabatlife/features/subscription/model/response/SubscriptionPaymentResponse;", "subscriptionPaymentRequestModel", "Lcom/talabat/talabatlife/features/subscription/model/request/SubscriptionPaymentRequestModel;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SubscriptionApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Call disableSubscriptionAutoRenew$default(SubscriptionApi subscriptionApi, int i11, String str, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = 3;
                }
                return subscriptionApi.disableSubscriptionAutoRenew(i11, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: disableSubscriptionAutoRenew");
        }

        public static /* synthetic */ Call enableSubscriptionAutoRenew$default(SubscriptionApi subscriptionApi, int i11, String str, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = 3;
                }
                return subscriptionApi.enableSubscriptionAutoRenew(i11, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enableSubscriptionAutoRenew");
        }

        public static /* synthetic */ Call getTLifeSubscriptionDetail$default(SubscriptionApi subscriptionApi, int i11, int i12, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 2) != 0) {
                    i12 = 3;
                }
                return subscriptionApi.getTLifeSubscriptionDetail(i11, i12);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTLifeSubscriptionDetail");
        }

        public static /* synthetic */ Call getUserPlans$default(SubscriptionApi subscriptionApi, int i11, int i12, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 2) != 0) {
                    i12 = 3;
                }
                return subscriptionApi.getUserPlans(i11, i12);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserPlans");
        }

        public static /* synthetic */ Call paySubscription$default(SubscriptionApi subscriptionApi, int i11, SubscriptionPaymentRequestModel subscriptionPaymentRequestModel, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = 3;
                }
                return subscriptionApi.paySubscription(i11, subscriptionPaymentRequestModel);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paySubscription");
        }
    }

    @NotNull
    @DELETE("/api/v{version}/subscriptions/{membershipId}/autorenew")
    Call<AutoRenewSubscriptionResponse> disableSubscriptionAutoRenew(@Path("version") int i11, @NotNull @Path("membershipId") String str);

    @NotNull
    @PUT("/api/v{version}/subscriptions/{membershipId}/autorenew")
    Call<AutoRenewSubscriptionResponse> enableSubscriptionAutoRenew(@Path("version") int i11, @NotNull @Path("membershipId") String str);

    @NotNull
    @GET("/api/v{version}/subscriptions/country/{countryId}/subscription-details")
    Call<TLifeSubscriptionDetailResponse> getTLifeSubscriptionDetail(@Path("countryId") int i11, @Path("version") int i12);

    @NotNull
    @GET("/api/v{version}/plans/country/{countryId}/available-for-me")
    Call<TLifePlansRootResponse> getUserPlans(@Path("countryId") int i11, @Path("version") int i12);

    @NotNull
    @POST("/api/v{version}/subscriptions/subscribe")
    Call<SubscriptionPaymentResponse> paySubscription(@Path("version") int i11, @NotNull @Body SubscriptionPaymentRequestModel subscriptionPaymentRequestModel);
}
