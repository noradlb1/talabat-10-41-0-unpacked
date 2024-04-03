package com.checkout.tokenization.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/checkout/tokenization/model/ExpiryDate;", "", "expiryMonth", "", "expiryYear", "(II)V", "getExpiryMonth", "()I", "getExpiryYear", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExpiryDate {
    private final int expiryMonth;
    private final int expiryYear;

    public ExpiryDate(int i11, int i12) {
        this.expiryMonth = i11;
        this.expiryYear = i12;
    }

    public static /* synthetic */ ExpiryDate copy$default(ExpiryDate expiryDate, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = expiryDate.expiryMonth;
        }
        if ((i13 & 2) != 0) {
            i12 = expiryDate.expiryYear;
        }
        return expiryDate.copy(i11, i12);
    }

    public final int component1() {
        return this.expiryMonth;
    }

    public final int component2() {
        return this.expiryYear;
    }

    @NotNull
    public final ExpiryDate copy(int i11, int i12) {
        return new ExpiryDate(i11, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExpiryDate)) {
            return false;
        }
        ExpiryDate expiryDate = (ExpiryDate) obj;
        return this.expiryMonth == expiryDate.expiryMonth && this.expiryYear == expiryDate.expiryYear;
    }

    public final int getExpiryMonth() {
        return this.expiryMonth;
    }

    public final int getExpiryYear() {
        return this.expiryYear;
    }

    public int hashCode() {
        return (this.expiryMonth * 31) + this.expiryYear;
    }

    @NotNull
    public String toString() {
        int i11 = this.expiryMonth;
        int i12 = this.expiryYear;
        return "ExpiryDate(expiryMonth=" + i11 + ", expiryYear=" + i12 + ")";
    }
}
