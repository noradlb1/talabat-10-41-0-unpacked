package com.talabat.talabatlife.features.offers.model.redeem;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatlife/features/offers/model/redeem/RedeemOfferResponse;", "", "()V", "errors", "", "", "getErrors", "()[Ljava/lang/String;", "setErrors", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "result", "", "getResult", "()Ljava/lang/Boolean;", "setResult", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "warnings", "getWarnings", "setWarnings", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemOfferResponse {
    @Nullable
    private String[] errors;
    @Nullable
    private Boolean result;
    @Nullable
    private String[] warnings;

    @Nullable
    public final String[] getErrors() {
        return this.errors;
    }

    @Nullable
    public final Boolean getResult() {
        return this.result;
    }

    @Nullable
    public final String[] getWarnings() {
        return this.warnings;
    }

    public final void setErrors(@Nullable String[] strArr) {
        this.errors = strArr;
    }

    public final void setResult(@Nullable Boolean bool) {
        this.result = bool;
    }

    public final void setWarnings(@Nullable String[] strArr) {
        this.warnings = strArr;
    }
}
