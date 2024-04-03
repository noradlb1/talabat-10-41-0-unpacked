package com.talabat.wallet.ui.expiringCard.model;

import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/talabat/wallet/ui/expiringCard/model/ExpiringCardDetailDisplayModel;", "", "()V", "amount", "", "getAmount", "()F", "setAmount", "(F)V", "expiryDate", "", "getExpiryDate", "()Ljava/lang/String;", "setExpiryDate", "(Ljava/lang/String;)V", "isLoadingCompleted", "", "()Z", "setLoadingCompleted", "(Z)V", "shouldDisplayView", "getShouldDisplayView", "setShouldDisplayView", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExpiringCardDetailDisplayModel {
    private float amount;
    @NotNull
    private String expiryDate = StringUtils.empty(StringCompanionObject.INSTANCE);
    private boolean isLoadingCompleted;
    private boolean shouldDisplayView;

    public final float getAmount() {
        return this.amount;
    }

    @NotNull
    public final String getExpiryDate() {
        return this.expiryDate;
    }

    public final boolean getShouldDisplayView() {
        return this.shouldDisplayView;
    }

    public final boolean isLoadingCompleted() {
        return this.isLoadingCompleted;
    }

    public final void setAmount(float f11) {
        this.amount = f11;
    }

    public final void setExpiryDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.expiryDate = str;
    }

    public final void setLoadingCompleted(boolean z11) {
        this.isLoadingCompleted = z11;
    }

    public final void setShouldDisplayView(boolean z11) {
        this.shouldDisplayView = z11;
    }
}
