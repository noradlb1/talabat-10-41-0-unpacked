package com.talabat.talabatcommon.feature.subscriptionManagement.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionDetailRootResponse;", "", "result", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionResponseModel;", "(Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionResponseModel;)V", "getResult", "()Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionResponseModel;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionDetailRootResponse {
    @SerializedName("result")
    @Nullable
    private final SubscriptionResponseModel result;

    public SubscriptionDetailRootResponse() {
        this((SubscriptionResponseModel) null, 1, (DefaultConstructorMarker) null);
    }

    public SubscriptionDetailRootResponse(@Nullable SubscriptionResponseModel subscriptionResponseModel) {
        this.result = subscriptionResponseModel;
    }

    public static /* synthetic */ SubscriptionDetailRootResponse copy$default(SubscriptionDetailRootResponse subscriptionDetailRootResponse, SubscriptionResponseModel subscriptionResponseModel, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            subscriptionResponseModel = subscriptionDetailRootResponse.result;
        }
        return subscriptionDetailRootResponse.copy(subscriptionResponseModel);
    }

    @Nullable
    public final SubscriptionResponseModel component1() {
        return this.result;
    }

    @NotNull
    public final SubscriptionDetailRootResponse copy(@Nullable SubscriptionResponseModel subscriptionResponseModel) {
        return new SubscriptionDetailRootResponse(subscriptionResponseModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SubscriptionDetailRootResponse) && Intrinsics.areEqual((Object) this.result, (Object) ((SubscriptionDetailRootResponse) obj).result);
    }

    @Nullable
    public final SubscriptionResponseModel getResult() {
        return this.result;
    }

    public int hashCode() {
        SubscriptionResponseModel subscriptionResponseModel = this.result;
        if (subscriptionResponseModel == null) {
            return 0;
        }
        return subscriptionResponseModel.hashCode();
    }

    @NotNull
    public String toString() {
        SubscriptionResponseModel subscriptionResponseModel = this.result;
        return "SubscriptionDetailRootResponse(result=" + subscriptionResponseModel + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionDetailRootResponse(SubscriptionResponseModel subscriptionResponseModel, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : subscriptionResponseModel);
    }
}
