package com.talabat.feature.bnplcore.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\t\u0010\n\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u000f\u001a\u00020\rJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/bnplcore/domain/model/Overdues;", "", "count", "", "totalAmount", "", "(ID)V", "getTotalAmount", "()D", "component1", "component2", "copy", "equals", "", "other", "hasOverdues", "hashCode", "toString", "", "com_talabat_feature_bnpl-core_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Overdues {
    private final int count;
    private final double totalAmount;

    public Overdues(int i11, double d11) {
        this.count = i11;
        this.totalAmount = d11;
    }

    private final int component1() {
        return this.count;
    }

    public static /* synthetic */ Overdues copy$default(Overdues overdues, int i11, double d11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = overdues.count;
        }
        if ((i12 & 2) != 0) {
            d11 = overdues.totalAmount;
        }
        return overdues.copy(i11, d11);
    }

    public final double component2() {
        return this.totalAmount;
    }

    @NotNull
    public final Overdues copy(int i11, double d11) {
        return new Overdues(i11, d11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Overdues)) {
            return false;
        }
        Overdues overdues = (Overdues) obj;
        return this.count == overdues.count && Intrinsics.areEqual((Object) Double.valueOf(this.totalAmount), (Object) Double.valueOf(overdues.totalAmount));
    }

    public final double getTotalAmount() {
        return this.totalAmount;
    }

    public final boolean hasOverdues() {
        return this.count > 0;
    }

    public int hashCode() {
        return (this.count * 31) + Double.doubleToLongBits(this.totalAmount);
    }

    @NotNull
    public String toString() {
        int i11 = this.count;
        double d11 = this.totalAmount;
        return "Overdues(count=" + i11 + ", totalAmount=" + d11 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Overdues(int i11, double d11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i12 & 2) != 0 ? 0.0d : d11);
    }
}
