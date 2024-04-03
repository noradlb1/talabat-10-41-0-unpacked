package com.talabat.talabatlife.ui.redeemAndPay.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/talabat/talabatlife/ui/redeemAndPay/model/RedeemOfferDisplayModel;", "", "()V", "errors", "", "", "getErrors", "()[Ljava/lang/String;", "setErrors", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "result", "", "getResult", "()Z", "setResult", "(Z)V", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemOfferDisplayModel {
    @NotNull
    private String[] errors = new String[0];
    private boolean result;

    @NotNull
    public final String[] getErrors() {
        return this.errors;
    }

    public final boolean getResult() {
        return this.result;
    }

    public final void setErrors(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.errors = strArr;
    }

    public final void setResult(boolean z11) {
        this.result = z11;
    }
}
