package com.talabat.feature.fees.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/fees/domain/model/Fees;", "", "fees", "", "Lcom/talabat/feature/fees/domain/model/Fee;", "feesDescriptions", "Lcom/talabat/feature/fees/domain/model/FeeDescription;", "(Ljava/util/List;Ljava/util/List;)V", "getFees", "()Ljava/util/List;", "getFeesDescriptions", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_pricing_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Fees {
    @NotNull
    private final List<Fee> fees;
    @NotNull
    private final List<FeeDescription> feesDescriptions;

    public Fees(@NotNull List<Fee> list, @NotNull List<FeeDescription> list2) {
        Intrinsics.checkNotNullParameter(list, "fees");
        Intrinsics.checkNotNullParameter(list2, "feesDescriptions");
        this.fees = list;
        this.feesDescriptions = list2;
    }

    public static /* synthetic */ Fees copy$default(Fees fees2, List<Fee> list, List<FeeDescription> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = fees2.fees;
        }
        if ((i11 & 2) != 0) {
            list2 = fees2.feesDescriptions;
        }
        return fees2.copy(list, list2);
    }

    @NotNull
    public final List<Fee> component1() {
        return this.fees;
    }

    @NotNull
    public final List<FeeDescription> component2() {
        return this.feesDescriptions;
    }

    @NotNull
    public final Fees copy(@NotNull List<Fee> list, @NotNull List<FeeDescription> list2) {
        Intrinsics.checkNotNullParameter(list, "fees");
        Intrinsics.checkNotNullParameter(list2, "feesDescriptions");
        return new Fees(list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Fees)) {
            return false;
        }
        Fees fees2 = (Fees) obj;
        return Intrinsics.areEqual((Object) this.fees, (Object) fees2.fees) && Intrinsics.areEqual((Object) this.feesDescriptions, (Object) fees2.feesDescriptions);
    }

    @NotNull
    public final List<Fee> getFees() {
        return this.fees;
    }

    @NotNull
    public final List<FeeDescription> getFeesDescriptions() {
        return this.feesDescriptions;
    }

    public int hashCode() {
        return (this.fees.hashCode() * 31) + this.feesDescriptions.hashCode();
    }

    @NotNull
    public String toString() {
        List<Fee> list = this.fees;
        List<FeeDescription> list2 = this.feesDescriptions;
        return "Fees(fees=" + list + ", feesDescriptions=" + list2 + ")";
    }
}
