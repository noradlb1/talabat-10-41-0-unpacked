package com.talabat.talabatcommon.feature.subscriptionManagement.repository;

import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SetSubscriptionDefaultCardResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionAutoRenewRequestModel;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionAutoRenewUpdateResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionDefaultCardRequestModel;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionDefaultCardResponseModel;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionDefaultCardRootResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionDetailRootResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionPlanResponseResult;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionPlanRootResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionResponseModel;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionResponseResult;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionRootResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.subscriptionCancellation.SubscriptionCancellationFeedbackRequest;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.subscriptionCancellation.SubscriptionCancellationFeedbackResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.subscriptionCancellation.SubscriptionCancellationReasonResponse;
import com.talabat.talabatcommon.feature.subscriptionManagement.model.subscriptionCancellation.SubscriptionCancellationReasonResult;
import com.talabat.talabatcommon.feature.subscriptionManagement.network.SubscriptionManagementApi;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.platform.NetworkHandler;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\bH\u0016J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\bH\u0016J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00130\b2\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001b0\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001c\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001f0\b2\u0006\u0010 \u001a\u00020!H\u0016J,\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020#0\b2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0019H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/talabat/talabatcommon/feature/subscriptionManagement/repository/SubscriptionManagementRepositoryImpl;", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/repository/SubscriptionManagementRepository;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "subscriptionManagementApi", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/network/SubscriptionManagementApi;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/talabatcommon/feature/subscriptionManagement/network/SubscriptionManagementApi;)V", "getProSubscription", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionRootResponse;", "country", "", "productId", "getSubscriptionCancellationReasons", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/subscriptionCancellation/SubscriptionCancellationReasonResponse;", "getSubscriptionDefaultCard", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionDefaultCardRootResponse;", "getSubscriptionDetail", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionDetailRootResponse;", "subscriptionMemberId", "getSubscriptionPlans", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionPlanRootResponse;", "getSubscriptions", "isActive", "", "postSubscriptionCancellationFeedback", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/subscriptionCancellation/SubscriptionCancellationFeedbackResponse;", "subscriptionCancellationFeedbackRequest", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/subscriptionCancellation/SubscriptionCancellationFeedbackRequest;", "setSubscriptionDefaultCard", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SetSubscriptionDefaultCardResponse;", "subscriptionDefaultCard", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionDefaultCardRequestModel;", "updateSubscriptionAutoRenew", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionAutoRenewUpdateResponse;", "subscriptionAutoRenewRequestModel", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionAutoRenewRequestModel;", "isInstrumentationTest", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionManagementRepositoryImpl implements SubscriptionManagementRepository {
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull
    private final SubscriptionManagementApi subscriptionManagementApi;

    public SubscriptionManagementRepositoryImpl(@NotNull NetworkHandler networkHandler2, @NotNull SubscriptionManagementApi subscriptionManagementApi2) {
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(subscriptionManagementApi2, "subscriptionManagementApi");
        this.networkHandler = networkHandler2;
        this.subscriptionManagementApi = subscriptionManagementApi2;
    }

    @NotNull
    public Either<Failure, SubscriptionRootResponse> getProSubscription(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "country");
        Intrinsics.checkNotNullParameter(str2, "productId");
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(SubscriptionManagementApi.DefaultImpls.getProSubscriptionStatus$default(this.subscriptionManagementApi, (String) null, 0, str, str2, 3, (Object) null), SubscriptionManagementRepositoryImpl$getProSubscription$1.INSTANCE, new SubscriptionRootResponse((SubscriptionResponseResult) null, 1, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public Either<Failure, SubscriptionCancellationReasonResponse> getSubscriptionCancellationReasons() {
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(SubscriptionManagementApi.DefaultImpls.getSubscriptionCancellationReasons$default(this.subscriptionManagementApi, (String) null, 0, 3, (Object) null), SubscriptionManagementRepositoryImpl$getSubscriptionCancellationReasons$1.INSTANCE, new SubscriptionCancellationReasonResponse((SubscriptionCancellationReasonResult) null, 1, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public Either<Failure, SubscriptionDefaultCardRootResponse> getSubscriptionDefaultCard() {
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(SubscriptionManagementApi.DefaultImpls.getDefaultSubscriptionCard$default(this.subscriptionManagementApi, (String) null, 0, 3, (Object) null), SubscriptionManagementRepositoryImpl$getSubscriptionDefaultCard$1.INSTANCE, new SubscriptionDefaultCardRootResponse((SubscriptionDefaultCardResponseModel) null, 1, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public Either<Failure, SubscriptionDetailRootResponse> getSubscriptionDetail(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "subscriptionMemberId");
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(SubscriptionManagementApi.DefaultImpls.getSubscriptionDetail$default(this.subscriptionManagementApi, (String) null, 0, str, 3, (Object) null), SubscriptionManagementRepositoryImpl$getSubscriptionDetail$1.INSTANCE, new SubscriptionDetailRootResponse((SubscriptionResponseModel) null, 1, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public Either<Failure, SubscriptionPlanRootResponse> getSubscriptionPlans(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "country");
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(SubscriptionManagementApi.DefaultImpls.getSubscriptionPlans$default(this.subscriptionManagementApi, (String) null, 0, str, 3, (Object) null), SubscriptionManagementRepositoryImpl$getSubscriptionPlans$1.INSTANCE, new SubscriptionPlanRootResponse((SubscriptionPlanResponseResult) null, 1, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public Either<Failure, SubscriptionRootResponse> getSubscriptions(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "country");
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(SubscriptionManagementApi.DefaultImpls.getSubscription$default(this.subscriptionManagementApi, (String) null, 0, str, z11, 3, (Object) null), SubscriptionManagementRepositoryImpl$getSubscriptions$1.INSTANCE, new SubscriptionRootResponse((SubscriptionResponseResult) null, 1, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public Either<Failure, SubscriptionCancellationFeedbackResponse> postSubscriptionCancellationFeedback(@NotNull SubscriptionCancellationFeedbackRequest subscriptionCancellationFeedbackRequest) {
        Intrinsics.checkNotNullParameter(subscriptionCancellationFeedbackRequest, "subscriptionCancellationFeedbackRequest");
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(SubscriptionManagementApi.DefaultImpls.postSubscriptionCancellationFeedback$default(this.subscriptionManagementApi, (String) null, 0, subscriptionCancellationFeedbackRequest, 3, (Object) null), SubscriptionManagementRepositoryImpl$postSubscriptionCancellationFeedback$1.INSTANCE, new SubscriptionCancellationFeedbackResponse((Boolean) null, 1, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public Either<Failure, SetSubscriptionDefaultCardResponse> setSubscriptionDefaultCard(@NotNull SubscriptionDefaultCardRequestModel subscriptionDefaultCardRequestModel) {
        Intrinsics.checkNotNullParameter(subscriptionDefaultCardRequestModel, "subscriptionDefaultCard");
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(SubscriptionManagementApi.DefaultImpls.setSubscriptionDefaultCard$default(this.subscriptionManagementApi, (String) null, 0, subscriptionDefaultCardRequestModel, 3, (Object) null), SubscriptionManagementRepositoryImpl$setSubscriptionDefaultCard$1.INSTANCE, new SetSubscriptionDefaultCardResponse((List) null, 1, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public Either<Failure, SubscriptionAutoRenewUpdateResponse> updateSubscriptionAutoRenew(@NotNull String str, @NotNull SubscriptionAutoRenewRequestModel subscriptionAutoRenewRequestModel, boolean z11) {
        Call call;
        Intrinsics.checkNotNullParameter(str, "subscriptionMemberId");
        Intrinsics.checkNotNullParameter(subscriptionAutoRenewRequestModel, "subscriptionAutoRenewRequestModel");
        if (z11) {
            call = SubscriptionManagementApi.DefaultImpls.updateSubscriptionAutoRenewStatusForMockTest$default(this.subscriptionManagementApi, (String) null, 0, str, subscriptionAutoRenewRequestModel, 3, (Object) null);
        } else {
            call = SubscriptionManagementApi.DefaultImpls.updateSubscriptionAutoRenewStatus$default(this.subscriptionManagementApi, (String) null, 0, str, subscriptionAutoRenewRequestModel, 3, (Object) null);
        }
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(call, SubscriptionManagementRepositoryImpl$updateSubscriptionAutoRenew$1.INSTANCE, new SubscriptionAutoRenewUpdateResponse((List) null, 1, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
