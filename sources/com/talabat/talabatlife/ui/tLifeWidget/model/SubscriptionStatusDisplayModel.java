package com.talabat.talabatlife.ui.tLifeWidget.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/talabatlife/ui/tLifeWidget/model/SubscriptionStatusDisplayModel;", "", "()V", "isUserSubscribed", "", "()Z", "setUserSubscribed", "(Z)V", "logoUrl", "", "getLogoUrl", "()Ljava/lang/String;", "setLogoUrl", "(Ljava/lang/String;)V", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionStatusDisplayModel {
    private boolean isUserSubscribed;
    @NotNull
    private String logoUrl = "";

    @NotNull
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final boolean isUserSubscribed() {
        return this.isUserSubscribed;
    }

    public final void setLogoUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.logoUrl = str;
    }

    public final void setUserSubscribed(boolean z11) {
        this.isUserSubscribed = z11;
    }
}
