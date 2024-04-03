package com.talabat.feature.fees.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/fees/domain/model/CartFee;", "", "value", "", "name", "", "(DLjava/lang/String;)V", "getName", "()Ljava/lang/String;", "getValue", "()D", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_pricing_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartFee {
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f58529name;
    private final double value;

    public CartFee(double d11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.value = d11;
        this.f58529name = str;
    }

    public static /* synthetic */ CartFee copy$default(CartFee cartFee, double d11, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            d11 = cartFee.value;
        }
        if ((i11 & 2) != 0) {
            str = cartFee.f58529name;
        }
        return cartFee.copy(d11, str);
    }

    public final double component1() {
        return this.value;
    }

    @NotNull
    public final String component2() {
        return this.f58529name;
    }

    @NotNull
    public final CartFee copy(double d11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new CartFee(d11, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CartFee)) {
            return false;
        }
        CartFee cartFee = (CartFee) obj;
        return Intrinsics.areEqual((Object) Double.valueOf(this.value), (Object) Double.valueOf(cartFee.value)) && Intrinsics.areEqual((Object) this.f58529name, (Object) cartFee.f58529name);
    }

    @NotNull
    public final String getName() {
        return this.f58529name;
    }

    public final double getValue() {
        return this.value;
    }

    public int hashCode() {
        return (Double.doubleToLongBits(this.value) * 31) + this.f58529name.hashCode();
    }

    @NotNull
    public String toString() {
        double d11 = this.value;
        String str = this.f58529name;
        return "CartFee(value=" + d11 + ", name=" + str + ")";
    }
}
