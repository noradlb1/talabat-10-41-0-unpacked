package com.talabat.feature.fees.domain.repository;

import com.talabat.feature.fees.domain.model.Fees;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/fees/domain/repository/FeesResult;", "", "fees", "Lcom/talabat/feature/fees/domain/model/Fees;", "cachedFees", "(Lcom/talabat/feature/fees/domain/model/Fees;Lcom/talabat/feature/fees/domain/model/Fees;)V", "getCachedFees", "()Lcom/talabat/feature/fees/domain/model/Fees;", "getFees", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_pricing_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeesResult {
    @Nullable
    private final Fees cachedFees;
    @Nullable
    private final Fees fees;

    public FeesResult() {
        this((Fees) null, (Fees) null, 3, (DefaultConstructorMarker) null);
    }

    public FeesResult(@Nullable Fees fees2, @Nullable Fees fees3) {
        this.fees = fees2;
        this.cachedFees = fees3;
    }

    public static /* synthetic */ FeesResult copy$default(FeesResult feesResult, Fees fees2, Fees fees3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            fees2 = feesResult.fees;
        }
        if ((i11 & 2) != 0) {
            fees3 = feesResult.cachedFees;
        }
        return feesResult.copy(fees2, fees3);
    }

    @Nullable
    public final Fees component1() {
        return this.fees;
    }

    @Nullable
    public final Fees component2() {
        return this.cachedFees;
    }

    @NotNull
    public final FeesResult copy(@Nullable Fees fees2, @Nullable Fees fees3) {
        return new FeesResult(fees2, fees3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeesResult)) {
            return false;
        }
        FeesResult feesResult = (FeesResult) obj;
        return Intrinsics.areEqual((Object) this.fees, (Object) feesResult.fees) && Intrinsics.areEqual((Object) this.cachedFees, (Object) feesResult.cachedFees);
    }

    @Nullable
    public final Fees getCachedFees() {
        return this.cachedFees;
    }

    @Nullable
    public final Fees getFees() {
        return this.fees;
    }

    public int hashCode() {
        Fees fees2 = this.fees;
        int i11 = 0;
        int hashCode = (fees2 == null ? 0 : fees2.hashCode()) * 31;
        Fees fees3 = this.cachedFees;
        if (fees3 != null) {
            i11 = fees3.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        Fees fees2 = this.fees;
        Fees fees3 = this.cachedFees;
        return "FeesResult(fees=" + fees2 + ", cachedFees=" + fees3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeesResult(Fees fees2, Fees fees3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : fees2, (i11 & 2) != 0 ? null : fees3);
    }
}
