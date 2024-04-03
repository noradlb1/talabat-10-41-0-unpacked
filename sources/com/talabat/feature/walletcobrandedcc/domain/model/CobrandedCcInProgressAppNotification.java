package com.talabat.feature.walletcobrandedcc.domain.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/walletcobrandedcc/domain/model/CobrandedCcInProgressAppNotification;", "", "shouldNotifyUser", "", "(Z)V", "getShouldNotifyUser", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_feature_wallet-cobranded-cc_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CobrandedCcInProgressAppNotification {
    private final boolean shouldNotifyUser;

    public CobrandedCcInProgressAppNotification(boolean z11) {
        this.shouldNotifyUser = z11;
    }

    public static /* synthetic */ CobrandedCcInProgressAppNotification copy$default(CobrandedCcInProgressAppNotification cobrandedCcInProgressAppNotification, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = cobrandedCcInProgressAppNotification.shouldNotifyUser;
        }
        return cobrandedCcInProgressAppNotification.copy(z11);
    }

    public final boolean component1() {
        return this.shouldNotifyUser;
    }

    @NotNull
    public final CobrandedCcInProgressAppNotification copy(boolean z11) {
        return new CobrandedCcInProgressAppNotification(z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CobrandedCcInProgressAppNotification) && this.shouldNotifyUser == ((CobrandedCcInProgressAppNotification) obj).shouldNotifyUser;
    }

    public final boolean getShouldNotifyUser() {
        return this.shouldNotifyUser;
    }

    public int hashCode() {
        boolean z11 = this.shouldNotifyUser;
        if (z11) {
            return 1;
        }
        return z11 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.shouldNotifyUser;
        return "CobrandedCcInProgressAppNotification(shouldNotifyUser=" + z11 + ")";
    }
}
