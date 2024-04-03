package com.talabat.feature.subscriptions.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/SubscriptionSavingsInfo;", "", "overallSavings", "", "monthlySavings", "(FF)V", "getMonthlySavings", "()F", "getOverallSavings", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionSavingsInfo {
    private final float monthlySavings;
    private final float overallSavings;

    public SubscriptionSavingsInfo() {
        this(0.0f, 0.0f, 3, (DefaultConstructorMarker) null);
    }

    public SubscriptionSavingsInfo(float f11, float f12) {
        this.overallSavings = f11;
        this.monthlySavings = f12;
    }

    public static /* synthetic */ SubscriptionSavingsInfo copy$default(SubscriptionSavingsInfo subscriptionSavingsInfo, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = subscriptionSavingsInfo.overallSavings;
        }
        if ((i11 & 2) != 0) {
            f12 = subscriptionSavingsInfo.monthlySavings;
        }
        return subscriptionSavingsInfo.copy(f11, f12);
    }

    public final float component1() {
        return this.overallSavings;
    }

    public final float component2() {
        return this.monthlySavings;
    }

    @NotNull
    public final SubscriptionSavingsInfo copy(float f11, float f12) {
        return new SubscriptionSavingsInfo(f11, f12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionSavingsInfo)) {
            return false;
        }
        SubscriptionSavingsInfo subscriptionSavingsInfo = (SubscriptionSavingsInfo) obj;
        return Intrinsics.areEqual((Object) Float.valueOf(this.overallSavings), (Object) Float.valueOf(subscriptionSavingsInfo.overallSavings)) && Intrinsics.areEqual((Object) Float.valueOf(this.monthlySavings), (Object) Float.valueOf(subscriptionSavingsInfo.monthlySavings));
    }

    public final float getMonthlySavings() {
        return this.monthlySavings;
    }

    public final float getOverallSavings() {
        return this.overallSavings;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.overallSavings) * 31) + Float.floatToIntBits(this.monthlySavings);
    }

    @NotNull
    public String toString() {
        float f11 = this.overallSavings;
        float f12 = this.monthlySavings;
        return "SubscriptionSavingsInfo(overallSavings=" + f11 + ", monthlySavings=" + f12 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionSavingsInfo(float f11, float f12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0.0f : f11, (i11 & 2) != 0 ? 0.0f : f12);
    }
}
