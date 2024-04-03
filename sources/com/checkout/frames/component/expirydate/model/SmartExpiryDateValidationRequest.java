package com.checkout.frames.component.expirydate.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/checkout/frames/component/expirydate/model/SmartExpiryDateValidationRequest;", "", "isFocused", "", "inputExpiryDate", "", "(ZLjava/lang/String;)V", "getInputExpiryDate", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SmartExpiryDateValidationRequest {
    @NotNull
    private final String inputExpiryDate;
    private final boolean isFocused;

    public SmartExpiryDateValidationRequest(boolean z11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "inputExpiryDate");
        this.isFocused = z11;
        this.inputExpiryDate = str;
    }

    public static /* synthetic */ SmartExpiryDateValidationRequest copy$default(SmartExpiryDateValidationRequest smartExpiryDateValidationRequest, boolean z11, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = smartExpiryDateValidationRequest.isFocused;
        }
        if ((i11 & 2) != 0) {
            str = smartExpiryDateValidationRequest.inputExpiryDate;
        }
        return smartExpiryDateValidationRequest.copy(z11, str);
    }

    public final boolean component1() {
        return this.isFocused;
    }

    @NotNull
    public final String component2() {
        return this.inputExpiryDate;
    }

    @NotNull
    public final SmartExpiryDateValidationRequest copy(boolean z11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "inputExpiryDate");
        return new SmartExpiryDateValidationRequest(z11, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmartExpiryDateValidationRequest)) {
            return false;
        }
        SmartExpiryDateValidationRequest smartExpiryDateValidationRequest = (SmartExpiryDateValidationRequest) obj;
        return this.isFocused == smartExpiryDateValidationRequest.isFocused && Intrinsics.areEqual((Object) this.inputExpiryDate, (Object) smartExpiryDateValidationRequest.inputExpiryDate);
    }

    @NotNull
    public final String getInputExpiryDate() {
        return this.inputExpiryDate;
    }

    public int hashCode() {
        boolean z11 = this.isFocused;
        if (z11) {
            z11 = true;
        }
        return ((z11 ? 1 : 0) * true) + this.inputExpiryDate.hashCode();
    }

    public final boolean isFocused() {
        return this.isFocused;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.isFocused;
        String str = this.inputExpiryDate;
        return "SmartExpiryDateValidationRequest(isFocused=" + z11 + ", inputExpiryDate=" + str + ")";
    }
}
