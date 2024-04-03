package com.talabat.feature.subscriptions.domain.model;

import com.talabat.feature.subscriptions.domain.exception.TProFreeDeliveryException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/TProOrderStatus;", "", "isTpro", "", "movDifference", "", "isFreeDelivery", "isFreeDeliveryEligibleVendor", "(ZDZZ)V", "()Z", "isValidMovDifferenceValue", "movAchieved", "getMovAchieved", "getMovDifference", "()D", "shouldShowTProPromotion", "getShouldShowTProPromotion", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOrderStatus {
    private final boolean isFreeDelivery;
    private final boolean isFreeDeliveryEligibleVendor;
    private final boolean isTpro;
    private final boolean isValidMovDifferenceValue;
    private final boolean movAchieved;
    private final double movDifference;
    private final boolean shouldShowTProPromotion;

    public TProOrderStatus() {
        this(false, 0.0d, false, false, 15, (DefaultConstructorMarker) null);
    }

    public TProOrderStatus(boolean z11, double d11, boolean z12, boolean z13) {
        this.isTpro = z11;
        this.movDifference = d11;
        this.isFreeDelivery = z12;
        this.isFreeDeliveryEligibleVendor = z13;
        if (!z12 || z13) {
            boolean z14 = true;
            this.shouldShowTProPromotion = z11 && z13;
            this.isValidMovDifferenceValue = !Double.isInfinite(d11) && !Double.isNaN(d11);
            this.movAchieved = d11 > 0.0d ? false : z14;
            return;
        }
        throw new TProFreeDeliveryException();
    }

    public static /* synthetic */ TProOrderStatus copy$default(TProOrderStatus tProOrderStatus, boolean z11, double d11, boolean z12, boolean z13, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = tProOrderStatus.isTpro;
        }
        if ((i11 & 2) != 0) {
            d11 = tProOrderStatus.movDifference;
        }
        double d12 = d11;
        if ((i11 & 4) != 0) {
            z12 = tProOrderStatus.isFreeDelivery;
        }
        boolean z14 = z12;
        if ((i11 & 8) != 0) {
            z13 = tProOrderStatus.isFreeDeliveryEligibleVendor;
        }
        return tProOrderStatus.copy(z11, d12, z14, z13);
    }

    public final boolean component1() {
        return this.isTpro;
    }

    public final double component2() {
        return this.movDifference;
    }

    public final boolean component3() {
        return this.isFreeDelivery;
    }

    public final boolean component4() {
        return this.isFreeDeliveryEligibleVendor;
    }

    @NotNull
    public final TProOrderStatus copy(boolean z11, double d11, boolean z12, boolean z13) {
        return new TProOrderStatus(z11, d11, z12, z13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProOrderStatus)) {
            return false;
        }
        TProOrderStatus tProOrderStatus = (TProOrderStatus) obj;
        return this.isTpro == tProOrderStatus.isTpro && Intrinsics.areEqual((Object) Double.valueOf(this.movDifference), (Object) Double.valueOf(tProOrderStatus.movDifference)) && this.isFreeDelivery == tProOrderStatus.isFreeDelivery && this.isFreeDeliveryEligibleVendor == tProOrderStatus.isFreeDeliveryEligibleVendor;
    }

    public final boolean getMovAchieved() {
        return this.movAchieved;
    }

    public final double getMovDifference() {
        return this.movDifference;
    }

    public final boolean getShouldShowTProPromotion() {
        return this.shouldShowTProPromotion;
    }

    public int hashCode() {
        boolean z11 = this.isTpro;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int a11 = (((z11 ? 1 : 0) * true) + Double.doubleToLongBits(this.movDifference)) * 31;
        boolean z13 = this.isFreeDelivery;
        if (z13) {
            z13 = true;
        }
        int i11 = (a11 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.isFreeDeliveryEligibleVendor;
        if (!z14) {
            z12 = z14;
        }
        return i11 + (z12 ? 1 : 0);
    }

    public final boolean isFreeDelivery() {
        return this.isFreeDelivery;
    }

    public final boolean isFreeDeliveryEligibleVendor() {
        return this.isFreeDeliveryEligibleVendor;
    }

    public final boolean isTpro() {
        return this.isTpro;
    }

    public final boolean isValidMovDifferenceValue() {
        return this.isValidMovDifferenceValue;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.isTpro;
        double d11 = this.movDifference;
        boolean z12 = this.isFreeDelivery;
        boolean z13 = this.isFreeDeliveryEligibleVendor;
        return "TProOrderStatus(isTpro=" + z11 + ", movDifference=" + d11 + ", isFreeDelivery=" + z12 + ", isFreeDeliveryEligibleVendor=" + z13 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TProOrderStatus(boolean r5, double r6, boolean r8, boolean r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r6 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
        L_0x000e:
            r1 = r6
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r3 = r0
            goto L_0x0016
        L_0x0015:
            r3 = r8
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r10 = r0
            goto L_0x001d
        L_0x001c:
            r10 = r9
        L_0x001d:
            r5 = r4
            r6 = r11
            r7 = r1
            r9 = r3
            r5.<init>(r6, r7, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.domain.model.TProOrderStatus.<init>(boolean, double, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
