package com.talabat.talabatcommon.feature.subscriptionManagement.network;

import com.talabat.talabatcommon.feature.TalabatCommonUrlConstants;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SetSubscriptionDefaultCardResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionAutoRenewRequestModel;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionAutoRenewUpdateResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionDefaultCardRequestModel;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionDefaultCardRootResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionDetailRootResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionPlanRootResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionRootResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.subscriptionCancellation.SubscriptionCancellationFeedbackRequest;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.subscriptionCancellation.SubscriptionCancellationFeedbackResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.subscriptionCancellation.SubscriptionCancellationReasonResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\bH'J6\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u0006H'J6\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u000fH'J\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\bH'J,\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0014\u001a\u00020\u0006H'J,\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\u0006H'J,\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0019\u001a\u00020\u001aH'J,\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u001d\u001a\u00020\u001eH'J6\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010!\u001a\u00020\"H'J6\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010!\u001a\u00020\"H'¨\u0006$"}, d2 = {"Lcom/talabat/talabatcommon/feature/subscriptionManagement/network/SubscriptionManagementApi;", "", "getDefaultSubscriptionCard", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionDefaultCardRootResponse;", "organizationToken", "", "version", "", "getProSubscriptionStatus", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionRootResponse;", "country", "productId", "getSubscription", "isActive", "", "getSubscriptionCancellationReasons", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/subscriptionCancellation/SubscriptionCancellationReasonResponse;", "getSubscriptionDetail", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionDetailRootResponse;", "subscriptionMemberId", "getSubscriptionPlans", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionPlanRootResponse;", "postSubscriptionCancellationFeedback", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/subscriptionCancellation/SubscriptionCancellationFeedbackResponse;", "subscriptionCancellationFeedbackRequest", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/subscriptionCancellation/SubscriptionCancellationFeedbackRequest;", "setSubscriptionDefaultCard", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SetSubscriptionDefaultCardResponse;", "subscriptionDefaultCard", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionDefaultCardRequestModel;", "updateSubscriptionAutoRenewStatus", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionAutoRenewUpdateResponse;", "subscriptionAutoRenewRequestModel", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionAutoRenewRequestModel;", "updateSubscriptionAutoRenewStatusForMockTest", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SubscriptionManagementApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Call getDefaultSubscriptionCard$default(SubscriptionManagementApi subscriptionManagementApi, String str, int i11, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    str = TalabatCommonUrlConstants.Companion.getSubscriptionOrganizationToken("release");
                }
                if ((i12 & 2) != 0) {
                    i11 = 1;
                }
                return subscriptionManagementApi.getDefaultSubscriptionCard(str, i11);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDefaultSubscriptionCard");
        }

        public static /* synthetic */ Call getProSubscriptionStatus$default(SubscriptionManagementApi subscriptionManagementApi, String str, int i11, String str2, String str3, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    str = TalabatCommonUrlConstants.Companion.getSubscriptionOrganizationToken("release");
                }
                if ((i12 & 2) != 0) {
                    i11 = 1;
                }
                return subscriptionManagementApi.getProSubscriptionStatus(str, i11, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getProSubscriptionStatus");
        }

        public static /* synthetic */ Call getSubscription$default(SubscriptionManagementApi subscriptionManagementApi, String str, int i11, String str2, boolean z11, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    str = TalabatCommonUrlConstants.Companion.getSubscriptionOrganizationToken("release");
                }
                if ((i12 & 2) != 0) {
                    i11 = 1;
                }
                return subscriptionManagementApi.getSubscription(str, i11, str2, z11);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSubscription");
        }

        public static /* synthetic */ Call getSubscriptionCancellationReasons$default(SubscriptionManagementApi subscriptionManagementApi, String str, int i11, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    str = TalabatCommonUrlConstants.Companion.getSubscriptionOrganizationToken("release");
                }
                if ((i12 & 2) != 0) {
                    i11 = 1;
                }
                return subscriptionManagementApi.getSubscriptionCancellationReasons(str, i11);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSubscriptionCancellationReasons");
        }

        public static /* synthetic */ Call getSubscriptionDetail$default(SubscriptionManagementApi subscriptionManagementApi, String str, int i11, String str2, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    str = TalabatCommonUrlConstants.Companion.getSubscriptionOrganizationToken("release");
                }
                if ((i12 & 2) != 0) {
                    i11 = 1;
                }
                return subscriptionManagementApi.getSubscriptionDetail(str, i11, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSubscriptionDetail");
        }

        public static /* synthetic */ Call getSubscriptionPlans$default(SubscriptionManagementApi subscriptionManagementApi, String str, int i11, String str2, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    str = TalabatCommonUrlConstants.Companion.getSubscriptionOrganizationToken("release");
                }
                if ((i12 & 2) != 0) {
                    i11 = 1;
                }
                return subscriptionManagementApi.getSubscriptionPlans(str, i11, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSubscriptionPlans");
        }

        public static /* synthetic */ Call postSubscriptionCancellationFeedback$default(SubscriptionManagementApi subscriptionManagementApi, String str, int i11, SubscriptionCancellationFeedbackRequest subscriptionCancellationFeedbackRequest, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    str = TalabatCommonUrlConstants.Companion.getSubscriptionOrganizationToken("release");
                }
                if ((i12 & 2) != 0) {
                    i11 = 1;
                }
                return subscriptionManagementApi.postSubscriptionCancellationFeedback(str, i11, subscriptionCancellationFeedbackRequest);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postSubscriptionCancellationFeedback");
        }

        public static /* synthetic */ Call setSubscriptionDefaultCard$default(SubscriptionManagementApi subscriptionManagementApi, String str, int i11, SubscriptionDefaultCardRequestModel subscriptionDefaultCardRequestModel, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    str = TalabatCommonUrlConstants.Companion.getSubscriptionOrganizationToken("release");
                }
                if ((i12 & 2) != 0) {
                    i11 = 1;
                }
                return subscriptionManagementApi.setSubscriptionDefaultCard(str, i11, subscriptionDefaultCardRequestModel);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSubscriptionDefaultCard");
        }

        public static /* synthetic */ Call updateSubscriptionAutoRenewStatus$default(SubscriptionManagementApi subscriptionManagementApi, String str, int i11, String str2, SubscriptionAutoRenewRequestModel subscriptionAutoRenewRequestModel, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    str = TalabatCommonUrlConstants.Companion.getSubscriptionOrganizationToken("release");
                }
                if ((i12 & 2) != 0) {
                    i11 = 1;
                }
                return subscriptionManagementApi.updateSubscriptionAutoRenewStatus(str, i11, str2, subscriptionAutoRenewRequestModel);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateSubscriptionAutoRenewStatus");
        }

        public static /* synthetic */ Call updateSubscriptionAutoRenewStatusForMockTest$default(SubscriptionManagementApi subscriptionManagementApi, String str, int i11, String str2, SubscriptionAutoRenewRequestModel subscriptionAutoRenewRequestModel, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    str = TalabatCommonUrlConstants.Companion.getSubscriptionOrganizationToken("release");
                }
                if ((i12 & 2) != 0) {
                    i11 = 1;
                }
                return subscriptionManagementApi.updateSubscriptionAutoRenewStatusForMockTest(str, i11, str2, subscriptionAutoRenewRequestModel);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateSubscriptionAutoRenewStatusForMockTest");
        }
    }

    @NotNull
    @GET("/api/v{version}/customer/cards/default-card")
    Call<SubscriptionDefaultCardRootResponse> getDefaultSubscriptionCard(@NotNull @Header("organization") String str, @Path("version") int i11);

    @NotNull
    @GET("/api/v{version}/customer/subscriptions")
    Call<SubscriptionRootResponse> getProSubscriptionStatus(@NotNull @Header("organization") String str, @Path("version") int i11, @NotNull @Query("country") String str2, @NotNull @Query("product_id") String str3);

    @NotNull
    @GET("/api/v{version}/customer/subscriptions")
    Call<SubscriptionRootResponse> getSubscription(@NotNull @Header("organization") String str, @Path("version") int i11, @NotNull @Query("country") String str2, @Query("active") boolean z11);

    @NotNull
    @GET("/api/v{version}/customer/cancellation-feedback/reasons")
    Call<SubscriptionCancellationReasonResponse> getSubscriptionCancellationReasons(@NotNull @Header("organization") String str, @Path("version") int i11);

    @NotNull
    @GET("/api/v{version}/customer/subscriptions/{memberId}")
    Call<SubscriptionDetailRootResponse> getSubscriptionDetail(@NotNull @Header("organization") String str, @Path("version") int i11, @NotNull @Path("memberId") String str2);

    @NotNull
    @GET("/api/v{version}/customer/plans")
    Call<SubscriptionPlanRootResponse> getSubscriptionPlans(@NotNull @Header("organization") String str, @Path("version") int i11, @NotNull @Query("country") String str2);

    @NotNull
    @POST("/api/v{version}/customer/cancellation-feedback")
    Call<SubscriptionCancellationFeedbackResponse> postSubscriptionCancellationFeedback(@NotNull @Header("organization") String str, @Path("version") int i11, @NotNull @Body SubscriptionCancellationFeedbackRequest subscriptionCancellationFeedbackRequest);

    @NotNull
    @PUT("/api/v{version}/customer/cards/default-card")
    Call<SetSubscriptionDefaultCardResponse> setSubscriptionDefaultCard(@NotNull @Header("organization") String str, @Path("version") int i11, @NotNull @Body SubscriptionDefaultCardRequestModel subscriptionDefaultCardRequestModel);

    @NotNull
    @PATCH("/api/v{version}/customer/subscriptions/{memberId}/auto-renew")
    Call<SubscriptionAutoRenewUpdateResponse> updateSubscriptionAutoRenewStatus(@NotNull @Header("organization") String str, @Path("version") int i11, @NotNull @Path("memberId") String str2, @NotNull @Body SubscriptionAutoRenewRequestModel subscriptionAutoRenewRequestModel);

    @NotNull
    @POST("/api/v{version}/customer/subscriptions/{memberId}/auto-renew")
    Call<SubscriptionAutoRenewUpdateResponse> updateSubscriptionAutoRenewStatusForMockTest(@NotNull @Header("organization") String str, @Path("version") int i11, @NotNull @Path("memberId") String str2, @NotNull @Body SubscriptionAutoRenewRequestModel subscriptionAutoRenewRequestModel);
}
