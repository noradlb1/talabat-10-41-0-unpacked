package com.checkout.validation.model;

import com.talabat.card_tokenization.CardTokenizationPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/checkout/validation/model/ExpiryDateValidationRequest;", "", "expiryMonth", "", "expiryYear", "(Ljava/lang/String;Ljava/lang/String;)V", "getExpiryMonth", "()Ljava/lang/String;", "getExpiryYear", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExpiryDateValidationRequest {
    @NotNull
    private final String expiryMonth;
    @NotNull
    private final String expiryYear;

    public ExpiryDateValidationRequest(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, CardTokenizationPlugin.ARG_EXPIRY_MONTH_KEY);
        Intrinsics.checkNotNullParameter(str2, CardTokenizationPlugin.ARG_EXPIRY_YEAR_KEY);
        this.expiryMonth = str;
        this.expiryYear = str2;
    }

    public static /* synthetic */ ExpiryDateValidationRequest copy$default(ExpiryDateValidationRequest expiryDateValidationRequest, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = expiryDateValidationRequest.expiryMonth;
        }
        if ((i11 & 2) != 0) {
            str2 = expiryDateValidationRequest.expiryYear;
        }
        return expiryDateValidationRequest.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.expiryMonth;
    }

    @NotNull
    public final String component2() {
        return this.expiryYear;
    }

    @NotNull
    public final ExpiryDateValidationRequest copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, CardTokenizationPlugin.ARG_EXPIRY_MONTH_KEY);
        Intrinsics.checkNotNullParameter(str2, CardTokenizationPlugin.ARG_EXPIRY_YEAR_KEY);
        return new ExpiryDateValidationRequest(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExpiryDateValidationRequest)) {
            return false;
        }
        ExpiryDateValidationRequest expiryDateValidationRequest = (ExpiryDateValidationRequest) obj;
        return Intrinsics.areEqual((Object) this.expiryMonth, (Object) expiryDateValidationRequest.expiryMonth) && Intrinsics.areEqual((Object) this.expiryYear, (Object) expiryDateValidationRequest.expiryYear);
    }

    @NotNull
    public final String getExpiryMonth() {
        return this.expiryMonth;
    }

    @NotNull
    public final String getExpiryYear() {
        return this.expiryYear;
    }

    public int hashCode() {
        return (this.expiryMonth.hashCode() * 31) + this.expiryYear.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.expiryMonth;
        String str2 = this.expiryYear;
        return "ExpiryDateValidationRequest(expiryMonth=" + str + ", expiryYear=" + str2 + ")";
    }
}
