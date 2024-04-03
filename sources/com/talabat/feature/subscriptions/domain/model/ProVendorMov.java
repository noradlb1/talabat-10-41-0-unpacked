package com.talabat.feature.subscriptions.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J.\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/ProVendorMov;", "", "mov", "", "branchId", "", "isTalabatPro", "", "(Ljava/lang/Float;IZ)V", "getBranchId", "()I", "()Z", "getMov", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "component3", "copy", "(Ljava/lang/Float;IZ)Lcom/talabat/feature/subscriptions/domain/model/ProVendorMov;", "equals", "other", "hashCode", "toString", "", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProVendorMov {
    private final int branchId;
    private final boolean isTalabatPro;
    @Nullable
    private final Float mov;

    public ProVendorMov() {
        this((Float) null, 0, false, 7, (DefaultConstructorMarker) null);
    }

    public ProVendorMov(@Nullable Float f11, int i11, boolean z11) {
        this.mov = f11;
        this.branchId = i11;
        this.isTalabatPro = z11;
    }

    public static /* synthetic */ ProVendorMov copy$default(ProVendorMov proVendorMov, Float f11, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            f11 = proVendorMov.mov;
        }
        if ((i12 & 2) != 0) {
            i11 = proVendorMov.branchId;
        }
        if ((i12 & 4) != 0) {
            z11 = proVendorMov.isTalabatPro;
        }
        return proVendorMov.copy(f11, i11, z11);
    }

    @Nullable
    public final Float component1() {
        return this.mov;
    }

    public final int component2() {
        return this.branchId;
    }

    public final boolean component3() {
        return this.isTalabatPro;
    }

    @NotNull
    public final ProVendorMov copy(@Nullable Float f11, int i11, boolean z11) {
        return new ProVendorMov(f11, i11, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProVendorMov)) {
            return false;
        }
        ProVendorMov proVendorMov = (ProVendorMov) obj;
        return Intrinsics.areEqual((Object) this.mov, (Object) proVendorMov.mov) && this.branchId == proVendorMov.branchId && this.isTalabatPro == proVendorMov.isTalabatPro;
    }

    public final int getBranchId() {
        return this.branchId;
    }

    @Nullable
    public final Float getMov() {
        return this.mov;
    }

    public int hashCode() {
        Float f11 = this.mov;
        int hashCode = (((f11 == null ? 0 : f11.hashCode()) * 31) + this.branchId) * 31;
        boolean z11 = this.isTalabatPro;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public final boolean isTalabatPro() {
        return this.isTalabatPro;
    }

    @NotNull
    public String toString() {
        Float f11 = this.mov;
        int i11 = this.branchId;
        boolean z11 = this.isTalabatPro;
        return "ProVendorMov(mov=" + f11 + ", branchId=" + i11 + ", isTalabatPro=" + z11 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProVendorMov(Float f11, int i11, boolean z11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? Float.valueOf(0.0f) : f11, (i12 & 2) != 0 ? 0 : i11, (i12 & 4) != 0 ? false : z11);
    }
}
