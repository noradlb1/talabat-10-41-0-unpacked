package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionB2BVoucherResponseModel;", "", "planId", "", "(Ljava/lang/String;)V", "getPlanId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionB2BVoucherResponseModel {
    @Nullable
    private final String planId;

    public SubscriptionB2BVoucherResponseModel() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public SubscriptionB2BVoucherResponseModel(@Nullable @Json(name = "planId") String str) {
        this.planId = str;
    }

    public static /* synthetic */ SubscriptionB2BVoucherResponseModel copy$default(SubscriptionB2BVoucherResponseModel subscriptionB2BVoucherResponseModel, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subscriptionB2BVoucherResponseModel.planId;
        }
        return subscriptionB2BVoucherResponseModel.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.planId;
    }

    @NotNull
    public final SubscriptionB2BVoucherResponseModel copy(@Nullable @Json(name = "planId") String str) {
        return new SubscriptionB2BVoucherResponseModel(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SubscriptionB2BVoucherResponseModel) && Intrinsics.areEqual((Object) this.planId, (Object) ((SubscriptionB2BVoucherResponseModel) obj).planId);
    }

    @Nullable
    public final String getPlanId() {
        return this.planId;
    }

    public int hashCode() {
        String str = this.planId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.planId;
        return "SubscriptionB2BVoucherResponseModel(planId=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionB2BVoucherResponseModel(String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str);
    }
}
