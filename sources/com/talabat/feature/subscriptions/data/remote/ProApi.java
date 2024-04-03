package com.talabat.feature.subscriptions.data.remote;

import com.talabat.feature.subscriptions.data.remote.model.ProVendorMovRootResponse;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionMultiPlanRootResponse;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionSavingsInfoRootResponse;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingBannerAndPlansRootResponseModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J_\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\t\u001a\u00020\u00052\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u00020\u00102\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J/\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J_\u0010\u0016\u001a\u00020\u00172\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\t\u001a\u00020\u00052\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/ProApi;", "", "getMultiPlanWithHeroBanner", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingBannerAndPlansRootResponseModel;", "version", "", "organizationToken", "", "requestingPage", "country", "duration", "freeCoffeeEnabled", "", "voucherCode", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProVendorMov", "Lcom/talabat/feature/subscriptions/data/remote/model/ProVendorMovRootResponse;", "branchId", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSavingsInfo", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionSavingsInfoRootResponse;", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSubscriptionMultiPlan", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionMultiPlanRootResponse;", "Companion", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ProApi {
    @NotNull
    public static final Companion Companion = Companion.f58950a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/ProApi$Companion;", "", "()V", "API_VERSION", "", "API_VERSION_V2", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private static final int API_VERSION = 1;
        private static final int API_VERSION_V2 = 2;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f58950a = new Companion();

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object getMultiPlanWithHeroBanner$default(ProApi proApi, int i11, String str, String str2, int i12, String str3, Boolean bool, String str4, Continuation continuation, int i13, Object obj) {
            if (obj == null) {
                return proApi.getMultiPlanWithHeroBanner((i13 & 1) != 0 ? 2 : i11, str, str2, i12, str3, bool, str4, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMultiPlanWithHeroBanner");
        }

        public static /* synthetic */ Object getProVendorMov$default(ProApi proApi, int i11, int i12, Continuation continuation, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 1) != 0) {
                    i11 = 1;
                }
                return proApi.getProVendorMov(i11, i12, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getProVendorMov");
        }

        public static /* synthetic */ Object getSavingsInfo$default(ProApi proApi, String str, int i11, int i12, Continuation continuation, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 2) != 0) {
                    i11 = 1;
                }
                return proApi.getSavingsInfo(str, i11, i12, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSavingsInfo");
        }

        public static /* synthetic */ Object getSubscriptionMultiPlan$default(ProApi proApi, int i11, String str, String str2, int i12, String str3, Boolean bool, String str4, Continuation continuation, int i13, Object obj) {
            if (obj == null) {
                return proApi.getSubscriptionMultiPlan((i13 & 1) != 0 ? 1 : i11, str, str2, i12, str3, bool, str4, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSubscriptionMultiPlan");
        }
    }

    @Nullable
    @GET("v{apiVersion}/Plans")
    Object getMultiPlanWithHeroBanner(@Path("apiVersion") int i11, @NotNull @Header("organization") String str, @Nullable @Header("requesting-page") String str2, @Query("country") int i12, @Nullable @Query("durations") String str3, @Nullable @Query("free-coffee") Boolean bool, @Nullable @Query("subscription-code") String str4, @NotNull Continuation<? super TProOnBoardingBannerAndPlansRootResponseModel> continuation);

    @Nullable
    @GET("v{apiVersion}/branch/{branch_id}")
    Object getProVendorMov(@Path("apiVersion") int i11, @Path("branch_id") int i12, @NotNull Continuation<? super ProVendorMovRootResponse> continuation);

    @Nullable
    @GET("v{apiVersion}/customer/roi")
    Object getSavingsInfo(@NotNull @Header("organization") String str, @Path("apiVersion") int i11, @Query("country") int i12, @NotNull Continuation<? super SubscriptionSavingsInfoRootResponse> continuation);

    @Nullable
    @GET("v{apiVersion}/plans")
    Object getSubscriptionMultiPlan(@Path("apiVersion") int i11, @NotNull @Header("organization") String str, @Nullable @Header("requesting-page") String str2, @Query("country") int i12, @Nullable @Query("durations") String str3, @Nullable @Query("free-coffee") Boolean bool, @Nullable @Query("subscription-code") String str4, @NotNull Continuation<? super SubscriptionMultiPlanRootResponse> continuation);
}
