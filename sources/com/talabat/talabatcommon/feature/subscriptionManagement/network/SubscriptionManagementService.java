package com.talabat.talabatcommon.feature.subscriptionManagement.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
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
import com.talabat.talabatcommon.feature.subscriptionManagement.network.SubscriptionManagementApi;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J.\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J.\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J&\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J&\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J&\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H\u0016J&\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&H\u0016J.\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*H\u0016J.\u0010+\u001a\b\u0012\u0004\u0012\u00020(0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*H\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006,"}, d2 = {"Lcom/talabat/talabatcommon/feature/subscriptionManagement/network/SubscriptionManagementService;", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/network/SubscriptionManagementApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "subscriptionManagementApi", "getSubscriptionManagementApi", "()Lcom/talabat/talabatcommon/feature/subscriptionManagement/network/SubscriptionManagementApi;", "subscriptionManagementApi$delegate", "Lkotlin/Lazy;", "getDefaultSubscriptionCard", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionDefaultCardRootResponse;", "organizationToken", "", "version", "", "getProSubscriptionStatus", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionRootResponse;", "country", "productId", "getSubscription", "isActive", "", "getSubscriptionCancellationReasons", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/subscriptionCancellation/SubscriptionCancellationReasonResponse;", "getSubscriptionDetail", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionDetailRootResponse;", "subscriptionMemberId", "getSubscriptionPlans", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionPlanRootResponse;", "postSubscriptionCancellationFeedback", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/subscriptionCancellation/SubscriptionCancellationFeedbackResponse;", "subscriptionCancellationFeedbackRequest", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/subscriptionCancellation/SubscriptionCancellationFeedbackRequest;", "setSubscriptionDefaultCard", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SetSubscriptionDefaultCardResponse;", "subscriptionDefaultCard", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionDefaultCardRequestModel;", "updateSubscriptionAutoRenewStatus", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionAutoRenewUpdateResponse;", "subscriptionAutoRenewRequestModel", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionAutoRenewRequestModel;", "updateSubscriptionAutoRenewStatusForMockTest", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionManagementService implements SubscriptionManagementApi {
    @NotNull
    private final Lazy subscriptionManagementApi$delegate;

    public SubscriptionManagementService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.subscriptionManagementApi$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new SubscriptionManagementService$subscriptionManagementApi$2(talabatAPIBuilder));
    }

    private final SubscriptionManagementApi getSubscriptionManagementApi() {
        return (SubscriptionManagementApi) this.subscriptionManagementApi$delegate.getValue();
    }

    @NotNull
    public Call<SubscriptionDefaultCardRootResponse> getDefaultSubscriptionCard(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "organizationToken");
        return SubscriptionManagementApi.DefaultImpls.getDefaultSubscriptionCard$default(getSubscriptionManagementApi(), (String) null, 0, 3, (Object) null);
    }

    @NotNull
    public Call<SubscriptionRootResponse> getProSubscriptionStatus(@NotNull String str, int i11, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "organizationToken");
        Intrinsics.checkNotNullParameter(str2, "country");
        Intrinsics.checkNotNullParameter(str3, "productId");
        return SubscriptionManagementApi.DefaultImpls.getProSubscriptionStatus$default(getSubscriptionManagementApi(), (String) null, 0, str2, str3, 3, (Object) null);
    }

    @NotNull
    public Call<SubscriptionRootResponse> getSubscription(@NotNull String str, int i11, @NotNull String str2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "organizationToken");
        Intrinsics.checkNotNullParameter(str2, "country");
        return SubscriptionManagementApi.DefaultImpls.getSubscription$default(getSubscriptionManagementApi(), (String) null, 0, str2, z11, 3, (Object) null);
    }

    @NotNull
    public Call<SubscriptionCancellationReasonResponse> getSubscriptionCancellationReasons(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "organizationToken");
        return SubscriptionManagementApi.DefaultImpls.getSubscriptionCancellationReasons$default(getSubscriptionManagementApi(), (String) null, 0, 3, (Object) null);
    }

    @NotNull
    public Call<SubscriptionDetailRootResponse> getSubscriptionDetail(@NotNull String str, int i11, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "organizationToken");
        Intrinsics.checkNotNullParameter(str2, "subscriptionMemberId");
        return SubscriptionManagementApi.DefaultImpls.getSubscriptionDetail$default(getSubscriptionManagementApi(), (String) null, 0, str2, 3, (Object) null);
    }

    @NotNull
    public Call<SubscriptionPlanRootResponse> getSubscriptionPlans(@NotNull String str, int i11, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "organizationToken");
        Intrinsics.checkNotNullParameter(str2, "country");
        return SubscriptionManagementApi.DefaultImpls.getSubscriptionPlans$default(getSubscriptionManagementApi(), (String) null, 0, str2, 3, (Object) null);
    }

    @NotNull
    public Call<SubscriptionCancellationFeedbackResponse> postSubscriptionCancellationFeedback(@NotNull String str, int i11, @NotNull SubscriptionCancellationFeedbackRequest subscriptionCancellationFeedbackRequest) {
        Intrinsics.checkNotNullParameter(str, "organizationToken");
        Intrinsics.checkNotNullParameter(subscriptionCancellationFeedbackRequest, "subscriptionCancellationFeedbackRequest");
        return SubscriptionManagementApi.DefaultImpls.postSubscriptionCancellationFeedback$default(getSubscriptionManagementApi(), (String) null, 0, subscriptionCancellationFeedbackRequest, 3, (Object) null);
    }

    @NotNull
    public Call<SetSubscriptionDefaultCardResponse> setSubscriptionDefaultCard(@NotNull String str, int i11, @NotNull SubscriptionDefaultCardRequestModel subscriptionDefaultCardRequestModel) {
        Intrinsics.checkNotNullParameter(str, "organizationToken");
        Intrinsics.checkNotNullParameter(subscriptionDefaultCardRequestModel, "subscriptionDefaultCard");
        return SubscriptionManagementApi.DefaultImpls.setSubscriptionDefaultCard$default(getSubscriptionManagementApi(), (String) null, 0, subscriptionDefaultCardRequestModel, 3, (Object) null);
    }

    @NotNull
    public Call<SubscriptionAutoRenewUpdateResponse> updateSubscriptionAutoRenewStatus(@NotNull String str, int i11, @NotNull String str2, @NotNull SubscriptionAutoRenewRequestModel subscriptionAutoRenewRequestModel) {
        Intrinsics.checkNotNullParameter(str, "organizationToken");
        Intrinsics.checkNotNullParameter(str2, "subscriptionMemberId");
        Intrinsics.checkNotNullParameter(subscriptionAutoRenewRequestModel, "subscriptionAutoRenewRequestModel");
        return SubscriptionManagementApi.DefaultImpls.updateSubscriptionAutoRenewStatus$default(getSubscriptionManagementApi(), (String) null, 0, str2, subscriptionAutoRenewRequestModel, 3, (Object) null);
    }

    @NotNull
    public Call<SubscriptionAutoRenewUpdateResponse> updateSubscriptionAutoRenewStatusForMockTest(@NotNull String str, int i11, @NotNull String str2, @NotNull SubscriptionAutoRenewRequestModel subscriptionAutoRenewRequestModel) {
        Intrinsics.checkNotNullParameter(str, "organizationToken");
        Intrinsics.checkNotNullParameter(str2, "subscriptionMemberId");
        Intrinsics.checkNotNullParameter(subscriptionAutoRenewRequestModel, "subscriptionAutoRenewRequestModel");
        return SubscriptionManagementApi.DefaultImpls.updateSubscriptionAutoRenewStatusForMockTest$default(getSubscriptionManagementApi(), (String) null, 0, str2, subscriptionAutoRenewRequestModel, 3, (Object) null);
    }
}
