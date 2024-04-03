package com.talabat.core.flutter.channels.impl.data.cart.dto;

import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.Bounds;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003J[\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006("}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/cart/dto/ApplyVoucherCallArguments;", "", "discountValue", "", "title", "", "id", "maxDiscountCap", "voucherCode", "minOrderValue", "discountType", "bounds", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/Bounds;", "(DLjava/lang/String;Ljava/lang/String;DLjava/lang/String;DLjava/lang/String;Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/Bounds;)V", "getBounds", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/Bounds;", "getDiscountType", "()Ljava/lang/String;", "getDiscountValue", "()D", "getId", "getMaxDiscountCap", "getMinOrderValue", "getTitle", "getVoucherCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ApplyVoucherCallArguments {
    @Nullable
    private final Bounds bounds;
    @NotNull
    private final String discountType;
    private final double discountValue;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f55911id;
    private final double maxDiscountCap;
    private final double minOrderValue;
    @NotNull
    private final String title;
    @NotNull
    private final String voucherCode;

    public ApplyVoucherCallArguments(double d11, @NotNull String str, @NotNull String str2, double d12, @NotNull String str3, double d13, @NotNull String str4, @Nullable Bounds bounds2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "id");
        Intrinsics.checkNotNullParameter(str3, "voucherCode");
        Intrinsics.checkNotNullParameter(str4, "discountType");
        this.discountValue = d11;
        this.title = str;
        this.f55911id = str2;
        this.maxDiscountCap = d12;
        this.voucherCode = str3;
        this.minOrderValue = d13;
        this.discountType = str4;
        this.bounds = bounds2;
    }

    public static /* synthetic */ ApplyVoucherCallArguments copy$default(ApplyVoucherCallArguments applyVoucherCallArguments, double d11, String str, String str2, double d12, String str3, double d13, String str4, Bounds bounds2, int i11, Object obj) {
        ApplyVoucherCallArguments applyVoucherCallArguments2 = applyVoucherCallArguments;
        int i12 = i11;
        return applyVoucherCallArguments.copy((i12 & 1) != 0 ? applyVoucherCallArguments2.discountValue : d11, (i12 & 2) != 0 ? applyVoucherCallArguments2.title : str, (i12 & 4) != 0 ? applyVoucherCallArguments2.f55911id : str2, (i12 & 8) != 0 ? applyVoucherCallArguments2.maxDiscountCap : d12, (i12 & 16) != 0 ? applyVoucherCallArguments2.voucherCode : str3, (i12 & 32) != 0 ? applyVoucherCallArguments2.minOrderValue : d13, (i12 & 64) != 0 ? applyVoucherCallArguments2.discountType : str4, (i12 & 128) != 0 ? applyVoucherCallArguments2.bounds : bounds2);
    }

    public final double component1() {
        return this.discountValue;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final String component3() {
        return this.f55911id;
    }

    public final double component4() {
        return this.maxDiscountCap;
    }

    @NotNull
    public final String component5() {
        return this.voucherCode;
    }

    public final double component6() {
        return this.minOrderValue;
    }

    @NotNull
    public final String component7() {
        return this.discountType;
    }

    @Nullable
    public final Bounds component8() {
        return this.bounds;
    }

    @NotNull
    public final ApplyVoucherCallArguments copy(double d11, @NotNull String str, @NotNull String str2, double d12, @NotNull String str3, double d13, @NotNull String str4, @Nullable Bounds bounds2) {
        String str5 = str;
        Intrinsics.checkNotNullParameter(str5, "title");
        String str6 = str2;
        Intrinsics.checkNotNullParameter(str6, "id");
        String str7 = str3;
        Intrinsics.checkNotNullParameter(str7, "voucherCode");
        String str8 = str4;
        Intrinsics.checkNotNullParameter(str8, "discountType");
        return new ApplyVoucherCallArguments(d11, str5, str6, d12, str7, d13, str8, bounds2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApplyVoucherCallArguments)) {
            return false;
        }
        ApplyVoucherCallArguments applyVoucherCallArguments = (ApplyVoucherCallArguments) obj;
        return Intrinsics.areEqual((Object) Double.valueOf(this.discountValue), (Object) Double.valueOf(applyVoucherCallArguments.discountValue)) && Intrinsics.areEqual((Object) this.title, (Object) applyVoucherCallArguments.title) && Intrinsics.areEqual((Object) this.f55911id, (Object) applyVoucherCallArguments.f55911id) && Intrinsics.areEqual((Object) Double.valueOf(this.maxDiscountCap), (Object) Double.valueOf(applyVoucherCallArguments.maxDiscountCap)) && Intrinsics.areEqual((Object) this.voucherCode, (Object) applyVoucherCallArguments.voucherCode) && Intrinsics.areEqual((Object) Double.valueOf(this.minOrderValue), (Object) Double.valueOf(applyVoucherCallArguments.minOrderValue)) && Intrinsics.areEqual((Object) this.discountType, (Object) applyVoucherCallArguments.discountType) && Intrinsics.areEqual((Object) this.bounds, (Object) applyVoucherCallArguments.bounds);
    }

    @Nullable
    public final Bounds getBounds() {
        return this.bounds;
    }

    @NotNull
    public final String getDiscountType() {
        return this.discountType;
    }

    public final double getDiscountValue() {
        return this.discountValue;
    }

    @NotNull
    public final String getId() {
        return this.f55911id;
    }

    public final double getMaxDiscountCap() {
        return this.maxDiscountCap;
    }

    public final double getMinOrderValue() {
        return this.minOrderValue;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getVoucherCode() {
        return this.voucherCode;
    }

    public int hashCode() {
        int a11 = ((((((((((((Double.doubleToLongBits(this.discountValue) * 31) + this.title.hashCode()) * 31) + this.f55911id.hashCode()) * 31) + Double.doubleToLongBits(this.maxDiscountCap)) * 31) + this.voucherCode.hashCode()) * 31) + Double.doubleToLongBits(this.minOrderValue)) * 31) + this.discountType.hashCode()) * 31;
        Bounds bounds2 = this.bounds;
        return a11 + (bounds2 == null ? 0 : bounds2.hashCode());
    }

    @NotNull
    public String toString() {
        double d11 = this.discountValue;
        String str = this.title;
        String str2 = this.f55911id;
        double d12 = this.maxDiscountCap;
        String str3 = this.voucherCode;
        double d13 = this.minOrderValue;
        String str4 = this.discountType;
        Bounds bounds2 = this.bounds;
        return "ApplyVoucherCallArguments(discountValue=" + d11 + ", title=" + str + ", id=" + str2 + ", maxDiscountCap=" + d12 + ", voucherCode=" + str3 + ", minOrderValue=" + d13 + ", discountType=" + str4 + ", bounds=" + bounds2 + ")";
    }
}
