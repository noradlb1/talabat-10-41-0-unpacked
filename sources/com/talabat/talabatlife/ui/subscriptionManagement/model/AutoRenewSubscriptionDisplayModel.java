package com.talabat.talabatlife.ui.subscriptionManagement.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatlife/ui/subscriptionManagement/model/AutoRenewSubscriptionDisplayModel;", "", "()V", "error", "", "getError", "()Ljava/lang/String;", "setError", "(Ljava/lang/String;)V", "result", "", "getResult", "()Z", "setResult", "(Z)V", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AutoRenewSubscriptionDisplayModel {
    @NotNull
    private String error = "";
    private boolean result;

    @NotNull
    public final String getError() {
        return this.error;
    }

    public final boolean getResult() {
        return this.result;
    }

    public final void setError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.error = str;
    }

    public final void setResult(boolean z11) {
        this.result = z11;
    }
}
