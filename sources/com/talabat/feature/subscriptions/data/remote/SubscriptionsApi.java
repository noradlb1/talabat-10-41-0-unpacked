package com.talabat.feature.subscriptions.data.remote;

import com.talabat.feature.subscriptions.data.remote.model.CancellationFeedbackRequestModel;
import com.talabat.feature.subscriptions.data.remote.model.ProCentralizationRootResponse;
import com.talabat.feature.subscriptions.data.remote.model.SendCancellationFeedbackRootResponse;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionAutoRenewRequestModel;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionB2BVoucherRequestModel;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionB2BVoucherRootResponse;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionCancellationReasonsRootResponse;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionDetailsRootResponse;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentOTPRequestModel;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentOTPRootResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRequestModel;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentRootResponse;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionsAutoRenewUpdateRootResponse;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionsRootResponse;
import com.talabat.feature.subscriptions.data.remote.model.UpgradePlanRequestModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 42\u00020\u0001:\u00014J/\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ9\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u00072\b\b\u0001\u0010\r\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J1\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ9\u0010\u0015\u001a\u00020\u00162\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u00072\b\b\u0001\u0010\r\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ/\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\u0019\u001a\u00020\u001aH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ/\u0010\u001c\u001a\u00020\u001d2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\u001e\u001a\u00020\u001fH§@ø\u0001\u0000¢\u0006\u0002\u0010 J/\u0010!\u001a\u00020\"2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010#\u001a\u00020$H§@ø\u0001\u0000¢\u0006\u0002\u0010%J/\u0010&\u001a\u00020'2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010(\u001a\u00020)H§@ø\u0001\u0000¢\u0006\u0002\u0010*J9\u0010+\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010,\u001a\u00020-H§@ø\u0001\u0000¢\u0006\u0002\u0010.J9\u0010/\u001a\u00020\u00182\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u00100\u001a\u00020\u00052\b\b\u0001\u00101\u001a\u000202H§@ø\u0001\u0000¢\u0006\u0002\u00103\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/SubscriptionsApi;", "", "cancelFreeTrial", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionsAutoRenewUpdateRootResponse;", "organizationToken", "", "version", "", "subscriptionMemberId", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProCentralizationStatus", "Lcom/talabat/feature/subscriptions/data/remote/model/ProCentralizationRootResponse;", "country", "productId", "(Ljava/lang/String;IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSubscriptionCancellationReasons", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionCancellationReasonsRootResponse;", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSubscriptionDetails", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionDetailsRootResponse;", "subscriptionId", "getSubscriptionsForCountry", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionsRootResponse;", "payForSubscriptionPlan", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentRootResponse;", "subscriptionPaymentRequestModel", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentRequestModel;", "(Ljava/lang/String;ILcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payForSubscriptionPlanOTP", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentOTPRootResponseModel;", "subscriptionPaymentOTPRequestModel", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentOTPRequestModel;", "(Ljava/lang/String;ILcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentOTPRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendCancellationFeedback", "Lcom/talabat/feature/subscriptions/data/remote/model/SendCancellationFeedbackRootResponse;", "cancellationFeedbackRequestModel", "Lcom/talabat/feature/subscriptions/data/remote/model/CancellationFeedbackRequestModel;", "(Ljava/lang/String;ILcom/talabat/feature/subscriptions/data/remote/model/CancellationFeedbackRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "subscribeWithB2BVoucher", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionB2BVoucherRootResponse;", "subscriptionB2BVoucherRequestModel", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionB2BVoucherRequestModel;", "(Ljava/lang/String;ILcom/talabat/feature/subscriptions/data/remote/model/SubscriptionB2BVoucherRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSubscriptionAutoRenewStatus", "subscriptionAutoRenewRequestModel", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionAutoRenewRequestModel;", "(Ljava/lang/String;ILjava/lang/String;Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionAutoRenewRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upgradeSubscriptionPlan", "subscriptionMembershipId", "upgradePlanRequestModel", "Lcom/talabat/feature/subscriptions/data/remote/model/UpgradePlanRequestModel;", "(Ljava/lang/String;ILjava/lang/String;Lcom/talabat/feature/subscriptions/data/remote/model/UpgradePlanRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SubscriptionsApi {
    @NotNull
    public static final Companion Companion = Companion.f58951a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/SubscriptionsApi$Companion;", "", "()V", "API_VERSION", "", "API_VERSION_V2", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private static final int API_VERSION = 1;
        private static final int API_VERSION_V2 = 2;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f58951a = new Companion();

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object cancelFreeTrial$default(SubscriptionsApi subscriptionsApi, String str, int i11, String str2, Continuation continuation, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 2) != 0) {
                    i11 = 2;
                }
                return subscriptionsApi.cancelFreeTrial(str, i11, str2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancelFreeTrial");
        }

        public static /* synthetic */ Object getProCentralizationStatus$default(SubscriptionsApi subscriptionsApi, String str, int i11, int i12, String str2, Continuation continuation, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 2) != 0) {
                    i11 = 1;
                }
                return subscriptionsApi.getProCentralizationStatus(str, i11, i12, str2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getProCentralizationStatus");
        }

        public static /* synthetic */ Object getSubscriptionCancellationReasons$default(SubscriptionsApi subscriptionsApi, String str, int i11, Continuation continuation, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 2) != 0) {
                    i11 = 1;
                }
                return subscriptionsApi.getSubscriptionCancellationReasons(str, i11, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSubscriptionCancellationReasons");
        }

        public static /* synthetic */ Object getSubscriptionDetails$default(SubscriptionsApi subscriptionsApi, String str, int i11, String str2, Continuation continuation, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 2) != 0) {
                    i11 = 1;
                }
                if ((i12 & 4) != 0) {
                    str2 = null;
                }
                return subscriptionsApi.getSubscriptionDetails(str, i11, str2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSubscriptionDetails");
        }

        public static /* synthetic */ Object getSubscriptionsForCountry$default(SubscriptionsApi subscriptionsApi, String str, int i11, int i12, String str2, Continuation continuation, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 2) != 0) {
                    i11 = 1;
                }
                return subscriptionsApi.getSubscriptionsForCountry(str, i11, i12, str2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSubscriptionsForCountry");
        }

        public static /* synthetic */ Object payForSubscriptionPlan$default(SubscriptionsApi subscriptionsApi, String str, int i11, SubscriptionPaymentRequestModel subscriptionPaymentRequestModel, Continuation continuation, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 2) != 0) {
                    i11 = 2;
                }
                return subscriptionsApi.payForSubscriptionPlan(str, i11, subscriptionPaymentRequestModel, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: payForSubscriptionPlan");
        }

        public static /* synthetic */ Object payForSubscriptionPlanOTP$default(SubscriptionsApi subscriptionsApi, String str, int i11, SubscriptionPaymentOTPRequestModel subscriptionPaymentOTPRequestModel, Continuation continuation, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 2) != 0) {
                    i11 = 1;
                }
                return subscriptionsApi.payForSubscriptionPlanOTP(str, i11, subscriptionPaymentOTPRequestModel, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: payForSubscriptionPlanOTP");
        }

        public static /* synthetic */ Object sendCancellationFeedback$default(SubscriptionsApi subscriptionsApi, String str, int i11, CancellationFeedbackRequestModel cancellationFeedbackRequestModel, Continuation continuation, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 2) != 0) {
                    i11 = 1;
                }
                return subscriptionsApi.sendCancellationFeedback(str, i11, cancellationFeedbackRequestModel, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendCancellationFeedback");
        }

        public static /* synthetic */ Object subscribeWithB2BVoucher$default(SubscriptionsApi subscriptionsApi, String str, int i11, SubscriptionB2BVoucherRequestModel subscriptionB2BVoucherRequestModel, Continuation continuation, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 2) != 0) {
                    i11 = 2;
                }
                return subscriptionsApi.subscribeWithB2BVoucher(str, i11, subscriptionB2BVoucherRequestModel, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subscribeWithB2BVoucher");
        }

        public static /* synthetic */ Object updateSubscriptionAutoRenewStatus$default(SubscriptionsApi subscriptionsApi, String str, int i11, String str2, SubscriptionAutoRenewRequestModel subscriptionAutoRenewRequestModel, Continuation continuation, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 2) != 0) {
                    i11 = 1;
                }
                return subscriptionsApi.updateSubscriptionAutoRenewStatus(str, i11, str2, subscriptionAutoRenewRequestModel, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateSubscriptionAutoRenewStatus");
        }

        public static /* synthetic */ Object upgradeSubscriptionPlan$default(SubscriptionsApi subscriptionsApi, String str, int i11, String str2, UpgradePlanRequestModel upgradePlanRequestModel, Continuation continuation, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 2) != 0) {
                    i11 = 1;
                }
                return subscriptionsApi.upgradeSubscriptionPlan(str, i11, str2, upgradePlanRequestModel, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: upgradeSubscriptionPlan");
        }
    }

    @PATCH("/api/v{apiVersion}/customer/subscriptions/cancel/{memberId}")
    @Nullable
    Object cancelFreeTrial(@NotNull @Header("organization") String str, @Path("apiVersion") int i11, @NotNull @Path("memberId") String str2, @NotNull Continuation<? super SubscriptionsAutoRenewUpdateRootResponse> continuation);

    @Nullable
    @GET("api/v{apiVersion}/feature/customer/country/{country}/participation")
    Object getProCentralizationStatus(@NotNull @Header("organization") String str, @Path("apiVersion") int i11, @Path("country") int i12, @NotNull @Query("product_id") String str2, @NotNull Continuation<? super ProCentralizationRootResponse> continuation);

    @Nullable
    @GET("/api/v{apiVersion}/customer/cancellation-feedback/reasons")
    Object getSubscriptionCancellationReasons(@NotNull @Header("organization") String str, @Path("apiVersion") int i11, @NotNull Continuation<? super SubscriptionCancellationReasonsRootResponse> continuation);

    @Nullable
    @GET("api/v{apiVersion}/customer/subscriptions/{subscriptionId}")
    Object getSubscriptionDetails(@NotNull @Header("organization") String str, @Path("apiVersion") int i11, @Nullable @Path("subscriptionId") String str2, @NotNull Continuation<? super SubscriptionDetailsRootResponse> continuation);

    @Nullable
    @GET("api/v{apiVersion}/customer/subscriptions")
    Object getSubscriptionsForCountry(@NotNull @Header("organization") String str, @Path("apiVersion") int i11, @Query("country") int i12, @NotNull @Query("product_id") String str2, @NotNull Continuation<? super SubscriptionsRootResponse> continuation);

    @POST("/api/v{apiVersion}/customer/subscriptions")
    @Nullable
    Object payForSubscriptionPlan(@NotNull @Header("organization") String str, @Path("apiVersion") int i11, @NotNull @Body SubscriptionPaymentRequestModel subscriptionPaymentRequestModel, @NotNull Continuation<? super SubscriptionPaymentRootResponse> continuation);

    @POST("/api/v{apiVersion}/customer/subscriptions/otp")
    @Nullable
    Object payForSubscriptionPlanOTP(@NotNull @Header("organization") String str, @Path("apiVersion") int i11, @NotNull @Body SubscriptionPaymentOTPRequestModel subscriptionPaymentOTPRequestModel, @NotNull Continuation<? super SubscriptionPaymentOTPRootResponseModel> continuation);

    @POST("/api/v{apiVersion}/customer/cancellation-feedback")
    @Nullable
    Object sendCancellationFeedback(@NotNull @Header("organization") String str, @Path("apiVersion") int i11, @NotNull @Body CancellationFeedbackRequestModel cancellationFeedbackRequestModel, @NotNull Continuation<? super SendCancellationFeedbackRootResponse> continuation);

    @POST("api/v{apiVersion}/customer/subscriptions/b2b")
    @Nullable
    Object subscribeWithB2BVoucher(@NotNull @Header("organization") String str, @Path("apiVersion") int i11, @NotNull @Body SubscriptionB2BVoucherRequestModel subscriptionB2BVoucherRequestModel, @NotNull Continuation<? super SubscriptionB2BVoucherRootResponse> continuation);

    @PATCH("/api/v{apiVersion}/customer/subscriptions/{memberId}/auto-renew")
    @Nullable
    Object updateSubscriptionAutoRenewStatus(@NotNull @Header("organization") String str, @Path("apiVersion") int i11, @NotNull @Path("memberId") String str2, @NotNull @Body SubscriptionAutoRenewRequestModel subscriptionAutoRenewRequestModel, @NotNull Continuation<? super SubscriptionsAutoRenewUpdateRootResponse> continuation);

    @POST("/api/v{apiVersion}/customer/subscriptions/{membershipId}/upgrade")
    @Nullable
    Object upgradeSubscriptionPlan(@NotNull @Header("organization") String str, @Path("apiVersion") int i11, @NotNull @Path("membershipId") String str2, @NotNull @Body UpgradePlanRequestModel upgradePlanRequestModel, @NotNull Continuation<? super SubscriptionPaymentRootResponse> continuation);
}
