package com.checkout.validation.model;

import com.checkout.base.model.CardScheme;
import com.talabat.card_tokenization.CardTokenizationPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/checkout/validation/model/CvvValidationRequest;", "", "cvv", "", "cardScheme", "Lcom/checkout/base/model/CardScheme;", "(Ljava/lang/String;Lcom/checkout/base/model/CardScheme;)V", "getCardScheme", "()Lcom/checkout/base/model/CardScheme;", "getCvv", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CvvValidationRequest {
    @NotNull
    private final CardScheme cardScheme;
    @NotNull
    private final String cvv;

    public CvvValidationRequest(@NotNull String str, @NotNull CardScheme cardScheme2) {
        Intrinsics.checkNotNullParameter(str, CardTokenizationPlugin.ARG_CVV_KEY);
        Intrinsics.checkNotNullParameter(cardScheme2, "cardScheme");
        this.cvv = str;
        this.cardScheme = cardScheme2;
    }

    public static /* synthetic */ CvvValidationRequest copy$default(CvvValidationRequest cvvValidationRequest, String str, CardScheme cardScheme2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cvvValidationRequest.cvv;
        }
        if ((i11 & 2) != 0) {
            cardScheme2 = cvvValidationRequest.cardScheme;
        }
        return cvvValidationRequest.copy(str, cardScheme2);
    }

    @NotNull
    public final String component1() {
        return this.cvv;
    }

    @NotNull
    public final CardScheme component2() {
        return this.cardScheme;
    }

    @NotNull
    public final CvvValidationRequest copy(@NotNull String str, @NotNull CardScheme cardScheme2) {
        Intrinsics.checkNotNullParameter(str, CardTokenizationPlugin.ARG_CVV_KEY);
        Intrinsics.checkNotNullParameter(cardScheme2, "cardScheme");
        return new CvvValidationRequest(str, cardScheme2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CvvValidationRequest)) {
            return false;
        }
        CvvValidationRequest cvvValidationRequest = (CvvValidationRequest) obj;
        return Intrinsics.areEqual((Object) this.cvv, (Object) cvvValidationRequest.cvv) && this.cardScheme == cvvValidationRequest.cardScheme;
    }

    @NotNull
    public final CardScheme getCardScheme() {
        return this.cardScheme;
    }

    @NotNull
    public final String getCvv() {
        return this.cvv;
    }

    public int hashCode() {
        return (this.cvv.hashCode() * 31) + this.cardScheme.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.cvv;
        CardScheme cardScheme2 = this.cardScheme;
        return "CvvValidationRequest(cvv=" + str + ", cardScheme=" + cardScheme2 + ")";
    }
}
