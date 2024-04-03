package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionSavingsInfoResponseResult;", "", "overallSavings", "", "monthlySavings", "(Ljava/lang/Float;Ljava/lang/Float;)V", "getMonthlySavings", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getOverallSavings", "component1", "component2", "copy", "(Ljava/lang/Float;Ljava/lang/Float;)Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionSavingsInfoResponseResult;", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionSavingsInfoResponseResult {
    @Nullable
    private final Float monthlySavings;
    @Nullable
    private final Float overallSavings;

    public SubscriptionSavingsInfoResponseResult() {
        this((Float) null, (Float) null, 3, (DefaultConstructorMarker) null);
    }

    public SubscriptionSavingsInfoResponseResult(@Nullable @Json(name = "overallSavings") Float f11, @Nullable @Json(name = "monthlySavings") Float f12) {
        this.overallSavings = f11;
        this.monthlySavings = f12;
    }

    public static /* synthetic */ SubscriptionSavingsInfoResponseResult copy$default(SubscriptionSavingsInfoResponseResult subscriptionSavingsInfoResponseResult, Float f11, Float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = subscriptionSavingsInfoResponseResult.overallSavings;
        }
        if ((i11 & 2) != 0) {
            f12 = subscriptionSavingsInfoResponseResult.monthlySavings;
        }
        return subscriptionSavingsInfoResponseResult.copy(f11, f12);
    }

    @Nullable
    public final Float component1() {
        return this.overallSavings;
    }

    @Nullable
    public final Float component2() {
        return this.monthlySavings;
    }

    @NotNull
    public final SubscriptionSavingsInfoResponseResult copy(@Nullable @Json(name = "overallSavings") Float f11, @Nullable @Json(name = "monthlySavings") Float f12) {
        return new SubscriptionSavingsInfoResponseResult(f11, f12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionSavingsInfoResponseResult)) {
            return false;
        }
        SubscriptionSavingsInfoResponseResult subscriptionSavingsInfoResponseResult = (SubscriptionSavingsInfoResponseResult) obj;
        return Intrinsics.areEqual((Object) this.overallSavings, (Object) subscriptionSavingsInfoResponseResult.overallSavings) && Intrinsics.areEqual((Object) this.monthlySavings, (Object) subscriptionSavingsInfoResponseResult.monthlySavings);
    }

    @Nullable
    public final Float getMonthlySavings() {
        return this.monthlySavings;
    }

    @Nullable
    public final Float getOverallSavings() {
        return this.overallSavings;
    }

    public int hashCode() {
        Float f11 = this.overallSavings;
        int i11 = 0;
        int hashCode = (f11 == null ? 0 : f11.hashCode()) * 31;
        Float f12 = this.monthlySavings;
        if (f12 != null) {
            i11 = f12.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        Float f11 = this.overallSavings;
        Float f12 = this.monthlySavings;
        return "SubscriptionSavingsInfoResponseResult(overallSavings=" + f11 + ", monthlySavings=" + f12 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionSavingsInfoResponseResult(Float f11, Float f12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : f11, (i11 & 2) != 0 ? null : f12);
    }
}
