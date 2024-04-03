package com.checkout.validation.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/checkout/validation/model/CardNumberValidationRequest;", "", "cardNumber", "", "isEagerValidation", "", "(Ljava/lang/String;Z)V", "getCardNumber", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardNumberValidationRequest {
    @NotNull
    private final String cardNumber;
    private final boolean isEagerValidation;

    public CardNumberValidationRequest(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        this.cardNumber = str;
        this.isEagerValidation = z11;
    }

    public static /* synthetic */ CardNumberValidationRequest copy$default(CardNumberValidationRequest cardNumberValidationRequest, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cardNumberValidationRequest.cardNumber;
        }
        if ((i11 & 2) != 0) {
            z11 = cardNumberValidationRequest.isEagerValidation;
        }
        return cardNumberValidationRequest.copy(str, z11);
    }

    @NotNull
    public final String component1() {
        return this.cardNumber;
    }

    public final boolean component2() {
        return this.isEagerValidation;
    }

    @NotNull
    public final CardNumberValidationRequest copy(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        return new CardNumberValidationRequest(str, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardNumberValidationRequest)) {
            return false;
        }
        CardNumberValidationRequest cardNumberValidationRequest = (CardNumberValidationRequest) obj;
        return Intrinsics.areEqual((Object) this.cardNumber, (Object) cardNumberValidationRequest.cardNumber) && this.isEagerValidation == cardNumberValidationRequest.isEagerValidation;
    }

    @NotNull
    public final String getCardNumber() {
        return this.cardNumber;
    }

    public int hashCode() {
        int hashCode = this.cardNumber.hashCode() * 31;
        boolean z11 = this.isEagerValidation;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public final boolean isEagerValidation() {
        return this.isEagerValidation;
    }

    @NotNull
    public String toString() {
        String str = this.cardNumber;
        boolean z11 = this.isEagerValidation;
        return "CardNumberValidationRequest(cardNumber=" + str + ", isEagerValidation=" + z11 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardNumberValidationRequest(String str, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? false : z11);
    }
}
