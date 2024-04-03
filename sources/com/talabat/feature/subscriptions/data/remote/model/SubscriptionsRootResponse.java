package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionsRootResponse;", "", "result", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionResponseResult;", "(Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionResponseResult;)V", "getResult", "()Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionResponseResult;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionsRootResponse {
    @Nullable
    private final SubscriptionResponseResult result;

    public SubscriptionsRootResponse() {
        this((SubscriptionResponseResult) null, 1, (DefaultConstructorMarker) null);
    }

    public SubscriptionsRootResponse(@Nullable @Json(name = "result") SubscriptionResponseResult subscriptionResponseResult) {
        this.result = subscriptionResponseResult;
    }

    public static /* synthetic */ SubscriptionsRootResponse copy$default(SubscriptionsRootResponse subscriptionsRootResponse, SubscriptionResponseResult subscriptionResponseResult, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            subscriptionResponseResult = subscriptionsRootResponse.result;
        }
        return subscriptionsRootResponse.copy(subscriptionResponseResult);
    }

    @Nullable
    public final SubscriptionResponseResult component1() {
        return this.result;
    }

    @NotNull
    public final SubscriptionsRootResponse copy(@Nullable @Json(name = "result") SubscriptionResponseResult subscriptionResponseResult) {
        return new SubscriptionsRootResponse(subscriptionResponseResult);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SubscriptionsRootResponse) && Intrinsics.areEqual((Object) this.result, (Object) ((SubscriptionsRootResponse) obj).result);
    }

    @Nullable
    public final SubscriptionResponseResult getResult() {
        return this.result;
    }

    public int hashCode() {
        SubscriptionResponseResult subscriptionResponseResult = this.result;
        if (subscriptionResponseResult == null) {
            return 0;
        }
        return subscriptionResponseResult.hashCode();
    }

    @NotNull
    public String toString() {
        SubscriptionResponseResult subscriptionResponseResult = this.result;
        return "SubscriptionsRootResponse(result=" + subscriptionResponseResult + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionsRootResponse(SubscriptionResponseResult subscriptionResponseResult, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : subscriptionResponseResult);
    }
}
