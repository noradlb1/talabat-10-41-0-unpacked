package com.talabat.gem.domain.entities;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u000fJJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012¨\u0006#"}, d2 = {"Lcom/talabat/gem/domain/entities/GemTier;", "Ljava/io/Serializable;", "payOnlyAmount", "", "onTotalAmount", "currency", "", "color", "discountPercentage", "", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;)V", "getColor", "()Ljava/lang/String;", "getCurrency", "getDiscountPercentage", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getOnTotalAmount", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getPayOnlyAmount", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;)Lcom/talabat/gem/domain/entities/GemTier;", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemTier implements Serializable {
    @Nullable
    private final String color;
    @Nullable
    private final String currency;
    @Nullable
    private final Float discountPercentage;
    @Nullable
    private final Double onTotalAmount;
    @Nullable
    private final Double payOnlyAmount;

    public GemTier() {
        this((Double) null, (Double) null, (String) null, (String) null, (Float) null, 31, (DefaultConstructorMarker) null);
    }

    public GemTier(@Nullable Double d11, @Nullable Double d12, @Nullable String str, @Nullable String str2, @Nullable Float f11) {
        this.payOnlyAmount = d11;
        this.onTotalAmount = d12;
        this.currency = str;
        this.color = str2;
        this.discountPercentage = f11;
    }

    public static /* synthetic */ GemTier copy$default(GemTier gemTier, Double d11, Double d12, String str, String str2, Float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            d11 = gemTier.payOnlyAmount;
        }
        if ((i11 & 2) != 0) {
            d12 = gemTier.onTotalAmount;
        }
        Double d13 = d12;
        if ((i11 & 4) != 0) {
            str = gemTier.currency;
        }
        String str3 = str;
        if ((i11 & 8) != 0) {
            str2 = gemTier.color;
        }
        String str4 = str2;
        if ((i11 & 16) != 0) {
            f11 = gemTier.discountPercentage;
        }
        return gemTier.copy(d11, d13, str3, str4, f11);
    }

    @Nullable
    public final Double component1() {
        return this.payOnlyAmount;
    }

    @Nullable
    public final Double component2() {
        return this.onTotalAmount;
    }

    @Nullable
    public final String component3() {
        return this.currency;
    }

    @Nullable
    public final String component4() {
        return this.color;
    }

    @Nullable
    public final Float component5() {
        return this.discountPercentage;
    }

    @NotNull
    public final GemTier copy(@Nullable Double d11, @Nullable Double d12, @Nullable String str, @Nullable String str2, @Nullable Float f11) {
        return new GemTier(d11, d12, str, str2, f11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GemTier)) {
            return false;
        }
        GemTier gemTier = (GemTier) obj;
        return Intrinsics.areEqual((Object) this.payOnlyAmount, (Object) gemTier.payOnlyAmount) && Intrinsics.areEqual((Object) this.onTotalAmount, (Object) gemTier.onTotalAmount) && Intrinsics.areEqual((Object) this.currency, (Object) gemTier.currency) && Intrinsics.areEqual((Object) this.color, (Object) gemTier.color) && Intrinsics.areEqual((Object) this.discountPercentage, (Object) gemTier.discountPercentage);
    }

    @Nullable
    public final String getColor() {
        return this.color;
    }

    @Nullable
    public final String getCurrency() {
        return this.currency;
    }

    @Nullable
    public final Float getDiscountPercentage() {
        return this.discountPercentage;
    }

    @Nullable
    public final Double getOnTotalAmount() {
        return this.onTotalAmount;
    }

    @Nullable
    public final Double getPayOnlyAmount() {
        return this.payOnlyAmount;
    }

    public int hashCode() {
        Double d11 = this.payOnlyAmount;
        int i11 = 0;
        int hashCode = (d11 == null ? 0 : d11.hashCode()) * 31;
        Double d12 = this.onTotalAmount;
        int hashCode2 = (hashCode + (d12 == null ? 0 : d12.hashCode())) * 31;
        String str = this.currency;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.color;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Float f11 = this.discountPercentage;
        if (f11 != null) {
            i11 = f11.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        Double d11 = this.payOnlyAmount;
        Double d12 = this.onTotalAmount;
        String str = this.currency;
        String str2 = this.color;
        Float f11 = this.discountPercentage;
        return "GemTier(payOnlyAmount=" + d11 + ", onTotalAmount=" + d12 + ", currency=" + str + ", color=" + str2 + ", discountPercentage=" + f11 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GemTier(java.lang.Double r5, java.lang.Double r6, java.lang.String r7, java.lang.String r8, java.lang.Float r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
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
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.gem.domain.entities.GemTier.<init>(java.lang.Double, java.lang.Double, java.lang.String, java.lang.String, java.lang.Float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
