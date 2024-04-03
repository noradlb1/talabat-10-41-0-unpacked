package com.talabat.feature.subscriptions.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/CurrencyAmount;", "", "amount", "", "currency", "", "(FLjava/lang/String;)V", "getAmount", "()F", "getCurrency", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CurrencyAmount {
    private final float amount;
    @NotNull
    private final String currency;

    public CurrencyAmount(float f11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "currency");
        this.amount = f11;
        this.currency = str;
    }

    public static /* synthetic */ CurrencyAmount copy$default(CurrencyAmount currencyAmount, float f11, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = currencyAmount.amount;
        }
        if ((i11 & 2) != 0) {
            str = currencyAmount.currency;
        }
        return currencyAmount.copy(f11, str);
    }

    public final float component1() {
        return this.amount;
    }

    @NotNull
    public final String component2() {
        return this.currency;
    }

    @NotNull
    public final CurrencyAmount copy(float f11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "currency");
        return new CurrencyAmount(f11, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CurrencyAmount)) {
            return false;
        }
        CurrencyAmount currencyAmount = (CurrencyAmount) obj;
        return Intrinsics.areEqual((Object) Float.valueOf(this.amount), (Object) Float.valueOf(currencyAmount.amount)) && Intrinsics.areEqual((Object) this.currency, (Object) currencyAmount.currency);
    }

    public final float getAmount() {
        return this.amount;
    }

    @NotNull
    public final String getCurrency() {
        return this.currency;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.amount) * 31) + this.currency.hashCode();
    }

    @NotNull
    public String toString() {
        float f11 = this.amount;
        String str = this.currency;
        return "CurrencyAmount(amount=" + f11 + ", currency=" + str + ")";
    }
}
